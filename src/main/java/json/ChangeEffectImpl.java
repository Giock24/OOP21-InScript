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
    
    // Devo aggiungere un nuovo costruttore per gestire la creazione di un ChangeEffect con solo il nome;
    // - In questo modo la classe InfoEffectImpl non mi serve a niente in quanto avendo un altro costruttore 
    //   posso creare un nuovo oggetto ChangeEffect con solo il nome dell'effetto;
    // - Spostiamo il metodo generateInfoEffect dentro a ChangeEffectImpl e lo trattiamo come metodo privato;
    // - Aggiungiamo un nuovo campo privato(eventualmente Optional), per salvarci il nome dell'effetto in 
    //   ChangeEffectImpl, invece che doverlo passare al costruttore di InfoEffectImpl;
    
    public ChangeEffectImpl(final String effectName, final String cardName, final int lifeValue, final int attackValue, final String imageURL, final ChangeEffect effect) {
        super(effectName);
        this.name = cardName;
        this.lifePoints = lifeValue;
        this.attack = attackValue;
        this.imageURL = imageURL;
        this.effect = effect;
    }
    
    /*public ChangeEffectImpl(final String effectName) {
        super(effectName);
        name = effectName;
        this.lifePoints = 0;
        this.attack = 0;
        this.imageURL = "";
        this.effect = null;
    }*/

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


