package effects;

import java.util.Optional;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Rotten extends AbstractEffect {

    public Rotten() {
        super("Rotten", "Quando i punti vita di questa carta scendono a zero inizia a marcire lasciando del Putridume nel campo");
        
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.ONDEATH;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        cardOwner.getCurrentBoard().get(boardPosition).get().setLifePoint(3);
        cardOwner.getCurrentBoard().get(boardPosition).get().setAttack(0);
        cardOwner.getCurrentBoard().get(boardPosition).get().setEffect(Optional.empty());
        cardOwner.getCurrentBoard().get(boardPosition).get().setName("Putridume");
    }

}
