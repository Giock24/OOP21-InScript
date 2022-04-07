package gamemaster;

import java.util.ArrayList;
import java.util.Optional;

import battlephasemanager.BattlePhaseManager;
import cards.Card;
import drawphasemanager.DrawPhaseManager;
import drawphasemanager.DrawPhaseManagerImpl;
import mainphasemanager.MainPhaseManager;
import shared.Player;
import shared.PlayerImpl;

public class GameMasterImpl implements GameMaster {
    
    private Player humanPlayer;
    private Player aiPlayer;
    
    boolean isTheAIturn; // TODO verify if change must be do here or in the board controller
    
    private DrawPhaseManager drawPhaseManager;
    private MainPhaseManager mainPhaseManager;
    private BattlePhaseManager battlePhaseManager;

    public GameMasterImpl(ArrayList<Card> humanPlayerDeck, ArrayList<Card> aiPlayerDeck) {
        super();
        this.humanPlayer = new PlayerImpl(humanPlayerDeck, GameMasterImpl.DEFAULT_PLAYER_LIFE,  GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA, new ArrayList<Optional<Card>>(), new ArrayList<Card>());
        this.aiPlayer = new PlayerImpl(aiPlayerDeck,  GameMasterImpl.DEFAULT_PLAYER_LIFE, GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA, new ArrayList<Optional<Card>>(), new ArrayList<Card>());
        this.isTheAIturn = false;
        //this.drawPhaseManager = new ()
        //this.mainPhasemanager = new ()
        //this.battlePhaseManager = new ()
    }

    @Override
    public boolean startGame() {
        // TODO Auto-generated method stub
        return false;
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
    
}
