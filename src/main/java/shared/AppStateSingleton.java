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
        
        DeckFactory deckFactory = new DeckFactoryImpl();
        
        DecksList = new HashMap<String, List<Card>>();
        DecksList.putAll(deckFactory.getDecks());
        
        humanPlayerDeck = DecksList.get("deck-standard");
        aiPlayerDeck =  DecksList.get("deck-standard-IA");
    } 
 
    public static AppStateSingleton getInstance() {

        if (instance == null) {
            instance = new AppStateSingleton();
        }
        return instance;
    }
 
    
    
    private Map<String, List<Card>> DecksList;
    
    private List<Card> humanPlayerDeck;
    
    private List<Card> aiPlayerDeck;
    

    @Override
    public  Map<String, List<Card>> getDecksList() {
        return  this.DecksList;
    }

    @Override
    public List<Card> getHumanPlayerDeck() {
        final List<Card> humanPlayerDeckCopy = new ArrayList<>();
        List.copyOf(this.humanPlayerDeck).forEach(card -> {
            humanPlayerDeckCopy.add(new BaseCard(card.getIdCard(), card.getName(), card.getLifePoint(), card.getAttack(), card.getMana(), card.getEffect()));
        });
        return humanPlayerDeckCopy;
    }

    @Override
    public List<Card> getAIPlayerDeck() {
        final List<Card> AiPlayerDeckCopy = new ArrayList<>();
        List.copyOf(this.aiPlayerDeck).forEach(card -> {
            AiPlayerDeckCopy.add(new BaseCard(card.getIdCard(), card.getName(), card.getLifePoint(), card.getAttack(), card.getMana(), card.getEffect()));
        });
        return AiPlayerDeckCopy;
    }

    @Override
    public void selectHumanPlayerDeck(final String deckName) {
       humanPlayerDeck = DecksList.get(deckName);
    }

    @Override
    public void selectAIPlayer(final String deckName) {
       aiPlayerDeck = DecksList.get(deckName);
    }

    @Override
    public void demoveDeck(final String deckName) {
       aiPlayerDeck = DecksList.remove(deckName);
    }

    @Override
    public void addDeck(String deckName,List<Card> newDeck) {
        DecksList.put(deckName,newDeck);
    } 
 
}
