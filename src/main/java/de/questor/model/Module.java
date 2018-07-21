package de.questor.model;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name="REF_TYPE")
public abstract class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Module success;
    @OneToOne(cascade = CascadeType.ALL)
    private Module failure;

    public void setSuccess(Module success) {
        this.success = success;
    }

    public void setFailure(Module failure) {
        this.failure = failure;
    }

    public Module getSuccess() {

        return success;
    }

    public Module getFailure() {
        return failure;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }
}
