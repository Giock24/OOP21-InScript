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
    // private List<Optional<Card>> postBattleBoard = new ArrayList<>();
    
    public BattlePhaseManagerImpl(final Player p1, final Player p2) {
        this.player = p1;
        this.enemy = p2;
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
            
    @Override
    public void handleEffect() {
        effectPlayer = extractEvent(player);
        effectEnemy = extractEvent(enemy);
    }
    
    private List<Optional<Card>> handleBattle(final Player protagonist, final Player antagonist, final boolean a){
        final List<Optional<Card>> tmp = new ArrayList<>();
        for(int i = 0; i < protagonist.getCurrentBoard().size(); i++) {
            if(protagonist.getCurrentBoard().get(i).isPresent()) {
                if(antagonist.getCurrentBoard().get(i).isPresent()) {
                    
                    if(a) {
                        if(effectEnemy.get(i).get().getActivationEvent() == ActivationEvent.ONATTAKING) {
                            effectEnemy.get(i).get().useEffect(antagonist, protagonist, i);
                        }
                        if(effectPlayer.get(i).get().getActivationEvent() == ActivationEvent.ONDEFENDING) {
                            effectPlayer.get(i).get().useEffect(protagonist, antagonist, i);
                        }
                    }
                    // fare lo stesso if se è il turno del giocatore;

                    antagonist.getCurrentBoard().get(i).get().setLifePoint(antagonist.getCurrentBoard().get(i).get().getLifePoint() - protagonist.getCurrentBoard().get(i).get().getAttack());
                    
                    // aggiungere attivazione dell'effetto on death se la carta è morta e se possidete un effetto con activation OnDeath;
                    
                    tmp.add(antagonist.getCurrentBoard().get(i));        
                }
                else {
                    antagonist.setLifePoints(antagonist.getLifePoints() - protagonist.getCurrentBoard().get(i).get().getAttack());
                }
            }
        }
    
        // aggiungere controllo per determinare se una carta sia effettivamente morta dopo l'uso dell'effetto ON DEATH
        
        return tmp;
    }

    @Override
    public boolean startBattle(final boolean isTheAIturn) {
        handleEffect();
        if(isTheAIturn) {
            player.setCurrentBoard(handleBattle(enemy, player, isTheAIturn)); 
        }
        else {
            enemy.setCurrentBoard(handleBattle(player, enemy, isTheAIturn)); 
        }
        return player.getLifePoints() <= 0 || enemy.getLifePoints() <= 0;
    }

}
