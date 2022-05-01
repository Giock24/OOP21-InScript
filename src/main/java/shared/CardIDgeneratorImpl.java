package shared;

public class CardIDgeneratorImpl implements CardIDgenerator {
    
    private static CardIDgeneratorImpl instance = null;
    
    int idGiven;
    
    private CardIDgeneratorImpl() {
        idGiven=0;
    }
    
    public static CardIDgeneratorImpl getIntance() {
        if(instance == null) {
            instance = new CardIDgeneratorImpl();
        }
        return instance;
    }

    @Override
    public String generateID() {
        idGiven=idGiven+1;
        return String.valueOf(idGiven);
    }

}
