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
        marco = new PlayerImpl(false, Collections.emptyList(), 0, 0, 0, marcosBoard, Collections.emptyList() );
        aI = new PlayerImpl(true, Collections.emptyList(), 0, 0, 0, aIBoard, Collections.emptyList() );
        battleManager = new BattlePhaseManagerImpl(marco, aI);
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
    void PlayerEffectActivation() {
        marcosBoard.add(Optional.of(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png")));
        marcosBoard.add(Optional.of(new CardFactoyImpl().elusiveEffect( "Thief", 1, 3, 3, "standardDeckImage/Ladro.png")));
        
        aIBoard.add(Optional.of(new CardFactoyImpl().armoredEffect( "Templar", 2, 4, 5, "standardDeckImage/Templare.png")));
        aIBoard.add(Optional.empty());
        aIBoard.add(Optional.of(new CardFactoyImpl().rottenEffect( "Mummy", 1, 4, 3, "standardDeckImage/Mummia.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().lastwillEffect("Herald of The Pit", 6, 6, 6, "deckOfThePitImage/Herald_Of_The_Pit.png", "Seo", 2, 1, Optional.of(new Armored()), "deckOfThePitImage/Seo.png")));
        aIBoard.add(Optional.of(new CardFactoyImpl().armoredEffect( "Templar", 2, 4, 5, "standardDeckImage/Templare.png")));
        
        resultBoard.add(Optional.empty());        
        resultBoard.add(Optional.empty());
        resultBoard.add(Optional.of(new CardFactoyImpl().noEffect("Putridume", 3, 0, 3, "standardDeckImage/Putridume.png")));
        resultBoard.add(Optional.of(new CardFactoyImpl().armoredEffect("Seo", 2, 1, 6, "deckOfThePitImage/Seo.png")));
        resultBoard.add(Optional.of(new CardFactoyImpl().armoredEffect( "Templar", 3, 4, 5, "standardDeckImage/Templare.png")));
        
        battleManager.startBattle(false);

        IntStream.range(0, Player.NUM_CARD_BOARD).forEach( index -> {
            if(resultBoard.get(index).isPresent()) {
                assertEquals(resultBoard.get(index).get().getName(), aIBoard.get(index).get().getName());
                assertEquals(resultBoard.get(index).get().getLifePoint(), aIBoard.get(index).get().getLifePoint());
                assertEquals(resultBoard.get(index).get().getAttack(), aIBoard.get(index).get().getAttack());
                assertEquals(resultBoard.get(index).get().getMana(), aIBoard.get(index).get().getMana());
                assertEquals(resultBoard.get(index).get().getImageURL(), aIBoard.get(index).get().getImageURL());
                if(resultBoard.get(index).get().getEffect().isPresent()) {
                    assertEquals(resultBoard.get(index).get().getEffect().get().getNameEffect(), aIBoard.get(index).get().getEffect().get().getNameEffect());
                    assertEquals(resultBoard.get(index).get().getEffect().get().getDescriptionEffect(), aIBoard.get(index).get().getEffect().get().getDescriptionEffect());
                    assertEquals(resultBoard.get(index).get().getEffect().get().getImageEffectURL(), aIBoard.get(index).get().getEffect().get().getImageEffectURL());
                    assertEquals(resultBoard.get(index).get().getEffect().get().getActivationEvent(), aIBoard.get(index).get().getEffect().get().getActivationEvent());
                }
            }
        });
        
        assertEquals(-4, this.aI.getLifePoints());
        assertEquals(4, this.marco.getLifePoints());
        
    }
    
}
