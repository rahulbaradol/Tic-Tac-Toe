package Tic_Tac_Toe.gameplay.java_cts;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Play implements Initializable {

    @FXML
    private StackPane play;

    @FXML
    private Label turn, matchDescription;

    @FXML
    private GridPane pane;

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
        turn.setText(turn.getText() + " X");
        matchDescription.setText("Match Description -> Still not yet started.");

        FadeTransition ft = new FadeTransition(Duration.seconds(2), play);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    // Says whose turn it is
    private void setTurn(String whoseTurn) {
        turn.setText("Turn -> " + whoseTurn);
    }

    private void matchWon() {
        if ((pos1.getText().equals("X") && pos2.getText().equals("X") && pos3.getText().equals("X")) | (pos1.getText().equals("O") && pos2.getText().equals("O") && pos3.getText().equals("O"))) {
            if (pos1.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos1.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos7.getText().equals("X") && pos8.getText().equals("X") && pos9.getText().equals("X")) | (pos7.getText().equals("O") && pos8.getText().equals("O") && pos9.getText().equals("O"))) {
            if (pos7.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos7.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos3.getText().equals("X") && pos6.getText().equals("X") && pos9.getText().equals("X")) | (pos3.getText().equals("O") && pos6.getText().equals("O") && pos9.getText().equals("O"))) {
            if (pos3.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos3.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos1.getText().equals("X") && pos4.getText().equals("X") && pos7.getText().equals("X")) | (pos1.getText().equals("O") && pos4.getText().equals("O") && pos7.getText().equals("O"))) {
            if (pos1.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos1.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos2.getText().equals("X") && pos5.getText().equals("X") && pos8.getText().equals("X")) | (pos2.getText().equals("O") && pos5.getText().equals("O") && pos8.getText().equals("O"))) {
            if (pos2.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos2.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos4.getText().equals("X") && pos5.getText().equals("X") && pos6.getText().equals("X")) | (pos4.getText().equals("O") && pos5.getText().equals("O") && pos6.getText().equals("O"))) {
            if (pos4.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos4.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos1.getText().equals("X") && pos5.getText().equals("X") && pos9.getText().equals("X")) | (pos1.getText().equals("O") && pos5.getText().equals("O") && pos9.getText().equals("O"))) {
            if (pos1.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos1.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        } else if ((pos3.getText().equals("X") && pos5.getText().equals("X") && pos7.getText().equals("X")) | (pos3.getText().equals("O") && pos5.getText().equals("O") && pos7.getText().equals("O"))) {
            if (pos3.getText().equals("X")) {
                matchDescriptor("won", "X");
            } else if (pos3.getText().equals("O")) {
                matchDescriptor("won", "O");
            }
        }
    }

    private void matchDescriptor(String what, String whoWon) {
        if (what.equals("won")) {
            if (whoWon.equals("X")) {
                pane.setDisable(true);
                matchDescription.setText("Match Description -> Finished! Winner is " + whoWon + "!");
            } else if (whoWon.equals("O")) {
                pane.setDisable(true);
                matchDescription.setText("Match Description -> Finished! Winner is " + whoWon + "!");
            }
        }
    }

    private void matchStarted_And_MatchEnded(String matchDes) {

    }

    // Prints the letter in the board based on the position
    public void p1Click() {
        if (!p1) {
            if (x && !o) {
                pos1.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos1.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p1 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p2Click() {
        if (!p2) {
            if (x && !o) {
                pos2.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos2.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p2 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p3Click() {
        if (!p3) {
            if (x && !o) {
                pos3.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos3.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p3 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p4Click() {
        if (!p4) {
            if (x && !o) {
                pos4.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos4.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p4 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p5Click() {
        if (!p5) {
            if (x && !o) {
                pos5.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos5.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p5 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p6Click() {
        if (!p6) {
            if (x && !o) {
                pos6.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos6.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p6 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p7Click() {
        if (!p7) {
            if (x && !o) {
                pos7.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos7.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p7 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p8Click() {
        if (!p8) {
            if (x && !o) {
                pos8.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos8.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p8 = true;
        }
    }

    // Prints the letter in the board based on the position
    public void p9Click() {
        if (!p9) {
            if (x && !o) {
                pos9.setText("X");

                x = false;
                o = true;

                setTurn("O");
                matchWon();
            } else if (!x && o) {
                pos9.setText("O");

                x = true;
                o = false;

                setTurn("X");
                matchWon();
            }

            p9 = true;
        }
    }

}