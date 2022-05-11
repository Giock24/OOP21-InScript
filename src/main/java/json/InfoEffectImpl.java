package json;

public class InfoEffectImpl implements InfoEffect {

    private final String name;
    
    public InfoEffectImpl(final String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
}
