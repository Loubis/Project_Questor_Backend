package de.questor.model.modules;

import de.questor.model.Module;
import sun.security.pkcs11.Secmod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConfirmationModule extends Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String message;

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {

        return id;
    }

    public String getMessage() {
        return message;
    }
}
