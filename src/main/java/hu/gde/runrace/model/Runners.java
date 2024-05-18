package hu.gde.runrace.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Runners {
    private @Id
    @GeneratedValue(strategy = GenerationType.UUID) UUID runnerId;
    private String name;
    private String gender;
    private int age;

    public Runners() {

    }
    Runners(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    public void setRunnerId(UUID runnerId) {
        this.runnerId = runnerId;
    }

    public UUID getRunnerId() {
        return runnerId;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


      public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Runners{" +
                "name='" + name + '\'' +
                ", nem='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", runnerId=" + runnerId +
                '}';
    }

}



