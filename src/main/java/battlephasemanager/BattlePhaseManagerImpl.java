package battlephasemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cards.ActivationEvent;
import cards.Card;
import cards.Effect;
import shared.Player;

public class BattlePhaseManagerImpl implements BattlePhaseManager {
    
    private final Player player;
    private final Player enemy;
    private List<Optional<Effect>> effectPlayer = new ArrayList<>(), effectEnemy = new ArrayList<>();
    private final List<ActivationEvent> eventTarget = List.of(ActivationEvent.ONATTAKING, ActivationEvent.ONDEFENDING, ActivationEvent.ONDEATH);
    //private int timesUsed;
    
    public BattlePhaseManagerImpl(final Player p1, final Player p2) {
        this.player = p1;
        this.enemy = p2;
        //timesUsed = 0;
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
        //timesUsed++;
        final List<Optional<Card>> tmp = new ArrayList<>();
        final List<Optional<Card>> afterBattle = new ArrayList<>();       
        //System.out.println(" inizio Turno: " + timesUsed);
        for(int i = 0; i < protagonist.getCurrentBoard().size(); i++) {
            if(protagonist.getCurrentBoard().get(i).isPresent() && protagonist.getCurrentBoard().get(i).get().getLifePoint() > 0) {
                if(antagonist.getCurrentBoard().get(i).isPresent()) {
                    antagonist.getCurrentBoard().get(i).get().setLifePoint(antagonist.getCurrentBoard().get(i).get().getLifePoint() - protagonist.getCurrentBoard().get(i).get().getAttack());
                    if(isAITurn) {
                        if(effectEnemy.get(i).isPresent() && effectEnemy.get(i).get().getActivationEvent() == ActivationEvent.ONATTAKING) {
                            effectEnemy.get(i).get().useEffect(protagonist, antagonist, i);
                            //System.out.println(i+1 + "° effetto Attacco attaccante IA attivato: " + effectEnemy.get(i).get().getNameEffect());
                        }
                        if(effectPlayer.get(i).isPresent() && effectPlayer.get(i).get().getActivationEvent() == ActivationEvent.ONDEFENDING) {
                            effectPlayer.get(i).get().useEffect(antagonist, protagonist, i);
                            //System.out.println(i+1 + "° effetto Difesa Difensore giocatore attivato: " + effectPlayer.get(i).get().getNameEffect());
                        }
                    }
                    else {
                        if(effectPlayer.get(i).isPresent() && effectPlayer.get(i).get().getActivationEvent() == ActivationEvent.ONATTAKING) {
                            effectPlayer.get(i).get().useEffect(protagonist, antagonist, i);
                            //System.out.println(i+1 + "° effetto Attacco attaccante giocatore attivato: " + effectPlayer.get(i).get().getNameEffect());
                        }
                        if(effectEnemy.get(i).isPresent() && effectEnemy.get(i).get().getActivationEvent() == ActivationEvent.ONDEFENDING) {
                            effectEnemy.get(i).get().useEffect(antagonist, protagonist, i);
                            //System.out.println(i+1 + "° effetto Difesa Difensore IA attivato: " + effectEnemy.get(i).get().getNameEffect());
                        }
                    }
                    
                    if(antagonist.getCurrentBoard().get(i).isPresent() && antagonist.getCurrentBoard().get(i).get().getLifePoint() <= 0 && 
                            antagonist.getCurrentBoard().get(i).get().getEffect().isPresent() && 
                            antagonist.getCurrentBoard().get(i).get().getEffect().get().getActivationEvent() == ActivationEvent.ONDEATH) {
                        // il parametro i usato in questo scenario specifica solo come "bersaglio" quello immediatamente davanti alla carta morente/o la carta stessa.
                        antagonist.getCurrentBoard().get(i).get().getEffect().get().useEffect(antagonist, protagonist, i);
                        //System.out.println(i+1 + "° effetto Morte Difensore attivato: " + effectEnemy.get(i).get().getNameEffect());

                    }
                    //System.out.println(i+1 + "° scontro avvenuto tra " + protagonist.getCurrentBoard().get(i).get().getName() + " e " + antagonist.getCurrentBoard().get(i).get().getName());
                    tmp.add(antagonist.getCurrentBoard().get(i));
                }
                else {
                    antagonist.setLifePoints(antagonist.getLifePoints() - protagonist.getCurrentBoard().get(i).get().getAttack());
                    protagonist.setLifePoints(protagonist.getLifePoints() + protagonist.getCurrentBoard().get(i).get().getAttack());
                    //System.out.println(i+1 + "° attacco diretto da parte di: " + protagonist.getCurrentBoard().get(i).get().getName());
                    
                    tmp.add(Optional.empty());
                }
            }
            else {
                //System.out.println(i+1 + "° riga vuota");
                tmp.add(antagonist.getCurrentBoard().get(i));
                //if(antagonist.getCurrentBoard().get(i).isPresent()) {
                    //System.out.println(i+1 + "° carta difensiva presente: " + antagonist.getCurrentBoard().get(i).get().getName());
                //}
            }
        }

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
        //System.out.println(" fine Turno: " + timesUsed);
        //System.out.println("--------------------------------");

        return afterBattle;
    }
    
    @Override
    public void handleEffect() {
        effectPlayer = extractEvent(player);
        effectEnemy = extractEvent(enemy);
    }
    
    @Override
    public void startBattle(final boolean isTheAIturn) {
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
    }

}
