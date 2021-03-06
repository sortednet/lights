package net.sorted.lights.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="light")
public class Light {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="light_seq")
    @SequenceGenerator(name="light_seq", sequenceName="light_seq", allocationSize=1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;


    public Light(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    protected Light() {

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

    @Override
    public String toString() {
        return "Light{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
