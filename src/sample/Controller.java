package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Controller {

    // import Labels from the panel.fxml file so we can edit those.
    @FXML
    private Label HOME_FOULS;
    @FXML
    private Label AWAY_FOULS;
    @FXML
    private Label HOME_TIMEOUTS;
    @FXML
    private Label AWAY_TIMEOUTS;
    @FXML
    private Label SCORE;
    @FXML
    private Label HOME_PLAYER_1_FOULS;
    @FXML
    private Label HOME_PLAYER_1_RED_FOUL;
    @FXML
    private Label HOME_PLAYER_1_POINTS;
    @FXML
    private Label AWAY_PLAYER_1_POINTS;
    @FXML
    private Label AWAY_PLAYER_1_FOULS;
    @FXML
    private Label AWAY_PLAYER_1_RED_FOUL;
    @FXML
    private Label TIME;
    @FXML
    private Label PERIOD;

    //creating instances so we can access to our Game class
    private Team home = new Team("hupi-ukot");
    private Team away = new Team("hupi-akat");
    private Board board = new Board(home, away);
    private Game GameTool = new Game(board);

    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(100);
    private boolean isStarted = false;
    private boolean homeFoulsBusy = false;
    private boolean awayFoulsBusy = false;
    private boolean isTimeoutAlready = false;

    /**
     * Listens keyboard and launches correct method.
     *
     * @param event KEYEVENT: Typing on the keyboard.
     * @throws InterruptedException
     */
    public void KeyboardListener(KeyEvent event) throws InterruptedException {
        switch (event.getCode()) {
            case T:
                HOME_1_POINT();
                break;
            case Y:
                HOME_2_POINTS();
                break;
            case U:
                HOME_3_POINTS();
                break;
            case I:
                if (!homeFoulsBusy) {
                    homeFoulsBusy = true;
                    HOME_FOUL();
                }
                break;
            case O:
                if (!isTimeoutAlready) {
                    System.out.println("huhuu");
                    HOME_TIMEOUT();
                }
                break;
            case G:
                AWAY_1_POINT();
                break;
            case H:
                AWAY_2_POINTS();
                break;
            case J:
                AWAY_3_POINTS();
                break;
            case K:
                if (!awayFoulsBusy) {
                    awayFoulsBusy = true;
                    AWAY_FOUL();
                }
                break;
            case L:
                if (!isTimeoutAlready) {
                    isTimeoutAlready = true;
                    AWAY_TIMEOUT();
                }
                break;
            case SPACE:
                if (!isStarted) {
                    START();
                    isStarted = true;
                } else {
                    PAUSE();
                }
                break;
            default:
        }
    }

    /**
     * Increases home team's score by 1 and adds one point to maker.
     */
    public void HOME_1_POINT() {
        score_calculations(1, true, HOME_PLAYER_1_POINTS);
    }

    /**
     * Increases home team's score by 2 and adds one point to maker.
     */
    public void HOME_2_POINTS() {
        score_calculations(2, true, HOME_PLAYER_1_POINTS);
    }

    /**
     * Increases home team's score by 3 and adds one point to maker.
     */
    public void HOME_3_POINTS() {
        score_calculations(3, true, HOME_PLAYER_1_POINTS);
    }

    /**
     * Increases away team's score by 1 and adds one point to maker.
     */
    public void AWAY_1_POINT() {
        score_calculations(1, false, AWAY_PLAYER_1_POINTS);
    }

    /**
     * Increases away team's score by 2 and adds one point to maker.
     */
    public void AWAY_2_POINTS() {
        score_calculations(2, false, AWAY_PLAYER_1_POINTS);
    }

    /**
     * Increases away team's score by 3 and adds one point to maker.
     */
    public void AWAY_3_POINTS() {
        score_calculations(3, false, AWAY_PLAYER_1_POINTS);
    }

    /**
     * Adds or Substracs X amount of points from the selected team and player.
     *
     * @param points            INT: How many points to add. Add negative numbers to substract.
     * @param isHome            BOOLEAN: Is the selected team home or away
     * @param X_PLAYER_Y_POINTS LABEL: Select right Label to be manipulated.
     */
    private void score_calculations(int points, boolean isHome, Label X_PLAYER_Y_POINTS) {
        String[] scores = SCORE.getText().split("-", 5);
        if (isHome) {
            int homeScore = Integer.parseInt(scores[0]);
            SCORE.setText((homeScore + points) + "-" + scores[1]);
        } else {
            int awayScore = Integer.parseInt(scores[1]);
            SCORE.setText(scores[0] + "-" + (awayScore + points));
        }
        int PlayerScore = Integer.parseInt(X_PLAYER_Y_POINTS.getText());
        PlayerScore = PlayerScore + points;
        X_PLAYER_Y_POINTS.setText(Integer.toString(PlayerScore));
    }

    /**
     * Adds one foul to home team's fouls if limit is not yet met. Also adds one foul to player.
     */
    public void HOME_FOUL() {
        foul_calculations(GameTool.getMaxTeamFouls(), true, HOME_PLAYER_1_FOULS, HOME_PLAYER_1_RED_FOUL);
    }

    /**
     * Adds one foul to away team's fouls if limit is not yet met. Also adds one foul to player.
     */
    public void AWAY_FOUL() {
        foul_calculations(GameTool.getMaxTeamFouls(), false, AWAY_PLAYER_1_FOULS, AWAY_PLAYER_1_RED_FOUL);
    }

    /**
     * Does adding and (substracting)*(not eat!) of team fouls and marking players with fouls.
     *
     * @param maxFouls            INT: How many team fouls can be at maximum.
     * @param isHome              BOOLEAN: Is team home team or not?
     * @param X_PLAYER_Y_FOULS    LABEL: Link to correct players yellow fouls.
     * @param X_PLAYER_Y_RED_FOUL LABEL: Link to correct players red foul.
     */
    public void foul_calculations(int maxFouls, boolean isHome, Label X_PLAYER_Y_FOULS, Label X_PLAYER_Y_RED_FOUL) {
        int tmp;
        if (isHome) {
            tmp = Integer.parseInt(HOME_FOULS.getText()) + 1;
        } else {
            tmp = Integer.parseInt(AWAY_FOULS.getText()) + 1;
        }
        if (tmp < maxFouls + 1) {
            if (isHome) {
                HOME_FOULS.setText(Integer.toString(tmp));
            } else {
                AWAY_FOULS.setText(Integer.toString(tmp));
            }
        }
        if (X_PLAYER_Y_FOULS.getText().length() < 4) {
            yellow_foul_set(X_PLAYER_Y_FOULS, isHome);
        } else if (X_PLAYER_Y_FOULS.getText().length() == 4 && X_PLAYER_Y_RED_FOUL.getText().length() < 1) {
            red_foul_set(X_PLAYER_Y_RED_FOUL, isHome);
        }
    }

    /**
     * Adds one red foul to selected player and blinks that foul for 5 seconds.
     *
     * @param X_PLAYER_Y_RED_FOUL LABEL: Link to players red foul.
     */
    private void red_foul_set(Label X_PLAYER_Y_RED_FOUL, boolean isHome) {
        add_personal_foul(X_PLAYER_Y_RED_FOUL);
        Timeline timelineblinkred = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            blinkRed(X_PLAYER_Y_RED_FOUL);
        }));
        timelineblinkred.setCycleCount(10);
        timelineblinkred.playFromStart();
        timelineblinkred.setOnFinished(e -> {
            if (isHome) {
                homeFoulsBusy = false;
            } else {
                awayFoulsBusy = false;
            }
        });
    }

    /**
     * Adds one yellow foul to selected player and blinks that foul for 5 seconds.
     *
     * @param X_PLAYER_Y_FOULS LABEL: Link to players yellow fouls.
     */
    private void yellow_foul_set(Label X_PLAYER_Y_FOULS, boolean isHome) {
        add_personal_foul(X_PLAYER_Y_FOULS);
        int tmpFouls = X_PLAYER_Y_FOULS.getText().length();
        Timeline timelineblinkyellow = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            blinkYellow(tmpFouls, X_PLAYER_Y_FOULS);
        }));
        timelineblinkyellow.setCycleCount(10);
        timelineblinkyellow.playFromStart();
        timelineblinkyellow.setOnFinished(e -> {
            if (isHome) {
                homeFoulsBusy = false;
            } else {
                awayFoulsBusy = false;
            }
        });
    }

    /**
     * Adds one ● to selected player fouls.
     *
     * @param HOME_PLAYER_X_FOULS_OR_RED_FOUL LABEL: Link to correct players fouls.
     */
    private void add_personal_foul(Label HOME_PLAYER_X_FOULS_OR_RED_FOUL) {
        String foul = "●";
        HOME_PLAYER_X_FOULS_OR_RED_FOUL.setText(HOME_PLAYER_X_FOULS_OR_RED_FOUL.getText() + foul);
    }

    /**
     * Substracts one ● to selected player fouls.
     *
     * @param HOME_PLAYER_X_FOULS_OR_RED_FOUL LABEL: Link to correct players fouls.
     */
    private void substract_personal_foul(Label HOME_PLAYER_X_FOULS_OR_RED_FOUL) {
        int last = (HOME_PLAYER_X_FOULS_OR_RED_FOUL.getText().length() - 1);
        HOME_PLAYER_X_FOULS_OR_RED_FOUL.setText(HOME_PLAYER_X_FOULS_OR_RED_FOUL.getText().toString().substring(0, last));
    }

    /**
     * Does the red foul blinking.
     *
     * @param X_PLAYER_Y_RED_FOUL LABEL: Link to correct players fouls.
     */
    private void blinkRed(Label X_PLAYER_Y_RED_FOUL) {
        if (1 == X_PLAYER_Y_RED_FOUL.getText().length()) {
            substract_personal_foul(X_PLAYER_Y_RED_FOUL);
        } else {
            add_personal_foul(X_PLAYER_Y_RED_FOUL);
        }
    }

    /**
     * Does the yellow foul blinking.
     *
     * @param correctFouls     INT: How many current fouls shoud be at selected player.
     * @param X_PLAYER_Y_FOULS LABEL: Link to correct players fouls.
     */
    private void blinkYellow(int correctFouls, Label X_PLAYER_Y_FOULS) {
        if (correctFouls == X_PLAYER_Y_FOULS.getText().length()) {
            substract_personal_foul(X_PLAYER_Y_FOULS);
        } else {
            add_personal_foul(X_PLAYER_Y_FOULS);
        }
    }

    /*
    Pauses or continues any clock running.
     */
    public void PAUSE() {
        if ("RUNNING".equals(timeline.getStatus().toString())) {
            timeline.pause();
        } else {
            timeline.play();
        }
    }

    /**
     * Starts and creates the clock instance.
     */
    public void START() {
        if (!isStarted) {
            TIME.textProperty().bind(Bindings.format("%02d:%02d", timeSeconds.divide(60), timeSeconds.subtract(timeSeconds.divide(60).multiply(60))));
        }
        time_label_calculations();
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(timeSeconds.intValue()),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        timeline_ending_checks();
    }

    /**
     * Checks if timeouts or team fouls should be reset. Also sets next timePeriod to start manually if wanted.
     */
    private void timeline_ending_checks() {
        timeline.setOnFinished(e -> {
            if (GameTool.getResetTimeouts()) {
                resetTimeous();
            }
            if (GameTool.getResetTeamFouls()) {
                resetTeamFouls();
            }
            GameTool.nextTimePeriod();
            time_label_calculations();
            START();
            if (GameTool.getIsManual()) {
                PAUSE();
            }
        });
    }

    /**
     * Sets Labels PERIOD and TIME to the correct values.
     */
    private void time_label_calculations() {
        timeSeconds.setValue(GameTool.getTimePeriodSeconds());
        PERIOD.setText(GameTool.getLabel());
    }

    /**
     * Starts home team's timeout instantly.
     */
    public void HOME_TIMEOUT() {
        timeout_calculations(true);
    }

    /**
     * Starts away team's timeout instantly.
     */
    public void AWAY_TIMEOUT() {
        timeout_calculations(false);
    }

    /**
     * Adds timeout marker and initiates timeout if its correct to do so.
     *
     * @param isHome BOOLEAN: Is team home or not.
     */
    private void timeout_calculations(boolean isHome) {
        String tmp = "●";
        int count;
        if (isHome) {
            count = HOME_TIMEOUTS.getText().length();
        } else {
            count = AWAY_TIMEOUTS.getText().length();
        }
        if (count < GameTool.getMaxTimeouts()) {
            if (isHome) {
                HOME_TIMEOUTS.setText(HOME_TIMEOUTS.getText() + tmp);
            } else {
                AWAY_TIMEOUTS.setText(AWAY_TIMEOUTS.getText() + tmp);
            }
            GameTool.setTmpDuration(timeline.getCurrentTime());
            start_timeout();
        }
    }

    /**
     * Creates new timeline for timeout and starts running it.
     */
    public void start_timeout() {
        isTimeoutAlready = true;
        timeSeconds.setValue(GameTool.getTimeoutTime());
        PERIOD.setText("TIMEOUT");
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(timeSeconds.intValue()),
                        new KeyValue(timeSeconds, 0)));

        timeline.playFromStart();
        timeline.setOnFinished(e -> {
            timeSeconds.setValue(GameTool.getTimePeriodSeconds() - GameTool.getTmpDuration().toSeconds());
            PERIOD.setText(GameTool.getLabel());
            timeline_ending_checks();
            isTimeoutAlready = false;
        });
    }

    /**
     * Reset both teams fouls.
     */
    private void resetTeamFouls() {
        HOME_FOULS.setText("0");
        AWAY_FOULS.setText("0");
    }

    /**
     * Reset both teams timeouts.
     */
    private void resetTimeous() {
        AWAY_TIMEOUTS.setText("");
        HOME_TIMEOUTS.setText("");
    }
}