package shared;

import java.util.List;
import java.util.Map;

import cards.Card;

public class AppStateController implements AppState {
    
    private final AppStateSingleton state=AppStateSingleton.getInstance(); 

    @Override
    public Map<String, List<Card>> getDecksList() {
        return this.state.getDecksList();
    }

    @Override
    public List<Card> getHumanPlayerDeck() {
        return this.state.getHumanPlayerDeck();
    }

    @Override
    public List<Card> getAIPlayerDeck() {
        return this.state.getAIPlayerDeck();
    }

    @Override
    public void selectHumanPlayerDeck(String deckName) {
        this.state.selectHumanPlayerDeck(deckName);
    }

    @Override
    public void selectAIPlayer(String deckName) {
        this.state.selectAIPlayer(deckName);
    }

    @Override
    public void removeDeck(String deckName) {
        this.state.removeDeck(deckName);
    }

    @Override
    public void addDeck(String deckName, List<Card> newDeck) {
        this.state.addDeck(deckName, newDeck);
    }

}
