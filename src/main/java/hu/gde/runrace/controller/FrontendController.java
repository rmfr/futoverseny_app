package hu.gde.runrace.controller;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.RunnerResultDto;
import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.CompetitionsRepository;
import hu.gde.runrace.repository.ResultsRepository;
import hu.gde.runrace.repository.RunnersRepository;
import hu.gde.runrace.services.CompetitionsService;
import hu.gde.runrace.services.RunnersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class FrontendController {
    private final CompetitionsRepository competitionsRepository;
    private final RunnersService runnersService;
    private final CompetitionsService competitionsService;

    public FrontendController(CompetitionsRepository competitionsRepository, RunnersService runnersService, CompetitionsService competitionsService) {
        this.competitionsRepository = competitionsRepository;
        this.runnersService = runnersService;
        this.competitionsService = competitionsService;
    }
    @GetMapping("/races")
    public String showRaces(Model model) {
        List<Competitions> races = competitionsRepository.findAll();
        model.addAttribute("races", races);
        return "races";
    }


    @GetMapping("/raceDetails")
    public String showRaceDetails(Model model) {
        List<RunnerResultDto> runnerResults = runnersService.getAllRunnerResults();
        model.addAttribute("runnerResults", runnerResults);
        return "racedetails";
    }

    @GetMapping("/addRace")
    public String showAddRaceForm() {
        return "addrace";
    }

    @PostMapping("/addRace")
    public String addRace(@RequestParam("name") String name, @RequestParam("distance") int distance) {
        competitionsService.addRace(name, distance);
        return "redirect:/races";
    }

}
