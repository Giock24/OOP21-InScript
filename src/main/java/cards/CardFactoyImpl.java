package cards;

import java.util.Optional;

import effects.Armored;
import effects.Draw;
import effects.Elusive;
import effects.Exalted;
import effects.Growth;
import effects.Healer;
import effects.Poison;
import effects.Rotten;

public class CardFactoyImpl implements CardFactory {

    @Override
    public Card noEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.empty());
    }

    @Override
    public Card elusiveEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Elusive()));
    }

    @Override
    public Card exaltedEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Exalted()));
    }

    @Override
    public Card healerEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Healer()));
    }

    @Override
    public Card poisonEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Poison()));
    }

    @Override
    public Card armoredEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Armored()));
    }

    @Override
    public Card rottenEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Rotten()));
    }

    @Override
    public Card growthEffect( final String name, final int lifeValue, final int attackValue, final int manaCost,
            final String growthName, final int growthLife, final int growthAttack, final Optional<Effect> growthEffect) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Growth(growthName, growthLife, growthAttack, growthEffect)));
    }

    @Override
    public Card drawEffect( final String name, final int lifeValue, final int attackValue, final int manaCost) {
        
        return new BaseCard( name, lifeValue, attackValue, manaCost, Optional.of(new Draw()));
    }

}
