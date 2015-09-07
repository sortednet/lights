package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.sorted.lights.domain.Schedule;
import net.sorted.lights.domain.ScheduleItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(maxAge=3600)
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

    @RequestMapping(value = "/schedules/{id}", method = { RequestMethod.GET })
    public Schedule getSchedule(@PathVariable String id) {
        Optional<Schedule> o = findSchedule(id);
        if (o.isPresent()) {
            return o.get();
        } else {
            return null;
        }
    }

    @RequestMapping(value="/schedules/{id}", method = {RequestMethod.PUT })
    public void updateSchedule(@PathVariable String id, @RequestBody Schedule schedule) {
        System.out.println("Updating schedule "+schedule.getId());
        for (int i=0; i<schedules.size(); i++) {
            Schedule s = schedules.get(i);
            if (s.getId().equals(id)) {
                schedules.set(i, schedule);
                break;
            }
        }
    }

    @RequestMapping(value="/schedules", method = {RequestMethod.POST })
    @ResponseBody
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        System.out.println("Creating schedule "+schedule.getName());

        return schedule;
    }


    private Optional<Schedule> findSchedule(String id) {
        for (Schedule s : schedules) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}
