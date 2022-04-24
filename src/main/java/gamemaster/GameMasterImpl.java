package gamemaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import battlephasemanager.BattlePhaseManager;
import battlephasemanager.BattlePhaseManagerImpl;
import cards.Card;
import drawphasemanager.DrawPhaseManager;
import drawphasemanager.DrawPhaseManagerImpl;
import mainphasemanager.MainPhaseManager;
import mainphasemanager.MainPhaseManagerIA;
import mainphasemanager.MainPhaseManagerImpl;
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
        
        this.humanPlayer = new PlayerImpl(false,humanPlayerDeck, GameMasterImpl.DEFAULT_PLAYER_LIFE,  GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA,new ArrayList<Optional<Card>>(emptyBoard), new ArrayList<Card>());
        this.aiPlayer = new PlayerImpl(true,aiPlayerDeck, GameMasterImpl.DEFAULT_PLAYER_LIFE, GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA,new ArrayList<Optional<Card>>(emptyBoard), new ArrayList<Card>());
        this.isTheAIturn = false;
        this.drawPhaseManager = new DrawPhaseManagerImpl(humanPlayer, aiPlayer);
        this.mainPhaseManager = new MainPhaseManagerImpl(humanPlayer, aiPlayer);
        this.battlePhaseManager = new BattlePhaseManagerImpl(humanPlayer, aiPlayer);
        //this.mainPhaseManagerIA = new mainPhaseManagerIA(aiPlayer)
    }

    @Override
    public void startGame() {
        
        System.out.print("startGame\n");
        
        drawPhaseManager.firstDraw();
        
        System.out.print(aiPlayer.getHand().size()+"\n");
        System.out.print(humanPlayer.getHand().size()+"\n");
        
        drawPhaseManager.draw(true);
        //mainPhaseManagerIA.startAIMainPhase();

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
