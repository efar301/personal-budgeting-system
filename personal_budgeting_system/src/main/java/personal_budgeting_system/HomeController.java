package personal_budgeting_system;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button openAccountPageButton;

    @FXML
    public void initialize() {
        openAccountPageButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/personal_budgeting_system/define_account.fxml"));
                Stage stage = (Stage) openAccountPageButton.getScene().getWindow();
                Scene scene = new Scene(loader.load(), 400, 300);
                stage.setTitle("Define New Account");  // Correct title for the second page
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}