package gamemaster;

import javafx.fxml.FXML;

public interface BoardController {
    
    
    /**
     * this function is the one that react to the selection of the card in the hand,
     * 
     */
    @FXML
    void onHandCellPress();
    
    /**
     * this function is the one that handele the press of the positioning of the card on the board,
     * the user must have arleady selected a card, otherwise this function will do nothing
     * 
     */
    @FXML
    void onBoardCellPress();
    
}
