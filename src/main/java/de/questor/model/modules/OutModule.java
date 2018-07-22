package de.questor.model.modules;

import de.questor.model.Module;

import javax.persistence.Entity;

@Entity
public class OutModule extends Module {

    private Integer nextMarkerId;

    public void setNextMarkerId(Integer nextMarkerId) {
        this.nextMarkerId = nextMarkerId;
    }

    public Integer getNextMarkerId() {
        return nextMarkerId;
    }
}
