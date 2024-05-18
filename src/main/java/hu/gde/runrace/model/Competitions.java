package hu.gde.runrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Competitions {

    private @Id
    @GeneratedValue(strategy = GenerationType.UUID) UUID competitionID;
    private String competitionName;
    private int distance;

    public Competitions() {

    }

    public Competitions(String competitionName, int distance) {
        this.competitionName = competitionName;
        this.distance = distance;
    }

    public UUID getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(UUID competitionID) {
        this.competitionID = competitionID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    @Override
    public String toString() {
        return "Competitions{" +
                "competitionID=" + competitionID +
                ", competitionName='" + competitionName + '\'' +
                ", distance=" + distance +
                '}';
    }
}
