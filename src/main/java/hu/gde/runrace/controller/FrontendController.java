package hu.gde.runrace.controller;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Results;
import hu.gde.runrace.model.RunnerResultDto;
import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.CompetitionsRepository;
import hu.gde.runrace.repository.ResultsRepository;
import hu.gde.runrace.repository.RunnersRepository;
import hu.gde.runrace.services.RunnersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class FrontendController {
    private final CompetitionsRepository competitionsRepository;
    private final ResultsRepository resultsRepository;
    private final RunnersRepository runnersRepository;
    private final RunnersService runnersService;

    public FrontendController(CompetitionsRepository competitionsRepository, ResultsRepository resultsRepository, RunnersRepository runnersRepository, RunnersService runnersService) {
        this.competitionsRepository = competitionsRepository;
        this.resultsRepository = resultsRepository;
        this.runnersRepository = runnersRepository;
        this.runnersService = runnersService;
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

}
