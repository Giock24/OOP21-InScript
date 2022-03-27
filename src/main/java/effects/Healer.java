package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Healer extends AbstractEffect{

    public Healer() {
        super("Healer", "A fine turno aumenta la vita massima degli alleati adicenti a questa carta di 1");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        // TODO Auto-generated method stub
        return ActivationEvent.ENEMYDRAW;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        if (boardPosition == 0) {
            cardOwner.getCurrentBoard().get(boardPosition+1).setLifePoint(cardOwner.getCurrentBoard().get(boardPosition+1).getLifePoint() + 1);
            
        }else if (boardPosition == 5) {
            cardOwner.getCurrentBoard().get(boardPosition-1).setLifePoint(cardOwner.getCurrentBoard().get(boardPosition-1).getLifePoint() + 1);
            
        }else{
            cardOwner.getCurrentBoard().get(boardPosition-1).setLifePoint(cardOwner.getCurrentBoard().get(boardPosition-1).getLifePoint() + 1);
            cardOwner.getCurrentBoard().get(boardPosition+1).setLifePoint(cardOwner.getCurrentBoard().get(boardPosition+1).getLifePoint() + 1);
        }
            
    }

}
