package drawphasemanager;

import java.util.ArrayList;
import java.util.List;

import cards.Card;
import shared.Player;

public class DrawPhaseManagerImpl implements DrawPhaseManager {
    
    private static final boolean PLAYER_TURN = true;
    private static final int NO_MORE_CARDS = 0;
    private final Player player;
    private final Player playerIA;
    private List<Card> currentDeck;
    private List<Card> currentHand;
    
    public DrawPhaseManagerImpl (final Player player, final Player playerIA) {
        this.player = player;
        this.playerIA = playerIA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEffect() {
        // appena ci sarà un getActivationEvent sostituirai la condizione della filter
        // nel caso del player controllerai che la carta abbia o myDraw o everyDraw
        // nel caso del IA (enemyDraw o everyDraw)
        this.currentHand.stream().filter(card -> card.gatMana() == 12).peek(card -> this.draw(PLAYER_TURN));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final boolean isThePlayerTurn) {
        if (isThePlayerTurn == DrawPhaseManagerImpl.PLAYER_TURN) {
            this.manaAndHand(this.player);
        } else {
            this.manaAndHand(this.playerIA);
        }

    }
    
    /**
     *   when called increment mana and add one card on currentPlayer's hand
     *   
     * @param currentPlayer
     */
    private void manaAndHand(final Player currentPlayer) {
        if (currentPlayer.getDeck().size() > DrawPhaseManagerImpl.NO_MORE_CARDS) {
            currentPlayer.getMana();
            this.currentDeck = currentPlayer.getDeck();
            this.currentHand = currentPlayer.getHand();
            
            this.currentHand.add(this.currentDeck.get(this.currentDeck.size() - 1));
            this.currentDeck.remove(this.currentDeck.size() - 1);
        }
    }
    
    public List<Card> getCurrentDeck() {
        return new ArrayList<>(List.copyOf(this.currentDeck));
    }
    
    public List<Card> getCurrentHand() {
        return new ArrayList<>(List.copyOf(this.currentHand));
    }

    @Override
    public void firstDraw(boolean isTheAIturn) {
        // TODO Auto-generated method stub
        
    }

}
