package net.sorted.lights.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="schedule_item")
public class ScheduleItem {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="schedule_item_seq")
    @SequenceGenerator(name="schedule_item_seq", sequenceName="schedule_item_seq", allocationSize=1)
    private Long id;

    @Column(name="WAIT")
    private int wait;

    @Column(name="ONFORSECONDS")
    private int onForSeconds;

    @ManyToOne(optional=false)
    @JoinColumn(name="LIGHT_ID", nullable=false)
    private Light light;

    @Column(name="SCHEDULE_ID")
    private Long scheduleId;

    public ScheduleItem() {

    }

    public ScheduleItem(Long id, int wait, int onForSeconds, Long scheduleId) {
        this.id = id;
        this.wait = wait;
        this.onForSeconds = onForSeconds;
        this.scheduleId = scheduleId;
    }

    public Long getId() {
        return id;
    }

    public int getWait() {
        return wait;
    }

    public int getOnForSeconds() {
        return onForSeconds;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public Light getLight() {
        return light;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id=" + id +
                ", wait=" + wait +
                ", onForSeconds=" + onForSeconds +
                ", light=" + light +
                ", scheduleId=" + scheduleId +
                '}';
    }
}
