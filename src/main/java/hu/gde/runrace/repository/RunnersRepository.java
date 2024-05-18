package hu.gde.runrace.repository;

import hu.gde.runrace.model.Runners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RunnersRepository extends JpaRepository<Runners, UUID> {
}
