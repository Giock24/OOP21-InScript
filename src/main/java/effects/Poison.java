package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Poison extends AbstractEffect {
	

	public Poison() {
		super("Poison", "If this card damages an opponent's card, that card's life total becomes 0", "effects/effect_poison.png");
		
	}

	@Override
	public ActivationEvent getActivationEvent() {
		return ActivationEvent.ONATTAKING;
	}

	@Override
	public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
		
	    enemy.getCurrentBoard().get(boardPosition).get().setLifePoint(-100);	
		
	}


}
