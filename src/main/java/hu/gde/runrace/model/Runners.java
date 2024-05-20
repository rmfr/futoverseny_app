package hu.gde.runrace.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Runners {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO) long runnerId;
    private String name;
    private String gender;
    private int age;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "runners")
    private List<Results> results;

    public Runners() {

    }
    Runners(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public long getRunnerId() {
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

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

}



