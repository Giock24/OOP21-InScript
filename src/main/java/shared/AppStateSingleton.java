package shared;

import java.util.ArrayList;
import java.util.List;

import cards.BaseCard;
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
