package iPublisher;

import iPublisher.TitleAdaptor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddTitleController
{
    @FXML
    Button cancelBtn;
    @FXML
    Button saveBtn;
    @FXML
    TextField titleName;
    @FXML
    TextField titleID;

    private TitleAdaptor titleAdaptor;

    public void setModel(TitleAdaptor title) {
        titleAdaptor = title;
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save() {
        try {
            int titleId = Integer.parseInt(titleID.getText());
            titleAdaptor.insertTitle(titleName.getText(), titleId);
        } catch (SQLException ex) {
            //displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
