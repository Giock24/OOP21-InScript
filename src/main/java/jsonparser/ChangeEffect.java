package jsonparser;

import java.util.Optional;

import cards.Effect;

public interface ChangeEffect extends InfoEffect {
    
    String getNameCard();

    int getAttack();
    
    int getLifePoints();
    
    String getImageURL();
    
    Optional<ChangeEffect> getInnerEffect();
    
    Optional<Effect> generateChangeEffect();
    
}
