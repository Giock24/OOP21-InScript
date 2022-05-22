package view;

import static view.ViewState.HEIGHT;
import static view.ViewState.WIDTH;

import gamemaster.GameMaster;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
    
    @FXML Pane board_description_image;
    @FXML Pane victory_condition_image;
    @FXML Pane game_phases_image;
    @FXML Pane draw_phase_image;
    @FXML Pane main_phase_image;
    @FXML Pane battle_phase_image;
    @FXML Pane effects_image;
    
    
    public void initialize(){
        setText();
        setImages();
    }
    
    
    @FXML
    public final void switchToMenuScene(final MouseEvent event) {
        
        final Stage primaryStage = (Stage)root.getScene().getWindow();
        WIDTH.setCurrentValue(primaryStage.getScene().getWidth());
        HEIGHT.setCurrentValue(primaryStage.getScene().getHeight());
        
        final Showable menuGUI = new MenuGUI(primaryStage);
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.show();
    }
    
    private void setText() {
        board_description.setWrapText(true);
        board_description.setText("the game table is divided is 4 main-zone :\n"
                + "on the left - there is the 'info-zone' this zone display the information about the curret 'mana' the player posses and the current life of the player and of the enemy end turn button\n"
                + "on the center - there is the 'board-zone' this zone show the player and the enemy field and the card placed on it. the cards on the row on the top are the enemy's card\n"
                + "on the right - there is the 'card-detail-zone' this zone will display more detail of a card if you click on it\n"
                + "on the botton - there is the 'hand-zone' this zone show the card in the player hand\n");
        
        victory_condition.setWrapText(true);
        victory_condition.setText("the scope of the game is inflict damage to the AI until it's life reach: "+GameMaster.MIN_PLAYER_LIFE+"\n"
                + "the life is a balance. if you inflict damage to the AI you will steal it's life.\n");
        
        game_phases.setWrapText(true);
        game_phases.setText("the game is exectially divided in 3 phase: drawPhase mainPhase battlePhase\n" 
                +"on the start on your turn the draw-phase is automatically done, than you are in the mainphase until you click the battlephase button\n"
                +"the AI always play the first turn before you\n");
        
        draw_phase.setWrapText(true);
        draw_phase.setText("on the draw phase you will automatically draw a card\n"
                +"the maximum mana will increase by one, util it reach"+GameMaster.MAXIMUM_MANA+"\n"
                +"the your mana will be restore to the value of the current maximun mana\n");
        
        main_phase.setWrapText(true);
        main_phase.setText("On the main phase you can click on a card for select it. Then click on an empty cell for place it\n"
                +"you can place it only if you have enough");
        
        battle_phase.setWrapText(true);
        battle_phase.setText("when you press the end turn button, each card attack the card in the cell in front of it\n"
                +"the there is no card infront of it, it will steal the life of the other player\n");
        
        effects.setWrapText(true);
        effects.setText("Some cards have effects, if you click on a card you can see the datail of the card and the description of the effects");
    }
    
    private void  setImages() {
        
        board_description_image.setStyle(" "
                + "-fx-background-image:url('image/rules/board_description.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        board_description_image.setMinSize(ViewState.WIDTH.getValue()*0.4, ViewState.HEIGHT.getValue()*0.5);
    
        victory_condition_image.setStyle(" "
                + "-fx-background-image:url('image/rules/victory-condition.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        victory_condition_image.setMinSize(ViewState.WIDTH.getValue()*0.4, ViewState.HEIGHT.getValue()*0.5);
        
        game_phases_image.setStyle(" "
                + "-fx-background-image:url('image/rules/phase_sequence.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        game_phases_image.setMinSize(ViewState.WIDTH.getValue()*0.4, ViewState.HEIGHT.getValue()*0.5);
        
        draw_phase_image.setStyle(" "
                + "-fx-background-image:url('image/rules/mana-refil.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        draw_phase_image.setMinSize(ViewState.WIDTH.getValue()*0.4, ViewState.HEIGHT.getValue()*0.5);
        
        main_phase_image.setStyle(" "
                + "-fx-background-image:url('image/rules/mana-refil.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        draw_phase_image.setMinSize(ViewState.WIDTH.getValue()*0.4, ViewState.HEIGHT.getValue()*0.5);
        
        main_phase_image.setStyle(" "
                + "-fx-background-image:url('image/rules/mainPhase.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        main_phase_image.setMinSize(ViewState.WIDTH.getValue()*0.5, ViewState.HEIGHT.getValue()*0.8);
        
        battle_phase_image.setStyle(" "
                + "-fx-background-image:url('image/rules/end-turn-button.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        battle_phase_image.setMinSize(ViewState.WIDTH.getValue()*0.3, ViewState.HEIGHT.getValue()*0.5);
        
        effects_image.setStyle(" "
                + "-fx-background-image:url('image/rules/card-description.png'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        effects_image.setMinSize(ViewState.WIDTH.getValue()*0.3, ViewState.HEIGHT.getValue()*0.5);
        
        
        
    }
    

}
