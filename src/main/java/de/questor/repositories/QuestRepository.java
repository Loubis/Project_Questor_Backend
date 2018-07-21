package de.questor.repositories;

import de.questor.model.Quest;
import org.springframework.data.repository.CrudRepository;

public interface QuestRepository extends CrudRepository<Quest, Integer> {
}
