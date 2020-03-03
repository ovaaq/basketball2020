package sample;

public class PeriodInfo {

    int seconds; // Duration of the period
    boolean manual; // Is period manually started
    int period; // number of period
    String label; // name of the period
    boolean resetTimeouts; // do you reset timeouts when period ends
    boolean resetTeamFouls; // do you reset timeouts when period ends
    boolean isBreak; // is this period a break or not
    boolean isThisOvertime; // is this overtime

    PeriodInfo(int seconds, boolean manual, int period, String label, boolean resetTeamFouls, boolean resetTimeous, boolean isBreak, boolean isThisOvertime) {
        this.seconds = seconds;
        this.manual = manual;
        this.period = period;
        this.label = label;
        this.resetTeamFouls = resetTeamFouls;
        this.resetTimeouts = resetTimeous;
        this.isBreak = isBreak;
        this.isThisOvertime = isThisOvertime;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isResetTimeouts() {
        return resetTimeouts;
    }

    public void setResetTimeouts(boolean resetTimeouts) {
        this.resetTimeouts = resetTimeouts;
    }

    public boolean isResetTeamFouls() {
        return resetTeamFouls;
    }

    public void setResetTeamFouls(boolean resetTeamFouls) {
        this.resetTeamFouls = resetTeamFouls;
    }

    public boolean isBreak() {
        return isBreak;
    }

    public void setBreak(boolean aBreak) {
        isBreak = aBreak;
    }

    public boolean isThisOvertime() {
        return isThisOvertime;
    }

    public void setThisOvertime(boolean thisOvertime) {
        isThisOvertime = thisOvertime;
    }

}
