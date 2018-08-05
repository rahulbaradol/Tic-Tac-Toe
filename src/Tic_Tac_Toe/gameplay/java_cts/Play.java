package Tic_Tac_Toe.gameplay.java_cts;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Play implements Initializable {

    @FXML
    private StackPane play;

    @FXML
    private Label pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9;

    private static boolean x, o;
    private static boolean p1, p2, p3, p4, p5, p6, p7, p8, p9;

    static {
        x = true;
        o = false;

        p1 = false;
        p2 = false;
        p3 = false;
        p4 = false;
        p5 = false;
        p6 = false;
        p7 = false;
        p8 = false;
        p9 = false;
    }

    @Override // Initializes the game
    public void initialize(URL location, ResourceBundle resources) {
        play.setOpacity(0);

        FadeTransition ft = new FadeTransition(Duration.seconds(2), play);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    public void p1Click() {
        if (!p1) {
            if (x && !o) {
                pos1.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos1.setText("O");

                x = true;
                o = false;
            }

            p1 = true;
        }
    }

    public void p2Click() {
        if (!p2) {
            if (x && !o) {
                pos2.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos2.setText("O");

                x = true;
                o = false;
            }

            p2 = true;
        }
    }

    public void p3Click() {
        if (!p3) {
            if (x && !o) {
                pos3.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos3.setText("O");

                x = true;
                o = false;
            }

            p3 = true;
        }
    }

    public void p4Click() {
        if (!p4) {
            if (x && !o) {
                pos4.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos4.setText("O");

                x = true;
                o = false;
            }

            p4 = true;
        }
    }

    public void p5Click() {
        if (!p5) {
            if (x && !o) {
                pos5.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos5.setText("O");

                x = true;
                o = false;
            }

            p5 = true;
        }
    }

    public void p6Click() {
        if (!p6) {
            if (x && !o) {
                pos6.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos6.setText("O");

                x = true;
                o = false;
            }

            p6 = true;
        }
    }

    public void p7Click() {
        if (!p7) {
            if (x && !o) {
                pos7.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos7.setText("O");

                x = true;
                o = false;
            }

            p7 = true;
        }
    }

    public void p8Click() {
        if (!p8) {
            if (x && !o) {
                pos8.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos8.setText("O");

                x = true;
                o = false;
            }

            p8 = true;
        }
    }

    public void p9Click() {
        if (!p9) {
            if (x && !o) {
                pos9.setText("X");

                x = false;
                o = true;
            } else if (!x && o) {
                pos9.setText("O");

                x = true;
                o = false;
            }

            p9 = true;
        }
    }

}