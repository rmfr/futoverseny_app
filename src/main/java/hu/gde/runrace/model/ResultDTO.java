package hu.gde.runrace.model;

public class ResultDTO {
    private Runners runners;
    private Competitions competitions;
    private int minuteTime;


    public Runners getRunners() {
        return runners;
    }

    public void setRunners(Runners runners) {
        this.runners = runners;
    }

    public Competitions getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Competitions competitions) {
        this.competitions = competitions;
    }

    public int getMinuteTime() {
        return minuteTime;
    }

    public void setMinuteTime(int minuteTime) {
        this.minuteTime = minuteTime;
    }
}
