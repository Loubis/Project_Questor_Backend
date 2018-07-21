package de.questor.services;

import de.questor.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.questor.repositories.TestRepo;

@Service
public class TestService {

    @Autowired
    private TestRepo testRepo;

    public void test() {
        Test test = new Test();
        test.setName("testObject");
        testRepo.save(test);
    }

}
