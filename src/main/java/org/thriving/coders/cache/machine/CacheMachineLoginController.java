package org.thriving.coders.cache.machine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CacheMachineLoginController {

    @FXML
    private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    public void loginEmployee() throws IOException {
        Alert alert;
        if (username.getText().isEmpty() || username.getText().isBlank() || password.getText().isEmpty() || password.getText().isBlank()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.show();
        } else {
            // TODO: connect to database please to check username and password
            if(username.getText().equals("admin") && password.getText().equals("admin123")){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Login");

                loginBtn.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("cache-machine-dashboard.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                alert.show();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong Username/Password");
                alert.show();
            }
        }


    }


    public void close() {
        System.exit(0);
    }
}