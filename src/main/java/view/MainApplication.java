package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import static view.Music.MENU_THEME;

/**
 * JavaFX entry point, it launches the main menu
 */
public class MainApplication extends Application {

    /**
     * Initializes menu theme and sets all graphics components of main menu
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        
        Music.init();
        MENU_THEME.startMusic();
        MENU_THEME.loopMusic();
        
        
        final Showable menuGUI = new MenuGUI(primaryStage);
        
        primaryStage.setScene(menuGUI.getScene());
        primaryStage.getScene().getStylesheets().add("application.css");
        primaryStage.setOnCloseRequest((e) -> {
            Platform.exit();
        });
        
        primaryStage.show();
        
    }

}
