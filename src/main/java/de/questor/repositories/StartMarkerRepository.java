package de.questor.repositories;

import de.questor.model.StartMarker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartMarkerRepository extends CrudRepository<StartMarker, Integer> {
}
