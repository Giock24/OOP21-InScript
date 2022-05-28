package json;

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
    private final Optional<Effect> effect;
    private final String imageURL;
    String effectName; 

    
    public InfoCardImpl(final String name, final int lifeValue, final int attackValue, final int manaCost, final ChangeEffect effect, final String imageURL) {
        this.name = name;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.manaCost = manaCost;
        
        this.effectName = effect.getName();
        //System.out.println(effect.getName()); // info derivante da InfoEffect
        this.effect = effect.generateChangeEffect();
        //System.out.println(this.effect.toString());
        /*if(this.effect.isPresent()) {
            System.out.println(this.effect.get().getNameEffect());
        }*/
        System.out.println();
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
        if (effect.isPresent()) {
            if ("Growth".equals(effectName)) {
                return new CardFactoyImpl().growthEffect(name, lifeValue, attackValue, manaCost, imageURL, effect.get().getNameEffect(), lifeValue, attackValue, effect, effect.get().getImageEffectURL());
            }
            if ("LastWill".equals(effectName)) {
                return new CardFactoyImpl().lastwillEffect(name, lifeValue, attackValue, manaCost, imageURL, effect.get().getNameEffect(), lifeValue, attackValue, effect, effect.get().getImageEffectURL());
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
        }
        
        return new CardFactoyImpl().noEffect(name, lifeValue, attackValue, manaCost, imageURL);
        
        //return new BaseCard(name, lifeValue, attackValue, manaCost, imageURL, effect);
    }

}
