package battlephasemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cards.ActivationEvent;
import cards.Card;
import cards.Effect;
import gamemaster.GameMaster;
import shared.Player;

public class BattlePhaseManagerImpl implements BattlePhaseManager {
    
    private final Player player;
    private final Player enemy;
    private List<Optional<Effect>> effectPlayer = new ArrayList<>(), effectEnemy = new ArrayList<>();
    private final List<ActivationEvent> eventTarget = List.of(ActivationEvent.ONATTAKING, ActivationEvent.ONDEFENDING, ActivationEvent.ONDEATH);
    // private int timesUsed;
    
    public BattlePhaseManagerImpl(final Player p1, final Player p2) {
        this.player = p1;
        this.enemy = p2;
        // timesUsed = 0;
    }
    
    private List<Optional<Effect>> extractEvent(final Player target) {
        final List<Optional<Effect>> tmp = new ArrayList<>();
        // final aggiunto per sopprimere un warning, possibile problema;
        for(final Optional<Card> card : target.getCurrentBoard()) {
            if(card.isPresent()) {
                if(card.get().getEffect().isPresent() && eventTarget.contains(card.get().getEffect().get().getActivationEvent())) {
                    tmp.add(Optional.of(card.get().getEffect().get()));
                }
                else {
                    tmp.add(Optional.empty());
                }
            }
            else {
                tmp.add(Optional.empty());
            }
        }
        return tmp;
    } 
                
    // Metodo simil GodMethod, in caso di necessità cercherò di implementare una versione che divida in maniera più consona i vari compiti;
    private List<Optional<Card>> handleBattle(final Player protagonist, final Player antagonist, final boolean isAITurn){
        final List<Optional<Card>> tmp = new ArrayList<>();
        final List<Optional<Card>> afterBattle = new ArrayList<>();        
        for(int i = 0; i < protagonist.getCurrentBoard().size(); i++) {
            if(protagonist.getCurrentBoard().get(i).isPresent() && protagonist.getCurrentBoard().get(i).get().getLifePoint() > 0) {
                // System.out.println("protagonist present");
                if(antagonist.getCurrentBoard().get(i).isPresent()) {
                    // System.out.println("antagonist present");
                    antagonist.getCurrentBoard().get(i).get().setLifePoint(antagonist.getCurrentBoard().get(i).get().getLifePoint() - protagonist.getCurrentBoard().get(i).get().getAttack());
                    if(isAITurn) {
                        if(effectEnemy.get(i).isPresent() && effectEnemy.get(i).get().getActivationEvent() == ActivationEvent.ONATTAKING) {
                            effectEnemy.get(i).get().useEffect(protagonist, antagonist, i);
                        }
                        if(effectPlayer.get(i).isPresent() && effectPlayer.get(i).get().getActivationEvent() == ActivationEvent.ONDEFENDING) {
                            effectPlayer.get(i).get().useEffect(antagonist, protagonist, i);
                        }
                    }
                    else {
                        if(effectPlayer.get(i).isPresent() && effectPlayer.get(i).get().getActivationEvent() == ActivationEvent.ONATTAKING) {
                            effectPlayer.get(i).get().useEffect(protagonist, antagonist, i);
                        }
                        if(effectEnemy.get(i).isPresent() && effectEnemy.get(i).get().getActivationEvent() == ActivationEvent.ONDEFENDING) {
                            effectEnemy.get(i).get().useEffect(antagonist, protagonist, i);
                        }
                    }
                    
                    if(antagonist.getCurrentBoard().get(i).isPresent() && antagonist.getCurrentBoard().get(i).get().getLifePoint() <= 0 && 
                            antagonist.getCurrentBoard().get(i).get().getEffect().isPresent() && 
                            antagonist.getCurrentBoard().get(i).get().getEffect().get().getActivationEvent() == ActivationEvent.ONDEATH) {
                        // il parametro i usato in questo scenario specifica solo come "bersaglio" quello immediatamente davanti alla carta morente/o la carta stessa.
                        antagonist.getCurrentBoard().get(i).get().getEffect().get().useEffect(antagonist, protagonist, i);
                    }                    
                    tmp.add(antagonist.getCurrentBoard().get(i));
                    // System.out.println("added existing element");
                }
                else {
                    antagonist.setLifePoints(antagonist.getLifePoints() - protagonist.getCurrentBoard().get(i).get().getAttack());
                    protagonist.setLifePoints(protagonist.getLifePoints() + protagonist.getCurrentBoard().get(i).get().getAttack());
                    tmp.add(Optional.empty());
                    // System.out.println("added non-existing element");
                }
            }
            else {
                tmp.add(antagonist.getCurrentBoard().get(i));
                // System.out.println("new part used.");
            }
        }
        // System.out.println("tmp size " + tmp.size());

        // se fa schifo da vedere o da problemi cercherò di implementare una versione con stream,
        // occhio che stream.map() non supporta gli operatori ternari.
        for(final Optional<Card> card : tmp) {
            if(card.isPresent() && card.get().getLifePoint() > 0) {
                afterBattle.add(card);
            }
            else {
                afterBattle.add(Optional.empty());
            }
        }
        return afterBattle;
    }
    
    @Override
    public void handleEffect() {
        effectPlayer = extractEvent(player);
        effectEnemy = extractEvent(enemy);
    }
    
    @Override
    public boolean startBattle(final boolean isTheAIturn) {
        // timesUsed++;
        handleEffect();
        if(isTheAIturn) {
            player.setCurrentBoard(handleBattle(enemy, player, isTheAIturn)); 
        }
        else {
            enemy.setCurrentBoard(handleBattle(player, enemy, isTheAIturn)); 
        }
        // System.out.println(this.timesUsed);
        // System.out.println(player.getCurrentBoard().toString());
        // System.out.println(enemy.getCurrentBoard().toString());
        return player.getLifePoints() <= GameMaster.MIN_PLAYER_LIFE || enemy.getLifePoints() <= GameMaster.MIN_PLAYER_LIFE;
    }

}
