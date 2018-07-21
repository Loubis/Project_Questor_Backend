package de.questor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestMarker extends PositionMarker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToOne
    //private List<QuestMarker> pointedFrom;
    @OneToMany(cascade = CascadeType.ALL)
    private List<QuestMarker> pointsTo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Module> modules;

    public void setPointedFrom(List<QuestMarker> pointedFrom) {
        //this.pointedFrom = pointedFrom;
    }

    public void setPointsTo(List<QuestMarker> pointsTo) {
        this.pointsTo = pointsTo;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    //public List<QuestMarker> getPointedFrom() {
        //return pointedFrom;
    //}

    public List<QuestMarker> getPointsTo() {
        return pointsTo;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
