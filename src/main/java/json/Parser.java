package json;

import org.json.simple.JSONArray;

public interface Parser {
    
    // InfoCard simpleParser();
    
    // InfoCard complexParser();
    
    InfoDeck deckParser(JSONArray listDeck, String nameDeck);
    
}
    
    
    // Metodo di testing
    /*public static void JsonParsing() {
        final JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader("C:\\Users\\User\\Desktop\\Json testing\\test1.json")){
            final Object obj = jsonParser.parse(reader);
            final JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
            
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ParseException e) {
            e.printStackTrace();
        }
    }*/
    // con la struttura attuale durante il print del contenuto del JSON da priorità agli eventuali campi composti piuttosto all'ordine in cui sono disposti,
    // Cioè se prima di un campo composto c'era un'altro campo, stampa prima il campo composto invece che il campo prima di quello composto

