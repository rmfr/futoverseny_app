package hu.gde.runrace.controller;

import hu.gde.runrace.repository.ResultsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResultsController {

    private final ResultsRepository resultsRepository;

    public ResultsController(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

}
