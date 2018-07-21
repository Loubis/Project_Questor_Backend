package de.questor.model.modules;

import de.questor.model.Module;

import javax.persistence.Entity;
@Entity
public class ConfirmationModule extends Module {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
