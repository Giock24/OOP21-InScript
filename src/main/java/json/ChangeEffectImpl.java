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
            // Se il nome dell'effetto è growth e la carta in cui si deve transformare ha un effetto non growth allora il generateSimpleEffect ritorna un Optional di qualcosa.
            // Se invece l'effetto della carta in cui si deve transformare è di nuovo Growth o LastWill GenerateSimpleEffect ritorna un Optional.Empty().
            if(complex.generateSimpleEffect((InfoEffect)complex).isPresent()) {
                return Optional.of(new Growth(name, lifePoints, attack, complex.generateSimpleEffect((InfoEffect)complex), imageURL));
            }
            else {
                // Parte ricorsiva che non mi viene...
                // Dovrei richiamare generateComplexEffect passandogli l'effetto della carta in cui si transforma.
            }
            
            // return Optional.of(new Growth(name, lifePoints, attack, effect.get));
            // return Optional.empty();
        }
        // Una volta fatto la parte per Growth, la parte di LastWill è letteralmente un copia incolla.
        if(complex.getName() == "LastWill") {
            return Optional.empty();
        }
        return generateSimpleEffect((InfoEffect)complex);
    }

}
