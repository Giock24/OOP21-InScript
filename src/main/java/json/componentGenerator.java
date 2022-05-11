package json;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import cards.Card;
import cards.Effect;

public interface componentGenerator {

    Optional<Effect> generateSimpleEffect(InfoEffect e);
    
    Optional<Effect> generateEffect(ChangeEffect e);

    Card generateCard(InfoCard e);

    List<Card> generateDeck(InfoDeck e);
    
    Map<String, List<Card>> generateDeckList(InfoDeck e);
    
}
