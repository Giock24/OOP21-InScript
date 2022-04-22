package view;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import gamemaster.GameMasterControllerImpl;
import gamemaster.OnGameEnd;
import gamemaster.SlowUpdate;
import gamemaster.UpdateView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class GameSceneController {
    
    GameMasterControllerImpl gameMasterController;

    ////player info/////
    @FXML private Label lifePointsPlayer;
    @FXML private Label currentManaPlayer;
    @FXML private Label manaPlayer;
    
    ////player IA info////
    @FXML private Label lifePointsIA;
    @FXML private Label currentManaIA;
    @FXML private Label manaIA;
    
    
    ////cards//////
    @FXML private HBox boardIA;
    @FXML private HBox boardPlayer;
    @FXML private HBox handPlayer; //TODO this must be inside a ScrollPane in the view
    
    ////cardView////
    @FXML private VBox cardView;
    
   
    public void initialize(){
        this.gameMasterController= new GameMasterControllerImpl(updateBoardView,slowUpdate,onGameEnd);
        updateBoardView.update();
    }
    
    private UpdateView updateBoardView = () -> {

        ////player info/////
        lifePointsPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getLifePoints()));
        currentManaPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getCurrentMana()));
        manaPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getMana()));
        
        ////player IA info////
        lifePointsIA.setText(Integer.toString(gameMasterController.getIAPlayer().getLifePoints()));
        currentManaIA.setText(Integer.toString(gameMasterController.getIAPlayer().getCurrentMana()));
        manaIA.setText(Integer.toString(gameMasterController.getIAPlayer().getMana()));
        
        ////cards////
        updateBoardIA();
        updateBoardPlayer();
        updatePlayerHand();
        
        ////cardView////
        updateCardViewElement();
    
};

    private SlowUpdate slowUpdate = () -> {
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }   

};
 
    private OnGameEnd onGameEnd = () -> {
        showGameOverDialog();
    };

    /**
     * this function generate the grafic for the empty cell
     * 
     * @param inTheAIBoard indicate if the empty card cell is in the player board or in the AI board
     * @return
     * @throws FileNotFoundException 
     */
    private VBox generateEmptyCardCell(boolean inTheAIBoard) throws FileNotFoundException {
        final VBox emptyCardCell = new VBox();
        
        String image = inTheAIBoard? "emptyCardCellAI.png" : "emptyCardCell.png";
        
        emptyCardCell.setStyle(""
                + "-fx-background-image:url('"+ image +"'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        
        emptyCardCell.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_HEIGHT.getValue());
        
        return emptyCardCell;
    }
    
    /**
     * this function generate the element for display the cards
     * 
     * @param card
     * @return
     */
    private VBox generateCardElement(Card card) {
        
        //TODO probably can be necessary change the style of the card if it is gameMasterController.getCardToPlace();
        //in the hand
   
        
        final VBox cardElement = new VBox();
        cardElement.setAlignment(Pos.CENTER);
        //centralPanel.setSpacing(40);
        
        final Label cardName = new Label();
        cardName.setText(card.getName());
        
        //TODO add all the card element
        
        return cardElement;
    }
    
    /**
     * function connect to the end-turn button
     * 
     * @param event
     */
    @FXML
    private void onEndTurnButtonPress(Event event) {
        gameMasterController.onEndTurn();
    }

    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardIA() {    
        boardIA.getChildren().removeAll();
        
        
        gameMasterController.getIAPlayer().getCurrentBoard().forEach(card -> {
            final Button cardCell= new Button();
            if( card.isPresent()) {
                
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                cardCell.setGraphic(generateCardElement(card.get()));
                
            } else {
                
                try {
                    cardCell.setGraphic(generateEmptyCardCell(true));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                
            }
            boardIA.getChildren().add(cardCell);
        });
        
        
    }
    
    /**
     * this function attach the cards element to the HBox named boardIA
     */
    private void updateBoardPlayer() {    
        boardPlayer.getChildren().removeAll();
        
        
        List<Optional<Card>> userBoard = gameMasterController.getHumanPlayer().getCurrentBoard();    
 
        IntStream.range(0, userBoard.size()).forEach(index -> {
            final Button cardCell= new Button();
            Optional<Card> card= userBoard.get(index);
            if( card.isPresent()) {
                
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                cardCell.setGraphic(generateCardElement(card.get()));
                
            } else {
                
                cardCell.setOnMouseClicked(event -> gameMasterController.onCardPlacing(index));
                try {
                    cardCell.setGraphic(generateEmptyCardCell(false));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                
            }
            
            boardPlayer.getChildren().add(cardCell);
        });
        
    }
    
    /**
     * this function attach the cards element to the HBOX named handPlayer
     */
    private void updatePlayerHand() {
        handPlayer.getChildren().removeAll();
        
        gameMasterController.getHumanPlayer().getHand().forEach((card) -> {
          
                final Button cardCell= new Button();
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card));
                cardCell.setOnMouseClicked(event -> gameMasterController.onSelectCardToPlace(card));
                cardCell.setGraphic(generateCardElement(card));
                
                handPlayer.getChildren().add(cardCell);
           
        });
    }
       
    /**
     * this function generate the element for the VBox cardView 
     * 
     * @param card this is the selected card to show (it can be Optional.empty)
     * @return
     */
    private void updateCardViewElement() {
        
        final Optional<Card> selectedCardToShow = gameMasterController.getCardToShow();
        
        final VBox cardViewElement = new VBox();
        
        if(selectedCardToShow.isPresent()) {
            //TODO add all the grafic for show the card detail
        } else {
            //TODO add all the grafic for show the card detail
        }
        
        cardView=cardViewElement;
        
    }
    
    /**
     * @param event active when is clicked a button
     *          when this method is called you can return to menu
     */
    @FXML
    public final void switchToMenuScene(final MouseEvent event) {
        final Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        final Showable menuGUI = new MenuGUI(primaryStage);
        
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
    }

    /**
     * dialog to show when the game is over
     * 
     * @return game over dialog
     */
    private void showGameOverDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over");
        alert.showAndWait();

    }
}
