package Tic_Tac_Toe.bootup_and_configuration.java_cts;

import com.jfoenix.controls.JFXRadioButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseGameMode implements Initializable {

    @FXML
    private StackPane chooseMode;

    @FXML
    private JFXRadioButton normalMode, customisedMode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseMode.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), chooseMode);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void proceed() {
        if (normalMode.isSelected() && !customisedMode.isSelected()) {
            chooseMode.setDisable(true);

            FadeTransition ft = new FadeTransition(Duration.seconds(2), chooseMode);
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event -> {
                try {
                    Stage stage = (Stage) chooseMode.getScene().getWindow();
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
        } else if (!normalMode.isSelected() && customisedMode.isSelected()) {
            System.out.println("Yeah!!");
        }
    }

    public void back() {
        chooseMode.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), chooseMode);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) chooseMode.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tic_Tac_Toe/bootup_and_configuration/fxml_files/Menu.fxml"));

                Scene sc = new Scene(loader.load());
                sc.getStylesheets().setAll("/Tic_Tac_Toe/stylesheets/stylesheet.css");

                stage.setTitle("Tic Tac Toe - Menu");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });

        ft.play();
    }

}