package gamemaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import battlephasemanager.BattlePhaseManager;
import cards.Card;
import drawphasemanager.DrawPhaseManager;
import drawphasemanager.DrawPhaseManagerImpl;
import mainphasemanager.MainPhaseManager;
import mainphasemanager.MainPhaseManagerIA;
import shared.Player;
import shared.PlayerImpl;

public class GameMasterImpl implements GameMaster {
    
    private Player humanPlayer;
    private Player aiPlayer;
    
    boolean isTheAIturn; // TODO verify if change must be do here or in the board controller
    
    private DrawPhaseManager drawPhaseManager;
    private MainPhaseManager mainPhaseManager;
    private BattlePhaseManager battlePhaseManager;
    private MainPhaseManagerIA mainPhaseManagerIA;

    public GameMasterImpl(List<Card> humanPlayerDeck, List<Card> aiPlayerDeck) {
        super();
        
        final List<Optional<Card>> emptyBoard = new ArrayList<Optional<Card>>();
        IntStream.range(0, Player.NUM_CARD_BOARD).forEach( index -> {
            emptyBoard.add(Optional.empty());
        });
        
        //System.out.print(emptyBoard.size());
        
        this.humanPlayer = new PlayerImpl(humanPlayerDeck, GameMasterImpl.DEFAULT_PLAYER_LIFE,  GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA,emptyBoard, new ArrayList<Card>());
        this.aiPlayer = new PlayerImpl(aiPlayerDeck,  GameMasterImpl.DEFAULT_PLAYER_LIFE, GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA,emptyBoard, new ArrayList<Card>());
        this.isTheAIturn = false;
        //this.drawPhaseManager = new ()
        //this.mainPhasemanager = new mainPhaseManager(humanPlayer)
        //this.battlePhaseManager = new ()
        //this.mainPhaseManagerIA = new mainPhaseManagerIA(aiPlayer)
    }

    @Override
    public boolean startGame() {
        Random rand = new Random();
        boolean isAITurn = rand.nextBoolean();
        
        drawPhaseManager.firstDraw(false);
        drawPhaseManager.firstDraw(true);
        
        if(isAITurn) {
            drawPhaseManager.draw(true);
            mainPhaseManagerIA.startAIMainPhase();
            battlePhaseManager.startBattle(true);
        }
        
        return isAITurn;
    }

    @Override
    public Player getHumanPlayer() {
        return humanPlayer;
    }

    @Override
    public Player getIAPlayer() {
        return aiPlayer;
    }

    @Override
    public DrawPhaseManager getDrawPhaseManager() {
        return drawPhaseManager;
    }

    @Override
    public MainPhaseManager getMainPhaseManager() {
        return mainPhaseManager;
    }

    @Override
    public BattlePhaseManager getBattlePhaseManager() {
        return battlePhaseManager;
    }

    @Override
    public MainPhaseManagerIA getMainPhaseManagerAI() {
        return mainPhaseManagerIA;
    }
    
}
