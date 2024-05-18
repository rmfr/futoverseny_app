package hu.gde.runrace.services;

import hu.gde.runrace.model.Runners;
import hu.gde.runrace.repository.RunnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
