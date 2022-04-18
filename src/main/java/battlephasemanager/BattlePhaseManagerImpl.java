package battlephasemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cards.ActivationEvent;
import cards.Card;
import shared.Player;
import shared.PlayerImpl;

public class BattlePhaseManagerImpl implements BattlePhaseManager {
    
    private Player player;
    private Player enemy;

    private List<Optional<ActivationEvent>> effectPlayer = new ArrayList<>();
    private List<Optional<ActivationEvent>> effectEnemy = new ArrayList<>();
    private final List<ActivationEvent> eventTarget = List.of(ActivationEvent.ONATTAKING, ActivationEvent.ONDEFENDING, ActivationEvent.ONDEATH);
    private List<Optional<Card>> postBattleBoard = new ArrayList<>();
    
    public BattlePhaseManagerImpl(final Player p1, final Player p2) {
        this.player = p1;
        this.player = p2;
    }
    
    private List<Optional<ActivationEvent>> extractEvent(final Player target) {
        final List<Optional<ActivationEvent>> tmp = new ArrayList<>();
        for(Optional<Card> card : target.getCurrentBoard()) {
            if(card.isPresent()) {
                if(card.get().getEffect().isPresent() && eventTarget.contains(card.get().getEffect().get().getActivationEvent())) {
                    tmp.add(Optional.of(card.get().getEffect().get().getActivationEvent()));
                }
                else {
                    tmp.add(Optional.empty());
                }
            } 
        }
        return tmp;
    }
            
    @Override
    public void handleEffect() {
        effectPlayer = extractEvent(player);
        effectEnemy = extractEvent(enemy);
        
    }
    
    private List<Optional<Card>> handleBattle(Player protagonist){
        for(Optional<Card> card : protagonist.getCurrentBoard()) {
            if(card.isPresent()) {
                
            }
        }
        return postBattleBoard;
    }

    @Override
    public boolean startBattle(boolean isTheAIturn) {
        handleEffect();
        if(isTheAIturn) {
            
        }
        return false;
    }

}
