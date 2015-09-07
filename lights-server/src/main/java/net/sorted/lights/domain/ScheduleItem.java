package net.sorted.lights.domain;

public class ScheduleItem {
    private String id;
    private int wait;
    private int onForSeconds;

    public ScheduleItem(String id, int wait, int onForSeconds) {
        this.id = id;
        this.wait = wait;
        this.onForSeconds = onForSeconds;
    }

    public String getId() {
        return id;
    }

    public int getWait() {
        return wait;
    }

    public int getOnForSeconds() {
        return onForSeconds;
    }
}
