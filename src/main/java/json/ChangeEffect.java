package json;

import java.util.Optional;

import cards.Effect;

public interface ChangeEffect extends InfoEffect {

    int getAttack();
    
    int getLifePoints();
    
    String getImageURL();
    
    Optional<Effect> generateChangeEffect();
    
}
