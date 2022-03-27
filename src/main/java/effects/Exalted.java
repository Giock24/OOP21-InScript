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
    public void useEffect(Player cardOwner, Player enemy, int boardPosition) {
        if (boardPosition == 0) {
            cardOwner.getCurrentBoard().get(boardPosition+1).setAttack(cardOwner.getCurrentBoard().get(boardPosition+1).getAttack() + 1);
            
        }else if (boardPosition == 5) {
            cardOwner.getCurrentBoard().get(boardPosition-1).setAttack(cardOwner.getCurrentBoard().get(boardPosition-1).getAttack() + 1);
            
        }else{
            cardOwner.getCurrentBoard().get(boardPosition-1).setAttack(cardOwner.getCurrentBoard().get(boardPosition-1).getAttack() + 1);
            cardOwner.getCurrentBoard().get(boardPosition+1).setAttack(cardOwner.getCurrentBoard().get(boardPosition+1).getAttack() + 1);
        }
        
    }

}
