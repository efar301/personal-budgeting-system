package personal_budgeting_system;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

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
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
