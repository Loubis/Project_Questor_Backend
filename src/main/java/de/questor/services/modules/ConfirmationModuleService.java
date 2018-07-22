package de.questor.services.modules;

import de.questor.model.modules.ConfirmationModule;
import de.questor.repositories.modules.ConfirmationModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationModuleService {

    private final ConfirmationModuleRepository confirmationModuleRepository;

    public ConfirmationModuleService(ConfirmationModuleRepository confirmationModuleRepository) {
        this.confirmationModuleRepository = confirmationModuleRepository;
    }

    public ConfirmationModule getById(Integer id) {
        return confirmationModuleRepository.findById(id).orElse(null);
    }

    public Iterable<ConfirmationModule> getAll() {
        return confirmationModuleRepository.findAll();
    }

    public ConfirmationModule create(ConfirmationModule confirmationModule) {
        return confirmationModuleRepository.save(confirmationModule);
    }

    public ConfirmationModule update(ConfirmationModule confirmationModule) {
        return confirmationModuleRepository.save(confirmationModule);
    }

    public boolean delete(Integer id) {
        if (confirmationModuleRepository.existsById(id)) {
            confirmationModuleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
