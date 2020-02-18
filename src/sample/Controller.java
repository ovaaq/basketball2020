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

import java.util.LinkedList;

public class Controller {

    // import Labels from the panel.fxml file so we can edit those.
    @FXML
    private Label HOME_FOULS, HOME_TIMEOUTS;
    @FXML
    private Label AWAY_FOULS, AWAY_TIMEOUTS;
    @FXML
    private Label SCORE, TIME, PERIOD;
    @FXML
    private Label HOME_PLAYER_1_FOULS, HOME_PLAYER_2_FOULS, HOME_PLAYER_3_FOULS, HOME_PLAYER_4_FOULS, HOME_PLAYER_5_FOULS, HOME_PLAYER_6_FOULS, HOME_PLAYER_7_FOULS
            , HOME_PLAYER_8_FOULS, HOME_PLAYER_9_FOULS, HOME_PLAYER_10_FOULS, HOME_PLAYER_11_FOULS, HOME_PLAYER_12_FOULS;
    @FXML
    private Label HOME_PLAYER_1_RED_FOUL, HOME_PLAYER_2_RED_FOUL, HOME_PLAYER_3_RED_FOUL, HOME_PLAYER_4_RED_FOUL, HOME_PLAYER_5_RED_FOUL, HOME_PLAYER_6_RED_FOUL
            , HOME_PLAYER_7_RED_FOUL, HOME_PLAYER_8_RED_FOUL, HOME_PLAYER_9_RED_FOUL, HOME_PLAYER_10_RED_FOUL, HOME_PLAYER_11_RED_FOUL, HOME_PLAYER_12_RED_FOUL;
    @FXML
    private Label HOME_PLAYER_1_POINTS, HOME_PLAYER_2_POINTS, HOME_PLAYER_3_POINTS, HOME_PLAYER_4_POINTS, HOME_PLAYER_5_POINTS, HOME_PLAYER_6_POINTS
            , HOME_PLAYER_7_POINTS, HOME_PLAYER_8_POINTS, HOME_PLAYER_9_POINTS, HOME_PLAYER_10_POINTS, HOME_PLAYER_11_POINTS, HOME_PLAYER_12_POINTS;
    @FXML
    private Label HOME_PLAYER_1_NAME, HOME_PLAYER_2_NAME, HOME_PLAYER_3_NAME, HOME_PLAYER_4_NAME, HOME_PLAYER_5_NAME, HOME_PLAYER_6_NAME
            , HOME_PLAYER_7_NAME, HOME_PLAYER_8_NAME, HOME_PLAYER_9_NAME, HOME_PLAYER_10_NAME, HOME_PLAYER_11_NAME, HOME_PLAYER_12_NAME;
    @FXML
    private Label HOME_PLAYER_1_NUMBER, HOME_PLAYER_2_NUMBER, HOME_PLAYER_3_NUMBER, HOME_PLAYER_4_NUMBER, HOME_PLAYER_5_NUMBER, HOME_PLAYER_6_NUMBER
            , HOME_PLAYER_7_NUMBER, HOME_PLAYER_8_NUMBER, HOME_PLAYER_9_NUMBER, HOME_PLAYER_10_NUMBER, HOME_PLAYER_11_NUMBER, HOME_PLAYER_12_NUMBER;
    @FXML
    private Label AWAY_PLAYER_1_POINTS, AWAY_PLAYER_2_POINTS, AWAY_PLAYER_3_POINTS, AWAY_PLAYER_4_POINTS, AWAY_PLAYER_5_POINTS, AWAY_PLAYER_6_POINTS
            , AWAY_PLAYER_7_POINTS, AWAY_PLAYER_8_POINTS, AWAY_PLAYER_9_POINTS, AWAY_PLAYER_10_POINTS, AWAY_PLAYER_11_POINTS, AWAY_PLAYER_12_POINTS;
    @FXML
    private Label AWAY_PLAYER_1_FOULS, AWAY_PLAYER_2_FOULS, AWAY_PLAYER_3_FOULS, AWAY_PLAYER_4_FOULS, AWAY_PLAYER_5_FOULS, AWAY_PLAYER_6_FOULS
            , AWAY_PLAYER_7_FOULS, AWAY_PLAYER_8_FOULS, AWAY_PLAYER_9_FOULS, AWAY_PLAYER_10_FOULS, AWAY_PLAYER_11_FOULS, AWAY_PLAYER_12_FOULS;
    @FXML
    private Label AWAY_PLAYER_1_RED_FOUL, AWAY_PLAYER_2_RED_FOUL, AWAY_PLAYER_3_RED_FOUL, AWAY_PLAYER_4_RED_FOUL, AWAY_PLAYER_5_RED_FOUL, AWAY_PLAYER_6_RED_FOUL
            , AWAY_PLAYER_7_RED_FOUL, AWAY_PLAYER_8_RED_FOUL, AWAY_PLAYER_9_RED_FOUL, AWAY_PLAYER_10_RED_FOUL, AWAY_PLAYER_11_RED_FOUL, AWAY_PLAYER_12_RED_FOUL;
    @FXML
    private Label AWAY_PLAYER_1_NAME, AWAY_PLAYER_2_NAME, AWAY_PLAYER_3_NAME, AWAY_PLAYER_4_NAME, AWAY_PLAYER_5_NAME, AWAY_PLAYER_6_NAME
            , AWAY_PLAYER_7_NAME, AWAY_PLAYER_8_NAME, AWAY_PLAYER_9_NAME, AWAY_PLAYER_10_NAME, AWAY_PLAYER_11_NAME, AWAY_PLAYER_12_NAME;
    @FXML
    private Label AWAY_PLAYER_1_NUMBER, AWAY_PLAYER_2_NUMBER, AWAY_PLAYER_3_NUMBER, AWAY_PLAYER_4_NUMBER, AWAY_PLAYER_5_NUMBER, AWAY_PLAYER_6_NUMBER
            , AWAY_PLAYER_7_NUMBER, AWAY_PLAYER_8_NUMBER, AWAY_PLAYER_9_NUMBER, AWAY_PLAYER_10_NUMBER, AWAY_PLAYER_11_NUMBER, AWAY_PLAYER_12_NUMBER;


