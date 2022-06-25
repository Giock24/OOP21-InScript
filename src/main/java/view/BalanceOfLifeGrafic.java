package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import shared.Player;

public class BalanceOfLifeGrafic {
    
    private final Player player;
    private final Player aI;
    
    public BalanceOfLifeGrafic(final Player player, final  Player aI) {
        this.player = player;
        this.aI = aI;
    }
    
    /**
     * this method calculate which image of the balance should be placed
     * 
     * @return is the path of an image
     */
    private String getBalanceURL() {
        if(player.getLifePoints()>aI.getLifePoints()) {
            return "image/Balance-icon-left-heavy.png";
        } else if (player.getLifePoints()<aI.getLifePoints()) {
            return "image/Balance-icon-right-heavy.png";
        } else {
            return "image/Balance-icon-equity.png";
        }
    }
    
    /**
     * this method generate the grafic of the "Balance of life"
     * @return the grafic of the "Balance of life" is an Hbox
     */
    public HBox generateBalanceOfLife() {
        final HBox balance = new HBox();
        final Pane imageBalace = new Pane();
        
        final Label playerLife= new Label(" "+this.player.getLifePoints());
        playerLife.setStyle("-fx-text-fill: white;");
        final Label aILife= new Label(" "+this.aI.getLifePoints());
        aILife.setStyle("-fx-text-fill: white;");
        
        imageBalace.setStyle(" "
                + "-fx-background-image:url('"+getBalanceURL()+"'); "
                + "-fx-background-repeat: no-repeat;\n"
                + "-fx-background-size: contain;\n"
                + "-fx-background-size: 100% 100%;");
        // imageCard.setPadding(new Insets(ViewState.CARD_HEIGHT.getValue()/1.90, ViewState.CARD_WIDTH.getValue()/2.2 ,0 ,ViewState.CARD_WIDTH.getValue()/2.2));
        imageBalace.setPadding(new Insets( ViewState.WIDTH.getMinValue()*0.055));
        
        balance.getChildren().add(playerLife);
        balance.getChildren().add(imageBalace);
        balance.getChildren().add(aILife);
        
        
        return balance;
        
    }
}
