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
    public Optional<Effect> generateComplexEffect() {
        if(effect.getName() == "Growth" || effect.getName() == "LastWill" ) {
            // Se il nome dell'effetto è growth e la carta in cui si deve transformare ha un effetto non growth allora il generateSimpleEffect ritorna un Optional di qualcosa.
            // Se invece l'effetto della carta in cui si deve transformare è di nuovo Growth o LastWill GenerateSimpleEffect ritorna un Optional.Empty().
            if(effect.generateSimpleEffect().isPresent()) {
                return Optional.of(new Growth(name, lifePoints, attack, effect.generateSimpleEffect(), imageURL));
            }
            else {
                // Parte ricorsiva che non mi viene...
                // Dovrei richiamare generateComplexEffect passandogli l'effetto della carta in cui si transforma.
                
                // NON SO SE COSì FACENDO PRENDO IL ChangeEffect PIù INTENRO.
                return Optional.of(new Growth(name, lifePoints, attack, effect.generateComplexEffect(), imageURL));
            }            
            // return Optional.of(new Growth(name, lifePoints, attack, effect.get));
        }
        else {
            return effect.generateSimpleEffect();
        }
    }

}
