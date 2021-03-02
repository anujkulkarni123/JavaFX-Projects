package IPublisher;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Application {

    Scene AboutUs;

    public void start(Stage primaryStage) throws Exception{
        //declaring images using resourceasstream methods
        Image westernLogo = new Image(getClass().getResourceAsStream("WesternLogo.png"));
        Image backgroundImage = new Image(getClass().getResourceAsStream("WesternBackground.png"));

        //creating a menu
        Menu menu = new Menu("File");
        Menu menu1 = new Menu("Generate Report");
        Menu menu2 = new Menu("Maintain Revenue Report");
        Menu menu3 = new Menu("Perform Review");
        Menu menu4 = new Menu("About");

        //creating menuitems
        MenuItem menuItem1 = new MenuItem("Close");
        MenuItem menuItem2 = new MenuItem("Semi Annual Review");
        MenuItem menuItem3 = new MenuItem("Annual Review");
        MenuItem menuItem4 = new MenuItem("About Us");

        //adding items to menu bar
        menu.getItems().add(menuItem1);
        menu3.getItems().add(menuItem2);
        menu3.getItems().add(menuItem3);
        menu4.getItems().add(menuItem4);

        //creating menubar
        MenuBar menuBar = new MenuBar();

        //add menus to menubar
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        menuBar.getMenus().add(menu4);


        //setting onaction of "Close" menu item to close program
        menuItem1.setOnAction((ActionEvent actionEvent1) -> {
            System.exit(0);
        });


        //setting onAction of "About us" menu item to create new scene
        menuItem4.setOnAction((ActionEvent actionEvent2) -> {
           //created entire new stage, references it's own fxml and controller classes.
           //I used try because of the possible errors with the load() method.
           try{
               FXMLLoader fxmlLoader = new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("AboutUs.fxml"));
               AboutUs = new Scene(fxmlLoader.load(), 300, 300);
               Stage AboutUsStage = new Stage();
               AboutUsStage.setTitle("About Us");
               AboutUsStage.setScene(AboutUs);
               AboutUsStage.show();
               AboutUsStage.getIcons().add(westernLogo);
           } catch (IOException e) {
               Logger logger = Logger.getLogger(getClass().getName());
               logger.log(Level.SEVERE, "Failed to create new Window.", e);
           }

        });





        //creating vbox
        VBox vb = new VBox(menuBar);

        //declaring scene background image
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //declaring background and assigning a background image to it
        Background background = new Background(backgroundImg);

        //setting background
        vb.setBackground(background);

        //basic scene information
        Parent root = FXMLLoader.load(getClass().getResource("IPublisher.fxml"));
        primaryStage.setTitle("iPublisher");
        //adding logo to the title
        primaryStage.getIcons().add(westernLogo);
        primaryStage.setScene(new Scene(vb, 1300, 725));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
