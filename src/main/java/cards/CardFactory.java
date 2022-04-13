package cards;

public interface CardFactory {
    
    Card noEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card elusiveEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card exaltedEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card healerEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
    Card poisonEffect(final String idCard, final String name, final int lifeValue, final int attackValue, final int manaCost);
    
}
