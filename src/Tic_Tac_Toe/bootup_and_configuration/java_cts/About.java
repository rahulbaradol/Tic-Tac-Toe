package Tic_Tac_Toe.bootup_and_configuration.java_cts;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class About implements Initializable {

    @FXML
    private StackPane about;

    @FXML
    private JFXButton back;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        about.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), about);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void keyBoard_Functioning(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case BACK_SPACE:
                back();
                break;
        }
    }

    public void back() {
        back.setDisable(true);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), about);
        ft.setFromValue(1);
        ft.setToValue(0);

        ft.setOnFinished(event -> {
            try {
                Stage stage = (Stage) back.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tic_Tac_Toe/bootup_and_configuration/fxml_files/Menu.fxml"));

                Scene sc = new Scene(loader.load());
                sc.getStylesheets().setAll("/Tic_Tac_Toe/stylesheets/stylesheet.css");

                stage.setTitle("Tic Tac Toe - Menu");
                stage.setScene(sc);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ft.play();
    }

}