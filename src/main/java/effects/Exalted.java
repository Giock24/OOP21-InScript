package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Exalted extends AbstractEffect{

    public Exalted() {
        super("Exalted", "Quando questa carta entra in campo gli alleati adicenti guadagno 1 attacco");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.POSITIONING;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        if (boardPosition == 0) {
            if (cardOwner.getCurrentBoard().get(boardPosition+1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition+1).get().setAttack(cardOwner.getCurrentBoard().get(boardPosition+1).get().getAttack() + 1);
            }
            
        }else if (boardPosition == 4) {
            if (cardOwner.getCurrentBoard().get(boardPosition-1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition-1).get().setAttack(cardOwner.getCurrentBoard().get(boardPosition-1).get().getAttack() + 1);
            }
            
        }else{
            if (cardOwner.getCurrentBoard().get(boardPosition-1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition-1).get().setAttack(cardOwner.getCurrentBoard().get(boardPosition-1).get().getAttack() + 1);
            }
            if (cardOwner.getCurrentBoard().get(boardPosition+1).isPresent()) {
                cardOwner.getCurrentBoard().get(boardPosition+1).get().setAttack(cardOwner.getCurrentBoard().get(boardPosition+1).get().getAttack() + 1);
            }
        }
        
    }

}
