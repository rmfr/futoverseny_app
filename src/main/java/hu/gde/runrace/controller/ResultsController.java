package hu.gde.runrace.controller;

import hu.gde.runrace.model.ResultDTO;
import hu.gde.runrace.services.ResultsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ResultsController {

    private final ResultsService resultsService;


    public ResultsController(ResultsService resultsService) {
        this.resultsService = resultsService;
    }

@   PostMapping("/addResult")
    public ResponseEntity<String> addResult(@RequestBody ResultDTO resultDTO) {
        try {
            resultsService.addResult(resultDTO);
            return ResponseEntity.ok("Az eredmény sikeresen hozzá lett adva.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hiba történt az eredmény hozzáadása közben: " + e.getMessage());
        }
    }

    @GetMapping("/getAverageTime/{raceId}")
    public ResponseEntity<Double> getAverageTime(@PathVariable long raceId) {
        try {
            double averageTime = resultsService.calculateAverageTimeForRace(raceId);
            return ResponseEntity.ok(averageTime);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
