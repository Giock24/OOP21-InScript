package shared;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class AppStateSingleton implements AppState {

    private static AppStateSingleton instance = null; 
 
    private AppStateSingleton() {
        DecksList = new ArrayList<List<Card>>();
        DecksList.add(new ArrayList<Card>()); //TODO isert here a factory of deck
        humanPlayerDeck = DecksList.get(0);
        aiPlayerDeck =  DecksList.get(0);
    } 
 
    public static AppStateSingleton getInstance() {

        if (instance == null) {
            instance = new AppStateSingleton();
        }
        return instance;
    }
 
    
    private List<Card> humanPlayerDeck;
    
    private List<Card> aiPlayerDeck;
    
    private List<List<Card>> DecksList;
    

    @Override
    public List<List<Card>> getDecksList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Card> getHumanPlayerDeck() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Card> getAIPlayerDeck() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void selectHumanPlayerDeck(int indexOfTheDeckList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void selectAIPlayer(int indexOfTheDeckList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void demoveDeck(int indexOfTheDeckList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addDeck(List<Card> newDeck) {
        // TODO Auto-generated method stub
        
    } 
 
}
