package jsonparser;

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
//        System.out.println("PARAMETRI PASSATI....\n"
//                + "Name: " + cardName + "\n"
//                + "life: " + lifeValue + "\n"
//                + "atk: " + attackValue + "\n"
//                + "Name Actual Effect : " + effectName + "\n"
//                + "Inner Effect : " + effect.toString());
        //System.out.println("New Card Name : " + cardName + "\n");
        //System.out.println("New Life : " + lifeValue + "\n");
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
    public Optional<ChangeEffect> getInnerEffect() {
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
    public Optional<Effect> generateChangeEffect() {
        //System.out.println("Nome Effetto : " + effect.get().getName());
        if(effect.isPresent()) {
            System.out.println("INFO SINGOLO EFFETTO....\n"
                    + "Effetto che ha "+ super.getName() +"\n"
                    + "Name: " + this.getNameCard() + "\n"
                    + "life: " + this.lifePoints.get() + "\n"
                    + "atk: " + this.attack.get() +"\n"
                    + "New Effect "+ this.effect.toString() +"\n");
            //System.out.println("è DENTRO " + effect.get().getName());
                if("Growth".equals(effect.get().getName())) {
                    //Optional<Effect> tmp = this.effect.get().generateChangeEffect();
                    //System.out.println("return da sezione Growth");
                    //System.out.println(lifePoints.get());
//                    System.out.println("CREAZIONE EFFETTO GROWTH CON NUOVI PARAMETRI....\n"
//                            + "Effetto che ha "+ super.getName() +"\n"
//                            + "Name: " + this.getNameCard() + "\n"
//                            + "life: " + this.lifePoints.get() + "\n"
//                            + "atk: " + this.attack.get() +"\n"
//                            + "New Effect "+ this.effect.get().generateChangeEffect().get().getNameEffect() +"\n");
                    return Optional.of(new Growth(this.getNameCard(), 0, this.attack.get(), this.effect.get().generateChangeEffect(), this.imageURL.get()));
                }
                else if("LastWill".equals(this.effect.get().getName())) {
                    return Optional.of(new LastWill(name.get(), lifePoints.get(), attack.get(), this.effect.get().generateChangeEffect(), imageURL.get()));
                }
                else
                {
                    //System.out.println("return se effetto semplice");
                    //System.out.println(lifePoints.get());
                    return this.effect.get().generateInfoEffect();
                }
            }
        else {
            System.out.println("FAILSAFE");
            return this.generateInfoEffect();
        }
    }

}


