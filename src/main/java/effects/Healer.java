package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Healer extends AbstractEffect{

    public Healer() {
        super("Healer", "At the end of the turn, increase the maximum health of allies adjacent to this card by 1", "effects/effect_healer.png");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.ENEMYDRAW;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        if (boardPosition == 0) { 
            
            if (cardOwner.getCurrentBoard().get(boardPosition+1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition+1).get().setLifePoint(cardOwner.getCurrentBoard().get(boardPosition+1).get().getLifePoint() + 1);
            }
                
        }else if (boardPosition == 4) {
            
            if (cardOwner.getCurrentBoard().get(boardPosition-1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition-1).get().setLifePoint(cardOwner.getCurrentBoard().get(boardPosition-1).get().getLifePoint() + 1);
            
            }
            
        }else{ 
            
            if (cardOwner.getCurrentBoard().get(boardPosition-1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition-1).get().setLifePoint(cardOwner.getCurrentBoard().get(boardPosition-1).get().getLifePoint() + 1);
            }
           
            if (cardOwner.getCurrentBoard().get(boardPosition+1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition+1).get().setLifePoint(cardOwner.getCurrentBoard().get(boardPosition+1).get().getLifePoint() + 1);
            }

        }
    }

}
