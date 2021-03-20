package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddPublisherUnitController implements Initializable
{
    @FXML
    Button cancelBtn;
    @FXML
    Button saveBtn;
    @FXML
    TextField publisherName;
    @FXML
    TextField addressName;
    @FXML
    TextField ID;


    private PublisherUnitAdapter publisherUnitAdapter;

    public void setModel(PublisherUnitAdapter unit) {
        publisherUnitAdapter = unit;
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save() {
        try {
            int id = Integer.parseInt(ID.getText());
            publisherUnitAdapter.insertPublisherUnit(publisherName.getText(), addressName.getText(), id);
        } catch (SQLException ex) {
            //displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO
    }

}
