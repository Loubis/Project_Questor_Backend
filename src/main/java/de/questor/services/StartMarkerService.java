package de.questor.services;

import de.questor.model.Module;
import de.questor.model.Quest;
import de.questor.model.QuestMarker;
import de.questor.model.StartMarker;
import de.questor.model.modules.ConfirmationModule;
import de.questor.model.modules.InModule;
import de.questor.model.modules.OutModule;
import de.questor.repositories.QuestMarkerRepository;
import de.questor.repositories.QuestRepository;
import de.questor.repositories.modules.ConfirmationModuleRepository;
import de.questor.repositories.modules.InModuleRepository;
import de.questor.repositories.modules.OutModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.questor.repositories.StartMarkerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartMarkerService {

    private final StartMarkerRepository startMarkerRepository;
    private final QuestRepository questRepository;
    private final QuestMarkerRepository questMarkerRepository;
    private final ConfirmationModuleRepository confirmationModuleRepository;
    private final InModuleRepository inModuleRepository;
    private final OutModuleRepository outModuleRepository;

    @Autowired
    public StartMarkerService(StartMarkerRepository startMarkerRepository, QuestRepository questRepository, QuestMarkerRepository questMarkerRepository, ConfirmationModuleRepository confirmationModuleRepository, InModuleRepository inModuleRepository, OutModuleRepository outModuleRepository) {
        this.startMarkerRepository = startMarkerRepository;
        this.questRepository = questRepository;
        this.questMarkerRepository = questMarkerRepository;
        this.confirmationModuleRepository = confirmationModuleRepository;
        this.inModuleRepository = inModuleRepository;
        this.outModuleRepository = outModuleRepository;
    }

    public void test() {
        //Quests
        Quest q1 = new Quest();
        q1.setStory("Quest 1");
        //QuestMarker
        QuestMarker qm1 = new QuestMarker();
        q1.setStartPosition(qm1);
        QuestMarker qm2 = new QuestMarker();
        //Modules
        InModule mIn = new InModule();
        OutModule mOut = new OutModule();
        ConfirmationModule conf = new ConfirmationModule();
        mIn.setSuccess(conf);
        conf.setSuccess(mOut);
        mOut.setPointsTo(qm2);
        List<Module> modules = new ArrayList<>();
        modules.add(mIn);
        modules.add(mOut);
        modules.add(conf);
        qm1.setModules(modules);
        List<QuestMarker> pointsTo = new ArrayList<>();
        pointsTo.add(qm2);
        qm1.setPointsTo(pointsTo);
        //StartMarker
        StartMarker test = new StartMarker();
        test.setLatitude(1);
        test.setLongitude(1);
        List<Quest> quests = new ArrayList<>();
        test.setQuests(quests);
        quests.add(q1);
        confirmationModuleRepository.save(conf);
        inModuleRepository.save(mIn);
        outModuleRepository.save(mOut);
        questMarkerRepository.save(qm1);
        questMarkerRepository.save(qm2);
        questRepository.save(q1);
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

    public boolean delete(Integer id) {
        if (startMarkerRepository.existsById(id)) {
            startMarkerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
