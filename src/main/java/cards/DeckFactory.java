package cards;

import java.util.List;

public interface DeckFactory {
    List<Card> getPlayerDeck();
    List<Card> getPlayerIADeck();
}
