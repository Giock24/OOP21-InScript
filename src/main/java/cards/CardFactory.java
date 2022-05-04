package cards;

import java.util.Optional;

public interface CardFactory {
    
    Card noEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card elusiveEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card exaltedEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card healerEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card poisonEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card armoredEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card rottenEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
    
    Card growthEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL, final String growthName, final int growthLife, final int growthAttack, final Optional<Effect> growthEffect, final String growthImageURL);
    
    Card drawEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL);
}
