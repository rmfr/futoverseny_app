package hu.gde.runrace.services;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.RunnerResultDto;
import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.CompetitionsRepository;
import hu.gde.runrace.repository.ResultsRepository;
import hu.gde.runrace.repository.RunnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnersService {

    private final RunnersRepository runnersRepository;
    @Autowired
    private CompetitionsRepository competitionsRepository;

    @Autowired
    public RunnersService(RunnersRepository runnersRepository) {
        this.runnersRepository = runnersRepository;
    }

    public List<Runners> getAllRunners(){
        return runnersRepository.findAll();
    }

    public Runners saveRunners(Runners runners) {
        return runnersRepository.save(runners);
    }



    @Autowired
    private ResultsRepository resultsRepository;

    public List<RunnerResultDto> getAllRunnerResults() {
        List<RunnerResultDto> runnerResults = new ArrayList<>();
        List<Results> results =resultsRepository.findAll();
        for (Results result : results) {

            String runnerName = result.getRunnersName();
            int minuteTime = result.getMinuteTime();
            String raceName = result.getCompetitionName();

            runnerResults.add(new RunnerResultDto(runnerName,  minuteTime, raceName));
        }
        return runnerResults;
    }

    public List<RunnerResultDto> getAllRunnerResultsById(@PathVariable long id) {
        Competitions competitions = competitionsRepository.findById(id)
                .orElse(null);
         List<Results> results = resultsRepository.findByCompetitionsOrderByMinuteTimeAsc(competitions);
         List<RunnerResultDto> runnerResults = new ArrayList<>();

         for (Results result : results) {

            String runnerName = result.getRunnersName();
            int minuteTime = result.getMinuteTime();
            String raceName = result.getCompetitionName();

            runnerResults.add(new RunnerResultDto(runnerName,  minuteTime, raceName));
        }
            return runnerResults;
    }
}
