package net.sorted.lights.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="schedule_seq")
    @SequenceGenerator(name="schedule_seq", sequenceName="schedule_seq", allocationSize=1)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="SCHEDULE_ID")
    private List<ScheduleItem> items;

    public Schedule(Long id, String name, String description, List<ScheduleItem> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = items;
    }

    public Schedule(Long id, String name, String description) {
        this(id, name, description, new ArrayList<ScheduleItem>());
    }

    protected Schedule() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ScheduleItem> getItems() {
        return items;
    }
}
