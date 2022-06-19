package jsonparser;

import java.util.Optional;

import cards.Effect;

public interface ComplexEffect extends SimpleEffect {
    
    String getNameCard();

    int getAttack();
    
    int getLifePoints();
    
    String getImageURL();
    
    Optional<ComplexEffect> getInnerEffect();
    
    Optional<Effect> generateChangeEffect();
    
}
