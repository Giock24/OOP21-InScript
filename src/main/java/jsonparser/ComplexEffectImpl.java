package jsonparser;

import java.util.Optional;

import cards.Effect;
import effects.Growth;
import effects.LastWill;

public class ComplexEffectImpl extends SimpleEffectImpl implements ComplexEffect {
    
    /*private final String name;
    private final int lifePoints;
    private final int attack;
    private final String imageURL;
    private final ChangeEffect effect;*/
    
    private final Optional<String> name;
    private final Optional<Integer> lifePoints;
    private final Optional<Integer> attack;
    private final Optional<String> imageURL;
    private final Optional<ComplexEffect> effect;

    
    // Devo aggiungere un nuovo costruttore per gestire la creazione di un ChangeEffect con solo il nome;
    // - In questo modo la classe InfoEffectImpl non mi serve a niente in quanto avendo un altro costruttore 
    //   posso creare un nuovo oggetto ChangeEffect con solo il nome dell'effetto;
    // - Spostiamo il metodo generateInfoEffect dentro a ChangeEffectImpl e lo trattiamo come metodo privato;
    // - Aggiungiamo un nuovo campo privato(eventualmente Optional), per salvarci il nome dell'effetto in 
    //   ChangeEffectImpl, invece che doverlo passare al costruttore di InfoEffectImpl;
    
    public ComplexEffectImpl(final String effectName, final String cardName, final int lifeValue, final int attackValue, final String imageURL, final ComplexEffect effect) {
        super(effectName);
        this.name = Optional.of(cardName);
        this.lifePoints = Optional.of(lifeValue);
        this.attack = Optional.of(attackValue);
        this.imageURL = Optional.of(imageURL);
        this.effect = Optional.of(effect);
    }
    
    public ComplexEffectImpl(final String effectName) {
        super(effectName);
        this.name = Optional.empty();
        this.lifePoints = Optional.empty();
        this.attack = Optional.empty();
        this.imageURL = Optional.empty();
        this.effect = Optional.empty();
    }
    
    @Override
    public String getNameCard() {
        return this.name.get();
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
    public Optional<ComplexEffect> getInnerEffect() {
        return this.effect;
    }
    
    @Override
    public String toString() {
        if (this.attack.isPresent() && this.lifePoints.isPresent()) {
        return " ChangeEffect : \n"
              + "NewEffectName : " + super.getName() + "\n"
              + "NewAttack : " + this.getAttack() +"\n"
              + "Newlife : " + this.getLifePoints() + "\n"
              + "Neweffect : " + this.effect.toString() + "\n"
              + "NewURL :" + this.imageURL;
        } else {
            return " ChangeEffect : \n"
                    + "FinalEffectName : " + super.getName() + "\n"
                    + "NewAttack : NO_NEW_ATTACK\n"
                    + "Newlife : NO_NEW_LIFE\n"
                    + "Neweffect : " + this.effect.toString() + "\n"
                    + "NewURL :" + this.imageURL;
        }

    }

    @Override
    public Optional<Effect> generateComplexEffect() {
        if(effect.isPresent()) {
                if("Growth".equals(super.getName())) {
                    return Optional.of(new Growth(this.getNameCard(), this.lifePoints.get(), this.attack.get(), this.effect.get().generateComplexEffect(), this.imageURL.get()));
                }
                else if("LastWill".equals(super.getName())) {
                    return Optional.of(new LastWill(name.get(), lifePoints.get(), attack.get(), this.effect.get().generateComplexEffect(), imageURL.get()));
                }
                else
                {
                    return this.effect.get().generateSimpleEffect();
                }
            }
        else {
            return this.generateSimpleEffect();
        }
    }

}


