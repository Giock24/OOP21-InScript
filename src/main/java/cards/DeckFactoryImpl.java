package cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import effects.Armored;
import effects.Elusive;
import effects.Growth;
import effects.Healer;
import effects.Poison;

public class DeckFactoryImpl implements DeckFactory {
    
    final List<Card> playerDeck = new ArrayList<>();
    final List<Card> playerIADeck = new ArrayList<>();
    final List<Card> maisDeck = new ArrayList<>();
    final List<Card> shinobiDeck = new ArrayList<>();    
    final List<Card> duckDeck = new ArrayList<>();
    final Map<String, List<Card>> DeckList = new HashMap<String, List<Card>>();
    
    @Override
    public Map<String, List<Card>> getDecks() {
        
        this.DeckList.put("deck-standard", getPlayerDeck());
        this.DeckList.put("deck-standard-IA", getPlayerIADeck());
        this.DeckList.put("deck-mais", getMaisDeck());
        this.DeckList.put("deck-shinobi", getShinobiDeck());
        this.DeckList.put("deck-Duck", getDuckDeck());

        
        return DeckList;
    }

    private List<Card> getPlayerDeck() {
        
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1));
        this.playerDeck.add(new CardFactoyImpl().poisonEffect( "Vipera", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Terrapiattista", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Studiato", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().elusiveEffect( "Ladro", 1, 3, 3));
        this.playerDeck.add(new CardFactoyImpl().growthEffect( "Lucertola Rossa", 1, 1, 3, "Coccodrillo Rosso", 3, 3, Optional.empty()));
        this.playerDeck.add(new CardFactoyImpl().growthEffect( "Lucertola Rossa", 1, 1, 3, "Coccodrillo Rosso", 3, 3, Optional.empty()));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect( "G3n0s", 4, 1, 5));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Chierico", 3, 2, 3));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect( "Templare", 2, 4, 5));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Dinosauro", 6, 6, 6));
        
        return this.playerDeck;
    }

    private List<Card> getPlayerIADeck() {
        
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "Terrapiattista", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().poisonEffect( "Ratto", 2, 1, 3));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Studiato", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().elusiveEffect( "Mimic", 3, 2, 4));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Melma", 4, 2, 4));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Melma", 4, 2, 4));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Mummia", 1, 4, 3));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Mummia", 1, 4, 3));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect( "Guts", 1, 4, 3, "Berserk", 2, 5, Optional.of(new Elusive())));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect( "Uovo", 8, 0, 8, "Fafnir Drago Antico", 8, 8, Optional.of(new Armored())));
        
        return this.playerIADeck;
    }
    
    private List<Card> getMaisDeck(){
        
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1));
        
        this.maisDeck.add(new CardFactoyImpl().healerEffect( "Granaio", 4, 0, 2));
        this.maisDeck.add(new CardFactoyImpl().healerEffect( "Granaio", 4, 0, 2));
        this.maisDeck.add(new CardFactoyImpl().elusiveEffect( "Doppleganger-Mais", 2, 1, 2));
        this.maisDeck.add(new CardFactoyImpl().elusiveEffect( "Doppleganger-Mais", 2, 1, 2));
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect( "Spaventapasseri", 1, 2, 3));
        
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect( "Spaventapasseri", 1, 2, 3));
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect( "Spaventapasseri", 1, 2, 3));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "Cavaglieri di Mais", 3, 1, 3));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "Cavaglieri di Mais", 3, 1, 3));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "Cavaglieri di Mais", 3, 1, 3));
        
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mulino", 3, 0, 4, "Gigante", 4, 4,  Optional.empty()));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mulino", 3, 0, 4, "Gigante", 4, 4,  Optional.empty()));
        this.maisDeck.add(new CardFactoyImpl().noEffect( "Khael Mais Lich", 4, 3, 4));
        this.maisDeck.add(new CardFactoyImpl().noEffect( "Khael Mais Lich", 4, 3, 4));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Chiesa del Mais", 5, 0, 5, "Cattedrale del Mais", 10, 0, Optional.of(new Healer())));
        
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "il fattore", 5, 2, 5));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "il fattore", 5, 2, 5));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mietitrebbia", 4, 0, 7, "Cupo Mietitore", 8, 8, Optional.of(new Poison())));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mietritrebbia", 4, 0, 7, "Cupo Mietitore", 8, 8, Optional.of(new Poison())));
        this.maisDeck.add(new CardFactoyImpl().noEffect( "MAISxodia il proibito", 10, 10, 10));
       
        return this.maisDeck;
    }
    
    private List<Card> getShinobiDeck() {
        
        this.shinobiDeck.add(new CardFactoyImpl().drawEffect( "Studente Accademia", 1, 1, 2));
        this.shinobiDeck.add(new CardFactoyImpl().drawEffect( "Studente Accademia", 1, 1, 2));
        this.shinobiDeck.add(new CardFactoyImpl().drawEffect( "Studente Accademia", 1, 1, 2));
        
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Genin", 1, 1, 1));
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Genin", 1, 1, 1));
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Genin", 1, 1, 1));
        
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Ninja Medico", 2, 0, 2));
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Ninja Medico", 2, 0, 2));
        
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Copia Sakura", 2, 1, 2));
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Copia Sakura", 2, 1, 2));
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Copia Sakura", 2, 1, 2));
        
        this.shinobiDeck.add(new CardFactoyImpl().exaltedEffect( "Chunin", 1, 3, 3));
        this.shinobiDeck.add(new CardFactoyImpl().exaltedEffect( "Chunin", 1, 3, 3));
        this.shinobiDeck.add(new CardFactoyImpl().exaltedEffect( "Ninja della Sabbia", 1, 1, 2));
        this.shinobiDeck.add(new CardFactoyImpl().poisonEffect( "Orochimaru", 2, 1, 2));
        
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Jonin", 4, 2, 3));
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Jonin", 4, 2, 3));
        
        this.shinobiDeck.add(new CardFactoyImpl().elusiveEffect( "Ninja Traditore", 2, 2, 3));
        this.shinobiDeck.add(new CardFactoyImpl().elusiveEffect( "Ninja Traditore", 2, 2, 3));
        
        this.shinobiDeck.add(new CardFactoyImpl().armoredEffect( "Hinata", 4, 2, 4));
        this.shinobiDeck.add(new CardFactoyImpl().rottenEffect( "Nagato", 2, 4, 4));
        
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Kakashi", 4, 1, 5, "Kakashi [Anbu]", 4, 2, Optional.of(new Armored())));
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Itachi", 4, 1, 5, "Itachi [Susanoo]", 1, 5, Optional.empty()));
        
        // Card-Bosses
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Boruto Uzumaki", 5, 5, 8, "Momoshiki Otsutsuki", 8, 1, Optional.of(new Poison())));
        this.shinobiDeck.add(new CardFactoyImpl().armoredEffect( "Kaguya Otsutsuki", 10, 7, 8));
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Naruto Uzumaki", 4, 4, 7, "Naruto [Mod. Eremita]", 6, 6, 
                             Optional.of(new Growth("Naruto [Six-Path]", 8, 8, 
                             Optional.of(new Growth("Naruto [Mod. Bayron]", 10, 10, Optional.empty()))))));
        
        
        return this.shinobiDeck;
    }
    
    private List<Card> getDuckDeck() {
        
        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Guard", 2, 1, 2));
        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Guard", 2, 1, 2));
        
        this.duckDeck.add(new CardFactoyImpl().healerEffect( "Boss's Maiden", 2, 2, 3));
        this.duckDeck.add(new CardFactoyImpl().healerEffect( "Boss's Maiden", 2, 2, 3));

        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Tailor", 1, 1, 1));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Tailor", 1, 1, 1));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Tailor", 1, 1, 1));

        this.duckDeck.add(new CardFactoyImpl().growthEffect( "Boss's Lil Fella", 2, 2, 3, "Boss's Acolytes", 3, 4, Optional.of(new Elusive())));
        this.duckDeck.add(new CardFactoyImpl().growthEffect( "Boss's Lil Fella", 2, 2, 3, "Boss's Acolytes", 3, 4, Optional.of(new Elusive())));

        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Statue", 2, 0, 1));
        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Statue", 2, 0, 1));

        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Right Hand", 3, 3, 4));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Right Hand", 3, 3, 4));

        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Kitty", 4, 4, 5));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Kitty", 4, 4, 5));

        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "Boss's Heir", 5, 4, 6));
        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "Boss's Heir", 5, 4, 6));

        this.duckDeck.add(new CardFactoyImpl().elusiveEffect( "Boss's Acolytes", 3, 4, 5));
        this.duckDeck.add(new CardFactoyImpl().elusiveEffect( "Boss's Acolytes", 3, 4, 5));
        
        this.duckDeck.add(new CardFactoyImpl().poisonEffect( "Boss's Assassin", 1, 2, 1));
        this.duckDeck.add(new CardFactoyImpl().poisonEffect( "Boss's Assassin", 1, 2, 1));
        this.duckDeck.add(new CardFactoyImpl().poisonEffect( "Boss's Assassin", 1, 2, 1));
        
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktective Holmes", 3, 2, 3));
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktective Holmes", 3, 2, 3));
        
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktor Watson", 2, 2, 2));
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktor Watson", 2, 2, 2));
        
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Garden's Sage", 3, 3, 4));
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Garden's Sage", 3, 3, 4));

        this.duckDeck.add(new CardFactoyImpl().elusiveEffect( "The Impostor", 3, 4, 5));
        

        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "DuckPocalipse", 6, 5, 8));

        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "The Boss", 7, 6, 9));
        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "The Boss", 7, 6, 9));

        // 32 carte.
        return this.duckDeck;
    }

}
