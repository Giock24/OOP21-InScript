package json;

import java.util.Optional;

import cards.Effect;
import effects.Growth;
import effects.LastWill;

public class ChangeEffectImpl extends InfoEffectImpl implements ChangeEffect {
    
    private final String name;
    private final int lifePoints;
    private final int attack;
    private final String imageURL;
    private final ChangeEffect effect;
    
    public ChangeEffectImpl(final String effectName, final String cardName, final int lifeValue, final int attackValue, final String imageURL, final ChangeEffect effect) {
        super(effectName);
        this.name = cardName;
        this.lifePoints = lifeValue;
        this.attack = attackValue;
        this.imageURL = imageURL;
        this.effect = effect;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public String getImageURL() {
        return this.imageURL;
    }

    @Override
    public Optional<Effect> generateChangeEffect() {
        // [ REMINDER ] fare la condizione dell'if in modo che controlli se è effettivamente diverso da null.
        if(effect != null) {
                if(effect.getName() == "Growth") {
                    return Optional.of(new Growth(name, lifePoints, attack, effect.generateChangeEffect(), imageURL));
                }
                else if(effect.getName() == "Last Will") {
                    return Optional.of(new LastWill(name, lifePoints, attack, effect.generateChangeEffect(), imageURL));
                }
                else 
                {
                    return effect.generateInfoEffect();
                }
            }
        else {
            return Optional.empty();
        }
    }
}


