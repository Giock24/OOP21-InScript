package cards;


import java.io.InputStream;
import java.io.InputStreamReader;
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
import jsonparser.ParserImpl;
import jsonparser.Parser;




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


      try {
              final InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("json/decks.json");
              final InputStreamReader reader = new InputStreamReader(in);
              Parser parser = new ParserImpl(reader);
              return parser.deckListParser();
          } catch (Exception e) {
            e.printStackTrace();
        }
      
    getPlayerDeck();
    getPlayerIADeck();
    deckList.put("deck-standard", playerDeck);
    deckList.put("deck-standard-AI", playerIADeck);
    return deckList;

  } 
    
    private List<Card> getPlayerDeck() {
       
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerDeck.add(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png"));
        this.playerDeck.add(new CardFactoyImpl().poisonEffect( "Viper", 1, 1, 2, "standardDeckImage/Vipera.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Stone", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Stone", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Flat-earther", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "Flat-earther", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Academic", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Academic", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Peach", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerDeck.add(new CardFactoyImpl().drawEffect( "Peach", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerDeck.add(new CardFactoyImpl().elusiveEffect( "Thief", 1, 3, 3, "standardDeckImage/Ladro.png"));
        this.playerDeck.add(new CardFactoyImpl().growthEffect( "Red Lizard", 1, 1, 3, "standardDeckImage/Lucertola_rossa.png", "Red Crocodile", 3, 3, Optional.empty(), "standardDeckImage/Coccodrillo_rosso.png"));
        this.playerDeck.add(new CardFactoyImpl().growthEffect( "Red Lizard", 1, 1, 3, "standardDeckImage/Lucertola_rossa.png", "Red Crocodile", 3, 3, Optional.empty(), "standardDeckImage/Coccodrillo_rosso.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "No Vax Parade", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect( "No Vax Parade", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect( "G3n0s", 4, 1, 5, "standardDeckImage/G3n0s.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Cleric", 3, 2, 3, "standardDeckImage/Chierico.png"));
        this.playerDeck.add(new CardFactoyImpl().healerEffect( "Cleric", 3, 2, 3, "standardDeckImage/Chierico.png"));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect( "Templar", 2, 4, 5, "standardDeckImage/Templare.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Dinosaur", 6, 6, 6, "standardDeckImage/Dinosauro.png"));
        this.playerDeck.add(new CardFactoyImpl().noEffect( "Dinosaur", 6, 6, 6, "standardDeckImage/Dinosauro.png"));
        
        return this.playerDeck;
    }

    private List<Card> getPlayerIADeck() {
        
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Dog", 1, 1, 1, "standardDeckImage/Cane.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect( "Calendula", 2, 0, 1, "standardDeckImage/Calendula.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Stone", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerIADeck.add(new CardFactoyImpl().noEffect( "Stone", 4, 0, 2, "standardDeckImage/Sasso.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "flat-earther", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "flat-earther", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "flat-earther", 1, 1, 2, "standardDeckImage/Terrapiattista.png"));
        this.playerIADeck.add(new CardFactoyImpl().poisonEffect( "Rat", 2, 1, 3, "standardDeckImage/Ratto.png"));
        this.playerIADeck.add(new CardFactoyImpl().poisonEffect( "Rat", 2, 1, 3, "standardDeckImage/Ratto.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Academic", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Academic", 1, 1, 3, "standardDeckImage/Studiato.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Peach", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect( "Peach", 1, 0, 2, "standardDeckImage/Pesca.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Mummy", 1, 4, 3, "standardDeckImage/Mummia.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Mummy", 1, 4, 3, "standardDeckImage/Mummia.png"));
        this.playerIADeck.add(new CardFactoyImpl().elusiveEffect( "Mimic", 3, 2, 4, "standardDeckImage/Mimic.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Slime", 4, 2, 4, "standardDeckImage/Melma.png"));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect( "Slime", 4, 2, 4, "standardDeckImage/Melma.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "No Vax Parade", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect( "No Vax Parade", 1, 3, 4, "standardDeckImage/Corteo_No_Vax.png"));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect( "Guts", 1, 4, 3, "standardDeckImage/Guts.png", "Berserk", 2, 5, Optional.of(new Elusive()), "standardDeckImage/Berserk.png"));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect( "Egg", 8, 0, 8, "standardDeckImage/Uovo.png", "Fafnir Ancient Dragon", 8, 8, Optional.of(new Armored()), "standardDeckImage/Fafnir.png"));
        
        return this.playerIADeck;
    }

}
