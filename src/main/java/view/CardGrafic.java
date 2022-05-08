package view;

import java.util.Optional;

import cards.Card;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public interface CardGrafic {
    
    VBox generateEmptyCardCell(boolean inTheAIBoard);
    
    VBox generateCardElement(Card card,Optional<Card> cardToPlace);
    
    BorderPane generateCardViewElement(Optional<Card> selectedCardToShow);
    
}
