package net.sorted.lights.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public ScheduleItem() {

    }

    public ScheduleItem(long id, int wait, int onForSeconds) {
        this.id = id;
        this.wait = wait;
        this.onForSeconds = onForSeconds;
    }

    public long getId() {
        return id;
    }

    public int getWait() {
        return wait;
    }

    public int getOnForSeconds() {
        return onForSeconds;
    }
}
