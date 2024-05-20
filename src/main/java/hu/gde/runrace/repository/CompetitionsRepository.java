package hu.gde.runrace.repository;

import hu.gde.runrace.model.Competitions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompetitionsRepository extends JpaRepository<Competitions, Long> {
}
