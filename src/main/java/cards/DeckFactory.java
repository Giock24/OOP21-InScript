package cards;

import java.util.List;
import java.util.Map;

public interface DeckFactory {
    Map<String, List<Card>> getDecks();
}
