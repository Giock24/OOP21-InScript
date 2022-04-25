package cards;

import java.util.Optional;

public interface CardFactory {
    
    Card noEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card elusiveEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card exaltedEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card healerEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card poisonEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card armoredEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card rottenEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card growthEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String growthName, final int growthLife, final int growthAttack, final Optional<Effect> growthEffect);
    
    Card drawEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
}
