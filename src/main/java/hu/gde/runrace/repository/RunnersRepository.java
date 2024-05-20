package hu.gde.runrace.repository;

import hu.gde.runrace.model.Runners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnersRepository extends JpaRepository<Runners, Long> {
}
