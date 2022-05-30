package effects;

import java.util.Optional;

import cards.AbstractEffect;
import cards.ActivationEvent;
import cards.Effect;
import shared.Player;

public class Growth extends AbstractEffect{
    
    String name;
    int lifePoint;
    int attack;
    Optional<Effect> effect;
    String imageURL;
    
    public Growth(final String newName, final int newLifePoint, final int newAttack, final Optional<Effect> newEffect, final String newImageURL) {
        super("Growth", "After a turn on the playing field this card takes its true form", "effects/effect_growth");
        //System.out.println("\n Nuovo Effetto : " + newEffect.get().getNameEffect() + "\n");
        //System.out.println("\n Nuova Vita : " + newLifePoint + "\n");
        //System.out.println(newEffect.toString());
        this.name = newName;
        this.lifePoint = newLifePoint;
        this.attack = newAttack;
        this.effect = newEffect;
        this.imageURL = newImageURL;
                
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.MYDRAW;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        cardOwner.getCurrentBoard().get(boardPosition).get().setLifePoint(this.lifePoint);
        cardOwner.getCurrentBoard().get(boardPosition).get().setAttack(this.attack);
        cardOwner.getCurrentBoard().get(boardPosition).get().setEffect(this.effect);
        cardOwner.getCurrentBoard().get(boardPosition).get().setName(this.name);
        cardOwner.getCurrentBoard().get(boardPosition).get().setImageURL(this.imageURL);
        
    }
    
    @Override
    public String toString() {
        if (this.effect.isPresent()) {
            return " Growth \n"
                    + "newAttack : " + this.attack +"\n"
                    + "newLife : " + this.lifePoint + "\n"
                    + "newEffect : " + this.effect.get().getNameEffect() + "\n"
                    + "newURL :" + this.imageURL;
        } else {
            return "\n"
                    + "Effect Name : " + this.name + "\n"
                    + "newAttack : " + this.attack +"\n"
                    + "newLife : " + this.lifePoint + "\n"
                    + "newEffect : NoEffect\n";
        }

    }

}
