package shared;

import java.util.List;
import java.util.Optional;

import cards.Card;

public class PlayerImpl implements Player {
    
    private List<Card> deck;
    private int lifePoints;
    private int mana;
    private int currentMana;
    private List<Optional<Card>> currentBoard;
    private List<Card> hand;
    
    public PlayerImpl(List<Card> deck, int lifePoints, int mana, int currentMana,List<Optional<Card>> currentBoard, List<Card> hand) {
        super();
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
        this.currentMana = this.currentMana + mana;
    }

    @Override
    public void setLifePoints(final int newValueOfLife) {
        this.lifePoints = newValueOfLife;
    }

}
