package hu.gde.runrace.controller;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.repository.CompetitionsRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class ComptetitionController {

    private final CompetitionsRepository competitionsRepository;

    public ComptetitionController( CompetitionsRepository competitionsRepository) {
        this.competitionsRepository = competitionsRepository;
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
    public String getRaceRunners(@PathVariable Long id, Model model, @RequestBody Results results) {
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
