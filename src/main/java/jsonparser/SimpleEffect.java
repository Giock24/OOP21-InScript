package jsonparser;

import java.util.Optional;

import cards.Effect;

public interface SimpleEffect {

    String getName();
    
    Optional<Effect> generateInfoEffect();

}
