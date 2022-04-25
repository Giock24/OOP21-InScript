package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import effects.Armored;
import effects.Elusive;

public class DeckFactoryImpl implements DeckFactory {
    
    final List<Card> playerDeck = new ArrayList<>();
    final List<Card> playerIADeck = new ArrayList<>();

    @Override
    public List<Card> getPlayerDeck() {
        
        this.playerDeck.add(new CardFactoyImpl().noEffect("st-01", "Cane", 1, 1, 1));
        this.playerDeck.add(new CardFactoyImpl().noEffect("st-01", "Cane", 1, 1, 1));
        this.playerDeck.add(new CardFactoyImpl().poisonEffect("st-02", "Vipera", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().healerEffect("st-03", "Calendula", 2, 0, 1));
        this.playerDeck.add(new CardFactoyImpl().healerEffect("st-03", "Calendula", 2, 0, 1));
        this.playerDeck.add(new CardFactoyImpl().noEffect("st-04", "Sasso", 4, 0, 2));
        this.playerDeck.add(new CardFactoyImpl().noEffect("st-04", "Sasso", 4, 0, 2));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect("st-05", "Corteo no Vax", 1, 3, 4));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect("st-05", "Corteo no Vax", 1, 3, 4));
        this.playerDeck.add(new CardFactoyImpl().exaltedEffect("st-06", "Terrapiattista", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().drawEffect("st-08", "Studiato", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().drawEffect("st-09", "Pesca", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().drawEffect("st-09", "Pesca", 1, 1, 2));
        this.playerDeck.add(new CardFactoyImpl().elusiveEffect("st-10", "Ladro", 1, 3, 3));
        this.playerDeck.add(new CardFactoyImpl().growthEffect("st-13", "Lucertola Rossa", 1, 1, 3, "Coccodrillo Rosso", 3, 3, Optional.empty()));
        this.playerDeck.add(new CardFactoyImpl().growthEffect("st-13", "Lucertola Rossa", 1, 1, 3, "Coccodrillo Rosso", 3, 3, Optional.empty()));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect("st-14", "G3n0s", 4, 1, 5));
        this.playerDeck.add(new CardFactoyImpl().healerEffect("st-15", "Chierico", 3, 2, 3));
        this.playerDeck.add(new CardFactoyImpl().armoredEffect("st-18", "Templare", 2, 4, 5));
        this.playerDeck.add(new CardFactoyImpl().noEffect("st-19", "Dinosauro", 6, 6, 6));
        
        return this.playerDeck;
    }

    @Override
    public List<Card> getPlayerIADeck() {
        
        this.playerIADeck.add(new CardFactoyImpl().noEffect("st-01", "Cane", 1, 1, 1));
        this.playerIADeck.add(new CardFactoyImpl().noEffect("st-01", "Cane", 1, 1, 1));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect("st-03", "Calendula", 2, 0, 1));
        this.playerIADeck.add(new CardFactoyImpl().healerEffect("st-03", "Calendula", 2, 0, 1));
        this.playerIADeck.add(new CardFactoyImpl().noEffect("st-04", "Sasso", 4, 0, 2));
        this.playerIADeck.add(new CardFactoyImpl().noEffect("st-04", "Sasso", 4, 0, 2));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect("st-05", "Corteo no Vax", 1, 3, 4));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect("st-05", "Corteo no Vax", 1, 3, 4));
        this.playerIADeck.add(new CardFactoyImpl().exaltedEffect("st-06", "Terrapiattista", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().poisonEffect("st-07", "Ratto", 2, 1, 3));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect("st-08", "Studiato", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect("st-09", "Pesca", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().drawEffect("st-09", "Pesca", 1, 1, 2));
        this.playerIADeck.add(new CardFactoyImpl().elusiveEffect("st-11", "Mimic", 3, 2, 4));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect("st-12", "Melma", 4, 2, 4));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect("st-12", "Melma", 4, 2, 4));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect("st-16", "Mummia", 1, 4, 3));
        this.playerIADeck.add(new CardFactoyImpl().rottenEffect("st-16", "Mummia", 1, 4, 3));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect("st-17", "Guts", 1, 4, 3, "Berserk", 2, 5, Optional.of(new Elusive())));
        this.playerIADeck.add(new CardFactoyImpl().growthEffect("st-20", "Uovo", 8, 0, 8, "Fafnir Drago Antico", 8, 8, Optional.of(new Armored())));
        
        return this.playerIADeck;
    }

}
