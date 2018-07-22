package de.questor.model.modules;

import com.fasterxml.jackson.annotation.*;
import de.questor.model.Module;

import javax.persistence.Entity;

@Entity
@JsonTypeName("OUT")
public class OutModule extends Module {

    @JsonCreator
    public OutModule(@JsonProperty("originId") Integer nextMarkerId, @JsonProperty("success") Module success, @JsonProperty("failure") Module failure) {
        setNextMarkerId(nextMarkerId);
        setSuccess(success);
        setFailure(failure);
    }

    @JsonCreator
    public OutModule() {}

    @JsonProperty(value = "nextMarkerId")
    private Integer nextMarkerId;

    @JsonSetter
    public void setNextMarkerId(Integer nextMarkerId) {
        this.nextMarkerId = nextMarkerId;
    }

    @JsonGetter
    public Integer getNextMarkerId() {
        return nextMarkerId;
    }
}
