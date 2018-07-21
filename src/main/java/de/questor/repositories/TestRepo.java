package de.questor.repositories;

import de.questor.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends CrudRepository<Test, Integer> {
}
