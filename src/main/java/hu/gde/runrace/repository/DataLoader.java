package hu.gde.runrace.repository;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.Runners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RunnersRepository runnersRepository;
    private final CompetitionsRepository competitionsRepository;
    private final ResultsRepository resultsRepository;

    @Autowired
    public DataLoader(RunnersRepository runnersRepository, CompetitionsRepository competitionsRepository, ResultsRepository resultsRepository) {
        this.runnersRepository = runnersRepository;
        this.competitionsRepository = competitionsRepository;
        this.resultsRepository = resultsRepository;
    }

    @Override
    public void run(String... args){
        Runners runners = new Runners();
        runners.setName("Kis Tamás");
        runners.setAge(21);
        runners.setGender("Férfi");
        runnersRepository.save(runners);

        Runners runners1 = new Runners();
        runners1.setName("Nagy Ágnes");
        runners1.setAge(41);
        runners1.setGender("Nő");
        runnersRepository.save(runners1);

        Runners runners2 = new Runners();
        runners2.setName("Has Aladár");
        runners2.setAge(36);
        runners2.setGender("Férfi");
        runnersRepository.save(runners2);

        Runners runners4 = new Runners();
        runners4.setName("Kovács Tamásné");
        runners4.setAge(33);
        runners4.setGender("Nő");
        runnersRepository.save(runners4);

        Competitions race1 = new Competitions();
        race1.setCompetitionName("Fussunk");
        race1.setDistance(20);
        competitionsRepository.save(race1);

        Competitions race2 = new Competitions();
        race2.setCompetitionName("Szaladjunk");
        race2.setDistance(40);
        competitionsRepository.save(race2);

        Results result1 = new Results();
        result1.setRunners(runners);
        result1.setCompetitions(race1);
        result1.setMinuteTime(250);
        resultsRepository.save(result1);

        Results result2 = new Results();
        result2.setRunners(runners2);
        result2.setCompetitions(race1);
        result2.setMinuteTime(239);
        resultsRepository.save(result2);

        Results result3 = new Results();
        result3.setRunners(runners1);
        result3.setCompetitions(race1);
        result3.setMinuteTime(236);
        resultsRepository.save(result3);

        Results result4 = new Results();
        result4.setRunners(runners4);
        result4.setCompetitions(race2);
        result4.setMinuteTime(400);
        resultsRepository.save(result4);

        Results result5 = new Results();
        result5.setRunners(runners1);
        result5.setCompetitions(race2);
        result5.setMinuteTime(411);
        resultsRepository.save(result5);


        Results result6 = new Results();
        result6.setRunners(runners);
        result6.setCompetitions(race2);
        result6.setMinuteTime(409);
        resultsRepository.save(result6);
    }
}
