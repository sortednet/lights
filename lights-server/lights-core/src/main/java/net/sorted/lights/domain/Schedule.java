package net.sorted.lights.domain;


import java.util.ArrayList;
import java.util.List;
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
public class Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="schedule_seq")
    @SequenceGenerator(name="schedule_seq", sequenceName="schedule_seq", allocationSize=1)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @OneToMany
    @JoinColumn(name="SCHEDULE_ID")
    private List<ScheduleItem> lights;

    public Schedule(long id, String name, String description, List<ScheduleItem> lights) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lights = lights;
    }

    public Schedule(long id, String name, String description) {
        this(id, name, description, new ArrayList<ScheduleItem>());
    }

    protected Schedule() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ScheduleItem> getLights() {
        return lights;
    }
}
