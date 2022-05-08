package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import shared.Player;

public class BalanceOfLifeGrafic {
    
    private Player player;
    private Player AI;
    
    public BalanceOfLifeGrafic(Player player, Player AI) {
        this.player = player;
        this.AI = AI;
    }
    
    private String getBalanceURL() {
        if(player.getLifePoints()>AI.getLifePoints()) {
            return "Balance-icon-left-heavy.png";
        } else if (player.getLifePoints()<AI.getLifePoints()) {
            return "Balance-icon-right-heavy.png";
        } else {
            return "Balance-icon-equity.png";
        }
    }
    
    public HBox generateBalanceOfLife() {
        final HBox balance = new HBox();
        final Pane imageBalace = new Pane();
        
        final Label playerLife= new Label(""+this.player.getLifePoints());
        playerLife.setStyle("-fx-text-fill: white;");
        final Label AILife= new Label(""+this.AI.getLifePoints());
        AILife.setStyle("-fx-text-fill: white;");
        
        imageBalace.setStyle(" "
                + "-fx-background-image:url('"+getBalanceURL()+"'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        // imageCard.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()/1.90, ViewState.CARD_WIDTH.getValue()/2.2 ,0 ,ViewState.CARD_WIDTH.getValue()/2.2));
        imageBalace.setPadding(new Insets( ViewState.WIDTH.getMinValue()*0.055));
        
        balance.getChildren().add(playerLife);
        balance.getChildren().add(imageBalace);
        balance.getChildren().add(AILife);
        
        
        return balance;
        
    }
}
