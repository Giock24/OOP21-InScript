package cards;

import java.util.ArrayList;
import java.util.List;

public class DeckFactoryImpl implements DeckFactory {
    
    final List<Card> standardDeck = new ArrayList<>();

    @Override
    public List<Card> getStandardDeck() {
        
        for(int i=0; i<4; i++) {
            this.standardDeck.add(new CardFactoyImpl().noEffect("st-01", "Cane", 1, 1, 1));
        }
        this.standardDeck.add(new CardFactoyImpl().noEffect("st-04", "Sasso", 4, 0, 2));
        
        return this.standardDeck;
    }

}
