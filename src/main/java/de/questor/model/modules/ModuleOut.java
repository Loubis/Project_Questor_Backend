package de.questor.model.modules;

import de.questor.model.Module;
import de.questor.model.QuestMarker;

import javax.persistence.*;

@Entity
public class ModuleOut extends Module {

    @OneToOne(cascade = CascadeType.ALL)
    private QuestMarker pointsTo;

    public void setPointsTo(QuestMarker pointsTo) {
        this.pointsTo = pointsTo;
    }

    public QuestMarker getPointsTo() {

        return pointsTo;
    }
}
