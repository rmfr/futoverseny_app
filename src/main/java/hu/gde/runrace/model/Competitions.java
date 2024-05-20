package hu.gde.runrace.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Competitions implements Serializable {

    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO) long competitionID;
    private String competitionName;
    private int distance;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "competitions")
    private List<Results> results;


    public Competitions() {

    }

    public Competitions(String competitionName, int distance) {
        this.competitionName = competitionName;
        this.distance = distance;
    }

    public long getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(long competitionID) {
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

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }


}
