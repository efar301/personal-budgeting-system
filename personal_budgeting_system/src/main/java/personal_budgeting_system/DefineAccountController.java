package personal_budgeting_system;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class DefineAccountController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        backButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal_budgeting_system/home.fxml"));
                Stage stage = (Stage) backButton.getScene().getWindow();
                Scene scene = new Scene(loader.load(), 400, 300);
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void printAccountInfo() {
        System.out.println("Name: " + nameField.getText());
        System.out.println("Email: " + emailField.getText());
        System.out.println("Password: " + passwordField.getText());
    }
}
