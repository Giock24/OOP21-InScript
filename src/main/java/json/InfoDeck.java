package json;

import java.util.List;

import cards.Card;

public interface InfoDeck {
    
    String getName();
    
    List<InfoCard> getCards();
    
    List<Card> generateDeck();
    
}
