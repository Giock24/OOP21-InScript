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
    

    @Override
    public  Map<String, List<Card>> getDecksList() {
        return  this.decksList;
    }

    @Override
    public List<Card> getHumanPlayerDeck() {
        final List<Card> humanPlayerDeckCopy = new ArrayList<>();
        List.copyOf(this.humanPlayerDeck).forEach(card -> {
            humanPlayerDeckCopy.add(new BaseCard(card.getName(), card.getLifePoint(), card.getAttack(), card.getMana(), card.getImageURL(), card.getEffect()));
        });
        return humanPlayerDeckCopy;
    }

    @Override
    public List<Card> getAIPlayerDeck() {
        final List<Card> aiPlayerDeckCopy = new ArrayList<>();
        List.copyOf(this.aiPlayerDeck).forEach(card -> {
            aiPlayerDeckCopy.add(new BaseCard(card.getName(), card.getLifePoint(), card.getAttack(), card.getMana(), card.getImageURL(), card.getEffect()));
        });
        return aiPlayerDeckCopy;
    }

    @Override
    public void selectHumanPlayerDeck(final String deckName) {
       humanPlayerDeck = decksList.get(deckName);
    }

    @Override
    public void selectAIPlayer(final String deckName) {
       aiPlayerDeck = decksList.get(deckName);
    }

    @Override
    public void demoveDeck(final String deckName) {
       aiPlayerDeck = decksList.remove(deckName);
    }

    @Override
    public void addDeck(final String deckName, final List<Card> newDeck) {
        decksList.put(deckName,newDeck);
    } 
 
}
