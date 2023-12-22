package org.thriving.coders.warehouse;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button go_scan_item_barcode;

    @FXML
    private TextField input_item_barcode;

    @FXML
    private TableColumn<?, ?> item_barcode;

    @FXML
    private TableColumn<?, ?> item_category;

    @FXML
    private TableColumn<?, ?> item_id;

    @FXML
    private TableColumn<?, ?> item_name;

    @FXML
    private AnchorPane item_scan_barcode;

    @FXML
    private TextField item_search;

    @FXML
    private Button logout;

    private double x = 0;
    private double y = 0;

    public void close() {
        System.exit(0);
    }

    public void logout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();

        try {
            if (option.get().equals(ButtonType.OK)){

                logout.getScene().getWindow().hide();
// new FXMLLoader(Application.class.getResource("login.fxml"));
                Parent root = new FXMLLoader(DashboardController.class.getResource("login.fxml")).load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

                root.setOnMousePressed((MouseEvent event) ->{
                    x = event.getX();
                    y = event.getY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> stage.setOpacity(1));
            }
        } catch (Exception e){

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
