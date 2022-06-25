package shared;

import java.util.List;
import java.util.Map;

import cards.Card;

public class AppStateController implements AppState {
    
    private final AppStateSingleton state=AppStateSingleton.getInstance(); 

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, List<Card>> getDecksList() {
        return this.state.getDecksList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Card> getHumanPlayerDeck() {
        return this.state.getHumanPlayerDeck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Card> getAIPlayerDeck() {
        return this.state.getAIPlayerDeck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectHumanPlayerDeck(String deckName) {
        this.state.selectHumanPlayerDeck(deckName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectAIPlayer(String deckName) {
        this.state.selectAIPlayer(deckName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeDeck(String deckName) {
        this.state.removeDeck(deckName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDeck(String deckName, List<Card> newDeck) {
        this.state.addDeck(deckName, newDeck);
    }

}
