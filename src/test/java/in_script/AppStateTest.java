package in_script;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

import cards.Card;
import shared.AppState;
import shared.AppStateSingleton;

public class AppStateTest {
    
    final AppState appState = AppStateSingleton.getInstance();
    
    @Test
    void indipendetCopyTest() {
        
        final AppState appState = AppStateSingleton.getInstance();
        
        final List<Card> humanDeck = appState.getHumanPlayerDeck();
        final List<Card> humanDeck2 = appState.getHumanPlayerDeck();
        
        final List<Card> aiDeck = appState.getAIPlayerDeck();
        final List<Card> aiDeck2 = appState.getAIPlayerDeck();
        
        assertEquals(humanDeck.size(),humanDeck2.size());
        assertEquals(aiDeck.size(),aiDeck2.size());
        
        for(final Card card:humanDeck) {
            assertFalse(humanDeck2.contains(card));
            final int numberInDeck1= (int) humanDeck.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            final int numberInDeck2= (int) humanDeck2.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            assertEquals(numberInDeck1,numberInDeck2);
        }
        
        for(final Card card:aiDeck) {
            assertFalse(aiDeck2.contains(card));
            final int numberInDeck1= (int) humanDeck.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            final int numberInDeck2= (int) humanDeck2.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            assertEquals(numberInDeck1,numberInDeck2);
        }
        
       
    }
    
    @Test
    void sigletonTest() {
        final AppState appState = AppStateSingleton.getInstance();
        final AppState appState2 = AppStateSingleton.getInstance();
    
        final Random rand = new Random();
        final Set<String> deckNames =  appState.getDecksList().keySet();
        
        final String deckName = (String) deckNames.toArray()[Math.abs(rand.nextInt()%deckNames.size())];
        
        appState.selectHumanPlayerDeck(deckName);
        appState.selectAIPlayer(deckName);
        
        final List<Card> humanDeck = appState.getHumanPlayerDeck();
        final List<Card> humanDeck2 = appState2.getHumanPlayerDeck();
        
        final List<Card> aiDeck = appState.getAIPlayerDeck();
        final List<Card> aiDeck2 = appState2.getAIPlayerDeck();
        
        assertEquals(humanDeck.size(),humanDeck2.size());
        assertEquals(aiDeck.size(),aiDeck2.size());
        
        for(final Card card:humanDeck) {
            final int numberInDeck1= (int) humanDeck.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            final int numberInDeck2= (int) humanDeck2.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            assertEquals(numberInDeck1,numberInDeck2);
        }
        
        for(final Card card:aiDeck) {
            final int numberInDeck1= (int) aiDeck.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            final int numberInDeck2= (int) aiDeck2.stream().filter(deckCard -> deckCard.getName() == card.getName()).count();
            assertEquals(numberInDeck1,numberInDeck2);
        }
        
    } 
    

    
}
