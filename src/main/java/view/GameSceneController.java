package view;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import cards.Card;
import gamemaster.GameMasterControllerImpl;
import gamemaster.OnGameEnd;
import gamemaster.UpdateView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static view.ViewState.WIDTH;
import static view.ViewState.HEIGHT;

public class GameSceneController extends AbstractController{
    
    GameMasterControllerImpl gameMasterController;
    CardGrafic cardGrafic;
    BalanceOfLifeGrafic balanceGrafic;
    private int colomn; // TODO campo che può essere omesso se il metodo updateBoardIA usasse un IntStream
    
    @FXML private BorderPane root;

    @FXML private Label currentPhase; 
    @FXML private Button musicButton;
    
    ////info/////
    @FXML private Label currentManaPlayer;
    ////balance of life////
    @FXML private HBox balance;
    
    ////cards//////
    @FXML private GridPane boardIA;
    @FXML private GridPane boardPlayer;
    @FXML private HBox handPlayer; //TODO this must be inside a ScrollPane in the view
    
    ////cardView////
    @FXML private GridPane cardView;
    
    ////battle phase button////
    @FXML private Button battlePhaseButton;
    
    @Override
    public void initialize(){
        this.gameMasterController= new GameMasterControllerImpl(updateBoardView,onGameEnd);
        this.cardGrafic = new CardGraficImpl();
        this.balanceGrafic = new BalanceOfLifeGrafic(this.gameMasterController.getHumanPlayer(),this.gameMasterController.getIAPlayer());
        inizializeEndTurnButton();
        inizilizeMusicButton();
        updateBoardView.update();
        
       
    }
    
    /**
     * this method is meat to be call for update the view after a change in the player
     */
    private final UpdateView updateBoardView = () -> {

        ////player info/////
        currentManaPlayer.setText(Integer.toString(gameMasterController.getHumanPlayer().getCurrentMana()));
        updateBalance();
        
        ////cards////
        updateBoardIA();
        updateBoardPlayer();
        updatePlayerHand();
        
        ////cardView////
        updateCardViewElement();
    
};

    /**
     * this method is meat to be call for when the match is over
     */
    private final OnGameEnd onGameEnd = (String endMessage) -> {
        showGameOverDialog(endMessage);
    };
    
    /**
     * function update the end-turn button
     * 
     */
    private void inizializeEndTurnButton() {
        battlePhaseButton.setMinSize(ViewState.CARD_WIDTH.getValue(), ViewState.CARD_WIDTH.getValue());
        battlePhaseButton.setOnMousePressed(event -> gameMasterController.onEndTurn());
    }
    
    
    private void inizilizeMusicButton() {
        musicButton.setOnAction(e -> {
            Music.BOARD_THEME.pauseAndResumeMusic();
            if (Music.BOARD_THEME.musicIsActive()) {
                musicButton.setText("VOLUME ON");
            } else {
                musicButton.setText("VOLUME OFF");
            }
           }
        );
    }
    
    /**
     * this method is meat to be call for update the grafic of the
     * "balance of life"
     */
    private void updateBalance() {
        balance.getChildren().clear();
        balance.getChildren().add(balanceGrafic.generateBalanceOfLife());
    }

    /**
     * this method update the grafic of the bord of the AI player
     */
    private void updateBoardIA() {    
        boardIA.getChildren().clear();
        this.colomn = 0;
        
        gameMasterController.getIAPlayer().getCurrentBoard().forEach(card -> {
            VBox cardCell= null;
            
            
            if( card.isPresent()) {
                
                cardCell = this.cardGrafic.generateCardElement(card.get(),gameMasterController.getCardToPlace());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
                
            } else {
                
                cardCell = this.cardGrafic.generateEmptyCardCell(true);
                
            }
            
            cardCell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            boardIA.addColumn(this.colomn, cardCell);
            this.colomn++;
        });
        
        
    }
    
    /**
     * this method update the grafic of the board of the Human Player
     */
    private void updateBoardPlayer() {    
        boardPlayer.getChildren().clear();
        
        final List<Optional<Card>> userBoard = gameMasterController.getHumanPlayer().getCurrentBoard();    
        
        IntStream.range(0, userBoard.size()).forEach(index -> {
            VBox cardCell = null;
            
            
            final Optional<Card> card= userBoard.get(index);
            if( card.isPresent()) {
                cardCell = this.cardGrafic.generateCardElement(card.get(),gameMasterController.getCardToPlace());
                cardCell.setOnMouseEntered(event -> gameMasterController.onSelectCardToShow(card.get()));
            } else {
                cardCell =this.cardGrafic.generateEmptyCardCell(false); 
                cardCell.setOnMousePressed(event -> gameMasterController.onCardPlacing(index));
            }
            
            if(cardCell != null) {
                cardCell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                boardPlayer.addColumn(index, cardCell);
            }
            
        });
        
        
    }
    
    /**
     * this method update the grafic of the card in the hand of the Human player
     */
    private void updatePlayerHand() {
        handPlayer.getChildren().clear();
        
        gameMasterController.getHumanPlayer().getHand().forEach((card) -> {
          
                final VBox cardCell= this.cardGrafic.generateCardElement(card,gameMasterController.getCardToPlace());
                cardCell.setOnMouseReleased(event -> gameMasterController.onSelectCardToShow(card));
                cardCell.setOnMousePressed(event -> gameMasterController.onSelectCardToPlace(card));
                
                handPlayer.getChildren().add(cardCell);
           
        });
        
    }
       
    /**
     * this method update the grafic of the 'card in evidence'
     */
    private void updateCardViewElement() {
        
        final BorderPane cardViewElement = this.cardGrafic.generateCardViewElement(gameMasterController.getCardToShow());
        
        cardView.getChildren().clear();
        cardView.getChildren().add(cardViewElement);
        
    }
    
    /**
     * this method is meat to be use for return in the menu
     */
    private void returnToMenu() {
        
        Music.BOARD_THEME.stopMusic();
        
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        final Showable menuGUI = new MenuGUI(primaryStage);
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToMenuScene(final MouseEvent event) {
        returnToMenu();
    }
    

    /**
     * dialog to show when the game is over
     * 
     * @return game over dialog
     */
    private void showGameOverDialog(final String endMessage) {
        final Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(endMessage);
        final Optional<ButtonType> result =  alert.showAndWait();
        
        if(result.get() == ButtonType.OK || result.get() == ButtonType.CLOSE) {
            returnToMenu();
        }

    }
}
