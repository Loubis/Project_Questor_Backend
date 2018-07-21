package de.questor.services;

import de.questor.model.Quest;
import de.questor.repositories.QuestRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestService {

    private final QuestRepository questRepository;

    public QuestService(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public Quest getById(Integer id) {
        return questRepository.findById(id).orElse(null);
    }

    public Iterable<Quest> getAll() {
        return questRepository.findAll();
    }

    public Quest create(Quest quest) {
        return questRepository.save(quest);
    }

    public Quest update(Quest quest) {
        return questRepository.save(quest);
    }

    public boolean delete(Integer id) {
        if (questRepository.existsById(id)) {
            questRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
