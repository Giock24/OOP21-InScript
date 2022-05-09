package shared;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import cards.Card;

public class PlayerImpl implements Player {
    
    private final boolean isAiPlayer;
    private final List<Card> deck;
    private int lifePoints;
    private int mana;
    private int currentMana;
    private List<Optional<Card>> currentBoard;
    private final List<Card> hand;
    
    public PlayerImpl(final boolean isAiplayer, final List<Card> deck, final int lifePoints, final int mana, final int currentMana, final List<Optional<Card>> currentBoard, final List<Card> hand) {
        super();
        this.isAiPlayer= isAiplayer;
        this.deck = deck;
        this.lifePoints = lifePoints;
        this.mana = mana;
        this.currentMana = currentMana;
        this.currentBoard = currentBoard;
        this.hand = hand;
    }
    

    /**
     *  {@inheritDoc}
     */
    @Override
    public boolean isAiPlayer() {
        return this.isAiPlayer;
    }
        

    /**
     *  {@inheritDoc}
     */
    @Override
    public List<Card> getDeck() {
        return this.deck;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public int getMana() {
        return this.mana;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public int getCurrentMana() {
        return this.currentMana;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public List<Optional<Card>> getCurrentBoard() {
        return this.currentBoard;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public List<Card> getHand() {
        return this.hand;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void setMana(final int mana) {
        this.mana = this.mana + mana;
    }
    
    /**
     *  {@inheritDoc}
     */
    @Override
    public void setCurrentMana(final int mana) {
        this.currentMana = this.currentMana + mana;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void setCurrentBoard(final List<Optional<Card>> board) {
        this.currentBoard = board.stream().limit(NUM_CARD_BOARD).collect(Collectors.toList());
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public void setLifePoints(final int life) {
        this.lifePoints = life;
    }

}
