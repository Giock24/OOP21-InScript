package jsonparser;

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
        
        // ho dovuto ricorrere a un doppio cast, da object a long, e da long a int;
        // di per se funziona, ma fa schifo da vedere, l'esempio di lifevalue dovrebbe essere più pertinente, ma impone che tutti i valori interi siano espressi nel json come stringhe, in quanto
        // faccio un parse a string a int;
        final int lifeValue = (int)(long) cardObject.get("lifeValue");        
        final int attackValue = (int)(long) cardObject.get("attackValue");
        final int manaCost = (int)(long) cardObject.get("manaCost");
        final String imageURL = (String) cardObject.get("imageURL");
        final int copies = (int)(long) cardObject.get("copies");
        final ChangeEffect effect = complexEffectParser((JSONObject)cardObject.get("effect"));
        
        
        return new InfoCardImpl(name, lifeValue, attackValue, manaCost, effect, imageURL, copies);
    }
    
    private ChangeEffect simpleEffectParser(final JSONObject effect) {
        return new ChangeEffectImpl((String) effect.get("effectName"));
    }
    
    // Costruttore ChangeEffectImpl: final String effectName, final String cardName, final int lifeValue, final int attackValue, final String imageURL, final ChangeEffect effect
    private ChangeEffect complexEffectParser(final JSONObject effect) {
        // If se effect è un effetto composto(alias Growth o LastWill)
        final String effectName = (String) effect.get("effectName");        
        
        if("Growth".equals(effectName) || "LastWill".equals(effectName)) {
            final String name = (String) effect.get("cardName");
            final int lifeValue = (int)(long) effect.get("lifeValue");
            final int attackValue = (int)(long) effect.get("attackValue");
            final String imageURL = (String) effect.get("imageURL");
            final JSONObject innerInnerEffect = (JSONObject) effect.get("innerEffect");
            final ChangeEffect innerEffect = complexEffectParser(innerInnerEffect);

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
        final JSONObject deckObject = (JSONObject) deck.get("Deck");
        final String deckName = (String) deckObject.get("name");
        final JSONArray jCardList = (JSONArray) deckObject.get("cards");
        final List<InfoCard> cardList = new ArrayList<>();
        jCardList.forEach( card -> {  cardList.add( cardParser((JSONObject) card)); });
        
        return new InfoDeckImpl(deckName, cardList);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, List<Card>> deckListParser() {
        final Map<String, List<Card>> deckMap = new HashMap<>();

        try (FileReader reader = new FileReader(path)){
            
            final JSONParser jsonParser = new JSONParser();

            final Object obj = jsonParser.parse(reader);
            final JSONArray deckList = (JSONArray) obj;
            
            // print per il controllo del corretto parsing da parte del JsonParser;
            // System.out.println(deckList);
            
            // RIGA MOLTO PERICOLOSA -> Utilizza tutto il parsing eseguito adesso + Genera il deck partendo dal parsing eseguito, e lo mette dentro a una mappa<Stringa, Lista<Carta>>;
            deckList.forEach(deck -> {final InfoDeck tmp = deckParser((JSONObject) deck); deckMap.put(tmp.getName(), tmp.generateDeck()); });
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
        return deckMap;

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
