package effects;

import java.util.Optional;

import cards.AbstractEffect;
import cards.ActivationEvent;
import cards.Effect;
import shared.Player;

public class LastWill extends AbstractEffect{
    
    String name;
    int lifePoint;
    int attack;
    Optional<Effect> effect;
    String imageURL;
    
    public LastWill(final String newName, final int newLifePoint, final int newAttack, final Optional<Effect> newEffect, final String newImageURL) {
        super("LastWill", "Dopo che questa carta muore esprime le sue ultimo volonta trasformandosi", "effects/effect_lastwill");
        
        this.name = newName;
        this.lifePoint = newLifePoint;
        this.attack = newAttack;
        this.effect = newEffect;
        this.imageURL = newImageURL;
                
    }

    @Override
    public ActivationEvent getActivationEvent() {
        
        return ActivationEvent.ONDEATH;
    }

    @Override
    public void useEffect(final Player cardOwner, final Player enemy, final int boardPosition) {
        
        cardOwner.getCurrentBoard().get(boardPosition).get().setLifePoint(this.lifePoint);
        cardOwner.getCurrentBoard().get(boardPosition).get().setAttack(this.attack);
        cardOwner.getCurrentBoard().get(boardPosition).get().setEffect(this.effect);
        cardOwner.getCurrentBoard().get(boardPosition).get().setName(this.name);
        cardOwner.getCurrentBoard().get(boardPosition).get().setImageURL(this.imageURL);
        
    }

}
