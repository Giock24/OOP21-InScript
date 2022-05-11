package json;

import java.util.Optional;

import cards.Card;
import cards.Effect;

public interface InfoCard {
    
    String getName();
    
    int getAttackValue();
    
    int getLifeValue();

    int getManaCost();
    
    ChangeEffect getEffect();
            
    Card generateCard(final InfoCard card);
    
}
