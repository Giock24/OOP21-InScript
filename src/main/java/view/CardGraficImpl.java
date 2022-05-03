package view;

import java.util.Optional;

import cards.Card;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
        
        final boolean isCardToPlace = cardToPlace.isPresent() && cardToPlace.get().equals(card);
        
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
        final BorderPane nameContainer = new BorderPane();
        final Pane imageContainer = new Pane();
        final BorderPane statsContainter = new BorderPane();
        
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
            
            final Label cardMana = new Label();
            cardMana.setText(" "+card.getMana());
            
            nameContainer.setLeft(cardName);
            nameContainer.setRight(cardMana);
            
            final Label pipo = new Label();
            
            imageContainer.getChildren().add(pipo);
            imageContainer.setStyle(" "
                    + "-fx-background-image:url('standardDeckImage/Cane.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;");
            imageContainer.setPadding(new Insets(100));
            
            final Label atkValue = new Label();
            atkValue.setText(" "+card.getAttack());
            atkValue.setPadding(new Insets(10));
            
            final Label effectDescription = new Label();
            if (card.getEffect().isPresent()) {
            effectDescription.setText(card.getEffect().get().getNameEffect()+": "+card.getEffect().get().getDescriptionEffect());
            effectDescription.setWrapText(true);
            }else {
                effectDescription.setText("No Effect");
            }
            
            final Label lifeValue = new Label();
            lifeValue.setText(" "+card.getLifePoint());
            lifeValue.setPadding(new Insets(10));
            
            statsContainter.setLeft(atkValue);
            statsContainter.setCenter(effectDescription);
            statsContainter.setRight(lifeValue);
            
            cardViewElement.getChildren().add(nameContainer);
            cardViewElement.getChildren().add(imageContainer);
            cardViewElement.getChildren().add(statsContainter);
            
        } 
        
        return cardViewElement;
        
    }

}
