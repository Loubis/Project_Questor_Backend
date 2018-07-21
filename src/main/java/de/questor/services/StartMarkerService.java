package de.questor.services;

import de.questor.model.Module;
import de.questor.model.Quest;
import de.questor.model.QuestMarker;
import de.questor.model.StartMarker;
import de.questor.model.modules.ConfirmationModule;
import de.questor.model.modules.ModuleIn;
import de.questor.model.modules.ModuleOut;
import de.questor.repositories.QuestMarkerRepository;
import de.questor.repositories.QuestRepository;
import de.questor.repositories.modules.ConfirmationModuleRepository;
import de.questor.repositories.modules.ModuleInRepository;
import de.questor.repositories.modules.ModuleOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.questor.repositories.StartMarkerRepository;
import sun.security.pkcs11.Secmod;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartMarkerService {

    @Autowired
    private StartMarkerRepository startMarkerRepository;
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private QuestMarkerRepository questMarkerRepository;
    @Autowired
    private ConfirmationModuleRepository confirmationModuleRepository;
    @Autowired
    private ModuleInRepository moduleInRepository;
    @Autowired
    private ModuleOutRepository moduleOutRepository;

    public void test() {

        //Quests
        Quest q1 = new Quest();
        q1.setStory("Quest 1");
        //QuestMarker
        QuestMarker qm1 = new QuestMarker();
        q1.setStartPosition(qm1);
        QuestMarker qm2 = new QuestMarker();
        //Modules
        ModuleIn mIn = new ModuleIn();
        ModuleOut mOut = new ModuleOut();
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
        moduleInRepository.save(mIn);
        moduleOutRepository.save(mOut);
        questMarkerRepository.save(qm1);
        questMarkerRepository.save(qm2);
        questRepository.save(q1);
        startMarkerRepository.save(test);
    }

}
