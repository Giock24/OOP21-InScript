package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cards.Card;

public class ParserImpl implements Parser {
    
    final String path;
    
    public ParserImpl(final String filePath) {
        this.path = filePath;
    }
    
    //@Override
    // Costruttore InfoCardImpl: final String name, final int lifeValue, final int attackValue, final int manaCost, final ChangeEffect effect, final String imageURL
    private InfoCard cardParser(final JSONObject card) {
        final JSONObject cardObject = (JSONObject) card.get("card");        
        final String name = (String) cardObject.get("name");
        final int lifeValue = (int) cardObject.get("lifeValue");
        final int attackValue = (int) cardObject.get("attackValue");
        final int manaCost = (int) cardObject.get("manaCost");        
        final ChangeEffect effect = complexEffectParser((JSONObject)cardObject.get("effect"));        
        final String imageURL = (String) cardObject.get("imageURL");
        
        return new InfoCardImpl(name, lifeValue, attackValue, manaCost, effect, imageURL);
    }
    
    private ChangeEffect simpleEffectParser(final JSONObject effect) {
        return new ChangeEffectImpl((String) effect.get("nameEffect"));
    }
    
    // Costruttore ChangeEffectImpl: final String effectName, final String cardName, final int lifeValue, final int attackValue, final String imageURL, final ChangeEffect effect
    private ChangeEffect complexEffectParser(final JSONObject effect) {
        // If se effect è un effetto composto(alias Growth o LastWill)
        if(effect.get("nameEffect") == "Growth" || effect.get("nameEffect") == "LastWill") {
            final String effectName = (String) effect.get("nameEffect");
            final String name = (String) effect.get("name");
            final int lifeValue = (int) effect.get("lifeValue");
            final int attackValue = (int) effect.get("attackValue");
            final ChangeEffect innerEffect = complexEffectParser((JSONObject)effect.get("effect"));
            final String imageURL = (String) effect.get("imageURL");
            return new ChangeEffectImpl(effectName, name, lifeValue, attackValue, imageURL, innerEffect);
        }
        //  else nel caso effect è una stringa vuota o se effect è un effetto semplice(alias armored, etc...)
        else 
        {
            return simpleEffectParser(effect);
        }
    }

    // Forse sarà necessario anche un deckListParser, in quanto non mi posso aspettare una invocazione esterna a questa classe in quanto è solo questa
    // la classe specializzata per la conversione del JSON.
    // - in caso, bisogna modificare interfaccia.
    @SuppressWarnings("unchecked")
    @Override
    public InfoDeck deckParser(final JSONObject deck) {
        
        final JSONObject deckObject = (JSONObject) deck.get("card");
        final String deckName = (String) deckObject.get("name");
        final JSONArray jCardList = (JSONArray) deckObject.get("cards");
        final List<InfoCard> cardList = new ArrayList<>();
        jCardList.forEach( card -> {  cardList.add( (InfoCard) cardParser((JSONObject) card)); });
        return new InfoDeckImpl(deckName, cardList);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, List<Card>> deckListParser() {
        // Object obj = null;
        try (FileReader reader = new FileReader(path)){
            
            final JSONParser jsonParser = new JSONParser();

            final Object obj = jsonParser.parse(reader);
            final JSONArray deckList = (JSONArray) obj;
            
            final Map<String, List<Card>> deckMap = new HashMap<>();
            
            // print per il controllo del corretto parsing da parte del JsonParser;
            System.out.println(deckList);
            
            // RIGA MOLTO PERICOLOSA -> Utilizza tutto il parsing eseguito adesso + Genera il deck partendo dal parsing eseguito, e lo mette dentro a una mappa<Stringa, Lista<Carta>>;
            deckList.forEach(deck -> {deckMap.put(deckParser((JSONObject) deck).getName(), deckParser((JSONObject) deck).generateDeck()); });
            return deckMap;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ParseException e) {
            e.printStackTrace();
        }
        return Map.of();

    }

    
    /*final List<InfoCard> cards = new ArrayList<>();
    String nameSelected = null;
    JSONObject deckSelected = null;
    
    for(final var decks :  listDeck) {
        final JSONObject deck1 = (JSONObject) decks;
        final String name = (String) deck1.get("name");
        if (nameDeck.equals(name)) {
            nameSelected = name;
            deckSelected = deck1;
            break;
        }
    }
    
    try {
        final JSONArray cards2 = (JSONArray) deckSelected.get("cards");
        cards2.forEach(card -> {
            cards.add(this.cardParser((JSONObject) card));
        });
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
    
    return new InfoDeckImpl(nameSelected, cards);*/

    
    
    
    
}
