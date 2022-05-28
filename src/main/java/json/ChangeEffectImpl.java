package json;

import java.util.Optional;

import cards.Effect;
import effects.Growth;
import effects.LastWill;

public class ChangeEffectImpl extends InfoEffectImpl implements ChangeEffect {
    
    /*private final String name;
    private final int lifePoints;
    private final int attack;
    private final String imageURL;
    private final ChangeEffect effect;*/
    
    private final Optional<String> name;
    private final Optional<Integer> lifePoints;
    private final Optional<Integer> attack;
    private final Optional<String> imageURL;
    private final Optional<ChangeEffect> effect;

    
    // Devo aggiungere un nuovo costruttore per gestire la creazione di un ChangeEffect con solo il nome;
    // - In questo modo la classe InfoEffectImpl non mi serve a niente in quanto avendo un altro costruttore 
    //   posso creare un nuovo oggetto ChangeEffect con solo il nome dell'effetto;
    // - Spostiamo il metodo generateInfoEffect dentro a ChangeEffectImpl e lo trattiamo come metodo privato;
    // - Aggiungiamo un nuovo campo privato(eventualmente Optional), per salvarci il nome dell'effetto in 
    //   ChangeEffectImpl, invece che doverlo passare al costruttore di InfoEffectImpl;
    
    public ChangeEffectImpl(final String effectName, final String cardName, final int lifeValue, final int attackValue, final String imageURL, final ChangeEffect effect) {
        super(effectName);
        //System.out.println("\n Name Effect : " + effectName + "\n");
        this.name = Optional.of(cardName);
        this.lifePoints = Optional.of(lifeValue);
        this.attack = Optional.of(attackValue);
        this.imageURL = Optional.of(imageURL);
        this.effect = Optional.of(effect);
    }
    
    public ChangeEffectImpl(final String effectName) {
        super(effectName);
        //System.out.println("\n Name Effect : " + effectName + "\n");
        this.name = Optional.empty();
        this.lifePoints = Optional.empty();
        this.attack = Optional.empty();
        this.imageURL = Optional.empty();
        this.effect = Optional.empty();
    }

    @Override
    public int getAttack() {
        return this.attack.get();
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints.get();
    }

    @Override
    public String getImageURL() {
        return this.imageURL.get();
    }
    
    @Override
    public Optional<ChangeEffect> getInnerEffect() {
        return this.effect;
    }

    @Override
    public Optional<Effect> generateChangeEffect() { 
        if(effect.isPresent()) {
            //System.out.println("è presente ed è: " + effect.get().getName());
                if("Growth".equals(this.effect.get().getName())) {
                    return Optional.of(new Growth(name.get(), lifePoints.get(), attack.get(), this.effect.get().generateChangeEffect(), imageURL.get()));
                }
                else if("LastWill".equals(this.effect.get().getName())) {
                    return Optional.of(new LastWill(name.get(), lifePoints.get(), attack.get(), this.effect.get().generateChangeEffect(), imageURL.get()));
                }
                else
                {
                    return this.effect.get().generateInfoEffect();
                }
            }
        else {
            return this.generateInfoEffect();
        }
    }

}


