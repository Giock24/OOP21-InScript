package cards;

import shared.Player;

public interface Effect {
    int MAXIMUM_USE_EFFECT = 1;
    
    ActivationEvent getActivationEvent();
    String getNameEffect();
    String getDescriptionEffect();
    void useEffect(Player cardOwner, Player enemy, int boardPosition);
}
