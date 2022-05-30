package jsonparser;

import java.util.Optional;

import cards.Card;
import cards.Effect;

public interface InfoCard {
    
    String getName();
    
    int getAttackValue();
    
    int getLifeValue();

    int getManaCost();
    
    int getCopies();
    
    Optional<Effect> getEffect();
            
    Card generateCard();
    
    String toString();
    
}
