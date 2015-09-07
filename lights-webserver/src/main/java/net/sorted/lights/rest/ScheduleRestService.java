package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.List;
import net.sorted.lights.domain.Schedule;
import net.sorted.lights.domain.ScheduleItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleRestService {

    private List<Schedule> schedules = new ArrayList();

    public ScheduleRestService() {
        List<ScheduleItem> lights1 = new ArrayList<>();
        lights1.add(new ScheduleItem("l1", 0, 3600));
        lights1.add(new ScheduleItem("l2", 0, 7200));
        lights1.add(new ScheduleItem("l3", 0, 5000));
        List<ScheduleItem> lights2 = new ArrayList<>();
        lights2.add(new ScheduleItem("l1", 0, 4000));
        lights2.add(new ScheduleItem("l2", 0, 5000));
        lights2.add(new ScheduleItem("l3", 0, 6000));
        schedules.add(new Schedule("0", "Summer", "Summer schedule", lights1));
        schedules.add(new Schedule("1", "Winter", "Winter schedule", lights2));
    }

    @RequestMapping(value = "/schedules", method = { RequestMethod.GET})
    public List<Schedule> getAllSchedules() {

        return schedules;
    }

    @RequestMapping(value = "/schedule", method = { RequestMethod.GET })
    public Schedule getSchedule(@RequestParam String id) {
        for (Schedule s : schedules) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @RequestMapping(value="/schedule", method = {RequestMethod.PUT })
    public void updateSchedule(@RequestParam Schedule schedule) {
        System.out.println("Updating schedule "+schedule.getId());
    }

    @RequestMapping(value="/schedule", method = {RequestMethod.POST })
    public void createSchedule(@RequestParam Schedule schedule) {
        System.out.println("Creating schedule "+schedule.getName());
    }


}
