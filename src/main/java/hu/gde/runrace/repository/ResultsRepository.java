package hu.gde.runrace.repository;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.Runners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultsRepository extends JpaRepository<Results, Long> {
    List<Results> findByRunners(Runners runners);
    List<Results> findByCompetitionsOrderByMinuteTimeAsc(Competitions competitions);
}
