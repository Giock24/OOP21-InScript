package json;

import java.util.ArrayList;
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

    // [REMINDER] Non serve passare al metodo lo stesso oggetto che contiene la lista delle InfoCard da generare, in quanto è l'oggetto stesso.
    // Da rimuovere "final InfoDeck e" e modificare l'interfaccia perchè non accetti nessun parametro in input.
    @Override
    public List<Card> generateDeck(final InfoDeck e) {
        final List<Card> tmpCardList = new ArrayList<>();
        for(final InfoCard card : e.getCards()) {
            // [REMINDER] Stessa discorso per generateCard e il rispettivo parametro non necessario che prende in input.
            tmpCardList.add(card.generateCard(card));
        }
        deckList.add(tmpCardList);
        return tmpCardList;
    }

    // [REMINDER] Anche qui non serve che passi in input come parametri la lista dei deck da cui verrà generata la lista finale dei Deck disponibili;
    // Uso una variabile locale "deckList" per salvarmi ogni volta l'ultimo deck generato dalla rispettiva lista di InfoCard;
    // Per quanto riguarda la "List<String> names" per ora va ancora bene, in quanto non ho ancora trovato un metodo efficiente per salvarmi il nome dei mazzi.
    @Override
    public Map<String, List<Card>> generateDeckList(final List<InfoDeck> decks, final List<String> names) {
        // TODO Auto-generated method stub
        return null;
    }

}
