package de.questor.repositories;

import de.questor.model.QuestMarker;
import org.springframework.data.repository.CrudRepository;

public interface QuestMarkerRepository extends CrudRepository<QuestMarker, Integer> {
}
