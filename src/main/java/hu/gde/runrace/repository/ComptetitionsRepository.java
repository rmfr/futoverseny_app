package hu.gde.runrace.repository;

import hu.gde.runrace.model.Competitions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComptetitionsRepository extends JpaRepository<Competitions, UUID> {
}
