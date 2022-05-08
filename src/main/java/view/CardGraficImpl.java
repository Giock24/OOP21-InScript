package view;

import java.util.Optional;

import cards.Card;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    public BorderPane generateCardViewElement(final Optional<Card> selectedCardToShow) {
        final BorderPane cardViewElement = new BorderPane();
        cardViewElement.setMaxSize(ViewState.CARD_WIDTH.getValue()*1.7, ViewState.CARD_HEIGHT.getValue()*1.7);
        
        if(selectedCardToShow.isPresent()) {
            
            final Card card = selectedCardToShow.get();
            
            cardViewElement.setStyle(" "
                    + "-fx-font-family: Impact;\n"
                    );
            
            
            //top layout
            final GridPane topLay = new GridPane();
            
            topLay.setStyle(" "
                    + "-fx-background-image:url('cardBackgroudTop.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;"
                    + "-fx-font-size: 16;"
                    );
            
            final HBox nameLay = new HBox();
            final Label nameText = new Label(card.getName());
            nameText.setWrapText(true);
            
            final HBox manaLay = new HBox();
            final Label manaText = new Label("Mana: " + card.getMana());
            
            nameLay.setAlignment(Pos.TOP_LEFT);
            nameLay.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()*0.05, 0, 0, ViewState.CARD_WIDTH.getValue()*0.15));
            nameLay.getChildren().add(nameText);
            
            
            manaLay.setAlignment(Pos.TOP_RIGHT);
            manaLay.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()*0.05, ViewState.CARD_WIDTH.getValue()*0.05, 0, 0));
            manaLay.getChildren().add(manaText);
            
            GridPane.setConstraints(nameLay, 0, 0);
            GridPane.setConstraints(manaLay, 1, 0);
            topLay.getColumnConstraints().add(new ColumnConstraints(130));
            topLay.getColumnConstraints().add(new ColumnConstraints(100));
            
            topLay.getChildren().addAll(nameLay, manaLay);
            
            cardViewElement.setTop(topLay);
            
            //center layout
            final BorderPane imageLay = new BorderPane();
            final VBox image = new VBox();
            BorderPane.setMargin(image, new Insets(ViewState.CARD_HEIGHT.getValue()*0.05, ViewState.CARD_WIDTH.getValue()*0.10, ViewState.CARD_HEIGHT.getValue()*0.05, ViewState.CARD_WIDTH.getValue()*0.10));
            
            imageLay.setStyle(" "
                    + "-fx-background-image:url('cardBackgroudCenter.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;"
                    );
            
            
            
            image.setStyle(" "
                    + "-fx-background-image:url('"+card.getImageURL()+"'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;"
                    );
            image.setAlignment(Pos.CENTER);
            //image.setPadding(new Insets(0,ViewState.CARD_WIDTH.getValue()*1.5, 0,ViewState.CARD_WIDTH.getValue()*0.1));
            //imageLay.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()*0.01, ViewState.CARD_WIDTH.getValue()*0.1, ViewState.CARD_HEIGHT.getValue()*0.01, ViewState.CARD_WIDTH.getValue()*0.1));
            imageLay.setCenter(image);
            
            
            cardViewElement.setCenter(imageLay);
            
            // BOTTOM layouts
            final GridPane bottomLay = new GridPane();
            
            bottomLay.setStyle(" "
                    + "-fx-background-image:url('cardBackgroudBot.png'); "
                    + "-fx-background-repeat: no-repeat;\n"
                    + "-fx-background-size: contain;\n"
                    + "-fx-background-size: 100% 100%;"
                    + "-fx-font-size: 14;"
                    );
            
            final VBox atkLay = new VBox();
            final Label atk = new Label("ATK");
            final Label intAtk = new Label(" "+ card.getAttack());
            
            atkLay.setAlignment(Pos.TOP_LEFT);
            atkLay.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()*0.1, 0, ViewState.CARD_HEIGHT.getValue()*0.12, ViewState.CARD_WIDTH.getValue()*0.12));
            atkLay.setSpacing(2);
            atkLay.getChildren().addAll(atk, intAtk);
            
            final VBox hpLay = new VBox();
            final Label hp = new Label("HP");
            final Label intHP = new Label(" "+ card.getLifePoint());
            
            hpLay.setAlignment(Pos.BOTTOM_RIGHT);
            hpLay.setPadding(new Insets(0, 0, ViewState.CARD_HEIGHT.getValue()*0.1, 0));
            hpLay.setSpacing(2);
            hpLay.getChildren().addAll(hp, intHP);
            
            final VBox descLay = new VBox();
            if (card.getEffect().isPresent()) {
                final Label effectDescription = new Label(card.getEffect().get().getNameEffect()+": "+card.getEffect().get().getDescriptionEffect());
                effectDescription.setWrapText(true);
                
                descLay.setAlignment(Pos.CENTER);
                descLay.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()*0.01, 0, ViewState.CARD_HEIGHT.getValue()*0.08, ViewState.CARD_WIDTH.getValue()*0.1));
                descLay.getChildren().add(effectDescription);
            }
            
            GridPane.setConstraints(atkLay, 0, 0);
            GridPane.setConstraints(descLay, 1, 0);
            GridPane.setConstraints(hpLay, 2, 0);
            bottomLay.getColumnConstraints().add(new ColumnConstraints(40));
            bottomLay.getColumnConstraints().add(new ColumnConstraints(140));
            bottomLay.getColumnConstraints().add(new ColumnConstraints(40));
            
            bottomLay.getChildren().addAll(atkLay, descLay, hpLay);
            
            cardViewElement.setBottom(bottomLay);
            
        } 
        
        return cardViewElement;
        
    }

}
