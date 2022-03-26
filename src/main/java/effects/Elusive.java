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
    public void useEffect(Player cardOwner, Player enemy, int boardPosition) {
        
        if (!enemy.getCurrentBoard().get(boardPosition).getEffect().getNameEffect().equals("Elusive")) {
            
            //waiting for setter method of player life 
            
        }
        
    }

}
