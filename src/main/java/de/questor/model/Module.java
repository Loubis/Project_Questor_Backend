package de.questor.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.questor.ModuleDeserializer;

import javax.persistence.*;

@JsonDeserialize(using = ModuleDeserializer.class)
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

    private String moduleType;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSuccess(Module success) {
        this.success = success;
    }

    public void setFailure(Module failure) {
        this.failure = failure;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public Integer getId() {
        return id;
    }

    public Module getSuccess() {
        return success;
    }

    public Module getFailure() {
        return failure;
    }

    public String getModuleType() {
        return moduleType;
    }
}
