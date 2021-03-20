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
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddMatchController implements Initializable {

    //Declaring Comboboxes
    @FXML
    ComboBox<String> homeTeamComboBox;
    @FXML
    ComboBox<String> visitorTeamComboBox;
    @FXML
    Button cancelButton;

    //initializing data variables used for comboboxes
    final ObservableList<String> data = FXCollections.observableArrayList();
    //Referencing models inside controllers
    private MatchesAdapter matchesAdapter;
    private TeamsAdapter teamsAdapter;

    public void setModel(MatchesAdapter match, TeamsAdapter team)   {
        matchesAdapter = match;
        teamsAdapter = team;
        buildComboBoxData();
    }
    //Get
    public void buildComboBoxData() {
        try{
            data.addAll(teamsAdapter.getTeamsNames());
        } catch (SQLException exception)    {
            displayAlert("Error" + exception.getMessage());
        }
    }
    //method for cancel button
    @FXML
    public void cancel()    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    //method for save button
    public void save()  {
        try {
            matchesAdapter.insertMatch(matchesAdapter.getMax(), homeTeamComboBox.getValue(), visitorTeamComboBox.getValue());
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            displayAlert(e.getMessage());
        }
    }
    //
    private void displayAlert(String err) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alert.fxml"));
            Parent ERROR = loader.load();
            AlertController controller = (AlertController) loader.getController();

            Scene scene = new Scene(ERROR);
            Stage stage = new Stage();
            stage.setScene(scene);

            stage.getIcons().add(new Image(getClass().getResourceAsStream("WesternLogo.png")));
            controller.setAlertText(err);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        } catch (IOException ex1) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homeTeamComboBox.setItems(data);
        visitorTeamComboBox.setItems(data);
    }
}
