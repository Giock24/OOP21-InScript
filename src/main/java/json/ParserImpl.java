package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParserImpl implements Parser {
    
    final JSONParser jsonParser = new JSONParser();
    FileReader reader;
    JSONObject cardObject;
    
    public ParserImpl(final String filePath) {
        try{
            reader = new FileReader(filePath);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            // reader = null;

        }
        /*} catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }
    

    //@Override
    // Costruttore InfoCardImpl: final String name, final int lifeValue, final int attackValue, final int manaCost, final ChangeEffect effect, final String imageURL
    private InfoCard cardParser(final JSONObject card) {
        cardObject = (JSONObject) card.get("card");        
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
            final String name = (String) cardObject.get("name");
            final int lifeValue = (int) cardObject.get("lifeValue");
            final int attackValue = (int) cardObject.get("attackValue");
            final ChangeEffect innerEffect = complexEffectParser((JSONObject)cardObject.get("effect"));
            final String imageURL = (String) cardObject.get("imageURL");
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
    @Override
    public InfoDeck deckParser() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /*@Override
    public InfoDeck deckListParser() {
        // TODO Auto-generated method stub
        return null;
    }*/

}
