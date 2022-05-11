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
    
    public ChangeEffectImpl(final String effectName, final String cardName, final int lifePoints, final int attack, final String imageURL, final ChangeEffect effect) {
        super(effectName);
        this.name = cardName;
        this.lifePoints = lifePoints;
        this.attack = attack;
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
    public Optional<Effect> generateComplexEffect(final ChangeEffect complex) {
        if(complex.getName() == "Growth") {
            // return Optional.of(new Growth(name, lifePoints, attack, imageURL, effect));
            return Optional.empty();
        }
        if(complex.getName() == "LastWill") {
            return Optional.empty();

        }
        return Optional.empty();
    }

}
