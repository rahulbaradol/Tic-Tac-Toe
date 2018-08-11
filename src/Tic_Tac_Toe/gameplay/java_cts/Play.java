package Tic_Tac_Toe.gameplay.java_cts;

import com.sun.istack.internal.Nullable;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Play implements Initializable {

    @FXML
    private StackPane play;

    @FXML
    private Label turn, matchDescription;

    @FXML
    private Label xPoint, oPoint;

    @FXML
    private GridPane pane;

    @FXML
    private Label pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8, pos9;

    private static boolean x, o;
    private static boolean p1, p2, p3, p4, p5, p6, p7, p8, p9;
    private static int xPoints, oPoints;

    static {
        x = true;
        o = false;

        xPoints = 0;
        oPoints = 0;

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

        xPoint.setText("X -> " + xPoints);
        oPoint.setText(oPoints + " <- O");

        FadeTransition ft = new FadeTransition(Duration.seconds(2), play);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    // Says whose turn it is
    private void setTurn(String whoseTurn) {
        turn.setText("Turn -> " + whoseTurn);
        matchDescriptor_And_FlowManager("match started", null);
    }

    // Checks whether the moves done by users has lead to the winning condition or not
    private void matchWon() {
        if ((pos1.getText().equals("X") && pos2.getText().equals("X") && pos3.getText().equals("X")) | (pos1.getText().equals("O") && pos2.getText().equals("O") && pos3.getText().equals("O"))) {
            if (pos1.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos1.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("horizontal upper");
        } else if ((pos7.getText().equals("X") && pos8.getText().equals("X") && pos9.getText().equals("X")) | (pos7.getText().equals("O") && pos8.getText().equals("O") && pos9.getText().equals("O"))) {
            if (pos7.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos7.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("horizontal lower");
        } else if ((pos3.getText().equals("X") && pos6.getText().equals("X") && pos9.getText().equals("X")) | (pos3.getText().equals("O") && pos6.getText().equals("O") && pos9.getText().equals("O"))) {
            if (pos3.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos3.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("vertical right");
        } else if ((pos1.getText().equals("X") && pos4.getText().equals("X") && pos7.getText().equals("X")) | (pos1.getText().equals("O") && pos4.getText().equals("O") && pos7.getText().equals("O"))) {
            if (pos1.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos1.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("vertical left");
        } else if ((pos2.getText().equals("X") && pos5.getText().equals("X") && pos8.getText().equals("X")) | (pos2.getText().equals("O") && pos5.getText().equals("O") && pos8.getText().equals("O"))) {
            if (pos2.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos2.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("vertical center");
        } else if ((pos4.getText().equals("X") && pos5.getText().equals("X") && pos6.getText().equals("X")) | (pos4.getText().equals("O") && pos5.getText().equals("O") && pos6.getText().equals("O"))) {
            if (pos4.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos4.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("horizontal center");
        } else if ((pos1.getText().equals("X") && pos5.getText().equals("X") && pos9.getText().equals("X")) | (pos1.getText().equals("O") && pos5.getText().equals("O") && pos9.getText().equals("O"))) {
            if (pos1.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos1.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("diagonal right");
        } else if ((pos3.getText().equals("X") && pos5.getText().equals("X") && pos7.getText().equals("X")) | (pos3.getText().equals("O") && pos5.getText().equals("O") && pos7.getText().equals("O"))) {
            if (pos3.getText().equals("X")) {
                matchDescriptor_And_FlowManager("won", "X");
            } else if (pos3.getText().equals("O")) {
                matchDescriptor_And_FlowManager("won", "O");
            }

            showWinner_Outline("diagonal left");
        } else if (!pos1.getText().equals("") && !pos2.getText().equals("") && !pos3.getText().equals("") && !pos4.getText().equals("") &&
                !pos5.getText().equals("") && !pos6.getText().equals("") && !pos7.getText().equals("") && !pos8.getText().equals("") && !pos9.getText().equals("")) {

            pane.setDisable(true);
            matchDescriptor_And_FlowManager("draw", null);
        }
    }

    // Decides what to display match description
    private void matchDescriptor_And_FlowManager(String what, @Nullable String whoWon) {
        switch (what) {
            case "won":
                if (whoWon.equals("X")) {
                    matchDescription.setText("Match Description -> Winner is " + whoWon + "! 1 point to X!");
                    setPoints("X");
                } else if (whoWon.equals("O")) {
                    matchDescription.setText("Match Description -> Winner is " + whoWon + "! 1 point to O!");
                    setPoints("O");
                }

                turn.setText("Match Over!");
                break;

            case "draw":
                turn.setText("Match Over!");
                matchDescription.setText("Match Description -> No one won! It is Draw!");
                break;

            case "match started":
                matchDescription.setText("Match Description -> Match is going on...");
                break;

            case "reset":
                matchDescription.setText("Match Description -> Still not yet started.");
                break;
        }
    }

    // Shows who is the winner
    private void showWinner_Outline(String whatToDisable) {
        switch (whatToDisable) {
            case "horizontal upper":
                pos4.setDisable(true);
                pos5.setDisable(true);
                pos6.setDisable(true);
                pos7.setDisable(true);
                pos8.setDisable(true);
                pos9.setDisable(true);
                break;

            case "horizontal lower":
                pos1.setDisable(true);
                pos2.setDisable(true);
                pos3.setDisable(true);
                pos4.setDisable(true);
                pos5.setDisable(true);
                pos6.setDisable(true);
                break;

            case "vertical right":
                pos1.setDisable(true);
                pos2.setDisable(true);
                pos4.setDisable(true);
                pos5.setDisable(true);
                pos7.setDisable(true);
                pos8.setDisable(true);
                break;

            case "vertical left":
                pos2.setDisable(true);
                pos3.setDisable(true);
                pos5.setDisable(true);
                pos6.setDisable(true);
                pos8.setDisable(true);
                pos9.setDisable(true);
                break;
            case "horizontal center":
                pos1.setDisable(true);
                pos2.setDisable(true);
                pos3.setDisable(true);
                pos7.setDisable(true);
                pos8.setDisable(true);
                pos9.setDisable(true);
                break;

            case "vertical center":
                pos1.setDisable(true);
                pos3.setDisable(true);
                pos4.setDisable(true);
                pos6.setDisable(true);
                pos7.setDisable(true);
                pos9.setDisable(true);
                break;

            case "diagonal left":
                pos1.setDisable(true);
                pos2.setDisable(true);
                pos4.setDisable(true);
                pos6.setDisable(true);
                pos8.setDisable(true);
                pos9.setDisable(true);
                break;

            case "diagonal right":
                pos2.setDisable(true);
                pos3.setDisable(true);
                pos4.setDisable(true);
                pos6.setDisable(true);
                pos7.setDisable(true);
                pos8.setDisable(true);
                break;
        }
    }

    // Set the points
    private void setPoints(String toWhom) {
        if (toWhom.equals("X")) {
            xPoints++;
            xPoint.setText("X -> " + xPoints);

            if (xPoints == 10) {
                Alert gift = new Alert(Alert.AlertType.INFORMATION);
                gift.setTitle("Tic Tac Toe");
                gift.setHeaderText(null);
                gift.setContentText("Congratulations X! You have reached 10 points!!\nNow you can continue playing if you want!!");
                gift.showAndWait();
            }
        } else if (toWhom.equals("O")) {
            oPoints++;
            oPoint.setText(oPoints + " <- O");

            if (oPoints == 10) {
                Alert gift = new Alert(Alert.AlertType.INFORMATION);
                gift.setTitle("Tic Tac Toe");
                gift.setHeaderText(null);
                gift.setContentText("Congratulations O! You have reached 10 points!!\nNow you can continue playing if you want!!");
                gift.showAndWait();
            }
        }
    }

    // Shows the Board Status (or loads BoardStatus.fxml file)
    public void showBoardStatus() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tic_Tac_Toe/gameplay/fxml_files/BoardStatus.fxml"));
            Scene sc = new Scene(loader.load());

            stage.setTitle("Tic Tac Toe - Board Status");
            stage.setScene(sc);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Allows to use the keyboard for easy use of quick toggles or buttons available on the board
    public void keyBoard_Functioning(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case R:
                reset();
                break;

            case B:
                showBoardStatus();
                break;

            case BACK_SPACE:
                back();
                break;

            case ESCAPE:
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
                break;
        }
    }

    // Resets everything
    public void reset() {
        Alert reset = new Alert(Alert.AlertType.CONFIRMATION);
        reset.setTitle("Tic Tac Toe");
        reset.setHeaderText(null);
        reset.setContentText("Are you sure, you want to reset?");

        ButtonType resetCurrentState = new ButtonType("Reset Current State");
        ButtonType resetEverything = new ButtonType("Reset Everything");
        ButtonType no = new ButtonType("No");
        reset.getButtonTypes().setAll(resetCurrentState, resetEverything, no);

        Optional<ButtonType> confirmation = reset.showAndWait();

        if ((confirmation.get() == resetCurrentState) | (confirmation.get() == resetEverything)) {
            x = true;
            o = false;

            if (confirmation.get() == resetEverything) {
                xPoints = 0;
                oPoints = 0;

                xPoint.setText("X -> " + xPoints);
                oPoint.setText(oPoints + " <- O");
            }

            p1 = false;
            p2 = false;
            p3 = false;
            p4 = false;
            p5 = false;
            p6 = false;
            p7 = false;
            p8 = false;
            p9 = false;

            pane.setDisable(false);

            pos1.setDisable(false);
            pos2.setDisable(false);
            pos3.setDisable(false);
            pos4.setDisable(false);
            pos5.setDisable(false);
            pos6.setDisable(false);
            pos7.setDisable(false);
            pos8.setDisable(false);
            pos9.setDisable(false);

            pos1.setText("");
            pos2.setText("");
            pos3.setText("");
            pos4.setText("");
            pos5.setText("");
            pos6.setText("");
            pos7.setText("");
            pos8.setText("");
            pos9.setText("");

            setTurn("X");
            matchDescriptor_And_FlowManager("reset", null);
        } else {
            // Nothing happens here
        }
    }

    // Takes back to Choose Game Mode Scene
    public void back() {
        Alert back = new Alert(Alert.AlertType.CONFIRMATION);
        back.setTitle("Tic Tac Toe");
        back.setHeaderText(null);
        back.setContentText("Are you sure, you want to leave the game and go back?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");
        back.getButtonTypes().setAll(yes, no);

        Optional<ButtonType> confirmation = back.showAndWait();

        if (confirmation.get() == yes) {
            play.setDisable(true);

            FadeTransition ft = new FadeTransition(Duration.seconds(2), play);
            ft.setFromValue(1);
            ft.setToValue(0);

            ft.setOnFinished(event -> {
                try {
                    Stage stage = (Stage) play.getScene().getWindow();
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
        } else {
            // Nothing happens here
        }
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