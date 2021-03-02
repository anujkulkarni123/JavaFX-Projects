package IPublisher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutUsController  {

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    public void handleCLoseButtonAction()  {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


}