    private LinkedList<Label[]> home_player_list = new LinkedList<>();
    private LinkedList<Label[]> away_player_list = new LinkedList<>();

    Label[] hp1 = new Label[]{HOME_PLAYER_1_NUMBER, HOME_PLAYER_1_NAME, HOME_PLAYER_1_POINTS, HOME_PLAYER_1_FOULS, HOME_PLAYER_1_RED_FOUL};
    Label[] hp2 = new Label[]{HOME_PLAYER_2_NUMBER, HOME_PLAYER_2_NAME, HOME_PLAYER_2_POINTS, HOME_PLAYER_2_FOULS, HOME_PLAYER_2_RED_FOUL};
    Label[] hp3 = new Label[]{HOME_PLAYER_3_NUMBER, HOME_PLAYER_3_NAME, HOME_PLAYER_3_POINTS, HOME_PLAYER_3_FOULS, HOME_PLAYER_3_RED_FOUL};
    Label[] hp4 = new Label[]{HOME_PLAYER_4_NUMBER, HOME_PLAYER_4_NAME, HOME_PLAYER_4_POINTS, HOME_PLAYER_4_FOULS, HOME_PLAYER_4_RED_FOUL};
    Label[] hp5 = new Label[]{HOME_PLAYER_5_NUMBER, HOME_PLAYER_5_NAME, HOME_PLAYER_5_POINTS, HOME_PLAYER_5_FOULS, HOME_PLAYER_5_RED_FOUL};
    Label[] hp6 = new Label[]{HOME_PLAYER_6_NUMBER, HOME_PLAYER_6_NAME, HOME_PLAYER_6_POINTS, HOME_PLAYER_6_FOULS, HOME_PLAYER_6_RED_FOUL};
    Label[] hp7 = new Label[]{HOME_PLAYER_7_NUMBER, HOME_PLAYER_7_NAME, HOME_PLAYER_7_POINTS, HOME_PLAYER_7_FOULS, HOME_PLAYER_7_RED_FOUL};
    Label[] hp8 = new Label[]{HOME_PLAYER_8_NUMBER, HOME_PLAYER_8_NAME, HOME_PLAYER_8_POINTS, HOME_PLAYER_8_FOULS, HOME_PLAYER_8_RED_FOUL};
    Label[] hp9 = new Label[]{HOME_PLAYER_9_NUMBER, HOME_PLAYER_9_NAME, HOME_PLAYER_9_POINTS, HOME_PLAYER_9_FOULS, HOME_PLAYER_9_RED_FOUL};
    Label[] hp10 = new Label[]{HOME_PLAYER_10_NUMBER, HOME_PLAYER_10_NAME, HOME_PLAYER_10_POINTS, HOME_PLAYER_10_FOULS, HOME_PLAYER_10_RED_FOUL};
    Label[] hp11 = new Label[]{HOME_PLAYER_11_NUMBER, HOME_PLAYER_11_NAME, HOME_PLAYER_11_POINTS, HOME_PLAYER_11_FOULS, HOME_PLAYER_11_RED_FOUL};
    Label[] hp12 = new Label[]{HOME_PLAYER_12_NUMBER, HOME_PLAYER_12_NAME, HOME_PLAYER_12_POINTS, HOME_PLAYER_12_FOULS, HOME_PLAYER_12_RED_FOUL};

