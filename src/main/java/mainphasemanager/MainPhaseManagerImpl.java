package mainphasemanager;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.ActivationEvent;
import cards.Card;
import cards.Effect;
import shared.Player;

public class MainPhaseManagerImpl implements MainPhaseManager {
    
    private boolean isTheAITurn;
    private boolean canPlace;
    private boolean cellEmpty;
    
    private final Player player;
    private final Player playerAI;
    
    public MainPhaseManagerImpl(final Player player, final Player playerAI) {
        this.player = player;
        this.playerAI = playerAI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEffect() {
        
        if (this.isTheAITurn) {
            this.activeEvent(this.playerAI);
        } else {
            this.activeEvent(this.player);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void positioning(final Card cardToBePositioned, final int boardCellIndex, final boolean isTheAITurn) {
        this.isTheAITurn = isTheAITurn;
        if (isTheAITurn && this.isEnoughTheMana(this.playerAI, cardToBePositioned)) {
            this.playerPositioning(this.playerAI, cardToBePositioned, boardCellIndex);
            
            this.handleEffect();
        } else if (!isTheAITurn && this.isEnoughTheMana(this.player, cardToBePositioned)) {
            this.playerPositioning(this.player, cardToBePositioned, boardCellIndex);
            
            this.handleEffect();
        }
    }
    
    /**
     *     when called the current Player place the card
     *     and his current mana is decreased
     * 
     * @param currentPlayer
     */
    private void playerPositioning(final Player currentPlayer, final Card cardToBePositioned, final int boardCellIndex) {
        final List<Optional<Card>> tmpBoard = currentPlayer.getCurrentBoard();
        final List<Card> tmpHand = currentPlayer.getHand();
        
        if (this.isCellEmpty(tmpBoard, boardCellIndex)) {
            cardToBePositioned.setPlacementRounds(Card.FIRST_ROUND_PLACED);
            tmpBoard.set(boardCellIndex, Optional.of(cardToBePositioned));
            
            tmpHand.remove(cardToBePositioned);
            currentPlayer.setCurrentMana(- cardToBePositioned.getMana());
           
        }
           
    }
    
    /**
     *
     *    check the player's current board and for each
     *    event found active (On Positioning EFFECT)
     *
     * @param player
     */
    private void activeEvent(final Player player) {
        final List<Optional<Card>> tmpBoard = player.getCurrentBoard();
        
        IntStream.range(0, tmpBoard.size() - 1).forEach(index -> {
            if (tmpBoard.get(index).isPresent()) {
                final Card cardSaved = tmpBoard.get(index).get();
                
                if (cardSaved.getEffect().isPresent() &&
                    cardSaved.getEffect().get().getActivationEvent() == ActivationEvent.POSITIONING &&
                    cardSaved.getPlacementRounds() <= Effect.MAXIMUM_USE_EFFECT) {
                    
                    if (this.isTheAITurn) {
                        cardSaved.getEffect().get().useEffect(this.playerAI, this.player, index);
                        cardSaved.setPlacementRounds(cardSaved.getPlacementRounds() + 1);
                    } else {
                        cardSaved.getEffect().get().useEffect(this.player, this.playerAI, index);
                        cardSaved.setPlacementRounds(cardSaved.getPlacementRounds() + 1);
                    }
                }
                
            }
            
        });
    }
    
    /**
     * 
     *     check if the player can place that card with the current mana
     * 
     * @param player
     * @param cardToBePositioned
     * @return true if can place that card otherwise false
     */
    private boolean isEnoughTheMana (final Player player, final Card cardToBePositioned) {
        this.canPlace = player.getCurrentMana() - cardToBePositioned.getMana() >= MainPhaseManager.NO_ENOUGH_MANA;
        return this.canPlace;
    }
    
    /**
     * 
     *    check if the cell selected is empty
     * 
     * @param board
     * @param boardCellIndex
     * @return true if is empty otherwise false
     */
    private boolean isCellEmpty(final List<Optional<Card>> board, final int boardCellIndex) {
        this.cellEmpty = board.get(boardCellIndex).isEmpty();
        return this.cellEmpty;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkCanPlace() {
        return this.canPlace;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkCellEmpty() {
        return this.cellEmpty;
    }

}
