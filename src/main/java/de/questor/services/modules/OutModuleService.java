package de.questor.services.modules;

import de.questor.model.modules.OutModule;
import de.questor.repositories.modules.OutModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class OutModuleService {

    private final OutModuleRepository outModuleRepository;

    public OutModuleService(OutModuleRepository outModuleRepository) {
        this.outModuleRepository = outModuleRepository;
    }

    public OutModule getById(Integer id) {
        return outModuleRepository.findById(id).orElse(null);
    }

    public Iterable<OutModule> getAll() {
        return outModuleRepository.findAll();
    }

    public OutModule create(OutModule outModule) {
        return outModuleRepository.save(outModule);
    }

    public OutModule update(OutModule outModule) {
        return outModuleRepository.save(outModule);
    }

    public boolean delete(Integer id) {
        if (outModuleRepository.existsById(id)) {
            outModuleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
