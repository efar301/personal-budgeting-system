package personal_budgeting_system;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Controller class for the "Define New Account" page in the Personal Budgeting System.
 * Handles user input, including account name, opening balance, and opening date, 
 * as well as navigation between the home page and the new account page.
 */
public class DefineAccountController {

    @FXML
    private TextField accountNameField;

    @FXML
    private TextField openingBalanceField;

    @FXML
    private DatePicker openingDateField;

    @FXML
    private Button backButton;

    @FXML
    private Button saveButton;

    private static final HashSet<String> accountNames = new HashSet<>();

    
  
    @FXML
    public void initialize() {
        backButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal_budgeting_system/home.fxml"));
                Stage stage = (Stage) backButton.getScene().getWindow();
                Scene scene = new Scene(loader.load(), 750, 750);
                stage.setTitle("Home Page");  
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        saveButton.setOnAction(event -> {
            //save action
            System.out.println("Account Name: " + accountNameField.getText());
            System.out.println("Opening Balance: " + openingBalanceField.getText());
            System.out.println("Opening Date: " + openingDateField.getValue());
        });

        openingDateField.setValue(LocalDate.now());

        openingBalanceField.addEventFilter(KeyEvent.KEY_TYPED, this::validateDoubleInput);
    }
    
     @FXML
    private void onSave(ActionEvent event) {
        String accountName = accountNameField.getText().trim();
        String balanceText = openingBalanceField.getText().trim();
        LocalDate openingDate = openingDateField.getValue();

        //required fields
        if (accountName.isEmpty() || balanceText.isEmpty() || openingDate == null) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields are required.");
            return;
        }

        //Validate the balance input
        try {
            double openingBalance = Double.parseDouble(balanceText);
            if (openingBalance < 0) {
                showAlert(Alert.AlertType.ERROR, "Validation Error", "Opening balance cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid balance. Please enter a valid number.");
            return;
        }

        //check for duplicate account names
        if (accountNames.contains(accountName)) {
            showAlert(Alert.AlertType.ERROR, "Duplicate Account", "Account name already exists.");
            return;
        }

        //save the account details
        accountNames.add(accountName);  // Add to HashSet to prevent future duplicates
        showAlert(Alert.AlertType.INFORMATION, "Success", "Account saved successfully.");

        clearFields();
    }

    @FXML
    private void onBack(ActionEvent event) {
        System.out.println("Back button pressed");
    }

    private void clearFields() {
        accountNameField.clear();
        openingBalanceField.clear();
        openingDateField.setValue(LocalDate.now());
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void validateDoubleInput(KeyEvent event) {
        String input = event.getCharacter();
        if (!input.matches("\\d|\\.") || (input.equals(".") && openingBalanceField.getText().contains("."))) {
            event.consume();  //ignore invalid input
        }
    }
}
