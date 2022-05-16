package json;

import java.util.Optional;

import cards.Effect;
import effects.Armored;
import effects.Draw;
import effects.Elusive;
import effects.Exalted;
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
        if(name == "Armored") {
            return Optional.of(new Armored());
        }
        if(name == "Draw") {
            return Optional.of(new Draw());
        }
        if(name == "Elusive") {
            return Optional.of(new Elusive());
        }
        if(name == "Exalted") {
            return Optional.of(new Exalted());
        }
        if(name == "Healer") {
            return Optional.of(new Healer());
        }
        if(name == "Poison") {
            return Optional.of(new Poison());
        }
        if(name == "Rotten") {
            return Optional.of(new Rotten());
        }
        return Optional.empty();
    }
    
}
