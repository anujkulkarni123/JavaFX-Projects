package iPublisher;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddAuthorController
{
    @FXML
    Button cancelBtn;
    @FXML
    Button saveBtn;
    @FXML
    TextField authorName;
    @FXML
    TextField authorID;

    private AuthorAdapter authorAdapter;

    public void setModel(AuthorAdapter author) {
        authorAdapter = author;
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void save() {
        try {
            int id = Integer.parseInt(authorID.getText());
            authorAdapter.insertAuthor(authorName.getText(), id);
        } catch (SQLException ex) {
            //displayAlert("ERROR: " + ex.getMessage());
        }

        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
