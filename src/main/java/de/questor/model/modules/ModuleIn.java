package de.questor.model.modules;

import de.questor.model.Module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModuleIn extends Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
