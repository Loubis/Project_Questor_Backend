package de.questor.services;

import de.questor.model.StartMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.questor.repositories.StartMarkerRepository;

@Service
public class StartMarkerService {

    @Autowired
    private StartMarkerRepository startMarkerRepository;

    public void test() {
        StartMarker test = new StartMarker();
        test.setLatitude(1);
        test.setLongitude(1);
        startMarkerRepository.save(test);
    }

}
