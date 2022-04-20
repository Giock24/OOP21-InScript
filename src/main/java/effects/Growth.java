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
    
    public Growth(final String newName, final int newLifePoint, final int newAttack, final Optional<Effect> newEffect) {
        super("Growth", "Dopo un turno nel campo di gioco questa carta assume la sua vera forma");
        
        this.name = newName;
        this.lifePoint = newLifePoint;
        this.attack = newAttack;
        this.effect = newEffect;
                
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
        
    }

}
