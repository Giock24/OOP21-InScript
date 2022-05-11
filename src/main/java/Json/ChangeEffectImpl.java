package Json;

public class ChangeEffectImpl extends InfoEffectImpl implements ChangeEffect {
    
    private final int lifePoints;
    private final int attack;
    private final String imageURL;
    
    public ChangeEffectImpl(final String name, final int lifePoints, final int attack, final String imageURL) {
        super(name);
        this.lifePoints = lifePoints;
        this.attack = attack;
        this.imageURL = imageURL;
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

}
