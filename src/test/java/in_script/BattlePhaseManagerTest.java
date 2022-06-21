package in_script;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import cards.CardFactoyImpl;
import shared.Player;
import shared.PlayerImpl;

import org.junit.jupiter.api.Test;

import battlephasemanager.BattlePhaseManager;
import battlephasemanager.BattlePhaseManagerImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;


public class BattlePhaseManagerTest {
    
    final List<Optional<Card>> emptyBoard = new ArrayList<>();
    final List<Optional<Card>> marcosBoard = new ArrayList<>(), aIBoard =  new ArrayList<>();
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
    void playerEffectActivation() {
        
    }
    
    @Test
    void playerOnDeathEffectActivation() {
        
    }
}