    Label[] ap1 = new Label[]{AWAY_PLAYER_1_NUMBER, AWAY_PLAYER_1_NAME, AWAY_PLAYER_1_POINTS, AWAY_PLAYER_1_FOULS, AWAY_PLAYER_1_RED_FOUL};
    Label[] ap2 = new Label[]{AWAY_PLAYER_2_NUMBER, AWAY_PLAYER_2_NAME, AWAY_PLAYER_2_POINTS, AWAY_PLAYER_2_FOULS, AWAY_PLAYER_2_RED_FOUL};
    Label[] ap3 = new Label[]{AWAY_PLAYER_3_NUMBER, AWAY_PLAYER_3_NAME, AWAY_PLAYER_3_POINTS, AWAY_PLAYER_3_FOULS, AWAY_PLAYER_3_RED_FOUL};
    Label[] ap4 = new Label[]{AWAY_PLAYER_4_NUMBER, AWAY_PLAYER_4_NAME, AWAY_PLAYER_4_POINTS, AWAY_PLAYER_4_FOULS, AWAY_PLAYER_4_RED_FOUL};
    Label[] ap5 = new Label[]{AWAY_PLAYER_5_NUMBER, AWAY_PLAYER_5_NAME, AWAY_PLAYER_5_POINTS, AWAY_PLAYER_5_FOULS, AWAY_PLAYER_5_RED_FOUL};
    Label[] ap6 = new Label[]{AWAY_PLAYER_6_NUMBER, AWAY_PLAYER_5_NAME, AWAY_PLAYER_6_POINTS, AWAY_PLAYER_6_FOULS, AWAY_PLAYER_6_RED_FOUL};
    Label[] ap7 = new Label[]{AWAY_PLAYER_7_NUMBER, AWAY_PLAYER_6_NAME, AWAY_PLAYER_7_POINTS, AWAY_PLAYER_7_FOULS, AWAY_PLAYER_7_RED_FOUL};
    Label[] ap8 = new Label[]{AWAY_PLAYER_8_NUMBER, AWAY_PLAYER_7_NAME, AWAY_PLAYER_8_POINTS, AWAY_PLAYER_8_FOULS, AWAY_PLAYER_8_RED_FOUL};
    Label[] ap9 = new Label[]{AWAY_PLAYER_9_NUMBER, AWAY_PLAYER_8_NAME, AWAY_PLAYER_9_POINTS, AWAY_PLAYER_9_FOULS, AWAY_PLAYER_9_RED_FOUL};
    Label[] ap10 = new Label[]{AWAY_PLAYER_10_NUMBER, AWAY_PLAYER_9_NAME, AWAY_PLAYER_10_POINTS, AWAY_PLAYER_10_FOULS, AWAY_PLAYER_10_RED_FOUL};
    Label[] ap11 = new Label[]{AWAY_PLAYER_11_NUMBER, AWAY_PLAYER_10_NAME, AWAY_PLAYER_11_POINTS, AWAY_PLAYER_11_FOULS, AWAY_PLAYER_11_RED_FOUL};
    Label[] ap12 = new Label[]{AWAY_PLAYER_12_NUMBER, AWAY_PLAYER_11_NAME, AWAY_PLAYER_12_POINTS, AWAY_PLAYER_12_FOULS, AWAY_PLAYER_12_RED_FOUL};

