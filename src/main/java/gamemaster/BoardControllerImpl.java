package gamemaster;

import java.util.ArrayList;

import cards.Card;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class BoardControllerImpl {
    
    GameMaster gameMaster;
    
    @FXML private Button firstPlayerBoardCell;
    
    public void initialize(){
        //TODO: add the deck here
        gameMaster= new GameMasterImpl(new ArrayList<Card>(), new ArrayList<Card>());
    }

    @FXML
    private void onFirstHandCellPress(Event event) {
        // TODO Auto-generated method stub
    }
    @FXML
    private void onSecondHandCellPress(Event event) {
        // TODO Auto-generated method stub
    }
    @FXML
    private void onThirdHandCellPress(Event event) {
        // TODO Auto-generated method stub
    }
    @FXML
    private void onForthHandCellPress(Event event) {
        // TODO Auto-generated method stub
    }
    @FXML
    private void onFifthHandCellPress(Event event) {
        // TODO Auto-generated method stub
    }
    

    @FXML
    public void onFirstBoardCellPress(Event event) {
        // TODO Auto-generated method stub
        
    };
    @FXML
    public void onSecondBoardCellPress(Event event) {
        // TODO Auto-generated method stub
        
    };
    @FXML
    public void onThirdBoardCellPress(Event event) {
        // TODO Auto-generated method stub
        
    };
    @FXML
    public void onForthBoardCellPress(Event event) {
        // TODO Auto-generated method stub
        
    };
    @FXML
    public void onFifthBoardCellPress(Event event) {
        // TODO Auto-generated method stub
        
    };


}
