package cards;

import java.util.Optional;

public interface CardFactory {
    

    Card noEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card elusiveEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card exaltedEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card healerEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card poisonEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card armoredEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card rottenEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card growthEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL, final String growthName, final int growthLife, final int growthAttack, final Optional<Effect> growthEffect, String growthImageURL);
    
    Card drawEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, String imageURL);
    
    Card lastwillEffect( final String name, final int lifeValue, final int attackValue, final int manaCost, final String imageURL, final String lastwillName, final int lastwillLife, final int lastwillAttack, final Optional<Effect> lastwillEffect, final String lastwillImageURL);

}
