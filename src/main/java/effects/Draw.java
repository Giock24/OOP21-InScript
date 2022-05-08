package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import drawphasemanager.DrawPhaseManagerImpl;
import shared.Player;

public class Draw extends AbstractEffect{

    public Draw() {
        super("Draw", "When this card enters the battlefield, the owner draws a card", "effects/effect_draw.png");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.POSITIONING;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        new DrawPhaseManagerImpl(cardOwner, enemy).drawWithoutMana(cardOwner);
    }

}
