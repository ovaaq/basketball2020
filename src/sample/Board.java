package sample;

public class Board {

    private Team homeTeam;
    private Team guestTeam;
    private int timeSeconds;
    private int period;
    private int[] lastFoul = new int[2];

    public Board(Team homeTeam, Team guestTeam) {

        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.timeSeconds = 666;
        this.period = 1;
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
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void nextPeriod() {
        this.period = period + 1;
    }

    public int[] getLastFoul() {
        return lastFoul;
    }

    public void setLastFoul(int[] lastFoul) {
        this.lastFoul = lastFoul;
    }

}
