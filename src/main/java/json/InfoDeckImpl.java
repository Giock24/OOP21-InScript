package json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cards.Card;

public class InfoDeckImpl implements InfoDeck {

    private final String name;
    private final List<InfoCard> cardList;
    
    public InfoDeckImpl(final String name, final List<InfoCard> cards) {
        this.name = name;
        this.cardList = cards;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<InfoCard> getCards() {
        return this.cardList;
    }

    @Override
    public List<Card> generateDeck(final InfoDeck e) {
        // TODO Auto-generated method stub
        return null;
    }

    /*@Override
    public Map<String, List<Card>> generateDeckList(InfoDeck e) {
        // TODO Auto-generated method stub
        return null;
    }*/

    @Override
    public Map<String, List<Card>> generateDeckList(final List<InfoDeck> decks, final List<String> names) {
        // TODO Auto-generated method stub
        return null;
    }

}
