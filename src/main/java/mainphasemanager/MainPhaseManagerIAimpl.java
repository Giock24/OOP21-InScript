package mainphasemanager;

import java.util.Optional;
import java.util.Random;

import cards.Card;
import gamemaster.GameMaster;
import shared.Player;

public class MainPhaseManagerIAimpl implements MainPhaseManagerIA {
    
    private final Player player;
    private final Player playerAI;
    private final MainPhaseManager mainPhaseManager;
    private final Random rand;
    private int cheaperPlacableCard;
    
    public MainPhaseManagerIAimpl(final Player player, final Player playerAI) {
        this.player = player;
        this.playerAI = playerAI;
        this.mainPhaseManager = new MainPhaseManagerImpl(player,playerAI);
        this.rand = new Random();
        cheaperPlacableCard=GameMaster.MAXIMUM_MANA+1;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void startAIMainPhase() {
        
        if(numberOfEmptyBoardCell() != 0) {
            do {
                final Optional<Card> cardToPlace =  getMostExpensivePlacebleCard();
                if(cardToPlace.isPresent()) {
                    this.mainPhaseManager.positioning(cardToPlace.get(), indexOfTheDungerousEnemyCardNotAlreadyCovered(), true);
                } else {
                    break;
                }
            } while (cheaperPlacableCard<=playerAI.getCurrentMana() && numberOfEmptyBoardCell() != 0);
        }
        
    }
    
    /**
     * this method calculate how many available cell are in the AI Board
     * 
     * @return the number of Empty Cell in the Board
     */
    private int numberOfEmptyBoardCell() {
        return (int) playerAI.getCurrentBoard().stream().filter((card)->card.isEmpty()).count();
    }
    
    /**
     * this method return the card with the higher mana cost in the AI hand that 
     * the AI is able to place based on AI current mana 
     * 
     * @return the card can be empty
     */
    private Optional<Card> getMostExpensivePlacebleCard() {

        Optional<Card> MostExpensiveCard = Optional.empty();
        cheaperPlacableCard=GameMaster.MAXIMUM_MANA+1;
        
        for (final Card card:playerAI.getHand()) {
            if(MostExpensiveCard.isPresent()) {
                if(card.getMana()>MostExpensiveCard.get().getMana() && card.getMana()<=playerAI.getCurrentMana()) {
                    MostExpensiveCard = Optional.of(card);
                }
            } else { 
                if( card.getMana()<=playerAI.getCurrentMana()) {
                    MostExpensiveCard = Optional.of(card);
                }
            }
           if(card.getMana()<cheaperPlacableCard) {
               cheaperPlacableCard=card.getMana();
           }
        }
        return MostExpensiveCard;     
    }
    
    /**
     * this method calculate the index of the most dangerous card of the enemy
     * that not have any card in fort of it.
     * the index of dangerousness of a card is based of its attack
     * 
     * @return index where AI should place the next card
     */
    private int indexOfTheDungerousEnemyCardNotAlreadyCovered() {
        int indexOfTheDungerous = Math.abs(rand.nextInt()%Player.NUM_CARD_BOARD);
        do {indexOfTheDungerous = Math.abs(rand.nextInt()%Player.NUM_CARD_BOARD); } while (playerAI.getCurrentBoard().get(indexOfTheDungerous).isPresent());
        
        int dungerousCardAttack = player.getCurrentBoard().get(indexOfTheDungerous).isPresent()? player.getCurrentBoard().get(indexOfTheDungerous).get().getAttack():0;
        
        for(final Optional<Card> card:player.getCurrentBoard()) {
            if(card.isPresent() && card.get().getAttack()>dungerousCardAttack && playerAI.getCurrentBoard().get(player.getCurrentBoard().indexOf(card)).isEmpty()) {
                indexOfTheDungerous = player.getCurrentBoard().indexOf(card);
                dungerousCardAttack = card.get().getAttack();
            }
        }
        
        return indexOfTheDungerous;
        
    }
}
