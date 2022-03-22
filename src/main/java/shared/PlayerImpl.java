package shared;

import java.util.ArrayList;

import cards.Card;

public class PlayerImpl implements Player {
    
    private ArrayList<Card> deck;
    private int lifePoints;
    private int mana;
    private int currentMana;
    private ArrayList<Card> currentBoard;
    private ArrayList<Card> hand;
    
    public PlayerImpl(ArrayList<Card> deck, int lifePoints, int mana, int currentMana,ArrayList<Card> currentBoard, ArrayList<Card> hand) {
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
    public ArrayList<Card> getDeck() {
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
    public ArrayList<Card> getCurrentBoard() {
        return this.currentBoard;
    }

    /**
     *  {@inheritDoc}
     */
    @Override
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /**
     *  {@inheritDoc}
     */
	@Override
	public void setMana(final int mana) {
		this.currentMana = this.currentMana + mana;
	}

}
