package hu.gde.runrace.controller;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.CompetitionsRepository;
import hu.gde.runrace.repository.RunnersRepository;
import hu.gde.runrace.services.CompetitionsService;
import hu.gde.runrace.services.RunnersService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class ComptetitionController {

    private final CompetitionsService competitionsService;
    private final CompetitionsRepository competitionsRepository;
    private final RunnersRepository runnersRepository;
    private final RunnersRepository resultRepository;

    public ComptetitionController(CompetitionsService competitionsService, CompetitionsRepository competitionsRepository, RunnersRepository runnersRepository, RunnersRepository resultRepository) {
        this.competitionsService = competitionsService;
        this.competitionsRepository = competitionsRepository;
        this.runnersRepository = runnersRepository;
        this.resultRepository = resultRepository;
    }
/*
    @PutMapping("updateRace/{competitionID}")
    public Competitions updateRace(Competitions competitions) {
        return competitionsService.updateRace(competitions);
    }*/
    @PutMapping("updateRace/{id}")
        public Competitions updateRace(@RequestBody Competitions newCompetition, @PathVariable UUID id) {
        return competitionsRepository.findById(id)
                .map(competitions -> {
                    competitions.setCompetitionName(newCompetition.getCompetitionName());
                    competitions.setDistance(newCompetition.getDistance());
                    return competitionsRepository.save(competitions);
                })
                .orElseThrow(() -> new RuntimeException("Ilyen id-val nincs rögzítve verseny!"));
    }

    @GetMapping("/getRaceRunners2/{id}")
    public ArrayList<Results> getRaceRunners2(@PathVariable UUID id) {
        Competitions race = competitionsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A verseny nem létezik"));
       // return new ArrayList<>(race.getResults());
        ArrayList<Results> result = new ArrayList<>(race.getResults());
      //  return result;

        return result;
    }

    @GetMapping("/getRaceRunners/{id}")
    public String getRaceRunners(@PathVariable UUID id, Model model, @RequestBody Results results) {
        Competitions race = competitionsRepository.findById(id)
                .orElse(null);
        //Results res = resultRepository.findById(results.getResultsID()).orElse(null);
        ArrayList<Results> result = new ArrayList<>(race.getResults());

        List<String> runnerName = result.stream().map(Results::getRunnersName)
                .collect(Collectors.toList());
        List<Integer> runMin = result.stream().map(Results::getMinuteTime)
                .collect(Collectors.toList()).reversed();
       // Map<List<String>, List<Integer>> rr = Map.of(runner, runmin);

        model.addAttribute("Futó neve", runnerName);
        model.addAttribute("Elért idő", runMin);
        //model.addAttribute("egyben", rr);
        return model.toString();

    }
}
