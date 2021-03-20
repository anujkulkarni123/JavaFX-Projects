package TennisBallGames;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddScoreController implements Initializable {
    @FXML
    ComboBox<String> scoreComboBox;

    @FXML
    TextField homeScore;

    @FXML
    TextField visitorScore;

    @FXML
    Button cancelButton;

    final ObservableList<String> data = FXCollections.observableArrayList();

    private MatchesAdapter matchesAdapter;
    private TeamsAdapter teamsAdapter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scoreComboBox.setItems(data);
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private void displayAlert(String msg) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image(getClass().getResourceAsStream("WesternLogo.png")));
            controller.setAlertText(msg);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    public void setModel(MatchesAdapter match, TeamsAdapter team) {
        matchesAdapter = match;
        teamsAdapter = team;
        buildComboBoxData();
    }

    public void buildComboBoxData() {
        try {
            data.addAll(matchesAdapter.getMatchesNamesList());
        } catch (SQLException ex) {
            displayAlert(ex.getMessage());
        }
    }
    @FXML
    public void save() {
        try {
            String matchSelection = scoreComboBox.getValue();

            int num = Integer.parseInt(matchSelection.split("-")[0].strip());
            String home = matchSelection.split("-")[1].strip();
            String visitor = matchSelection.split("-")[2].strip();

            int hScore = Integer.parseInt(homeScore.getText());
            int vScore = Integer.parseInt(visitorScore.getText());

            teamsAdapter.setStatus(home, visitor, hScore, vScore);
            matchesAdapter.setTeamsScore(num, hScore, vScore);

            Stage s = (Stage) cancelButton.getScene().getWindow();
            s.close();

        } catch (Exception e) {
            displayAlert(e.getMessage());
        }
    }
}

