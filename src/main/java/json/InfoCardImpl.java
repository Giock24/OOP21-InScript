package json;

import java.util.Optional;

import cards.Card;
import cards.Effect;
import cards.BaseCard;

public class InfoCardImpl implements InfoCard {

    private final String name;
    private final int lifeValue;
    private final int attackValue;
    private final int manaCost;
    private final Optional<Effect> effect;
    private final String imageURL;

    
    public InfoCardImpl(final String name, final int lifeValue, final int attackValue, final int manaCost, final ChangeEffect effect, final String imageURL) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.manaCost = manaCost;
        this.effect = effect.generateChangeEffect();
        this.imageURL = imageURL;
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
    public Optional<Effect> getEffect() {
        return this.effect;
    }

    @Override
    public Card generateCard() {
        return new BaseCard(name, lifeValue, attackValue, manaCost, imageURL, effect);
    }

}
