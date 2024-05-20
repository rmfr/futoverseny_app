package hu.gde.runrace.services;

import hu.gde.runrace.model.ResultDTO;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResultsService {
    @Autowired
    private final ResultsRepository resultsRepository;

    public ResultsService() {
        resultsRepository = null;
    }

    public void addResult(ResultDTO resultDTO) {
        Results result = new Results();
        result.setRunners(resultDTO.getRunners());
        result.setCompetitions(resultDTO.getCompetitions());
        result.setMinuteTime(resultDTO.getMinuteTime());
        assert resultsRepository != null;
        resultsRepository.save(result);
    }

        public double calculateAverageTimeForRace(UUID raceId) {

        List<Results> results = resultsRepository.findAll();
        double totalTime = 0;
        int count = 0;
            for (Results result : results) {
            totalTime += result.getMinuteTime();
            count++;
        }
        if (count == 0) {
            return 0;
        }
        return totalTime / count;
    }
}

