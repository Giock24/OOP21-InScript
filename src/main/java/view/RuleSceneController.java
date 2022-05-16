package view;

import static view.ViewState.HEIGHT;
import static view.ViewState.WIDTH;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RuleSceneController {
    
    @FXML BorderPane root;
    @FXML Label board_description;
    @FXML Label victory_condition;
    @FXML Label game_phases;
    @FXML Label draw_phase;
    @FXML Label main_phase;
    @FXML Label battle_phase;
    @FXML Label effects;
    
    
    public void initialize(){
        setText();
    }
    
    
    @FXML
    public final void switchToMenuScene(final MouseEvent event) {
        
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        final Showable menuGUI = new MenuGUI(primaryStage);
        
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
    }
    
    private void setText() {
        board_description.setText("the game table is divided is 4 main-zone\n "
                + "on the left - there is the 'info-zone' this zone display the information about the curret 'mana' the player posses and the current life of the player and of the enemy\n"
                + "on the center - there is the 'board-zone' this zone show the player and the enemy field and the card placed on it. the cards on the row on the top are the enemy's card\n"
                + "on the right - there is the 'card-detail-zone' this zone will display more detail of a card if you click on it\n"
                + "on the botton - there is the 'hand-zone' this zone show the card in the player hand\n");
    }
    

}
