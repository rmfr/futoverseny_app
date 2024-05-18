package hu.gde.runrace.services;

import hu.gde.runrace.model.Competitions;
import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.RunnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class RunnersService {

    private final RunnersRepository runnersRepository;

    @Autowired
    public RunnersService(RunnersRepository runnersRepository) {
        this.runnersRepository = runnersRepository;
    }

    public List<Runners> getAllRunners(){
        return runnersRepository.findAll();
    }

    public Runners saveRunners(Runners runners) {
        return runnersRepository.save(runners);
    }
}
