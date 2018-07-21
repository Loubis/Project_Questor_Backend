package de.questor.services;

import de.questor.model.QuestMarker;
import de.questor.repositories.QuestMarkerRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestMarkerService {

    private final QuestMarkerRepository questMarkerRepository;

    public QuestMarkerService(QuestMarkerRepository questMarkerRepository) {
        this.questMarkerRepository = questMarkerRepository;
    }

    public QuestMarker getById(Integer id) {
        return questMarkerRepository.findById(id).orElse(null);
    }

    public Iterable<QuestMarker> getAll() {
        return questMarkerRepository.findAll();
    }

    public QuestMarker create(QuestMarker questMarker) {
        return questMarkerRepository.save(questMarker);
    }

    public QuestMarker update(QuestMarker questMarker) {
        return questMarkerRepository.save(questMarker);
    }

    public void delete(Integer id) {
        questMarkerRepository.deleteById(id);
    }
}
