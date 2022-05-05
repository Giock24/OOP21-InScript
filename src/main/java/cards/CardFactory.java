package cards;

import java.util.Optional;

public interface CardFactory {
    

    Card noEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card elusiveEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card exaltedEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card healerEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card poisonEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card armoredEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card rottenEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card growthEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, final String growthName, final int growthLife, final int growthAttack, final Optional<Effect> growthEffect);
    
    Card drawEffect( final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card lastwillEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL, final String lastwillName, final int lastwillLife, final int lastwillAttack, final Optional<Effect> lastwillEffect, final String lastwillImageURL);

}
