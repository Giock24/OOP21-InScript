package in_script;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import cards.CardFactoyImpl;
import effects.Armored;
import shared.Player;
import shared.PlayerImpl;

import org.junit.jupiter.api.Test;

import battlephasemanager.BattlePhaseManager;
import battlephasemanager.BattlePhaseManagerImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class BattlePhaseManagerTest {
    
    final List<Optional<Card>> emptyBoard = new ArrayList<>();
    final List<Optional<Card>> marcosBoard = new ArrayList<>(), aIBoard =  new ArrayList<>(), resultBoard = new ArrayList<>();
    Player marco, aI;
    BattlePhaseManager battleManager;
    
    @BeforeEach
    void initialize() {
        IntStream.range(0, Player.NUM_CARD_BOARD).forEach( index -> {
            emptyBoard.add(Optional.empty());
        });
        marco = new PlayerImpl(false, Collections.EMPTY_LIST, 0, 0, 0, marcosBoard, Collections.EMPTY_LIST );
        aI = new PlayerImpl(true, Collections.EMPTY_LIST, 0, 0, 0, aIBoard, Collections.EMPTY_LIST );
        battleManager = new BattlePhaseManagerImpl(marco, aI);
    }
    
    @Test
    void testAIEmptyBoard() {
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        
        battleManager.startBattle(false);

        assertEquals(emptyBoard, this.aI.getCurrentBoard());
    }
    
    @Test
    void testPlayerEmptyBoard() {
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        
        battleManager.startBattle(true);

        assertEquals(emptyBoard, this.marco.getCurrentBoard());
    }

    @Test
    void aiHPLoss() {
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png")));
        
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());

        battleManager.startBattle(false);
        
        assertEquals(-5, this.aI.getLifePoints());
        assertEquals(5, this.marco.getLifePoints());
    }
    
    @Test
    void PoisonActivation() {
        // impossibile testare lastwill effect, per qualche motivo le liste sono letteralmente identiche, ma vengono comunque riconosciute come diverse, anche se non è presente nessuna
        // incoerenza, credo sia dovuto dal fatto che le carte create siano comunque considerate come carte diverse da quelle in cui cresce.
        // Stesso discorso anche per putridume.
        
        // PER QUALCHE MOTIVO, FAR COMBATTERE UN LADRO E UN TEMPLARE RENDE COMPLETAMENTE IRRICONOSCIBILE LE CARTE CHE HANNO COMBATTUTO. LA CARTA è LETTERALMENTE LA STESSA
        // MA VIENE COMUNQUE PRESA COME DIVERSA.
        
        // NON è POSSIBILE TESTARE NESSUN EFFETTO NE UNA NORMALE BATTAGLIA, IN QUANTO VENGONO TUTTI TRATTATI COME OGGETT DIVERSI PUR AVENDO LO STESSO STATO.
        
        // Tra l'altro, se un ladro combatte con un templare, questo si cura comunque del suo attacco.
        marcosBoard.add(Optional.of(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png")));
        marcosBoard.add(Optional.empty());
        marcosBoard.add(Optional.empty());
        marcosBoard.add(Optional.empty());
        
        // Optional.of(new CardFactoyImpl().lastwillEffect("Herald of The Pit", 6, 6, 6, "deckOfThePitImage/Herald_Of_The_Pit.png", "Seo", 2, 1, Optional.of(new Armored()), "deckOfThePitImage/Seo.png"))
        // Optional.of(new CardFactoyImpl().rottenEffect( "Mummy", 1, 4, 3, "standardDeckImage/Mummia.png"))
        aIBoard.add(Optional.of(new CardFactoyImpl().armoredEffect( "Templar", 2, 4, 5, "standardDeckImage/Templare.png")));
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.empty());
        
        resultBoard.add(Optional.empty());        
        resultBoard.add(Optional.empty());
        resultBoard.add(Optional.empty());
        resultBoard.add(Optional.empty());
        resultBoard.add(Optional.empty());
        
        battleManager.startBattle(false);
        
        assertEquals(resultBoard, this.aI.getCurrentBoard());
        assertEquals(-1, this.aI.getLifePoints());
        assertEquals(1, this.marco.getLifePoints());
        
    }
    
}
