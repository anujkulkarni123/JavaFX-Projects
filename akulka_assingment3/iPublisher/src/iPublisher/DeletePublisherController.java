package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeletePublisherController implements Initializable
{
    @FXML
    Button cancelBtn;
    @FXML
    Button updateBtn;
    @FXML
    Button deleteBtn;
    @FXML
    ComboBox<String> publisherName;
    @FXML
    TextField updateName;
    @FXML
    TextField updateAddress;

    final ObservableList<String> data = FXCollections.observableArrayList();

    private PublisherUnitAdapter publisherUnitAdapter;

    public void setModel(PublisherUnitAdapter publisher) {
        publisherUnitAdapter = publisher;
        buildComboBoxData();
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void update() {
        try {
            int idNum = Integer.parseInt(publisherName.getValue().substring(0,1));
            String name = updateName.getText();
            String address = updateAddress.getText();
            publisherUnitAdapter.updatePublisherUnit(idNum, name, address);

        } catch (SQLException ex) {
            //displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        publisherName.setItems(data);
    }

    public void buildComboBoxData() {
        try {
            data.addAll(publisherUnitAdapter.getPublisherUnitList());
        } catch (SQLException ex) {

        }
    }

}
