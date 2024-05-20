package hu.gde.runrace.controller;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.RunnerResultDto;
import hu.gde.runrace.repository.CompetitionsRepository;
import hu.gde.runrace.services.RunnersService;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class ComptetitionController {

    private final CompetitionsRepository competitionsRepository;
    private final RunnersService runnersService;

    public ComptetitionController(CompetitionsRepository competitionsRepository, RunnersService runnersService) {
        this.competitionsRepository = competitionsRepository;
        this.runnersService = runnersService;
    }

    @PutMapping("updateRace/{id}")
        public Competitions updateRace(@RequestBody Competitions newCompetition, @PathVariable Long id) {
        return competitionsRepository.findById(id)
                .map(competitions -> {
                    competitions.setCompetitionName(newCompetition.getCompetitionName());
                    competitions.setDistance(newCompetition.getDistance());
                    return competitionsRepository.save(competitions);
                })
                .orElseThrow(() -> new RuntimeException("Ilyen id-val nincs rögzítve verseny!"));
    }


    @GetMapping("/getRaceRunners/{id}")
    public List<RunnerResultDto> getRaceRunnerById(@PathVariable long id){

        List<RunnerResultDto> runners = runnersService.getAllRunnerResultsById(id);
        return runners;
    }



}
