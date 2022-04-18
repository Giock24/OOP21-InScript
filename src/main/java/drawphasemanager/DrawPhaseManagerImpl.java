package drawphasemanager;

import java.util.ArrayList;
import java.util.List;

import cards.ActivationEvent;
import cards.Card;
import shared.Player;

public class DrawPhaseManagerImpl implements DrawPhaseManager {
    
    private static final int NO_MORE_CARDS = 0;
    private boolean isTheAIturn;
    private final Player player;
    private final Player playerAI;
    private List<Card> currentDeck;
    private List<Card> currentHand;
    
    public DrawPhaseManagerImpl (final Player player, final Player playerAI) {
        this.player = player;
        this.playerAI = playerAI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEffect() {
        
        if (this.isTheAIturn) {
            this.selectEventAndPlayer(ActivationEvent.ENEMYDRAW, this.playerAI);
            this.selectEventAndPlayer(ActivationEvent.EVERYDRAW, this.playerAI);
        } else {
            this.selectEventAndPlayer(ActivationEvent.MYDRAW, this.player);
            this.selectEventAndPlayer(ActivationEvent.EVERYDRAW, this.player);
        }
    }
    
    @Override
    public void firstDraw(final boolean isTheAIturn) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final boolean isTheAIturn) {
        this.isTheAIturn = isTheAIturn;
        
        if (this.isTheAIturn) {
            this.playerAI.getMana();
            this.generalDraw(this.playerAI);
            
            this.handleEffect();
        } else {
            this.player.getMana();
            this.generalDraw(this.player);
            
            this.handleEffect();
        }

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void drawWithoutMana(final boolean isTheAITurn) {
        if (isTheAITurn) {
            this.generalDraw(this.playerAI);
        } else {
            this.generalDraw(this.player);
        }
        
    }
    
    /**
     *   when called add one card on currentPlayer's hand
     *   
     * @param currentPlayer
     */
    private void generalDraw(final Player currentPlayer) {
        if (currentPlayer.getDeck().size() > DrawPhaseManagerImpl.NO_MORE_CARDS) {
            this.currentDeck = currentPlayer.getDeck();
            this.currentHand = currentPlayer.getHand();
            
            this.currentHand.add(this.currentDeck.get(this.currentDeck.size() - 1));
            this.currentDeck.remove(this.currentDeck.size() - 1);
        }
    }
    
    private void selectEventAndPlayer(final ActivationEvent event, final Player player) {
        this.currentHand.stream().filter(card -> card.getEffect().isPresent()).filter(card -> card
                .getEffect().get().getActivationEvent() == event)
                .peek(card -> this.generalDraw(player)); 
    }
    
    public List<Card> getCurrentDeck() {
        return new ArrayList<>(List.copyOf(this.currentDeck));
    }
    
    public List<Card> getCurrentHand() {
        return new ArrayList<>(List.copyOf(this.currentHand));
    }

}
