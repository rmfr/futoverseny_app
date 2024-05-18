package hu.gde.runrace.repository;

import hu.gde.runrace.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResultsRepository extends JpaRepository<Results, UUID> {
}
