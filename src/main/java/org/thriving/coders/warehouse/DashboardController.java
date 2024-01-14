package org.thriving.coders.warehouse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button add_items;

    @FXML
    private Button out_items;

    @FXML
    private Button go_scan_item_barcode;

    @FXML
    private TextField input_item_barcode;

    @FXML
    private TableView<Item> items_table_view;

    @FXML
    private TableColumn<Item, Integer> item_id;

    @FXML
    private TableColumn<Item, String> item_barcode;

    @FXML
    private TableColumn<Item, String> item_name;

    @FXML
    private TableColumn<Item, String> item_category;

    @FXML
    private AnchorPane item_scan_barcode;

    @FXML
    private TextField item_search;

    @FXML
    private Button logout;

    private ObservableList<Item> items;

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
                // TODO logout with session destroy + backup for goods
                logout.getScene().getWindow().hide();

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

    public ObservableList<Item> addItem() {

        ObservableList<Item> items = FXCollections.observableArrayList();

        items.add(new Item(2952516, "4607943497865", "Яйцо куриное с3 (с/п) (охлажденное, 90)", "Продукты питания (folder)/Яйцо куриное" ));
        items.add(new Item(2952518, "4607943497902", "Яйцо куриное св /20шт/ (с/п) (охлажденное, 90)", "Продукты питания (folder)/Яйцо куриное"));

        return items;
    }

    public void showItems() {
        items = addItem();

        item_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        item_barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        item_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        item_category.setCellValueFactory(new PropertyValueFactory<>("category"));

        items_table_view.setItems(items);
    }


    public void switchForm(ActionEvent event) {

        if(event.getSource() == add_items) {
            // TODO get form add items to warehouse
        } else if (event.getSource() == out_items) {
            // TODO get form out items from warehouse
        }
    }

    public void displayItems() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showItems();
    }
}
