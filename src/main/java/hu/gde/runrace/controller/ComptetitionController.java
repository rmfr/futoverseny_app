package hu.gde.runrace.controller;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.repository.CompetitionsRepository;
import hu.gde.runrace.services.CompetitionsService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class ComptetitionController {

    private final CompetitionsService competitionsService;
    private final CompetitionsRepository competitionsRepository;

    public ComptetitionController(CompetitionsService competitionsService, CompetitionsRepository competitionsRepository) {
        this.competitionsService = competitionsService;
        this.competitionsRepository = competitionsRepository;
    }
/*
    @PutMapping("updateRace/{id}")
    public Competitions updateRace(Competitions competitions) {
        return competitionsService.updateRace(competitions);
    }
*/
     @PutMapping("updateRace/{id}")
        public Competitions updateRace(
            @RequestBody Competitions newCompetition, @PathVariable UUID id) {
        return competitionsRepository.findById(id)
                .map(competitions -> {
                    competitions.setCompetitionName(newCompetition.getCompetitionName());
                    competitions.setDistance(newCompetition.getDistance());
                    return competitionsRepository.save(competitions);
                })
                .orElseThrow(() -> new RuntimeException("Ilyen id-val nincs rögzítve verseny!"));
    }
}


