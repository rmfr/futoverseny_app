package hu.gde.runrace.repository;

import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.Runners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResultsRepository extends JpaRepository<Results, UUID> {
    List<Results> findByRunners(Runners runners);
}
