package de.questor.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import de.questor.ModuleDeserializer;
import de.questor.model.modules.ConfirmationModule;
import de.questor.model.modules.InModule;
import de.questor.model.modules.OutModule;

import javax.persistence.*;

//@JsonDeserialize(using = ModuleDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InModule.class, name = "IN"),
        @JsonSubTypes.Type(value = ConfirmationModule.class, name = "CONFIRMATION"),
        @JsonSubTypes.Type(value = OutModule.class, name = "OUT")})
@Entity
@DiscriminatorColumn(name="REF_TYPE")
public abstract class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Module success;
    @OneToOne(cascade = CascadeType.ALL)
    private Module failure;

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonSetter
    public void setSuccess(Module success) {
        this.success = success;
    }

    @JsonSetter
    public void setFailure(Module failure) {
        this.failure = failure;
    }

    public Integer getId() {
        return id;
    }

    @JsonGetter
    public Module getSuccess() {
        return success;
    }

    @JsonGetter
    public Module getFailure() {
        return failure;
    }
}
