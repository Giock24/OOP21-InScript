package drawphasemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cards.ActivationEvent;
import cards.Card;
import shared.Player;

public class DrawPhaseManagerImpl implements DrawPhaseManager {
    
    private static final int NO_MORE_CARDS = 0;
    
    private boolean isTheAIturn;
    
    private final Player player;
    private final Player playerAI;
    
    // lasciati per i testing togliere col tempo
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
        
        this.selectEventAndPlayer(ActivationEvent.EVERYDRAW, this.playerAI);
        this.selectEventAndPlayer(ActivationEvent.EVERYDRAW, this.player);
        
        if (this.isTheAIturn) {
            this.selectEventAndPlayer(ActivationEvent.ENEMYDRAW, this.playerAI);
        } else {
            this.selectEventAndPlayer(ActivationEvent.MYDRAW, this.player);
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
        } else {
            this.player.getMana();
            this.generalDraw(this.player);
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
        final List<Card> tmpDeck = currentPlayer.getDeck();
        final List<Card> tmpHand = currentPlayer.getHand();
        
        
        if (currentPlayer.getDeck().size() > DrawPhaseManagerImpl.NO_MORE_CARDS) {
            this.currentDeck = tmpDeck; // campi da togliere in seguito
            this.currentHand = tmpHand;
            
            tmpHand.add(tmpDeck.get(tmpDeck.size() - 1));
            tmpDeck.remove(tmpDeck.size() - 1);
        }
    }
    
    /**
     * 
     *    select an ActivationEvent to filter the current Board and for each
     *    event found draw a card
     * 
     * @param event 
     * @param player 
     */
    private void selectEventAndPlayer(final ActivationEvent event, final Player player) {
        final List<Optional<Card>> tmpBoard = player.getCurrentBoard();
        
        for(int pos = 0; pos <= tmpBoard.size(); pos++) {
            if (tmpBoard.get(pos).isPresent()) {
                final Card cardSaved = tmpBoard.get(pos).get();
                
              if (cardSaved.getEffect().isPresent() && 
                  cardSaved.getEffect().get().getActivationEvent() == event) {
                  cardSaved.getEffect().get().useEffect(player, playerAI, pos);
                  
              }
              
            }   
            
        }
        
    }
    
    public List<Card> getCurrentDeck() {
        return new ArrayList<>(List.copyOf(this.currentDeck));
    }
    
    public List<Card> getCurrentHand() {
        return new ArrayList<>(List.copyOf(this.currentHand));
    }

}
