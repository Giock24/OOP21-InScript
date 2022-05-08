package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Elusive extends AbstractEffect{

    public Elusive() {
        super("Elusive", "Elude le carte avversarie, evitandone la difesa, a meno che non combatta con un altra carta Elusive", "effects/effect_elusive.png");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.ONATTAKING;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        if (enemy.getCurrentBoard().get(boardPosition).isPresent() && (enemy.getCurrentBoard().get(boardPosition).get().getEffect().isEmpty() ||
                !(enemy.getCurrentBoard().get(boardPosition).get().getEffect().get().getNameEffect().equals(cardOwner.getCurrentBoard().get(boardPosition).get().getEffect().get().getNameEffect()))))
                
                 {
            
            enemy.getCurrentBoard().get(boardPosition).get().setLifePoint(enemy.getCurrentBoard().get(boardPosition).get().getLifePoint()+cardOwner.getCurrentBoard().get(boardPosition).get().getAttack());
            
            enemy.setLifePoints(enemy.getLifePoints()-cardOwner.getCurrentBoard().get(boardPosition).get().getAttack());    
            
        }
        
    }

}
