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
    public boolean startAIMainPhase() {
        /*
        playerAI.getHand().stream().forEach(card -> {
            System.out.print(card.getMana()+"\n");
        });
        */
        
        //System.out.print( indexOfTheMostExpensivePlacebleCard());
        
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
        
        return false;
    }
    
    private int numberOfEmptyBoardCell() {
        return (int) playerAI.getCurrentBoard().stream().filter((card)->card.isEmpty()).count();
    }
    
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
