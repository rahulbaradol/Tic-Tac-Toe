package Tic_Tac_Toe.bootup_and_configuration.java_cts;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    @FXML
    private StackPane menu;

    @Override // Initializes the application/game
    public void initialize(URL location, ResourceBundle resources) {
        menu.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), menu);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    // Loads the scene which you can start playing game
    public void play() {
        menu.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), menu);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) menu.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tic_Tac_Toe/gameplay/fxml_files/Play.fxml"));

                Scene sc = new Scene(loader.load());
                sc.getStylesheets().setAll("/Tic_Tac_Toe/stylesheets/stylesheet.css");

                stage.setTitle("Tic Tac Toe");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });

        ft.play();
    }

    // Loads the scene which says about itself
    public void about() {
        menu.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), menu);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) menu.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tic_Tac_Toe/bootup_and_configuration/fxml_files/About.fxml"));

                Scene sc = new Scene(loader.load());
                sc.getStylesheets().setAll("/Tic_Tac_Toe/stylesheets/stylesheet.css");

                stage.setTitle("Tic Tac Toe - About");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ft.play();
    }

    // Allows to use the keyboard for the functions to perform
    public void keyBoardFunctioning(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case P:
                play();
                break;

            case F1:
                about();
                break;

            case ESCAPE:
                exit();
                break;
        }
    }

    // Are you sure, you want to exit? If yes, closes the entire application/game
    public void exit() {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);
        exit.setTitle("Tic Tac Toe");
        exit.setHeaderText(null);
        exit.setContentText("Are you sure, you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");
        exit.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> confirmation = exit.showAndWait();

        if (confirmation.get() == yes) {
            System.exit(0);
        } else {
            // Nothing happens here
        }
    }

}