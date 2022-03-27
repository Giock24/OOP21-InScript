package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Elusive extends AbstractEffect{

    public Elusive() {
        super("Elusive", "Elude le carte avversarie a meno che non combatta con un altra carta Elusive");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.ONATTAKING;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        if (!enemy.getCurrentBoard().get(boardPosition).getEffect().getNameEffect().equals(cardOwner.getCurrentBoard().get(boardPosition).getEffect().getNameEffect())) {
            
            enemy.setLifePoints(enemy.getLifePoints() - cardOwner.getCurrentBoard().get(boardPosition).getAttack()); 
            
        }
        
    }

}
