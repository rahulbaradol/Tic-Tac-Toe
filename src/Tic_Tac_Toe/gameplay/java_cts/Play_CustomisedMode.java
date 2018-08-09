package Tic_Tac_Toe.gameplay.java_cts;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Play_CustomisedMode implements Initializable {

    @FXML
    private StackPane play_CustomisedMode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        play_CustomisedMode.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), play_CustomisedMode);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

}