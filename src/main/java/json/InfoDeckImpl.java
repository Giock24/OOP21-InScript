package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cards.Card;

public class InfoDeckImpl implements InfoDeck {

    private final String name;
    private final List<InfoCard> cardList;
    private final List<List<Card>> deckList = new ArrayList<>();
    
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
    public List<Card> generateDeck() {
        final List<Card> tmpCardList = new ArrayList<>();
        for(final InfoCard card : cardList) {
            tmpCardList.add(card.generateCard());
        }
        deckList.add(tmpCardList);
        return tmpCardList;
    }

    @Override
    public Map<String, List<Card>> generateDeckList(final List<String> names) {
        final Map<String, List<Card>> deckList = new HashMap<>(); 
        for(final String name : names) {
            deckList.put(name, generateDeck());
        }
        return deckList;
    }

}
