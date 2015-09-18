package net.sorted.lights.clientdomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class ClientLight {
    private Long id;
    private String name;
    private String description;
    private boolean on;


    public ClientLight(Long id, String name, String description, boolean on) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.on = on;
    }

    protected ClientLight() {

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }

    @Override
    public String toString() {
        return "ClientLight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", on=" + on +
                '}';
    }
}
