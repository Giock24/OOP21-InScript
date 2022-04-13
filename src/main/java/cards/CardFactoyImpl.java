package cards;

import java.util.Optional;

import effects.Elusive;
import effects.Exalted;
import effects.Healer;
import effects.Poison;

public class CardFactoyImpl implements CardFactory {

    @Override
    public Card noEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost) {
        // TODO Auto-generated method stub
        return new BaseCard(idCard, name, lifeValue, attackValue, manaCost, Optional.empty());
    }

    @Override
    public Card elusiveEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost) {
        // TODO Auto-generated method stub
        return new BaseCard(idCard, name, lifeValue, attackValue, manaCost, Optional.of(new Elusive()));
    }

    @Override
    public Card exaltedEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost) {
        // TODO Auto-generated method stub
        return new BaseCard(idCard, name, lifeValue, attackValue, manaCost, Optional.of(new Exalted()));
    }

    @Override
    public Card healerEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost) {
        // TODO Auto-generated method stub
        return new BaseCard(idCard, name, lifeValue, attackValue, manaCost, Optional.of(new Healer()));
    }

    @Override
    public Card poisonEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost) {
        // TODO Auto-generated method stub
        return new BaseCard(idCard, name, lifeValue, attackValue, manaCost, Optional.of(new Poison()));
    }

    

}
