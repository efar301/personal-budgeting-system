package personal_budgeting_system;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main application class for the Personal Budgeting System.
 * This class launches the home page of the application using JavaFX.
 */
public class App extends Application {

    /**
     * The start method is the entry point for the JavaFX application.
     * It sets up the initial stage (window) and loads the home page (home.fxml).
     *
     * @param primaryStage The primary stage for this application, onto which
     *                     the scene is set.
     * @throws IOException If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the home.fxml file to set up the home page UI
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/personal_budgeting_system/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);

        // Set the title for the primary stage (window)
        primaryStage.setTitle("Home Page");  // Home Page title only for the first page
        primaryStage.setScene(scene);
        primaryStage.show();  // Display the stage
    }

    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application by calling the launch() method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch();  // Launch the JavaFX application
    }
}