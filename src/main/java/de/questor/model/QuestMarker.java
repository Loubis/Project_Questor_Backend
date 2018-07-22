package de.questor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestMarker extends PositionMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private List<Integer> originIds;
    @ElementCollection
    private List<Integer> nextMarkerIds;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.ALL})
    private List<Module> modules;

    public void setId(int id) {
        this.id = id;
    }

    public void setOriginIds(List<Integer> originIds) {
        this.originIds = originIds;
    }

    public void setNextMarkerIds(List<Integer> nextMarkerIds) {
        this.nextMarkerIds = nextMarkerIds;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getOriginIds() {
        return originIds;
    }

    public List<Integer> getNextMarkerIds() {
        return nextMarkerIds;
    }

    public List<Module> getModules() {
        return modules;
    }
}
