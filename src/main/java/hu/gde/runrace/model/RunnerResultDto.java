package hu.gde.runrace.model;

public class RunnerResultDto {
    private String runnerName;
    private int minTime;
    private String raceName;

    public RunnerResultDto(String runnerName, int minTime, String raceName) {
        this.runnerName = runnerName;
        this.minTime = minTime;
        this.raceName = raceName;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinuteTime(int minTime) {
        this.minTime = minTime;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public String toString() {
        return "RunnerResultDto{" +
                "runnerName='" + runnerName + '\'' +
                ", minTime=" + minTime +
                ", raceName='" + raceName + '\'' +
                '}';
    }
}
