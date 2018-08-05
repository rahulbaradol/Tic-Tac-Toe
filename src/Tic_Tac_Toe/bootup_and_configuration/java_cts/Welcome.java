package Tic_Tac_Toe.bootup_and_configuration.java_cts;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Welcome implements Initializable {

    @FXML
    private StackPane welcome;

    @FXML
    private Label clickDescription;

    private boolean clicked = false;

    @Override // Initializes the scene before calling it
    public void initialize(URL location, ResourceBundle resources) {
        welcome.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), welcome);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

        zoomDescriptionOutside();
    }

    // Makes the label to shrink inside
    private void zoomDescriptionInside() {
        RotateTransition rt_1 = new RotateTransition(Duration.seconds(1), clickDescription);
        ScaleTransition st_1 = new ScaleTransition(Duration.seconds(1), clickDescription);
        ParallelTransition pt = new ParallelTransition(rt_1, st_1);

        rt_1.setToAngle(-20);
        st_1.setToX(1);
        st_1.setToY(1);

        pt.setOnFinished(event -> zoomDescriptionOutside());

        pt.play();
    }

    // Makes the label to shrink outside
    private void zoomDescriptionOutside() {
        RotateTransition rt_1 = new RotateTransition(Duration.seconds(1), clickDescription);
        ScaleTransition st_1 = new ScaleTransition(Duration.seconds(1), clickDescription);
        ParallelTransition pt_1 = new ParallelTransition(rt_1, st_1);

        rt_1.setToAngle(360);
        st_1.setToX(1.3);
        st_1.setToY(1.3);

        pt_1.setOnFinished(event -> zoomDescriptionInside());

        pt_1.play();
    }


    // Makes the controls in the scene invisible and loads the load next scene
    public void proceed() {
        if (!clicked) {
            FadeTransition ft = new FadeTransition(Duration.seconds(2), welcome);
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event -> {
                try {
                    Stage stage = (Stage) welcome.getScene().getWindow();
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

            clicked = true;
        }
    }

}