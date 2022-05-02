package view;

import java.util.Optional;

import cards.Card;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CardGraficImpl implements CardGrafic {

    @Override
    public VBox generateEmptyCardCell(final boolean inTheAIBoard) {
        final VBox emptyCardCell = new VBox();
        
        final String image = inTheAIBoard? "emptyCardCellAI.png" : "emptyCardCell.png";
        
        emptyCardCell.setStyle(" "
                + "-fx-background-image:url('"+ image +"'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        
        emptyCardCell.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
        
        return emptyCardCell;
    }

    @Override
    public VBox generateCardElement(final Card card, final Optional<Card> cardToPlace) {
        final VBox cardElement = new VBox();
        cardElement.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
        
        final boolean isCardToPlace = cardToPlace.isPresent() && cardToPlace.get() == card;
        
        cardElement.setStyle(" "
                + "-fx-background-image:url('sampleCardImage.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;"
                + (isCardToPlace == true ?  
                        "-fx-border-color: #a7ab7d;\n" 
                        + "-fx-border-width: 6;\n" 
                         : "")
               );
        
        final Label cardNameAndMana = new Label();
        cardNameAndMana.setText(card.getName()+"      mana:"+card.getMana());
        final Label cardAttackAndLife = new Label();
        cardAttackAndLife.setText("atk:"+card.getAttack()+"        HP:"+card.getLifePoint());
        
        cardElement.getChildren().add(cardNameAndMana);
        cardElement.getChildren().add(cardAttackAndLife);
        
        return cardElement;
    }

    @Override
    public VBox generateCardViewElement(final Optional<Card> selectedCardToShow) {
        final VBox cardViewElement = new VBox();
        
        if(selectedCardToShow.isPresent()) {
            
            final Card card = selectedCardToShow.get();
            
            cardViewElement.setStyle(" "
                    + "-fx-background-image:url('sampleCardImage.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;");
            
            cardViewElement.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
            
            final Label cardName = new Label();
            cardName.setText(card.getName());
            
            cardViewElement.getChildren().add(cardName);
        } 
        
        return cardViewElement;
        
    }

}
