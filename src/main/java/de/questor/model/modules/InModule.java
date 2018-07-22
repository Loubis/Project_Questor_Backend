package de.questor.model.modules;

import de.questor.model.Module;

import javax.persistence.Entity;

@Entity
public class InModule extends Module {

    private Integer originId;

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }
}
