package personal_budgeting_system;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import java.time.LocalDate;
import java.util.HashSet;

public class DefineAccountController {

    @FXML
    private TextField accountNameField;

    @FXML
    private TextField openingBalanceField;

    @FXML
    private DatePicker openingDateField;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    private static final HashSet<String> accountNames = new HashSet<>();

    @FXML
    public void initialize() {
        // opening date to the current date by default
        openingDateField.setValue(LocalDate.now());

        openingBalanceField.addEventFilter(KeyEvent.KEY_TYPED, this::validateDoubleInput);
    }

    @FXML
    private void onSave(ActionEvent event) {
        String accountName = accountNameField.getText().trim();
        String balanceText = openingBalanceField.getText().trim();
        LocalDate openingDate = openingDateField.getValue();

        // required fields
        if (accountName.isEmpty() || balanceText.isEmpty() || openingDate == null) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields are required.");
            return;
        }

        //Validate balance input
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

        // Check duplicate account names
        if (accountNames.contains(accountName)) {
            showAlert(Alert.AlertType.ERROR, "Duplicate Account", "Account name already exists.");
            return;
        }

        // Save the account details
        accountNames.add(accountName);  //prevent future duplicates
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

    //allow only numeric input with one decimal point
    private void validateDoubleInput(KeyEvent event) {
        String input = event.getCharacter();
        if (!input.matches("\\d|\\.") || (input.equals(".") && openingBalanceField.getText().contains("."))) {
            event.consume();  //ignore invalid input
        }
    }
}
