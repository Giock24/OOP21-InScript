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
    
    private List<Optional<Card>> handleBattle(final Player protagonist, final Player antagonist){
        final List<Optional<Card>> tmp = new ArrayList<>();
        for(int i = 0; i < protagonist.getCurrentBoard().size(); i++) {
            if(protagonist.getCurrentBoard().get(i).isPresent()) {
                if(antagonist.getCurrentBoard().get(i).isPresent()) {
                    // Metodo dello sviluppo della battaglia.
                    // da aggiungere la parte per gestire gli effetti
                    
                    //if(effectPlayer.get(i).isPresent()) {
                    //    effectPlayer.get(i).get().useEffect(protagonist, antagonist, i);
                    //}
                    
                    // if(List.of(ActivationEvent.ONDEFENDING, ActivationEvent.ONDEATH).contains(antagonist))
                    // Se la carta è presente sottrae alla vita attuale di tale carta l'attacco della carta del protagonista
                    antagonist.getCurrentBoard().get(i).get().setLifePoint(antagonist.getCurrentBoard().get(i).get().getLifePoint() - protagonist.getCurrentBoard().get(i).get().getAttack());
                    if(antagonist.getCurrentBoard().get(i).get().getLifePoint() <= 0) {
                        tmp.add(Optional.empty());
                    }
                    else {
                        tmp.add(antagonist.getCurrentBoard().get(i));
                    }
                }
                else {
                    antagonist.setLifePoints(antagonist.getLifePoints() - protagonist.getCurrentBoard().get(i).get().getAttack());
                }
            }
        }
        return tmp;
    }

    @Override
    public boolean startBattle(final boolean isTheAIturn) {
        handleEffect();
        if(isTheAIturn) {
            player.setCurrentBoard(handleBattle(enemy, player)); 
        }
        else {
            enemy.setCurrentBoard(handleBattle(player, enemy)); 
        }
        return player.getLifePoints() <= 0 || enemy.getLifePoints() <= 0;
    }

}
