package drawphasemanager;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import cards.ActivationEvent;
import cards.Card;
import cards.Effect;
import gamemaster.GameMaster;
import shared.Player;

public class DrawPhaseManagerImpl implements DrawPhaseManager {
    
    private boolean isTheAIturn;
    
    private final Player player;
    private final Player playerAI;
    private final Random rng = new Random();
    
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
            this.selectEventAndPlayer(ActivationEvent.ENEMYDRAW, this.player);
        } else {
            this.selectEventAndPlayer(ActivationEvent.ENEMYDRAW, this.playerAI);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void firstDraw() {
        
            IntStream.range(0, DrawPhaseManager.INITAL_CARD_IN_THE_HAND).forEach(index -> {
                this.generalDraw(this.playerAI);
                this.generalDraw(this.player);
            });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean draw(final boolean isTheAIturn) {
        this.isTheAIturn = isTheAIturn;
        
        if (this.isTheAIturn) {
            this.updatePlacementRounds(this.playerAI);
            this.restoreMana(this.playerAI);
            this.generalDraw(this.playerAI);
            
            this.handleEffect();
        } else {
            this.updatePlacementRounds(this.player);
            this.restoreMana(this.player);
            this.generalDraw(this.player);
            
            this.handleEffect();
        }

        return false;

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void drawWithoutMana(final Player player) {
            this.generalDraw(player);
    }
    
    /**
     *   when called add one card on currentPlayer's hand
     *   
     * @param currentPlayer
     * @return 
     */
    private boolean generalDraw(final Player currentPlayer) {
        final List<Card> tmpDeck = currentPlayer.getDeck();
        final List<Card> tmpHand = currentPlayer.getHand();
        
        if (tmpDeck.size() > DrawPhaseManager.NO_MORE_CARDS) {
            
            final int randInt = this.rng.nextInt() % (tmpDeck.size());
            final int index = Math.abs(randInt);
            
            tmpHand.add(tmpDeck.get(index));
            tmpDeck.remove(index);
        }
        return checkGameEnd();
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
        
        for(int pos = 0; pos <= tmpBoard.size()-1; pos++) {
            if (tmpBoard.get(pos).isPresent()) {
                final Card cardSaved = tmpBoard.get(pos).get();
                
              if (cardSaved.getEffect().isPresent() && 
                  cardSaved.getEffect().get().getActivationEvent() == event &&
                  cardSaved.getPlacementRounds() <= Effect.MAXIMUM_USE_EFFECT) {
                  
                  if(this.isTheAIturn) {
                      cardSaved.getEffect().get().useEffect(this.playerAI, this.player, pos);
                  } else {
                      cardSaved.getEffect().get().useEffect(this.player, this.playerAI, pos);
                  }
                  
              }
              
            }   
            
        }
        
    }
    
    /**
     * 
     *     when called restore all mana of that player
     * 
     * @param player
     */
    private void restoreMana(final Player player) {
        if (player.getMana() + GameMaster.MANA_PLUS_ONE <= GameMaster.MAXIMUM_MANA) {
            player.setMana(GameMaster.MANA_PLUS_ONE);
        } 
        
        player.setCurrentMana(player.getMana() - player.getCurrentMana());
    }
    
    /**
     * 
     *    when called increase the placement round for each card on board
     * 
     * @param player
     */
    private void updatePlacementRounds(final Player player) {
        final List<Optional<Card>> tmpBoard = player.getCurrentBoard();
        
        tmpBoard.forEach(card -> {
            if (card.isPresent()) {
                card.get().setPlacementRounds(card.get().getPlacementRounds() + 1);
            }
        });
        
    }
    
    private boolean checkGameEnd() {
        return this.player.getLifePoints() <= GameMaster.MIN_PLAYER_LIFE || this.playerAI.getLifePoints() <= GameMaster.MIN_PLAYER_LIFE; 
    }

}
