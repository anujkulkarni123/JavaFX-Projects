package SampleHandler;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SampleHandlerController {
    @FXML
    private Label jumpingLabel;
    @FXML
    private void movingLabel(){
        Random randomPos = new Random();
        jumpingLabel.setLayoutX(randomPos.nextInt(500));
        jumpingLabel.setLayoutY(randomPos.nextInt(300));
    }
}
