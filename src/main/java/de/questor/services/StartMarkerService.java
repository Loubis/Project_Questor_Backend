package de.questor.services;

import de.questor.model.Quest;
import de.questor.model.StartMarker;
import de.questor.repositories.QuestRepository;
import de.questor.repositories.StartMarkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartMarkerService {

    private final StartMarkerRepository startMarkerRepository;
    private final QuestRepository questRepository;

    public StartMarkerService(StartMarkerRepository startMarkerRepository, QuestRepository questRepository) {
        this.startMarkerRepository = startMarkerRepository;
        this.questRepository = questRepository;
    }

    public void test() {
        StartMarker test = new StartMarker();
        test.setLatitude(1);
        test.setLongitude(1);
        List<Quest> quests = new ArrayList<>();
        Quest q1 = new Quest();
        q1.setStory("Quest 1");
        Quest q2 = new Quest();
        q2.setStory("Quest 2");
        quests.add(q1);
        quests.add(q2);
        test.setQuests(quests);
        questRepository.save(q1);
        questRepository.save(q2);
        startMarkerRepository.save(test);
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

    public void delete(Integer id) {
        startMarkerRepository.deleteById(id);
    }
}
