package hu.gde.runrace.services;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.repository.CompetitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CompetitionsService {
    @Autowired
    private final CompetitionsRepository competitionsRepository;

        public CompetitionsService(CompetitionsRepository competitionsRepository) {
            this.competitionsRepository = competitionsRepository;
        }

    public Competitions updateRace(
             @RequestBody Competitions newCompetition) {
            return competitionsRepository.findById(newCompetition.getCompetitionID())
                    .map(competitions -> {
                        competitions.setCompetitionName(newCompetition.getCompetitionName());
                        competitions.setDistance(newCompetition.getDistance());
                        return competitionsRepository.save(competitions);
                    })
                    .orElseThrow(() -> new RuntimeException("Ilyen id-val nincs rögzítve verseny!"));

    }

    public void addRace(String name, int distance) {
        Competitions race = new Competitions(name, distance);
        competitionsRepository.save(race);
        }
}
