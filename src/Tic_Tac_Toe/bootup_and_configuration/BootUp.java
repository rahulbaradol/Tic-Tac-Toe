package Tic_Tac_Toe.bootup_and_configuration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class BootUp extends Application {

    /**
     * @author Rahul Baradol
     * @since 4/8/2018
     */

    @Override // Starts the application/game
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tic_Tac_Toe/bootup_and_configuration/fxml_files/Welcome.fxml"));

        Scene sc = new Scene(loader.load());
        sc.getStylesheets().setAll("/Tic_Tac_Toe/stylesheets/stylesheet.css");

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(sc);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override // Gives a prompt saying bye, which, you know, the message that it will say is in the line 37
    public void stop() {
        Alert bye = new Alert(Alert.AlertType.INFORMATION);
        bye.setTitle("Tic Tac Toe");
        bye.setHeaderText(null);
        bye.setContentText("THANKS for using Tic Tac Toe!!\nGood bye. See you soon.");
        bye.showAndWait();
    }

    // Responsible for activating or calling the start(). In other words, simply executing the application/game
    public static void main(String[] args) {
        launch(args);
    }
}