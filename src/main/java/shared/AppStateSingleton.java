package shared;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import cards.DeckFactory;
import cards.DeckFactoryImpl;

public class AppStateSingleton implements AppState {

    private static AppStateSingleton instance = null; 
 
    private AppStateSingleton() {
        
        DeckFactory deckFactory = new DeckFactoryImpl();
        
        DecksList = new ArrayList<List<Card>>();
        DecksList.add(deckFactory.getPlayerDeck()); 
        DecksList.add(deckFactory.getPlayerIADeck());
        humanPlayerDeck = DecksList.get(0);
        aiPlayerDeck =  DecksList.get(1);
    } 
 
    public static AppStateSingleton getInstance() {

        if (instance == null) {
            instance = new AppStateSingleton();
        }
        return instance;
    }
 
    
    private List<List<Card>> DecksList;
    
    private List<Card> humanPlayerDeck;
    
    private List<Card> aiPlayerDeck;
    

    @Override
    public List<List<Card>> getDecksList() {
        return  this.DecksList;
    }

    @Override
    public List<Card> getHumanPlayerDeck() {
        return new ArrayList<>(List.copyOf(this.humanPlayerDeck));
    }

    @Override
    public List<Card> getAIPlayerDeck() {
        return new ArrayList<>(List.copyOf(this.aiPlayerDeck));
    }

    @Override
    public boolean selectHumanPlayerDeck(int indexOfTheDeckList) {
        if(indexOfTheDeckList<DecksList.size()){
            humanPlayerDeck = DecksList.get(indexOfTheDeckList);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean selectAIPlayer(int indexOfTheDeckList) {
        if(indexOfTheDeckList<DecksList.size()){
            aiPlayerDeck = DecksList.get(indexOfTheDeckList);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean demoveDeck(int indexOfTheDeckList) {
        if(indexOfTheDeckList<DecksList.size()){
            aiPlayerDeck = DecksList.remove(indexOfTheDeckList);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addDeck(List<Card> newDeck) {
        return DecksList.add(newDeck);
    } 
 
}
