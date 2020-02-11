package sample;

public class Team {
    private int score;
    private String name;
    private int timeOuts;
    private int foulsSet;

    public Team(String name) {
        score = 0;
        this.name = name;
        timeOuts = 3;
        foulsSet = 0;
    }

    public int getTimeOuts() {
        return timeOuts;
    }

    public void setTimeOuts(int timeOuts) {
        this.timeOuts = timeOuts;
    }

    public void TimeOut() {
        this.timeOuts = this.timeOuts - 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoints(int points) {
        this.score = this.score + points;
    }

    public int getFoulsSet() {
        return foulsSet;
    }

    public void setFoulsSet(int foulsSet) {
        this.foulsSet = foulsSet;
    }

    public void foulsSet() {
        this.foulsSet = this.foulsSet - 1;
    }

}
