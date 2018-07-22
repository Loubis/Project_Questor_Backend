package de.questor.services.modules;

import de.questor.model.modules.InModule;
import de.questor.repositories.modules.InModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class InModuleService {

    private final InModuleRepository inModuleRepository;

    public InModuleService(InModuleRepository inModuleRepository) {
        this.inModuleRepository = inModuleRepository;
    }

    public InModule getById(Integer id) {
        return inModuleRepository.findById(id).orElse(null);
    }

    public Iterable<InModule> getAll() {
        return inModuleRepository.findAll();
    }

    public InModule create(InModule inModule) {
        return inModuleRepository.save(inModule);
    }

    public InModule update(InModule inModule) {
        return inModuleRepository.save(inModule);
    }

    public boolean delete(Integer id) {
        if (inModuleRepository.existsById(id)) {
            inModuleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
