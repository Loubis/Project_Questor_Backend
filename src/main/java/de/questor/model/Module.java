package de.questor.model;

import javax.persistence.Embeddable;

@Embeddable
public abstract class Module {

    private Module success;
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
}
