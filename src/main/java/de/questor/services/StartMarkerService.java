package de.questor.services;

import de.questor.model.StartMarker;
import de.questor.repositories.StartMarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartMarkerService {

    private final StartMarkerRepository startMarkerRepository;

    @Autowired
    public StartMarkerService(StartMarkerRepository startMarkerRepository) {
        this.startMarkerRepository = startMarkerRepository;
    }

    public StartMarker getById(Integer id) {
        return startMarkerRepository.findById(id).orElse(null);
    }

    public Iterable<StartMarker> getAll() {
        return startMarkerRepository.findAll();
    }

    public StartMarker create(StartMarker startMarker) {
        return startMarkerRepository.save(startMarker);
    }

    public StartMarker update(StartMarker startMarker) {
        return startMarkerRepository.save(startMarker);
    }

    public boolean delete(Integer id) {
        if (startMarkerRepository.existsById(id)) {
            startMarkerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
