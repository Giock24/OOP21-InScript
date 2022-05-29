package json;

import java.util.Optional;

import cards.Effect;
import effects.Armored;
import effects.Draw;
import effects.Elusive;
import effects.Exalted;
import effects.Growth;
import effects.Healer;
import effects.Poison;
import effects.Rotten;

public class InfoEffectImpl implements InfoEffect {

    private final String name;
    
    public InfoEffectImpl(final String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Optional<Effect> generateInfoEffect() {
        if("Armored".equals(name)) {
            return Optional.of(new Armored());
        }
        if("Draw".equals(name)) {
            return Optional.of(new Draw());
        }
        if("Elusive".equals(name)) {
            return Optional.of(new Elusive());
        }
        if("Exalted".equals(name)) {
            return Optional.of(new Exalted());
        }
        if("Healer".equals(name)) {
            return Optional.of(new Healer());
        }
        if("Poison".equals(name)) {
            return Optional.of(new Poison());
        }
        if("Rotten".equals(name)) {
            return Optional.of(new Rotten());
        }
        return Optional.empty();
    }
    
}
