package hu.gde.runrace.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Results {
        private @Id
        @GeneratedValue(strategy = GenerationType.UUID) UUID resultsID;
        @ManyToOne
        private Runners runners;

         @ManyToOne
        private Competitions competitions;

         private int minuteTime;

        public Results() {

                }
        public Results(Runners runners, Competitions competitions) {
        this.runners = runners;
        this.competitions = competitions;
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

        public void setRunners(Runners runners) {
                this.runners = runners;
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
