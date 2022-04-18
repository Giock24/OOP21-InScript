package drawphasemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cards.Card;
import gamemaster.GameMaster;
import shared.Player;

public class DrawPhaseManagerImpl implements DrawPhaseManager {
    
    private static final boolean PLAYER_TURN = true;
    private static final int NO_MORE_CARDS = 0;
    private Player player;
    private Player playerIA;
    private List<Card> currentDeck;
    private List<Card> currentHand;

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEffect() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawPhaseManager(final Player player, final Player playerIA) {
        this.player = player;
        this.playerIA = playerIA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean draw(final boolean isThePlayerTurn) {
        if (isThePlayerTurn == DrawPhaseManagerImpl.PLAYER_TURN) {
            return this.manaAndHand(this.player);
        } else {
            return this.manaAndHand(this.playerIA);
        }

    }
    
    /**
     *   when called increment mana and add one card on currentPlayer's hand
     *   
     * @param currentPlayer
     */
    private boolean manaAndHand(final Player currentPlayer) {
        if (currentPlayer.getDeck().size() > DrawPhaseManagerImpl.NO_MORE_CARDS) {
            currentPlayer.getMana();
            this.currentDeck = new ArrayList<>(currentPlayer.getDeck().stream().collect(Collectors.toList()));
            this.currentHand = new ArrayList<>(currentPlayer.getHand().stream().collect(Collectors.toList()));
            
            this.currentHand.add(this.currentDeck.get(this.currentDeck.size() - 1));
            this.currentDeck.remove(this.currentDeck.size() - 1);
        }
        return checkGameEnd();
    }
    
    public List<Card> getCurrentDeck() {
        return new ArrayList<>(List.copyOf(this.currentDeck));
    }
    
    public List<Card> getCurrentHand() {
        return new ArrayList<>(List.copyOf(this.currentHand));
    }
    
    private boolean checkGameEnd() {
        return this.player.getLifePoints() <= GameMaster.MIN_PLAYER_LIFE || this.playerIA.getLifePoints() <= GameMaster.MIN_PLAYER_LIFE; 
    }

    @Override
    public void firstDraw(boolean isTheAIturn) {
        // TODO Auto-generated method stub
        
    }

}
