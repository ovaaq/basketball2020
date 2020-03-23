/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author joonass
 */
public class DisplayController implements Initializable {

    @FXML
    private Label CLOCK;
    @FXML
    private Label HOME_POS;
    @FXML
    private Label AWAY_POS;
    @FXML
    private VBox SCENE;
    @FXML
    PosClock n = new PosClock();
    private String currentTeam = "Home";
    private long currentTime = 24000;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        SCENE.onKeyPressedProperty().set(new EventHandler<KeyEvent>() {

            /**
             * Handles key events
             */
            
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Q:
                        n.pause();
                        break;
                    case A:
                        n.changeTime(1);
                        break;
                    case S:
                        n.changeTime(5);
                        break;
                    case D:
                        n.changeTime(10);
                        break;
                    case Z:
                        n.changeTime(-1);
                        break;
                    case X:
                        n.changeTime(-5);
                        break;
                    case C:
                        n.changeTime(-10);
                        break;
                    case W:
                        n.resume();
                        break;
                    case E:
                        n.swapTeam(currentTeam);
                        break;
                    case R:
                        n.timer(currentTeam, currentTime, CLOCK, HOME_POS, AWAY_POS);
                        break;
                    case H:
                        currentTeam = "Home";
                        break;
                    case J:
                        currentTeam = "Away";
                        break;
                    case N:
                        currentTime = n.changeAttackTime(currentTime);

                    default:
                }

            }
        });

        System.out.println(":D");

    }

    public void setLabelText(String text) {
        System.out.println("FXMLDocumentController.setLabelText(): Called");
        CLOCK.setText(text);
    }

}
