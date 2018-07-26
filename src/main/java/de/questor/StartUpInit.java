package de.questor;


import de.questor.model.Quest;
import de.questor.model.QuestMarker;
import de.questor.model.StartMarker;
import de.questor.model.modules.ConfirmationModule;
import de.questor.model.modules.InModule;
import de.questor.model.modules.OutModule;
import de.questor.repositories.QuestMarkerRepository;
import de.questor.repositories.StartMarkerRepository;
import de.questor.repositories.modules.ConfirmationModuleRepository;
import de.questor.repositories.modules.InModuleRepository;
import de.questor.repositories.modules.OutModuleRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@PropertySource(ignoreResourceNotFound = true, value = "assetspath.properties")
@Component
public class StartUpInit {
    @Value("${pathToResources}")
    String path;

    private final InModuleRepository inModuleRepository;
    private final ConfirmationModuleRepository confirmationModuleRepository;
    private final OutModuleRepository outModuleRepository;
    private final QuestMarkerRepository questMarkerRepository;
    private final StartMarkerRepository startMarkerRepository;


    @Autowired
    public StartUpInit(QuestMarkerRepository questMarkerRepository, StartMarkerRepository startMarkerRepository, InModuleRepository inModuleRepository, ConfirmationModuleRepository confirmationModuleRepository, OutModuleRepository outModuleRepository) {
        this.questMarkerRepository = questMarkerRepository;
        this.startMarkerRepository = startMarkerRepository;
        this.inModuleRepository = inModuleRepository;
        this.confirmationModuleRepository = confirmationModuleRepository;
        this.outModuleRepository = outModuleRepository;
    }

    @PostConstruct
    public void init() {
        buildMockInJava();
    }
    private void buildMockInJava() {

        // QuestMarker
        QuestMarker qm1 = new QuestMarker();
        QuestMarker qm2 = new QuestMarker();

        qm1.setLongitude(60.19179);
        qm1.setLatitude(24.96693);
        qm1.setName("QuestMarker1");
        qm1.setOriginIds(null);
        qm1.setNextMarkerIds(new ArrayList<>());
        qm1.setModules(new ArrayList<>());

        qm2.setLongitude(60.19279);
        qm2.setLatitude(24.96693);
        qm2.setName("QuestMarker2");
        qm2.setOriginIds(new ArrayList<>());
        qm2.setNextMarkerIds(null);
        qm2.setModules(new ArrayList<>());

        // Modules
        InModule inMod1 = new InModule(), inMod2 = new InModule();
        ConfirmationModule confMod1 = new ConfirmationModule(), confMod2 = new ConfirmationModule();
        OutModule outMod1 = new OutModule(), outMod2 = new OutModule();

        qm1.getModules().add(inMod1);
        qm1.getModules().add(confMod1);
        qm1.getModules().add(outMod1);

        qm2.getModules().add(inMod2);
        qm2.getModules().add(confMod2);
        qm2.getModules().add(outMod2);

        questMarkerRepository.save(qm1);
        qm2.getOriginIds().add(qm1.getId());
        questMarkerRepository.save(qm2);
        qm1.getNextMarkerIds().add(qm2.getId());
        questMarkerRepository.save(qm1);

        inMod1.setOriginId(null);
        inMod1.setFailure(confMod1);
        inMod1.setSuccess(confMod1);
        confMod1.setMessage("Please accept this!");
        confMod1.setFailure(outMod1);
        confMod1.setSuccess(outMod1);
        outMod1.setFailure(null);
        outMod1.setSuccess(null);
        outMod1.setNextMarkerId(qm2.getId());


        inMod2.setOriginId(qm1.getId());
        inMod2.setFailure(confMod2);
        inMod2.setSuccess(confMod2);
        confMod2.setMessage("Please accept this!");
        confMod2.setFailure(outMod2);
        confMod2.setSuccess(outMod2);
        outMod2.setFailure(null);
        outMod2.setSuccess(null);
        outMod2.setNextMarkerId(null);

        outModuleRepository.save(outMod1);
        outModuleRepository.save(outMod2);
        confirmationModuleRepository.save(confMod1);
        confirmationModuleRepository.save(confMod2);
        inModuleRepository.save(inMod1);
        inModuleRepository.save(inMod2);

        // Quest
        Quest quest = new Quest();
        quest.setSetting("post apocalypse");
        quest.setStory("You need to find decontaminated water.");
        quest.setRating(4);
        quest.setDuration(9.639);
        quest.setAuthor("Nancy G.");
        quest.setStartPosition(qm1);

        // Quests
        List<Quest> quests = new ArrayList<>();
        quests.add(quest);

        // StartMarker
        StartMarker sm = new StartMarker();
        sm.setLongitude(60.19079);
        sm.setLatitude(24.96693);
        sm.setName("StartMarker1");
        sm.setQuests(quests);

        startMarkerRepository.save(sm);
        System.out.println(new JSONObject(sm).toString());
    }
}
