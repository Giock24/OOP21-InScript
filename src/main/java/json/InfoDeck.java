package json;

import java.util.List;
import java.util.Map;

import cards.Card;

public interface InfoDeck {
    
    String getName();
    
    List<InfoCard> getCards();
    
    List<Card> generateDeck(InfoDeck deck);
    
    Map<String, List<Card>> generateDeckList(final List<InfoDeck> decks, final List<String> names);
    
}
