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
    final List<Card> deckOfThePit = new ArrayList<>();
    final List<Card> shinobiDeck = new ArrayList<>();    
    final List<Card> duckDeck = new ArrayList<>();
    final Map<String, List<Card>> deckList = new HashMap<>();
    
    @Override
    public Map<String, List<Card>> getDecks() {
        

        this.deckList.put("deck-standard", getPlayerDeck());
        this.deckList.put("deck-standard-IA", getPlayerIADeck());
        this.deckList.put("deck-mais", getMaisDeck());
        this.deckList.put("deck-shinobi", getShinobiDeck());
        this.deckList.put("deck-Duck", getDuckDeck());
        this.deckList.put("deck-ofThePit", getdeckOfThePit());

        
        return deckList;
    }


    private List<Card> getPlayerDeck() {
        
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerDeck.add(new CardFactoyImpl().poisonEffect( "Vipera", 1, 1, 2, "standardDeckImage/Vipera.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Terrapiattista", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Studiato", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerDeck.add(new CardFactoyImpl().elusiveEffect( "Ladro", 1, 3, 3, "standardDeckImage/Ladro.png"));
        this.playerDeck.add(new CardFactoyImpl().growthEffect( "Lucertola Rossa", 1, 1, 3, "standardDeckImage/Lucertola_rossa.png", "Coccodrillo Rosso", 3, 3, Optional.empty(), "standardDeckImage/Coccodrillo_rosso.png"));
        this.playerDeck.add(new CardFactoyImpl().growthEffect( "Lucertola Rossa", 1, 1, 3, "standardDeckImage/Lucertola_rossa.png", "Coccodrillo Rosso", 3, 3, Optional.empty(), "standardDeckImage/Coccodrillo_rosso.png"));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect( "G3n0s", 4, 1, 5, "standardDeckImage/G3n0s.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Chierico", 3, 2, 3, "standardDeckImage/Chierico.png"));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect( "Templare", 2, 4, 5, "standardDeckImage/Templare.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Dinosauro", 6, 6, 6, "standardDeckImage/Dinosauro.png"));
        
        return this.playerDeck;
    }

    private List<Card> getPlayerIADeck() {
        
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Cane", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Sasso", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "Corteo no Vax", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "Terrapiattista", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerIADeck.add(new CardFactoyImpl().poisonEffect( "Ratto", 2, 1, 3, "standardDeckImage/Ratto.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Studiato", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Pesca", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerIADeck.add(new CardFactoyImpl().elusiveEffect( "Mimic", 3, 2, 4, "standardDeckImage/Mimic.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Melma", 4, 2, 4, "standardDeckImage/Melma.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Melma", 4, 2, 4, "standardDeckImage/Melma.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Mummia", 1, 4, 3, "standardDeckImage/Mummia.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Mummia", 1, 4, 3, "standardDeckImage/Mummia.png"));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect( "Guts", 1, 4, 3, "standardDeckImage/Guts.png", "Berserk", 2, 5, Optional.of(new Elusive()), "standardDeckImage/Berserk.png"));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect( "Uovo", 8, 0, 8, "standardDeckImage/Uovo.png", "Fafnir Drago Antico", 8, 8, Optional.of(new Armored()), "standardDeckImage/Fafnir.png"));
        
        return this.playerIADeck;
    }
    
    private List<Card> getMaisDeck(){
        
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));

        
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        this.maisDeck.add(new CardFactoyImpl().drawEffect( "Mais", 1, 0, 1, "maisDeckImage/mais.jpg"));
        
        this.maisDeck.add(new CardFactoyImpl().healerEffect( "Granaio", 4, 0, 2, "maisDeckImage/granaio.jpg"));
        this.maisDeck.add(new CardFactoyImpl().healerEffect( "Granaio", 4, 0, 2, "maisDeckImage/granaio.jpg"));
        this.maisDeck.add(new CardFactoyImpl().elusiveEffect( "Doppleganger-Mais", 2, 1, 2, "maisDeckImage/doppleganger_mais.png"));
        this.maisDeck.add(new CardFactoyImpl().elusiveEffect( "Doppleganger-Mais", 2, 1, 2, "maisDeckImage/doppleganger_mais.png"));
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect( "Spaventapasseri", 1, 2, 3, "maisDeckImage/spaventapasseri.png"));
        
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect( "Spaventapasseri", 1, 2, 3, "maisDeckImage/spaventapasseri.png"));
        this.maisDeck.add(new CardFactoyImpl().exaltedEffect( "Spaventapasseri", 1, 2, 3, "maisDeckImage/spaventapasseri.png"));
        this.maisDeck.add(new CardFactoyImpl().rottenEffect( "Mais Cavaliere", 3, 1, 3, "maisDeckImage/mais_cavaliere.png"));
        this.maisDeck.add(new CardFactoyImpl().rottenEffect( "Mais Cavaliere", 3, 1, 3, "maisDeckImage/mais_cavaliere.png"));
        this.maisDeck.add(new CardFactoyImpl().rottenEffect( "Mais Cavaliere", 3, 1, 3, "maisDeckImage/mais_cavaliere.png"));
        
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mulino", 4, 0, 4, "maisDeckImage/mulino.png", "Gigante", 4, 4, Optional.empty(), "maisDeckImage/gigante.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mulino", 4, 0, 4, "maisDeckImage/mulino.png","Gigante", 4, 4,  Optional.empty(), "maisDeckImage/gigante.png"));
        this.maisDeck.add(new CardFactoyImpl().poisonEffect( "Khael Mais Lich", 4, 2, 4, "maisDeckImage/khael_mais_lich.png"));
        this.maisDeck.add(new CardFactoyImpl().poisonEffect( "Khael Mais Lich", 4, 2, 4, "maisDeckImage/khael_mais_lich.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Chiesa del Mais", 5, 0, 4, "maisDeckImage/chiesa_del_mais.png", "Cattedrale del Mais", 10, 0, Optional.of(new Healer()), "maisDeckImage/cattedrale_del_mais.png"));
        
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "il fattore", 5, 2, 5, "maisDeckImage/il_fattore.png"));
        this.maisDeck.add(new CardFactoyImpl().armoredEffect( "il fattore", 5, 2, 5, "maisDeckImage/il_fattore.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mietitrebbia", 4, 0, 7, "maisDeckImage/mietitrebbia.png", "Cupo Mietitore", 8, 8, Optional.of(new Poison()), "maisDeckImage/cupo_mietitore.png"));
        this.maisDeck.add(new CardFactoyImpl().growthEffect( "Mietritrebbia", 4, 0, 7, "maisDeckImage/mietitrebbia.png", "Cupo Mietitore", 8, 8, Optional.of(new Poison()), "maisDeckImage/cupo_mietitore.png"));
        this.maisDeck.add(new CardFactoyImpl().noEffect( "MAISxodia il proibito", 10, 10, 10, "maisDeckImage/MAISxodia.png"));
       
        return this.maisDeck;
    }
    
    private List<Card> getShinobiDeck() {
        
        this.shinobiDeck.add(new CardFactoyImpl().drawEffect( "Studente Accademia", 1, 1, 2, "shinobiDeckImage/Studente_Accademia.png"));
        this.shinobiDeck.add(new CardFactoyImpl().drawEffect( "Studente Accademia", 1, 1, 2, "shinobiDeckImage/Studente_Accademia.png"));
        this.shinobiDeck.add(new CardFactoyImpl().drawEffect( "Studente Accademia", 1, 1, 2, "shinobiDeckImage/Studente_Accademia.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Genin", 1, 1, 1, "shinobiDeckImage/Genin.png"));
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Genin", 1, 1, 1, "shinobiDeckImage/Genin.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Ninja Medico", 4, 0, 2, "shinobiDeckImage/Ninja_Medico.png"));
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Ninja Medico", 4, 0, 2, "shinobiDeckImage/Ninja_Medico.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Copia Sakura", 2, 1, 2, "shinobiDeckImage/Copia_Sakura.png"));
        this.shinobiDeck.add(new CardFactoyImpl().healerEffect( "Copia Sakura", 2, 1, 2, "shinobiDeckImage/Copia_Sakura.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().exaltedEffect( "Chunin", 1, 3, 3, "shinobiDeckImage/Chunin.png"));
        this.shinobiDeck.add(new CardFactoyImpl().exaltedEffect( "Chunin", 1, 3, 3, "shinobiDeckImage/Chunin.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().exaltedEffect( "Ninja della Sabbia", 1, 1, 1, "shinobiDeckImage/Ninja_della_Sabbia.png"));
        this.shinobiDeck.add(new CardFactoyImpl().poisonEffect( "Orochimaru", 1, 1, 2, "shinobiDeckImage/Orochimaru.png"));
        this.shinobiDeck.add(new CardFactoyImpl().poisonEffect( "Orochimaru", 1, 1, 2, "shinobiDeckImage/Orochimaru.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Jonin", 3, 1, 3, "shinobiDeckImage/Jonin.png"));
        this.shinobiDeck.add(new CardFactoyImpl().noEffect( "Jonin", 3, 1, 3, "shinobiDeckImage/Jonin.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().elusiveEffect( "Ninja Traditore", 3, 2, 3, "shinobiDeckImage/Ninja_Traditore.png"));
        this.shinobiDeck.add(new CardFactoyImpl().elusiveEffect( "Ninja Traditore", 3, 2, 3, "shinobiDeckImage/Ninja_Traditore.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().armoredEffect( "Hinata", 4, 1, 4, "shinobiDeckImage/Hinata.png"));
        this.shinobiDeck.add(new CardFactoyImpl().lastwillEffect("Nagato", 4, 4, 4, "shinobiDeckImage/Nagato.png", "Nagato [Reincarnation]", 2, 2, Optional.of(new Elusive()), "shinobiDeckImage/Nagato_Reincarnation2.png"));
        
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Kakashi", 2, 2, 4, "shinobiDeckImage/Kakashi.png", "Kakashi [Anbu]", 4, 2, Optional.of(new Armored()), "shinobiDeckImage/Kakashi_Anbu.png"));
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Itachi", 4, 1, 5, "shinobiDeckImage/Itachi.png", "Itachi [Susanoo]", 1, 5, Optional.empty(), "shinobiDeckImage/Itachi_Susanoo.png"));
        
        // Card-Bosses
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( "Boruto Uzumaki", 5, 5, 8, "shinobiDeckImage/Boruto_Uzumaki.png", "Momoshiki Otsutsuki", 8, 1, Optional.of(new Poison()), "shinobiDeckImage/Momoshiki_Otsutsuki.png"));
        this.shinobiDeck.add(new CardFactoyImpl().armoredEffect( "Kaguya Otsutsuki", 10, 7, 10, "shinobiDeckImage/Kaguya_Otsutsuki.png"));
        this.shinobiDeck.add(new CardFactoyImpl().growthEffect( 
                "Naruto Uzumaki", 4, 4, 7, "shinobiDeckImage/Naruto_Uzumaki.png", 
                        "Naruto [Mod. Eremita]", 6, 6, Optional.of(new Growth(
                                "Naruto [Six-Path]", 8, 8, Optional.of(new Growth(
                                        "Naruto [Mod. Bayron]", 10, 10, Optional.empty(), 
                                            "shinobiDeckImage/Naruto_Mod.Bayron.png")), 
                                                "shinobiDeckImage/Naruto_Six_Path.png")), 
                                                    "shinobiDeckImage/Naruto_Mod.Eremita.png"));  
        
        return this.shinobiDeck;
    }
    
    private List<Card> getDuckDeck() {
        
        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Guard", 2, 1, 2, "DuckDeckImage/Bosss_Guard.png"));
        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Guard", 2, 1, 2,"DuckDeckImage/Bosss_Guard.png"));
        
        this.duckDeck.add(new CardFactoyImpl().healerEffect( "Boss's Maiden", 2, 2, 3,"DuckDeckImage/Bosss_Maiden.png"));
        this.duckDeck.add(new CardFactoyImpl().healerEffect( "Boss's Maiden", 2, 2, 3,"DuckDeckImage/Bosss_Maiden.png"));

        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Tailor", 1, 1, 1,"DuckDeckImage/Bosss_Tailor.png"));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Tailor", 1, 1, 1,"DuckDeckImage/Bosss_Tailor.png"));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Tailor", 1, 1, 1,"DuckDeckImage/Bosss_Tailor.png"));

        this.duckDeck.add(new CardFactoyImpl().growthEffect( "Boss's Lil Fella", 2, 2, 3,"DuckDeckImage/Bosss_Lil_Fella.png", "Boss's Acolytes", 3, 4, Optional.of(new Elusive()),"DuckDeckImage/Bosss_Acolytes.png"));
        this.duckDeck.add(new CardFactoyImpl().growthEffect( "Boss's Lil Fella", 2, 2, 3,"DuckDeckImage/Bosss_Lil_Fella.png", "Boss's Acolytes", 3, 4, Optional.of(new Elusive()),"DuckDeckImage/Bosss_Acolytes.png"));

        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Statue", 2, 0, 1,"DuckDeckImage/Bosss_Statue.png"));
        this.duckDeck.add(new CardFactoyImpl().armoredEffect( "Boss's Statue", 2, 0, 1,"DuckDeckImage/Bosss_Statue.png"));

        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Right Hand", 3, 3, 4,"DuckDeckImage/Bosss_Right_Hand.png"));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Right Hand", 3, 3, 4,"DuckDeckImage/Bosss_Right_Hand.png"));

        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Kitty", 4, 4, 5,"DuckDeckImage/Bosss_Kitty.png"));
        this.duckDeck.add(new CardFactoyImpl().noEffect( "Boss's Kitty", 4, 4, 5,"DuckDeckImage/Bosss_Kitty.png"));

        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "Boss's Heir", 5, 4, 6,"DuckDeckImage/Bosss_Heir.png"));
        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "Boss's Heir", 5, 4, 6,"DuckDeckImage/Bosss_Heir.png"));

        this.duckDeck.add(new CardFactoyImpl().elusiveEffect( "Boss's Acolytes", 3, 4, 5,"DuckDeckImage/Bosss_Acolytes.png"));
        this.duckDeck.add(new CardFactoyImpl().elusiveEffect( "Boss's Acolytes", 3, 4, 5,"DuckDeckImage/Bosss_Acolytes.png"));
        
        this.duckDeck.add(new CardFactoyImpl().poisonEffect( "Boss's Assassin", 1, 2, 1,"DuckDeckImage/Bosss_Assassin.png"));
        this.duckDeck.add(new CardFactoyImpl().poisonEffect( "Boss's Assassin", 1, 2, 1,"DuckDeckImage/Bosss_Assassin.png"));
        this.duckDeck.add(new CardFactoyImpl().poisonEffect( "Boss's Assassin", 1, 2, 1,"DuckDeckImage/Bosss_Assassin.png"));
        
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktective Holmes", 3, 2, 3,"DuckDeckImage/Ducktective_Holmes.png"));
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktective Holmes", 3, 2, 3,"DuckDeckImage/Ducktective_Holmes.png"));
        
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktor Watson", 2, 2, 2,"DuckDeckImage/Ducktor_Watson.png"));
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Ducktor Watson", 2, 2, 2,"DuckDeckImage/Ducktor_Watson.png"));
        
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Garden's Sage", 3, 3, 4,"DuckDeckImage/Gardens_Sage.png"));
        this.duckDeck.add(new CardFactoyImpl().drawEffect( "Garden's Sage", 3, 3, 4,"DuckDeckImage/Gardens_Sage.png"));

        this.duckDeck.add(new CardFactoyImpl().elusiveEffect( "The Impostor", 3, 4, 5,"DuckDeckImage/The_Impostor.png"));
        

        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "DuckPocalipse", 6, 5, 8,"DuckDeckImage/DuckPocalipse.png"));

        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "The Boss", 7, 6, 9,"DuckDeckImage/The_Boss.png"));
        this.duckDeck.add(new CardFactoyImpl().exaltedEffect( "The Boss", 7, 6, 9,"DuckDeckImage/The_Boss.png"));

        // 32 carte.
        return this.duckDeck;
    }
    
    private List<Card> getdeckOfThePit() {
        
        this.deckOfThePit.add(new CardFactoyImpl().rottenEffect( "Cane Marcescente", 1, 1, 1, "deckOfThePitImage/Cane_Marcescente.png"));
        this.deckOfThePit.add(new CardFactoyImpl().rottenEffect( "Cane Marcescente", 1, 1, 1, "deckOfThePitImage/Cane_Marcescente.png"));
        this.deckOfThePit.add(new CardFactoyImpl().rottenEffect( "Cane Marcescente", 1, 1, 1, "deckOfThePitImage/Cane_Marcescente.png"));
        this.deckOfThePit.add(new CardFactoyImpl().exaltedEffect( "Palikko Salsa", 1, 0, 1, "deckOfThePitImage/Palikko_Salsa.png"));
        this.deckOfThePit.add(new CardFactoyImpl().exaltedEffect( "Palikko Salsa", 1, 0, 1, "deckOfThePitImage/Palikko_Salsa.png"));
        this.deckOfThePit.add(new CardFactoyImpl().drawEffect( "Sacrifical Chicken", 1, 1, 2, "deckOfThePitImage/Pollo_Sacrificale.png"));
        this.deckOfThePit.add(new CardFactoyImpl().drawEffect( "Sacrifical Chicken", 1, 1, 2, "deckOfThePitImage/Pollo_Sacrificale.png"));
        this.deckOfThePit.add(new CardFactoyImpl().drawEffect( "Sacrifical Chicken", 1, 1, 2, "deckOfThePitImage/Pollo_Sacrificale.png"));
        this.deckOfThePit.add(new CardFactoyImpl().healerEffect( "The Pit", 4, 0, 2, "deckOfThePitImage/The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().poisonEffect( "Arancina of The Pit", 2, 1, 2, "deckOfThePitImage/Arancina_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().poisonEffect( "Arancina of The Pit", 2, 1, 2, "deckOfThePitImage/Arancina_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().poisonEffect( "Arancina of The Pit", 2, 1, 2, "deckOfThePitImage/Arancina_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().noEffect( "Infernal Cop", 3, 3, 3, "deckOfThePitImage/Infernal_Cop.png"));
        this.deckOfThePit.add(new CardFactoyImpl().noEffect( "Infernal Cop", 3, 3, 3, "deckOfThePitImage/Infernal_Cop.png"));
        this.deckOfThePit.add(new CardFactoyImpl().noEffect( "Infernal Cop", 3, 3, 3, "deckOfThePitImage/Infernal_Cop.png"));
        this.deckOfThePit.add(new CardFactoyImpl().elusiveEffect( "Faxen Shadow", 1, 4, 3, "deckOfThePitImage/Faxen_Shadow.png"));
        this.deckOfThePit.add(new CardFactoyImpl().elusiveEffect( "Faxen Shadow", 1, 4, 3, "deckOfThePitImage/Faxen_Shadow.png"));
        this.deckOfThePit.add(new CardFactoyImpl().elusiveEffect( "Faxen Shadow", 1, 4, 3, "deckOfThePitImage/Faxen_Shadow.png"));
        this.deckOfThePit.add(new CardFactoyImpl().healerEffect( "Tower of The Pit", 5, 1, 3, "deckOfThePitImage/Tower_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().lastwillEffect( "Generic Paladin 3000", 2, 2, 4, "deckOfThePitImage/Paladin.png", "Corupted Paladin", 4, 4, Optional.empty(), "deckOfThePitImage/Corrupted_Paladin.png"));
        this.deckOfThePit.add(new CardFactoyImpl().lastwillEffect( "Generic Paladin 3000", 2, 2, 4, "deckOfThePitImage/Paladin.png", "Corupted Paladin", 4, 4, Optional.empty(), "deckOfThePitImage/Corrupted_Paladin.png"));
        this.deckOfThePit.add(new CardFactoyImpl().armoredEffect( "Lawyer of The Pit", 3, 5, 5, "deckOfThePitImage/Lawyer_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().armoredEffect( "Lawyer of The Pit", 3, 5, 5, "deckOfThePitImage/Lawyer_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().lastwillEffect( "Seo", 2, 4, 6, "deckOfThePitImage/Seo.png", "Herald of The Pit", 6, 6, Optional.of(new Armored()), "deckOfThePitImage/Herald_Of_The_Pit.png"));
        this.deckOfThePit.add(new CardFactoyImpl().exaltedEffect( "Lord of The Pit", 7, 7, 7, "deckOfThePitImage/Lord_Of_The_Pit.png"));
        
        return this.deckOfThePit;
    }

}
