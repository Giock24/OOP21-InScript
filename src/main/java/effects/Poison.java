package effects;

import cards.AbstractEffect;
import cards.ActivationEvent;
import shared.Player;

public class Poison extends AbstractEffect {
	

	public Poison(String effectName, String effectDescription) {
		super("Poison", "Se questa carta danneggia una carta dell'avversario i punti vita di quella carta diventano 0");
		
	}

	@Override
	public ActivationEvent getActivationEvent() {
		return ActivationEvent.ONATTAKING;
	}

	@Override
	public void useEffect(Player cardOwner, Player enemy, int boardPosition) {
		//implement Logic effect of Poison
		
		
	}


}
