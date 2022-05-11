package json;

import java.util.List;
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
    public Optional<Effect> generateSimpleEffect(final InfoEffect simple) {
        if(simple.getName() == "Armored") {
            return Optional.of(new Armored());
        }
        if(simple.getName() == "Draw") {
            return Optional.of(new Draw());
        }
        if(simple.getName() == "Elusive") {
            return Optional.of(new Elusive());
        }
        if(simple.getName() == "Exalted") {
            return Optional.of(new Exalted());
        }
        if(simple.getName() == "Healer") {
            return Optional.of(new Healer());
        }
        if(simple.getName() == "Poison") {
            return Optional.of(new Poison());
        }
        if(simple.getName() == "Rotten") {
            return Optional.of(new Rotten());
        }
        return Optional.empty();
    }
    
}
