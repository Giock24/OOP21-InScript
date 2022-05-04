package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Armored extends AbstractEffect {

    public Armored() {
        super("Armored", "Questa carta quando subisce danno da combattimento lo dimezza", "effects/effect_armored.png");
    
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.ONDEFENDING;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        cardOwner.getCurrentBoard().get(boardPosition).get().setLifePoint(cardOwner.getCurrentBoard().get(boardPosition).get().getLifePoint() + (enemy.getCurrentBoard().get(boardPosition).get().getAttack() / 2));
        
        
    }

}
