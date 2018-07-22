package de.questor.model.modules;

import com.fasterxml.jackson.annotation.*;
import de.questor.model.Module;

import javax.persistence.Entity;
@Entity
@JsonTypeName("CONFIRMATION")
public class ConfirmationModule extends Module {

    @JsonCreator
    public ConfirmationModule(@JsonProperty("message") String message, @JsonProperty("success")Module success, @JsonProperty("failure") Module failure) {
        setMessage(message);
        setSuccess(success);
        setFailure(failure);
    }

    @JsonCreator
    public ConfirmationModule() {}

    @JsonProperty("message")
    private String message;

    @JsonSetter()
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonGetter
    public String getMessage() {
        return message;
    }
}
