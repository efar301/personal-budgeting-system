module personal_budgeting_system {
    requires javafx.controls;
    requires javafx.fxml;

    opens personal_budgeting_system to javafx.fxml;
    exports personal_budgeting_system;
}
