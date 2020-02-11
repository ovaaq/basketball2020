package sample;

import javafx.util.Duration;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private Board board;
    private LinkedList<timeAndManual> gameOrder = new LinkedList<>();
    private int currentTimePeriod;
    private Duration tmp_time = null;
    private int maxTeamFouls = 5;

    class timeAndManual {
        int seconds;
        boolean manual;
        int period;
        String label;
        boolean resetTimeouts;
        int maxTimeouts;
        boolean resetTeamFouls;
        int maxTeamFouls;

        timeAndManual(int seconds, boolean manual, int period, String label, boolean resetTeamFouls, boolean resetTimeous, int maxTimeouts, int maxTeamFouls) {
            this.seconds = seconds;
            this.manual = manual;
            this.period = period;
            this.label = label;
            this.resetTeamFouls = resetTeamFouls;
            this.resetTimeouts = resetTimeous;
            this.maxTeamFouls = maxTeamFouls;
            this.maxTimeouts = maxTimeouts;
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
    timeAndManual p0 = new timeAndManual(minutes60, true, 0, "WAITING", false, false, 0, 0);

    // periods 1-4 and breaks between.
    timeAndManual p1 = new timeAndManual(minutes10, true, 1, "1. PERIOD", false, false, 2, maxTeamFouls);
    timeAndManual p2 = new timeAndManual(minutes2, false, 1, "BREAK", true, false, 0, maxTeamFouls);
    timeAndManual p3 = new timeAndManual(minutes10, true, 2, "2. PERIOD", false, false, 2, maxTeamFouls);
    timeAndManual p4 = new timeAndManual(minutes15, false, 2, "BREAK", true, false, 0, maxTeamFouls);
    timeAndManual p5 = new timeAndManual(minutes10, true, 3, "3. PERIOD", false, false, 3, maxTeamFouls);
    timeAndManual p6 = new timeAndManual(minutes2, false, 3, "BREAK", true, true, 0, maxTeamFouls);
    timeAndManual p7 = new timeAndManual(minutes10, true, 4, "4. PERIOD", false,false, 3, maxTeamFouls);

    // If the game is even then we continue with extra periods
    timeAndManual p8 = new timeAndManual(minutes2, false, 4, "BREAK", false, true, 0, maxTeamFouls);
    timeAndManual p9 = new timeAndManual(minutes2, true, 5, "E1", false, false, 1, maxTeamFouls);
    timeAndManual p10 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls);
    timeAndManual p11 = new timeAndManual(minutes2, true, 6, "E2", false,true, 1, maxTeamFouls);
    timeAndManual p12 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls);
    timeAndManual p13 = new timeAndManual(minutes2, true, 6, "E3", false,true, 1, maxTeamFouls);
    timeAndManual p14 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls);
    timeAndManual p15 = new timeAndManual(minutes2, true, 6, "E4", false,true, 1, maxTeamFouls);
    timeAndManual p16 = new timeAndManual(minutes2, false, 5, "BREAK", false, true, 0, maxTeamFouls);
    timeAndManual p17 = new timeAndManual(minutes2, true, 6, "E5", false,true, 1, maxTeamFouls);

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

}
