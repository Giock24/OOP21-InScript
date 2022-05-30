package jsonparser;

import java.util.Optional;

import cards.Card;
import cards.CardFactoyImpl;
import cards.Effect;
import cards.BaseCard;

public class InfoCardImpl implements InfoCard {

    private final String name;
    private final int lifeValue;
    private final int attackValue;
    private final int manaCost;
    private final ChangeEffect effect;
    private final String imageURL;
    private final int copies;
    String effectName; 

    
    public InfoCardImpl(final String name, final int lifeValue, final int attackValue, final int manaCost, final ChangeEffect effect, final String imageURL, final int copies) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.manaCost = manaCost;
        this.effectName = effect.getName();
        this.effect = effect;
        this.imageURL = imageURL;
        this.copies = copies;
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
    public int getCopies() {
        return this.copies;
    }
    
    @Override
    public Optional<Effect> getEffect() {
        return this.effect.generateChangeEffect();
    }
    
    @Override
    public String toString() {
        return " Info Card : \n"
              + "Attack : " + this.attackValue +"\n"
              + "life : " + this.lifeValue + "\n"
              + "URL :" + this.imageURL + "\n"
              + "effect : " + this.effect.toString();

    }

    @Override
    public Card generateCard() {
        if ("Growth".equals(effectName)) {  
            return new CardFactoyImpl().growthEffect(name, lifeValue, attackValue, manaCost, imageURL, effect.getNameCard(), effect.getLifePoints(), effect.getAttack(), effect.getInnerEffect().get().generateChangeEffect(), effect.getImageURL());
        }
        if ("LastWill".equals(effectName)) {
            return new CardFactoyImpl().lastwillEffect(name, lifeValue, attackValue, manaCost, imageURL, effect.getNameCard(), effect.getLifePoints(), effect.getAttack(), effect.getInnerEffect().get().generateChangeEffect(), effect.getImageURL());
        }
        if ("Elusive".equals(effectName)) {
            return new CardFactoyImpl().elusiveEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        if ("Exalted".equals(effectName)) {
            return new CardFactoyImpl().exaltedEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        if ("Healer".equals(effectName)) {
            return new CardFactoyImpl().healerEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        if ("Poison".equals(effectName)) {
            return new CardFactoyImpl().poisonEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        if ("Rotten".equals(effectName)) {
            return new CardFactoyImpl().rottenEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        if ("Draw".equals(effectName)) {
            return new CardFactoyImpl().drawEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        if ("Armored".equals(effectName)) {
             return new CardFactoyImpl().armoredEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        else {
            return new CardFactoyImpl().noEffect(name, lifeValue, attackValue, manaCost, imageURL);
        }
        
    }

}
