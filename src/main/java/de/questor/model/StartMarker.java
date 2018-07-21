package de.questor.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class StartMarker extends PositionMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
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

    public int getId() {
        return id;
    }
}
