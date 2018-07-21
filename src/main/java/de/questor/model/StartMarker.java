package de.questor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class StartMarker extends PositionMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Quest> quests;

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public List<Quest> getQuests() {

        return quests;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
