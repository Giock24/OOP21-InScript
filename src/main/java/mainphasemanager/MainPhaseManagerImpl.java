package mainphasemanager;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import shared.Player;

public class MainPhaseManagerImpl implements MainPhaseManager {
    
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
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void positioning(final Card cardToBePositioned, final int boardCellIndex, final boolean isTheAITurn) {
        // TODO mettere un controllo sul mana totale che ha a disposizione il player di quel turno
        
        if (isTheAITurn) {
            this.playerPositioning(this.playerAI, cardToBePositioned, boardCellIndex);
            
            // TODO aggiungere handleEffect
        } else {
            this.playerPositioning(this.player, cardToBePositioned, boardCellIndex);
            
            // TODO aggiungere handleEffect
        }
    }
    
    /**
     *     when called the current Player place the card
     * 
     * @param currentPlayer
     */
    private void playerPositioning(final Player currentPlayer, final Card cardToBePositioned, final int boardCellIndex) {
        final List<Optional<Card>> tmpBoard = currentPlayer.getCurrentBoard();
        final List<Card> tmpHand = currentPlayer.getHand();
        
        if (tmpBoard.get(boardCellIndex).isEmpty()) {
            tmpBoard.set(boardCellIndex, Optional.of(cardToBePositioned));
            
            IntStream.range(0, tmpHand.size() - 1).forEach(index -> {
                final Card currentCard = tmpHand.get(index);
                
                if (currentCard.equals(cardToBePositioned)) {
                    tmpHand.remove(index);
                }
            });
        }
        
        
    }

}
