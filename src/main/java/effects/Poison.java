package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Poison extends AbstractEffect {
	

	public Poison() {
		super("Poison", "Se questa carta danneggia una carta dell'avversario i punti vita di quella carta diventano 0");
		
	}

	@Override
	public ActivationEvent getActivationEvent() {
		return ActivationEvent.ONATTAKING;
	}

	@Override
	public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
		
	    enemy.getCurrentBoard().get(boardPosition).get().setLifePoint(0);	
		
	}


}
