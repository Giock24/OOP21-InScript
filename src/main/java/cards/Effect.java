package cards;

import shared.Player;

public interface Effect {
	ActivationEvent getActivationEvent();
	String getNameEffect();
	String getDescriptionEffect();
	void useEffect(Player cardOwner, Player enemy, int boardPosition);
}
