package personal_budgeting_system;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for the "Define New Account" page in the Personal Budgeting System.
 * Handles user input, including account name, opening balance, and opening date, 
 * as well as navigation between the home page and the new account page.
 */
public class DefineAccountController {

    // Text field for inputting the account name
    @FXML
    private TextField accountNameField;

    // Text field for inputting the opening balance
    @FXML
    private TextField openingBalanceField;

    // Date picker for selecting the opening date
    @FXML
    private DatePicker openingDateField;

    // Button to navigate back to the home page
    @FXML
    private Button backButton;

    // Button to save the account information
    @FXML
    private Button saveButton;

    /**
     * Initializes the DefineAccountController by setting up the action listeners 
     * for the back and save buttons. This method is automatically called after the 
     * FXML elements have been injected.
     */
    @FXML
    public void initialize() {
        // Action for the back button to return to the home page
        backButton.setOnAction(event -> {
            try {
                // Load the home page FXML file and set it as the scene
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal_budgeting_system/home.fxml"));
                Stage stage = (Stage) backButton.getScene().getWindow();
                Scene scene = new Scene(loader.load(), 400, 300);
                stage.setTitle("Home Page");  // Return back to the home page
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Action for the save button to print the entered account information
        saveButton.setOnAction(event -> {
            // Save action: print the entered account details to the console
            System.out.println("Account Name: " + accountNameField.getText());
            System.out.println("Opening Balance: " + openingBalanceField.getText());
            System.out.println("Opening Date: " + openingDateField.getValue());
        });
    }
}
