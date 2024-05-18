package hu.gde.runrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Runners {

    private String name;
    private String gender;
    private @Id
    @GeneratedValue(strategy = GenerationType.UUID) UUID runnerId;
    public Runners() {

    }
    Runners(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }


    public void setRunnerId(UUID runnerId) {
        this.runnerId = runnerId;
    }

    public UUID getRunnerId() {
        return runnerId;
    }

    @Override
    public String toString() {
        return "Runners{" +
                "name='" + name + '\'' +
                ", nem='" + gender + '\'' +
                ", runnerId=" + runnerId +
                '}';
    }

}



