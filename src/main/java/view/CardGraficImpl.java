package view;

import java.util.Optional;

import cards.Card;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
        final BorderPane statsContainter = new BorderPane();
        final Pane imageEffect = new Pane();
        final Pane imageCard = new Pane();
        final VBox imagecontainer = new VBox();
        final BorderPane nameContainer = new BorderPane();
        cardElement.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
        
        final boolean isCardToPlace = cardToPlace.isPresent() && cardToPlace.get().equals(card);
        
        cardElement.setStyle(" "
                + "-fx-background-image:url('cardBackgroud.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;"
                + "-fx-font-family: Impact;\n"
                + "-fx-font-size: 16;"
                + (isCardToPlace == true ?  
                        "-fx-border-color: #a7ab7d;\n" 
                        + "-fx-border-width: 6;\n" 
                         : "")
               );
                
        imageCard.setStyle(" "
                + "-fx-background-image:url('"+card.getImageURL()+"'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 95% 95%;");
        // imageCard.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()/1.90, ViewState.CARD_WIDTH.getValue()/2.2 ,0 ,ViewState.CARD_WIDTH.getValue()/2.2));
        imageCard.setPadding(new Insets(
                ViewState.CARD_HEIGHT.getValue()/1.90, 
                ViewState.CARD_WIDTH.getValue()/2.2, 
                ViewState.CARD_HEIGHT.getValue()*0.0000, 
                ViewState.CARD_WIDTH.getValue()/2.2));

        // imageCard.setMaxSize(ViewState.CARD_HEIGHT.getValue()/2, ViewState.CARD_WIDTH.getValue()/2);
                
        imagecontainer.getChildren().add(imageCard);
        imagecontainer.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()/20.9, 0, ViewState.CARD_HEIGHT.getValue()*0.03, ViewState.CARD_HEIGHT.getValue()/30));
        imagecontainer.setAlignment(Pos.CENTER);
        
        if(card.getEffect().isPresent()) {
            imageEffect.setStyle(" "
                    + "-fx-background-image:url('" + card.getEffect().get().getImageEffectURL() + "'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;");
            imageEffect.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()*0.001, 0, ViewState.CARD_HEIGHT.getValue()*0.125, 0));
            imageEffect.setMaxSize(ViewState.CARD_HEIGHT.getValue()/2, ViewState.CARD_WIDTH.getValue());
        }

        final Label cardName = new Label();
        cardName.setText(card.getName());
        cardName.setPadding(new Insets(3));
        
        final Label cardMana = new Label();
        cardMana.setText("Mana: "+card.getMana());
        cardMana.setPadding(new Insets(3));

        final Label atkValue = new Label();
        atkValue.setText("ATK\n "+card.getAttack());
        atkValue.setPadding(new Insets(
                -ViewState.CARD_HEIGHT.getValue()*0.0125, 
                -ViewState.CARD_WIDTH.getValue()*0, 
                ViewState.CARD_HEIGHT.getValue()*0.0125, 
                ViewState.CARD_WIDTH.getValue()*0.0125));
        
        final Label lifeValue = new Label();
        lifeValue.setText("HP\n "+card.getLifePoint());
        lifeValue.setPadding(new Insets(-ViewState.CARD_HEIGHT.getValue()*0.0125, 
                -ViewState.CARD_WIDTH.getValue()*0, 
                ViewState.CARD_HEIGHT.getValue()*0.0125, 
                0));
        // lifeValue.setPadding(new Insets(7));
        
        statsContainter.setLeft(atkValue);
        statsContainter.setCenter(imageEffect);
        statsContainter.setRight(lifeValue);
        statsContainter.setPadding(new Insets(0, ViewState.CARD_HEIGHT.getValue()*0.001, 0, ViewState.CARD_HEIGHT.getValue()*0.001));
        
        BorderPane.setAlignment(atkValue, Pos.CENTER);
        BorderPane.setAlignment(imageEffect, Pos.CENTER);
        BorderPane.setAlignment(lifeValue, Pos.CENTER);
        // imagecontainer.setMinSize(ViewState.CARD_WIDTH.getValue()/1.75, ViewState.CARD_HEIGHT.getValue()/1.65);

        nameContainer.setLeft(cardName);
        nameContainer.setRight(cardMana);

        cardElement.getChildren().add(nameContainer);
        cardElement.getChildren().add(imagecontainer);
        cardElement.getChildren().add(statsContainter);
        cardElement.setPadding(new Insets(6));
                
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
                    + "-fx-background-image:url('cardBackgroud.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;"
                    + "-fx-font-family: Impact;\n"
                    + "-fx-font-size: 15;");
            
            cardViewElement.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
            cardViewElement.setPadding(new Insets(10));
            
            final Label cardName = new Label();
            cardName.setText(card.getName());
            cardName.setPadding(new Insets(5));
            
            final Label cardMana = new Label();
            cardMana.setText(" "+card.getMana());
            cardMana.setPadding(new Insets(5));
            
            nameContainer.setLeft(cardName);
            nameContainer.setRight(cardMana);
            
            imageContainer.setStyle(" "
                    + "-fx-background-image:url('"+card.getImageURL()+"'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;");
            imageContainer.setPadding(new Insets(95));
            
            final Label atkValue = new Label();
            atkValue.setText(" "+card.getAttack());
            atkValue.setPadding(new Insets(15));
            
            final Label effectDescription = new Label();
            if (card.getEffect().isPresent()) {
            effectDescription.setText(card.getEffect().get().getNameEffect()+": "+card.getEffect().get().getDescriptionEffect());
            effectDescription.setWrapText(true);
            }else {
                effectDescription.setText(" ");
            }
            
            final Label lifeValue = new Label();
            lifeValue.setText(" "+card.getLifePoint());
            lifeValue.setPadding(new Insets(15));
            
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
