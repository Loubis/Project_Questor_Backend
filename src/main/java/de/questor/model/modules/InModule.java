package de.questor.model.modules;

import com.fasterxml.jackson.annotation.*;
import de.questor.model.Module;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;

@Entity
@JsonTypeName("IN")
public class InModule extends Module {

    @JsonCreator
    public InModule(@JsonProperty("originId") Integer originId, @JsonProperty("success")Module success, @JsonProperty("failure") Module failure) {
        setOriginId(originId);
        setSuccess(success);
        setFailure(failure);
    }

    @JsonCreator
    public InModule() {}

    @JsonProperty(value = "originId")
    private Integer originId;

    @JsonSetter
    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    @JsonGetter
    public Integer getOriginId() {
        return originId;
    }
}
