package hu.gde.runrace.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class Results implements Serializable{
        private @Id
        @GeneratedValue(strategy = GenerationType.UUID) UUID resultsID;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "runnerId")
        private Runners runners;

         @ManyToOne(fetch = FetchType.LAZY)
         @JoinColumn(name = "competitionId")
        private Competitions competitions;

         private int minuteTime;

        public Results() {

                }
        public Results(Runners runners, Competitions competitions, int minuteTime) {
        this.runners = runners;
        this.competitions = competitions;
        this.minuteTime = minuteTime;
        }

        public UUID getResultsID() {
                return resultsID;
        }

        public void setResultsID(UUID resultsID) {
                this.resultsID = resultsID;
        }

        public Runners getRunners() {
                return runners;
        }

        public String getRunnersName() {
                return runners.getName();
        }

        public void setRunners(Runners runners) {
                this.runners = runners;
        }

        public String getCompetitionName() {
                return competitions.getCompetitionName();
        }

        public Competitions getCompetitions() {
                return competitions;
        }

        public void setCompetitions(Competitions competitions) {
            this.competitions = competitions;
        }
        public void setMinuteTime(int minuteTime) {
             this.minuteTime = minuteTime;
             }
        public int getMinuteTime() {
            return minuteTime;
             }
};
