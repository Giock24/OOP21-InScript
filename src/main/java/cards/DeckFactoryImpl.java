package cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import effects.Armored;
import effects.Elusive;
import effects.Healer;
import effects.Poison;
import shared.CardIDgenerator;
import shared.CardIDgeneratorImpl;

public class DeckFactoryImpl implements DeckFactory {
    
    final List<Card> playerDeck = new ArrayList<>();
    final List<Card> playerIADeck = new ArrayList<>();
    final List<Card> maisDeck = new ArrayList<>();
    final Map<String, List<Card>> deckList = new HashMap<>();
    final CardIDgenerator idGenerator = CardIDgeneratorImpl.getIntance();
    
    @Override
    public Map<String, List<Card>> getDecks() {
        
        this.deckList.put("deck-standard", getPlayerDeck());
        this.deckList.put("deck-standard-IA", getPlayerIADeck());
        this.deckList.put("deck-mais", getMaisDeck());
        
        return deckList;
    }

    private List<Card> getPlayerDeck() {
        
        this.playerDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerDeck.add(new CardFactoyImpl().poisonEffect(idGenerator.generateID(), "Vipera", 1, 1, 2, "standardDeckImage/Vipera.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Terrapiattista", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Studiato", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerDeck.add(new CardFactoyImpl().elusiveEffect(idGenerator.generateID(), "Ladro", 1, 3, 3, "standardDeckImage/Ladro.png"));
        this.playerDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Lucertola Rossa", 1, 1, 3, "standardDeckImage/Lucertola_rossa.png", "Coccodrillo Rosso", 3, 3, Optional.empty(), "standardDeckImage/Coccodrillo_rosso.png"));
        this.playerDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Lucertola Rossa", 1, 1, 3, "standardDeckImage/Lucertola_rossa.png", "Coccodrillo Rosso", 3, 3, Optional.empty(), "standardDeckImage/Coccodrillo_rosso.png"));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "G3n0s", 4, 1, 5, "standardDeckImage/G3n0s.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Chierico", 3, 2, 3, "standardDeckImage/Chierico.png"));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "Templare", 2, 4, 5, "standardDeckImage/Templare.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Dinosauro", 6, 6, 6, "standardDeckImage/Dinosauro.png"));
        
        return this.playerDeck;
    }

    private List<Card> getPlayerIADeck() {
        
        this.playerIADeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Terrapiattista", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerIADeck.add(new CardFactoyImpl().poisonEffect(idGenerator.generateID(), "Ratto", 2, 1, 3, "standardDeckImage/Ratto.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Studiato", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerIADeck.add(new CardFactoyImpl().elusiveEffect(idGenerator.generateID(), "Mimic", 3, 2, 4, "standardDeckImage/Mimic.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect(idGenerator.generateID(), "Melma", 4, 2, 4, "standardDeckImage/Melma.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect(idGenerator.generateID(), "Melma", 4, 2, 4, "standardDeckImage/Melma.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect(idGenerator.generateID(), "Mummia", 1, 4, 3, "standardDeckImage/Mummia.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect(idGenerator.generateID(), "Mummia", 1, 4, 3, "standardDeckImage/Mummia.png"));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Guts", 1, 4, 3, "standardDeckImage/Guts.png", "Berserk", 2, 5, Optional.of(new Elusive()), "standardDeckImage/Berserk.png"));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Uovo", 8, 0, 8, "standardDeckImage/Uovo.png", "Fafnir Drago Antico", 8, 8, Optional.of(new Armored()), "standardDeckImage/Fafnir.png"));
        
        return this.playerIADeck;
    }
    
    private List<Card> getMaisDeck(){
        
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect(idGenerator.generateID(), "Mais", 1, 0, 1, "maisDeckImage/mais.png"));
        
        this.maisDeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Granaio", 4, 0, 2, "maisDeckImage/granaio.png"));
        this.maisDeck.add(new CardFactoyImpl().healerEffect(idGenerator.generateID(), "Granaio", 4, 0, 2, "maisDeckImage/granaio.png"));
        this.maisDeck.add(new CardFactoyImpl().elusiveEffect(idGenerator.generateID(), "Doppleganger-Mais", 2, 1, 2, "maisDeckImage/doppelganger-mais.png"));
        this.maisDeck.add(new CardFactoyImpl().elusiveEffect(idGenerator.generateID(), "Doppleganger-Mais", 2, 1, 2, "maisDeckImage/doppelganger-mais.png"));
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Spaventapasseri", 1, 2, 3, "maisDeckImage/spaventapasseri.png"));
        
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Spaventapasseri", 1, 2, 3, "maisDeckImage/spaventapasseri.png"));
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect(idGenerator.generateID(), "Spaventapasseri", 1, 2, 3, "maisDeckImage/spaventapasseri.png"));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "Cavaglieri di Mais", 3, 1, 3, "maisDeckImage/Mais-knight.png"));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "Cavaglieri di Mais", 3, 1, 3, "maisDeckImage/Mais-knight.png"));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "Cavaglieri di Mais", 3, 1, 3, "maisDeckImage/Mais-knight.png"));
        
        this.maisDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Mulino", 3, 0, 4, "maisDeckImage/mulino.png", "Gigante", 4, 4, Optional.empty(), "maisDeckImage/gigante.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Mulino", 3, 0, 4, "maisDeckImage/mulino.png","Gigante", 4, 4,  Optional.empty(), "maisDeckImage/gigante.png"));
        this.maisDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Khael Mais Lich", 4, 3, 4, "maisDeckImage/Lich.png"));
        this.maisDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "Khael Mais Lich", 4, 3, 4, "maisDeckImage/Lich.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Chiesa del Mais", 5, 0, 5, "maisDeckImage/chiesa.png", "Cattedrale del Mais", 10, 0, Optional.of(new Healer()), "maisDeckImage/cattedrale.png"));
        
        this.maisDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "il fattore", 5, 2, 5, "maisDeckImage/il-fattore.png"));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect(idGenerator.generateID(), "il fattore", 5, 2, 5, "maisDeckImage/il-fattore.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Mietitrebbia", 4, 0, 7, "maisDeckImage/mietitrebbia.png", "Cupo Mietitore", 8, 8, Optional.of(new Poison()), "maisDeckImage/cupo-mietitore.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect(idGenerator.generateID(), "Mietritrebbia", 4, 0, 7, "maisDeckImage/mietitrebbia.png", "Cupo Mietitore", 8, 8, Optional.of(new Poison()), "maisDeckImage/cupo-mietitore.png"));
        this.maisDeck.add(new CardFactoyImpl().noEffect(idGenerator.generateID(), "MAISxodia il proibito", 10, 10, 10, "maisDeckImage/MAISxodia.png"));
       
        return this.maisDeck;
    }

}
