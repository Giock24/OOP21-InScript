package json;

import cards.Card;

public class InfoCardImpl implements InfoCard {

    private final String name;
    private final int lifeValue;
    private final int attackValue;
    private final int manaCost;
    private final ChangeEffect effect;
    
    public InfoCardImpl(final String name, final int lifeValue, final int attackValue, final int manaCost, final ChangeEffect effect) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.manaCost = manaCost;
        this.effect = effect;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAttackValue() {
        return this.attackValue;
    }

    @Override
    public int getLifeValue() {
        return this.lifeValue;
    }

    @Override
    public int getManaCost() {
        return this.manaCost;
    }

    @Override
    public ChangeEffect getEffect() {
        return this.effect;
    }

    @Override
    public Card generateCard(final InfoCard card) {
        // TODO Auto-generated method stub
        return null;
    }

}
