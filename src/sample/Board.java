package sample;

public class Board {

    private Team homeTeam;
    private Team guestTeam;
    private int timeSeconds;
    private int currentTimePeriod;
    private int[] lastFoul = new int[2];

    public Board(Team homeTeam, Team guestTeam) {

        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.timeSeconds = 666;
        this.currentTimePeriod = 0;
    }

    public sample.Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(sample.Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public int getPeriod() {
        return currentTimePeriod;
    }

    public void setPeriod(int currentTimePeriod) {
        this.currentTimePeriod = currentTimePeriod;
    }

    public void nextTimePeriod() {
        this.currentTimePeriod = currentTimePeriod + 1;
    }

    public int[] getLastFoul() {
        return lastFoul;
    }

    public void setLastFoul(int[] lastFoul) {
        this.lastFoul = lastFoul;
    }

}
