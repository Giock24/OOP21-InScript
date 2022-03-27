/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package main.application;


import javafx.application.Application;

/** Main application entry-point. */

public final class App {
    private App() { }

    public static void main(final String[] args) {
        Application.launch(JavaFXAppWithFXML.class, args);
        // The following line raises: Error: class it.unibo.samplejavafx.App is not a subclass of javafx.application.Application
        // JavaFXApp.launch(args);
        // While the following would do just fine:
        // JavaFXApp.run(args)
    }
}