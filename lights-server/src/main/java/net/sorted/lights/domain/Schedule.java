package net.sorted.lights.domain;


import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String id;
    private String name;
    private String description;
    private List<ScheduleItem> lights;

    public Schedule(String id, String name, String description, List<ScheduleItem> lights) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lights = lights;
    }

    public Schedule(String id, String name, String description) {
        this(id, name, description, new ArrayList<ScheduleItem>());
    }

    public String getId() {
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
