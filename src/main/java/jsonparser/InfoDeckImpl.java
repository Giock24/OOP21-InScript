package jsonparser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
    public List<Card> generateDeck() {
        final List<Card> tmpCardList = new ArrayList<>();
        for(final InfoCard card : cardList) {
            IntStream.range(0, card.getCopies()).forEach(i -> { tmpCardList.add(card.generateCard()); });    
        }
        return tmpCardList;
    }
}
