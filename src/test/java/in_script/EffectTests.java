package in_script;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import battlephasemanager.BattlePhaseManager;
import cards.CardFactory;
import cards.CardFactoyImpl;
import drawphasemanager.DrawPhaseManager;
import gamemaster.GameMaster;
import gamemaster.GameMasterImpl;
import mainphasemanager.MainPhaseManager;
import shared.AppState;
import shared.AppStateSingleton;
import shared.Player;

class EffectTests {
    
    final static int LEFT = 0;
    final static int CENTER_LEFT = 1;
    final static int CENTER = 2;
    final static int CENTER_RIGHT = 3;
    final static int RIGHT = 4;
    
    final static boolean AITURN = true;
    final static boolean PLAYERTURN = false;

    final AppState appState = AppStateSingleton.getInstance();
    GameMaster gameMaster;
    Player aiPlayer;
    Player player;
    BattlePhaseManager battlePhase;
    CardFactory cardFactory;
    MainPhaseManager mainPhase;
    DrawPhaseManager drawPhase;
    
    @BeforeEach
    void initialize() {
        this.gameMaster = new GameMasterImpl(appState.getHumanPlayerDeck(), appState.getAIPlayerDeck());
        this.player = this.gameMaster.getHumanPlayer();
        this.aiPlayer = this.gameMaster.getIAPlayer();
        this.mainPhase = this.gameMaster.getMainPhaseManager();
        this.battlePhase = this.gameMaster.getBattlePhaseManager();
        this.cardFactory = new CardFactoyImpl();
        this.drawPhase = this.gameMaster.getDrawPhaseManager();
    }
        
    @Test
    void armoredTest() {
        player.getCurrentBoard().add(CENTER, Optional.of(cardFactory.armoredEffect("ArmoredTest", 4, 1, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER, Optional.of(cardFactory.armoredEffect("aiArmoredTest", 4, 2, 0, "")));
        
        battlePhase.startBattle(PLAYERTURN);
        battlePhase.startBattle(AITURN);
        
        System.out.println(player.getCurrentBoard().get(CENTER).get().getLifePoint());
        
        assertEquals(3, player.getCurrentBoard().get(CENTER).get().getLifePoint());
        assertEquals(3, aiPlayer.getCurrentBoard().get(CENTER).get().getLifePoint());
    }
    
    @Test
    void elusiveTest() {
        player.getCurrentBoard().add(CENTER, Optional.of(cardFactory.elusiveEffect("ElusiveTest", 4, 2, 0, "")));
        player.getCurrentBoard().add(CENTER_RIGHT, Optional.of(cardFactory.elusiveEffect("ElusiveTest", 4, 2, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER, Optional.of(cardFactory.elusiveEffect("aiElusiveTest", 4, 2, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER_RIGHT, Optional.of(cardFactory.armoredEffect("aiNotElusiveTest", 4, 2, 0, "")));
        
        battlePhase.startBattle(PLAYERTURN);
        
        assertEquals(2, aiPlayer.getCurrentBoard().get(CENTER).get().getLifePoint());
        assertEquals(-2, aiPlayer.getLifePoints());
    }
    
    @Test
    void growrhTest() {
        player.getCurrentBoard().add(CENTER, Optional.of(cardFactory.growthEffect("PreGrowthTest", 1, 1, 0, "", "GrowthTest", 4, 4, Optional.empty(), "")));
        
        drawPhase.draw(PLAYERTURN);
        
        assertEquals("GrowthTest", player.getCurrentBoard().get(CENTER).get().getName());
    }
    
    @Test
    void healetTest() {
        
        aiPlayer.getCurrentBoard().add(CENTER_LEFT, Optional.of(cardFactory.noEffect("aiNotHealerTest", 1, 1, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER, Optional.of(cardFactory.healerEffect("aiHealerTest", 3, 1, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER_RIGHT, Optional.of(cardFactory.noEffect("aiNotHealerTest", 1, 1, 0, "")));
        
        drawPhase.draw(PLAYERTURN);
        
        assertEquals(2, aiPlayer.getCurrentBoard().get(CENTER_LEFT).get().getLifePoint());
        assertEquals(2, aiPlayer.getCurrentBoard().get(CENTER_RIGHT).get().getLifePoint());
    }
    
    @Test
    void exaltedTest() {
        player.getCurrentBoard().add(CENTER_LEFT, Optional.of(cardFactory.noEffect("NotExaltedTest", 1, 1, 0, "")));
        player.getCurrentBoard().add(CENTER_RIGHT, Optional.of(cardFactory.noEffect("NotExaltedTest", 1, 1, 0, "")));
        
        mainPhase.positioning(cardFactory.exaltedEffect("ExaltedTest", 1, 1, 0, ""), CENTER, PLAYERTURN);
        
        assertEquals(2, player.getCurrentBoard().get(CENTER_LEFT).get().getAttack());
        assertEquals(2, player.getCurrentBoard().get(CENTER_RIGHT).get().getAttack());
    }
    
    @Test
    void lastWillTest() {
        player.getCurrentBoard().add(CENTER, Optional.of(cardFactory.lastwillEffect("LastWillNotTrasformedTest", 1, 4, 0, "", "LastWillTrasformedTest", 5, 5, Optional.empty(), "")));
        aiPlayer.getCurrentBoard().add(CENTER, Optional.of(cardFactory.noEffect("KillerOfLastWillTest", 10, 10, 0, "")));
        
        battlePhase.startBattle(AITURN);
        
        assertEquals("LastWillTrasformedTest", player.getCurrentBoard().get(CENTER).get().getName());
    }
    
    @Test
    void poisonTest() {
        player.getCurrentBoard().add(CENTER, Optional.of(cardFactory.poisonEffect("PoisonTest", 1, 1, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER, Optional.of(cardFactory.noEffect("NoEffectWallTest", 10, 10, 0, "")));
        
        battlePhase.startBattle(PLAYERTURN);
        
        assertEquals(true, aiPlayer.getCurrentBoard().get(CENTER).isEmpty());
    }
    
    @Test
    void rottenTest() {
        player.getCurrentBoard().add(CENTER, Optional.of(cardFactory.rottenEffect("RottenTest", 2, 2, 0, "")));
        aiPlayer.getCurrentBoard().add(CENTER, Optional.of(cardFactory.noEffect("KillerOfRottenTest", 10, 10, 0, "")));
        
        battlePhase.startBattle(AITURN);
        
        assertEquals("Putridume", player.getCurrentBoard().get(CENTER).get().getName());
    }
}
