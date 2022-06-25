package shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cards.BaseCard;
import cards.Card;
import cards.DeckFactory;
import cards.DeckFactoryImpl;

public class AppStateSingleton implements AppState {

    private static AppStateSingleton instance = null; 
 
    private AppStateSingleton() {
        
        final DeckFactory deckFactory = new DeckFactoryImpl();
        
        decksList = new HashMap<>();
        decksList.putAll(deckFactory.getDecks());
        
        humanPlayerDeck = decksList.get("deck-standard");
        aiPlayerDeck =  decksList.get("deck-standard-IA");
    } 
 
    public static AppStateSingleton getInstance() {

        if (instance == null) {
            instance = new AppStateSingleton();
        }
        return instance;
    }
 
    
    
    private Map<String, List<Card>> decksList;
    
    private List<Card> humanPlayerDeck;
    
    private List<Card> aiPlayerDeck;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public  Map<String, List<Card>> getDecksList() {
        return  this.decksList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Card> getHumanPlayerDeck() {
        final List<Card> humanPlayerDeckCopy = new ArrayList<>();
        List.copyOf(this.humanPlayerDeck).forEach(card -> {
            humanPlayerDeckCopy.add(new BaseCard(card.getName(), card.getLifePoint(), card.getAttack(), card.getMana(), card.getImageURL(), card.getEffect()));
        });
        return humanPlayerDeckCopy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Card> getAIPlayerDeck() {
        final List<Card> aiPlayerDeckCopy = new ArrayList<>();
        List.copyOf(this.aiPlayerDeck).forEach(card -> {
            aiPlayerDeckCopy.add(new BaseCard(card.getName(), card.getLifePoint(), card.getAttack(), card.getMana(), card.getImageURL(), card.getEffect()));
        });
        return aiPlayerDeckCopy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectHumanPlayerDeck(final String deckName) {
       humanPlayerDeck = decksList.get(deckName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void selectAIPlayer(final String deckName) {
       aiPlayerDeck = decksList.get(deckName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeDeck(final String deckName) {
       aiPlayerDeck = decksList.remove(deckName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDeck(final String deckName, final List<Card> newDeck) {
        decksList.put(deckName,newDeck);
    } 
 
}
