package hu.gde.runrace.controller;

import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.RunnersRepository;
import hu.gde.runrace.services.RunnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RunnersController {


    private final RunnersService runnersService;

    public RunnersController(RunnersService runnersService) {
        this.runnersService = runnersService;
    }

    @GetMapping("/getRunners")
    public List<Runners> getAllRunners() {

        return runnersService.getAllRunners();
    }

    @PostMapping("addRunner")
    public Runners createRunner(@RequestBody Runners runners) {
        return runnersService.saveRunners(runners);
    }

}
