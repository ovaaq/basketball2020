package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private Board board;
    private LinkedList<timeAndManual> gameOrder = new LinkedList<>();
    private int currentTimePeriod;
    private Duration tmp_time = null;
    private int maxTeamFouls = 5;

    private String HOME_PLAYER_1_FOULS, HOME_PLAYER_2_FOULS, HOME_PLAYER_3_FOULS, HOME_PLAYER_4_FOULS, HOME_PLAYER_5_FOULS, HOME_PLAYER_6_FOULS, HOME_PLAYER_7_FOULS
            , HOME_PLAYER_8_FOULS, HOME_PLAYER_9_FOULS, HOME_PLAYER_10_FOULS, HOME_PLAYER_11_FOULS, HOME_PLAYER_12_FOULS;

    private String HOME_PLAYER_1_RED_FOUL, HOME_PLAYER_2_RED_FOUL, HOME_PLAYER_3_RED_FOUL, HOME_PLAYER_4_RED_FOUL, HOME_PLAYER_5_RED_FOUL, HOME_PLAYER_6_RED_FOUL
            , HOME_PLAYER_7_RED_FOUL, HOME_PLAYER_8_RED_FOUL, HOME_PLAYER_9_RED_FOUL, HOME_PLAYER_10_RED_FOUL, HOME_PLAYER_11_RED_FOUL, HOME_PLAYER_12_RED_FOUL;

    private String HOME_PLAYER_1_POINTS, HOME_PLAYER_2_POINTS, HOME_PLAYER_3_POINTS, HOME_PLAYER_4_POINTS, HOME_PLAYER_5_POINTS, HOME_PLAYER_6_POINTS
            , HOME_PLAYER_7_POINTS, HOME_PLAYER_8_POINTS, HOME_PLAYER_9_POINTS, HOME_PLAYER_10_POINTS, HOME_PLAYER_11_POINTS, HOME_PLAYER_12_POINTS;

    private String HOME_PLAYER_1_NAME, HOME_PLAYER_2_NAME, HOME_PLAYER_3_NAME, HOME_PLAYER_4_NAME, HOME_PLAYER_5_NAME, HOME_PLAYER_6_NAME
            , HOME_PLAYER_7_NAME, HOME_PLAYER_8_NAME, HOME_PLAYER_9_NAME, HOME_PLAYER_10_NAME, HOME_PLAYER_11_NAME, HOME_PLAYER_12_NAME;

    private String HOME_PLAYER_1_NUMBER, HOME_PLAYER_2_NUMBER, HOME_PLAYER_3_NUMBER, HOME_PLAYER_4_NUMBER, HOME_PLAYER_5_NUMBER, HOME_PLAYER_6_NUMBER
            , HOME_PLAYER_7_NUMBER, HOME_PLAYER_8_NUMBER, HOME_PLAYER_9_NUMBER, HOME_PLAYER_10_NUMBER, HOME_PLAYER_11_NUMBER, HOME_PLAYER_12_NUMBER;

    private String AWAY_PLAYER_1_POINTS, AWAY_PLAYER_2_POINTS, AWAY_PLAYER_3_POINTS, AWAY_PLAYER_4_POINTS, AWAY_PLAYER_5_POINTS, AWAY_PLAYER_6_POINTS
            , AWAY_PLAYER_7_POINTS, AWAY_PLAYER_8_POINTS, AWAY_PLAYER_9_POINTS, AWAY_PLAYER_10_POINTS, AWAY_PLAYER_11_POINTS, AWAY_PLAYER_12_POINTS;

    private String AWAY_PLAYER_1_FOULS, AWAY_PLAYER_2_FOULS, AWAY_PLAYER_3_FOULS, AWAY_PLAYER_4_FOULS, AWAY_PLAYER_5_FOULS, AWAY_PLAYER_6_FOULS
            , AWAY_PLAYER_7_FOULS, AWAY_PLAYER_8_FOULS, AWAY_PLAYER_9_FOULS, AWAY_PLAYER_10_FOULS, AWAY_PLAYER_11_FOULS, AWAY_PLAYER_12_FOULS;

    private String AWAY_PLAYER_1_RED_FOUL, AWAY_PLAYER_2_RED_FOUL, AWAY_PLAYER_3_RED_FOUL, AWAY_PLAYER_4_RED_FOUL, AWAY_PLAYER_5_RED_FOUL, AWAY_PLAYER_6_RED_FOUL
            , AWAY_PLAYER_7_RED_FOUL, AWAY_PLAYER_8_RED_FOUL, AWAY_PLAYER_9_RED_FOUL, AWAY_PLAYER_10_RED_FOUL, AWAY_PLAYER_11_RED_FOUL, AWAY_PLAYER_12_RED_FOUL;

    private String AWAY_PLAYER_1_NAME, AWAY_PLAYER_2_NAME, AWAY_PLAYER_3_NAME, AWAY_PLAYER_4_NAME, AWAY_PLAYER_5_NAME, AWAY_PLAYER_6_NAME
            , AWAY_PLAYER_7_NAME, AWAY_PLAYER_8_NAME, AWAY_PLAYER_9_NAME, AWAY_PLAYER_10_NAME, AWAY_PLAYER_11_NAME, AWAY_PLAYER_12_NAME;

    private String AWAY_PLAYER_1_NUMBER, AWAY_PLAYER_2_NUMBER, AWAY_PLAYER_3_NUMBER, AWAY_PLAYER_4_NUMBER, AWAY_PLAYER_5_NUMBER, AWAY_PLAYER_6_NUMBER
            , AWAY_PLAYER_7_NUMBER, AWAY_PLAYER_8_NUMBER, AWAY_PLAYER_9_NUMBER, AWAY_PLAYER_10_NUMBER, AWAY_PLAYER_11_NUMBER, AWAY_PLAYER_12_NUMBER;


    private LinkedList<String[]> home_player_list = new LinkedList<>();
    private LinkedList<String[]> away_player_list = new LinkedList<>();

    String[] hp1 = new String[]{HOME_PLAYER_1_NUMBER, HOME_PLAYER_1_NAME, HOME_PLAYER_1_POINTS, HOME_PLAYER_1_FOULS, HOME_PLAYER_1_RED_FOUL};
    String[] hp2 = new String[]{HOME_PLAYER_2_NUMBER, HOME_PLAYER_2_NAME, HOME_PLAYER_2_POINTS, HOME_PLAYER_2_FOULS, HOME_PLAYER_2_RED_FOUL};
    String[] hp3 = new String[]{HOME_PLAYER_3_NUMBER, HOME_PLAYER_3_NAME, HOME_PLAYER_3_POINTS, HOME_PLAYER_3_FOULS, HOME_PLAYER_3_RED_FOUL};
    String[] hp4 = new String[]{HOME_PLAYER_4_NUMBER, HOME_PLAYER_4_NAME, HOME_PLAYER_4_POINTS, HOME_PLAYER_4_FOULS, HOME_PLAYER_4_RED_FOUL};
    String[] hp5 = new String[]{HOME_PLAYER_5_NUMBER, HOME_PLAYER_5_NAME, HOME_PLAYER_5_POINTS, HOME_PLAYER_5_FOULS, HOME_PLAYER_5_RED_FOUL};
    String[] hp6 = new String[]{HOME_PLAYER_6_NUMBER, HOME_PLAYER_6_NAME, HOME_PLAYER_6_POINTS, HOME_PLAYER_6_FOULS, HOME_PLAYER_6_RED_FOUL};
    String[] hp7 = new String[]{HOME_PLAYER_7_NUMBER, HOME_PLAYER_7_NAME, HOME_PLAYER_7_POINTS, HOME_PLAYER_7_FOULS, HOME_PLAYER_7_RED_FOUL};
    String[] hp8 = new String[]{HOME_PLAYER_8_NUMBER, HOME_PLAYER_8_NAME, HOME_PLAYER_8_POINTS, HOME_PLAYER_8_FOULS, HOME_PLAYER_8_RED_FOUL};
    String[] hp9 = new String[]{HOME_PLAYER_9_NUMBER, HOME_PLAYER_9_NAME, HOME_PLAYER_9_POINTS, HOME_PLAYER_9_FOULS, HOME_PLAYER_9_RED_FOUL};
    String[] hp10 = new String[]{HOME_PLAYER_10_NUMBER, HOME_PLAYER_10_NAME, HOME_PLAYER_10_POINTS, HOME_PLAYER_10_FOULS, HOME_PLAYER_10_RED_FOUL};
    String[] hp11 = new String[]{HOME_PLAYER_11_NUMBER, HOME_PLAYER_11_NAME, HOME_PLAYER_11_POINTS, HOME_PLAYER_11_FOULS, HOME_PLAYER_11_RED_FOUL};
    String[] hp12 = new String[]{HOME_PLAYER_12_NUMBER, HOME_PLAYER_12_NAME, HOME_PLAYER_12_POINTS, HOME_PLAYER_12_FOULS, HOME_PLAYER_12_RED_FOUL};

    String[] ap1 = new String[]{AWAY_PLAYER_1_NUMBER, AWAY_PLAYER_1_NAME, AWAY_PLAYER_1_POINTS, AWAY_PLAYER_1_FOULS, AWAY_PLAYER_1_RED_FOUL};
    String[] ap2 = new String[]{AWAY_PLAYER_2_NUMBER, AWAY_PLAYER_2_NAME, AWAY_PLAYER_2_POINTS, AWAY_PLAYER_2_FOULS, AWAY_PLAYER_2_RED_FOUL};
    String[] ap3 = new String[]{AWAY_PLAYER_3_NUMBER, AWAY_PLAYER_3_NAME, AWAY_PLAYER_3_POINTS, AWAY_PLAYER_3_FOULS, AWAY_PLAYER_3_RED_FOUL};
    String[] ap4 = new String[]{AWAY_PLAYER_4_NUMBER, AWAY_PLAYER_4_NAME, AWAY_PLAYER_4_POINTS, AWAY_PLAYER_4_FOULS, AWAY_PLAYER_4_RED_FOUL};
    String[] ap5 = new String[]{AWAY_PLAYER_5_NUMBER, AWAY_PLAYER_5_NAME, AWAY_PLAYER_5_POINTS, AWAY_PLAYER_5_FOULS, AWAY_PLAYER_5_RED_FOUL};
    String[] ap6 = new String[]{AWAY_PLAYER_6_NUMBER, AWAY_PLAYER_5_NAME, AWAY_PLAYER_6_POINTS, AWAY_PLAYER_6_FOULS, AWAY_PLAYER_6_RED_FOUL};
    String[] ap7 = new String[]{AWAY_PLAYER_7_NUMBER, AWAY_PLAYER_6_NAME, AWAY_PLAYER_7_POINTS, AWAY_PLAYER_7_FOULS, AWAY_PLAYER_7_RED_FOUL};
    String[] ap8 = new String[]{AWAY_PLAYER_8_NUMBER, AWAY_PLAYER_7_NAME, AWAY_PLAYER_8_POINTS, AWAY_PLAYER_8_FOULS, AWAY_PLAYER_8_RED_FOUL};
    String[] ap9 = new String[]{AWAY_PLAYER_9_NUMBER, AWAY_PLAYER_8_NAME, AWAY_PLAYER_9_POINTS, AWAY_PLAYER_9_FOULS, AWAY_PLAYER_9_RED_FOUL};
    String[] ap10 = new String[]{AWAY_PLAYER_10_NUMBER, AWAY_PLAYER_9_NAME, AWAY_PLAYER_10_POINTS, AWAY_PLAYER_10_FOULS, AWAY_PLAYER_10_RED_FOUL};
    String[] ap11 = new String[]{AWAY_PLAYER_11_NUMBER, AWAY_PLAYER_10_NAME, AWAY_PLAYER_11_POINTS, AWAY_PLAYER_11_FOULS, AWAY_PLAYER_11_RED_FOUL};
    String[] ap12 = new String[]{AWAY_PLAYER_12_NUMBER, AWAY_PLAYER_11_NAME, AWAY_PLAYER_12_POINTS, AWAY_PLAYER_12_FOULS, AWAY_PLAYER_12_RED_FOUL};

    public String getPlayerNumber(boolean isHome, int i) {
        if(isHome){
            return home_player_list.get(i)[0];
        } else {
            return away_player_list.get(i)[0];
        }
    }

    public void setPlayerNumber(String number, boolean isHome, int i) {
        if(isHome) {
            home_player_list.get(i)[0] = number;
        } else {
            away_player_list.get(i)[0] = number;
        }
    }

    public String getPlayerName(boolean isHome, int i) {
        if(isHome){
            return home_player_list.get(i)[1];
        } else {
            return away_player_list.get(i)[1];
        }
    }

    public void setPlayerName(String name, boolean isHome, int i) {
        if(isHome) {
            home_player_list.get(i)[1] = name;
        } else {
            away_player_list.get(i)[1] = name;
        }
    }

    public String getPlayerPoints(boolean isHome, int i) {
        if(isHome){
            return home_player_list.get(i)[2];
        } else {
            return away_player_list.get(i)[2];
        }
    }

    public void setPlayerPoints(String points, boolean isHome, int i){
        if(isHome) {
            home_player_list.get(i)[2] = points;
        } else {
            away_player_list.get(i)[2] = points;
        }
    }

    public String getPlayerFouls(boolean isHome, int i) {
        if(isHome){
            return home_player_list.get(i)[3];
        } else {
            return away_player_list.get(i)[3];
        }
    }

    public void setPlayerFouls(String fouls, boolean isHome, int i){
        if(isHome){
            home_player_list.get(i)[3] = fouls;
        } else {
            away_player_list.get(i)[3] = fouls;
        }
    }

    public String getPlayerRedFoul(boolean isHome, int i) {
        if(isHome){
            return home_player_list.get(i)[4];
        } else {
            return away_player_list.get(i)[4];
        }
    }

    public void setPlayerRedFoul(String redFoul, boolean isHome, int i) {
        if(isHome){
            home_player_list.get(i)[4] = redFoul;
        } else {
            away_player_list.get(i)[4] = redFoul;
        }
    }


    class timeAndManual {
        int seconds;
        boolean manual;
        int period;
        String label;
        boolean resetTimeouts;
        int maxTimeouts;
        boolean resetTeamFouls;
        int maxTeamFouls;
        boolean isBreakNext;

        timeAndManual(int seconds, boolean manual, int period, String label, boolean resetTeamFouls, boolean resetTimeous, int maxTimeouts, int maxTeamFouls, boolean isBreakNext) {
            this.seconds = seconds;
            this.manual = manual;
            this.period = period;
            this.label = label;
            this.resetTeamFouls = resetTeamFouls;
            this.resetTimeouts = resetTimeous;
            this.maxTeamFouls = maxTeamFouls;
            this.maxTimeouts = maxTimeouts;
            this.isBreakNext = isBreakNext;
        }
    }
    /*
    private static final Integer minutes60 = 3600;
    private static final Integer minutes15 = 900;
    private static final Integer minutes10 = 600;
    private static final Integer minutes2 = 120;
    private static final Integer minutes1 = 60;
     */

    private static final Integer minutes60 = 10;
    private static final Integer minutes15 = 10;
    private static final Integer minutes10 = 10;
    private static final Integer minutes2 = 10;
    private static final Integer minutes1 = 10;

    // before game
    timeAndManual p0 = new timeAndManual(minutes60, true, 0, "WAITING", false, false, 0, 0, false);

    // periods 1-4 and breaks between.
    timeAndManual p1 = new timeAndManual(minutes10, true, 1, "1. PERIOD", false, false, 2, maxTeamFouls, true);
    timeAndManual p2 = new timeAndManual(minutes2, false, 1, "BREAK", true, false, 0, maxTeamFouls, false);
    timeAndManual p3 = new timeAndManual(minutes10, true, 2, "2. PERIOD", false, false, 2, maxTeamFouls, true);
    timeAndManual p4 = new timeAndManual(minutes15, false, 2, "BREAK", true, true, 0, maxTeamFouls, false);
    timeAndManual p5 = new timeAndManual(minutes10, true, 3, "3. PERIOD", false, false, 3, maxTeamFouls, true);
    timeAndManual p6 = new timeAndManual(minutes2, false, 3, "BREAK", true, false, 0, maxTeamFouls, false);
    timeAndManual p7 = new timeAndManual(minutes10, true, 4, "4. PERIOD", false,false, 3, maxTeamFouls, true);

    // If the game is even then we continue with extra periods
    timeAndManual p8 = new timeAndManual(minutes2, false, 4, "BREAK", false, true, 0, maxTeamFouls, false);
    timeAndManual p9 = new timeAndManual(minutes2, true, 5, "E1", false, false, 1, maxTeamFouls, true);
    timeAndManual p10 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls, false);
    timeAndManual p11 = new timeAndManual(minutes2, true, 6, "E2", false,true, 1, maxTeamFouls, true);
    timeAndManual p12 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls, false);
    timeAndManual p13 = new timeAndManual(minutes2, true, 6, "E3", false,true, 1, maxTeamFouls, true);
    timeAndManual p14 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls, false);
    timeAndManual p15 = new timeAndManual(minutes2, true, 6, "E4", false,true, 1, maxTeamFouls, true);
    timeAndManual p16 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls, false);
    timeAndManual p17 = new timeAndManual(minutes2, true, 6, "E5", false,true, 1, maxTeamFouls, true);

    public Game(Board board) {
        currentTimePeriod = 0;
        this.board = board;
        gameOrder.add(p0);
        gameOrder.add(p1);
        gameOrder.add(p2);
        gameOrder.add(p3);
        gameOrder.add(p4);
        gameOrder.add(p5);
        gameOrder.add(p6);
        gameOrder.add(p7);
        gameOrder.add(p8);
        gameOrder.add(p9);
        gameOrder.add(p10);
        gameOrder.add(p11);

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

    public Board getBoard() {
        return board;
    }

    public void nextTimePeriod() {
        currentTimePeriod = currentTimePeriod + 1;
        tmp_time = null;
    }

    public int getPeriod() {
        return gameOrder.get(currentTimePeriod).period;
    }

    public boolean getIsManual() {
        return gameOrder.get(currentTimePeriod).manual;
    }

    public int getTimePeriodSeconds() {
        return gameOrder.get(currentTimePeriod).seconds;
    }

    public void homeScore(int points) {
        board.getGuestTeam().addPoints(points);
    }

    public void guestScore(int points) {
        board.getGuestTeam().addPoints(points);
    }

    public void guestTimeOut() {
        board.getGuestTeam().TimeOut();
    }

    public String getLabel() {return gameOrder.get(currentTimePeriod).label;}

    public void setTmpDuration(Duration X) {
        if(null == tmp_time) {
            tmp_time = X;
        } else {
            tmp_time.add(X);
        }
    }

    public Duration getTmpDuration() {
        return tmp_time;
    }

    public int getTimeoutTime(){
        return minutes1;
    }

    public boolean getResetTimeouts(){
        return gameOrder.get(currentTimePeriod).resetTimeouts;
    }

    public boolean getResetTeamFouls(){
        return gameOrder.get(currentTimePeriod).resetTeamFouls;
    }

    public int getMaxTeamFouls() {
        return gameOrder.get(currentTimePeriod).maxTeamFouls;
    }

    public int getMaxTimeouts(){
        return gameOrder.get(currentTimePeriod).maxTimeouts;
    }

    public boolean getIsBreakNext() {
        return gameOrder.get(currentTimePeriod).isBreakNext;
    }

}
