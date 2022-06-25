package shared;

import java.util.List;
import java.util.Map;

import cards.Card;

public interface AppState {
    
    /**
     * this method return the list of all the decks in the app
     * @return the key are also the decks' name 
     */
    Map<String, List<Card>> getDecksList();
    
    /**
     * this method return a copy of the deck that the user chose to play with
     * @return
     */
    List<Card> getHumanPlayerDeck();
    
    /**
     * this method return a copy of the deck the AI will play with
     * @return
     */
    List<Card> getAIPlayerDeck();
    
    /**
     * set the deck which the user will use during the game
     * @param deckName is the key of the Map received with the method getDecksList
     */
    void selectHumanPlayerDeck(String deckName);
    
    /**
     * set the deck which the AI will use during the game
     * @param deckName is the key of the Map received with the method getDecksList
     */
    void selectAIPlayer(String deckName);
    
    /**
     * remove a deck from the available deck list
     * @param deckName
     */
    void removeDeck(String deckName);
    
    /**
     * add a deck to the available deck list
     * 
     * @param deckName is will also be the key in the decks map
     * @param newDeck
     */
    void addDeck(String deckName,List<Card> newDeck);
    
}