    public void fun () {
        home_player_list.add(hp1);
        home_player_list.add(hp2);
        home_player_list.add(hp3);
        home_player_list.add(hp4);
        home_player_list.add(hp5);
        home_player_list.add(hp6);
        home_player_list.add(hp7);
        home_player_list.add(hp8);
        home_player_list.add(hp9);
        home_player_list.add(hp10);
        home_player_list.add(hp11);
        home_player_list.add(hp12);
        away_player_list.add(ap1);
        away_player_list.add(ap2);
        away_player_list.add(ap3);
        away_player_list.add(ap4);
        away_player_list.add(ap5);
        away_player_list.add(ap6);
        away_player_list.add(ap7);
        away_player_list.add(ap8);
        away_player_list.add(ap9);
        away_player_list.add(ap10);
        away_player_list.add(ap11);
        away_player_list.add(ap12);
    }


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
    private boolean onBreak = false;

    public Controller() {
        for (int i = 0; i <= 12; i = i + 1){
            home_player_list.get(i)[0].setText(GameTool.getPlayerNumber(true, i));
            home_player_list.get(i)[1].setText(GameTool.getPlayerName(true, i));
            home_player_list.get(i)[2].setText(GameTool.getPlayerPoints(true, i));
            home_player_list.get(i)[3].setText(GameTool.getPlayerFouls(true, i));
            home_player_list.get(i)[4].setText(GameTool.getPlayerRedFoul(true, i));
            away_player_list.get(i)[0].setText(GameTool.getPlayerNumber(false, i));
            away_player_list.get(i)[1].setText(GameTool.getPlayerName(false, i));
            away_player_list.get(i)[2].setText(GameTool.getPlayerPoints(false, i));
            away_player_list.get(i)[3].setText(GameTool.getPlayerFouls(false, i));
            away_player_list.get(i)[4].setText(GameTool.getPlayerRedFoul(false, i));
        }
    }

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
            if(onBreak){
                GameTool.nextTimePeriod();
                time_label_calculations();
                START();
                onBreak = false;
            }
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
            if(!GameTool.getIsBreakNext()) {
                GameTool.nextTimePeriod();
                time_label_calculations();
                START();
            } else {
                onBreak = true;
            }

            if (GameTool.getIsManual()) {
                timeline.pause();
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
        timeline.playFromStart();
        timeline.setOnFinished(e -> {
            test();
            isTimeoutAlready = false;
            timeline_ending_checks();
        });
    }

    private void test() {
        timeSeconds.setValue(GameTool.getTimePeriodSeconds() - GameTool.getTmpDuration().toSeconds());
        PERIOD.setText(GameTool.getLabel());
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(timeSeconds.intValue()),
                        new KeyValue(timeSeconds, 0)));
    }

    /**
     * Checks if timeouts or team fouls should be reset. Also sets next timePeriod to start manually if wanted.
     */
    private void timeout_ending_checks() {
        timeline.setOnFinished(e -> {
            if (GameTool.getResetTimeouts()) {
                resetTimeous();
            }
            if (GameTool.getResetTeamFouls()) {
                resetTeamFouls();
            }
            START();
            if (GameTool.getIsManual()) {
                PAUSE();
            }
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