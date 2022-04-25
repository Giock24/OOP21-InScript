package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import cards.DeckFactoryImpl;
import drawphasemanager.DrawPhaseManagerImpl;
import shared.Player;

public class Draw extends AbstractEffect{

    public Draw() {
        super("Draw", "Quando entra in campo pesca una carta");
        
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
