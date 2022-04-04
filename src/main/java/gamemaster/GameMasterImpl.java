package gamemaster;

import java.util.ArrayList;
import java.util.Optional;

import cards.Card;
import drawphasemanager.DrawPhaseManagerImpl;
import mainphasemanager.MainPhaseManager;
import shared.Player;
import shared.PlayerImpl;

public class GameMasterImpl implements GameMaster {
    
    Player humanPlayer;
    Player aiPlayer;
    
    boolean isTheAIturn;

    public GameMasterImpl(ArrayList<Card> humanPlayerDeck, ArrayList<Card> aiPlayerDeck, boolean isTheAIturn) {
        super();
        this.humanPlayer = new PlayerImpl(humanPlayerDeck, GameMasterImpl.DEFAULT_PLAYER_LIFE,  GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA, new ArrayList<Optional<Card>>(Player.NUM_CARD_BOARD), new ArrayList<Card>());
        this.aiPlayer = new PlayerImpl(aiPlayerDeck,  GameMasterImpl.DEFAULT_PLAYER_LIFE, GameMasterImpl.INITIAL_MANA, GameMasterImpl.INITIAL_MANA, new ArrayList<Optional<Card>>(Player.NUM_CARD_BOARD), new ArrayList<Card>());
        this.isTheAIturn = isTheAIturn;
    }

    @Override
    public boolean startGame() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
