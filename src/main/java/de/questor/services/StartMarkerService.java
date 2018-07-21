package de.questor.services;

import de.questor.model.Quest;
import de.questor.model.StartMarker;
import de.questor.repositories.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.questor.repositories.StartMarkerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartMarkerService {

    @Autowired
    private StartMarkerRepository startMarkerRepository;
    @Autowired
    private QuestRepository questRepository;

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

}
