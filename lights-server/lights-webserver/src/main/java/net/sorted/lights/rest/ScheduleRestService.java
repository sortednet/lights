package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import net.sorted.lights.domain.Schedule;
import net.sorted.lights.domain.ScheduleItem;
import net.sorted.lights.repository.ScheduleRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(maxAge=3600)
@RestController
public class ScheduleRestService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @RequestMapping(value = "/schedules", method = { RequestMethod.GET})
    public List<Schedule> getAllSchedules() {

        ArrayList<Schedule> list = new ArrayList<>();
        Iterable<Schedule> iter = scheduleRepository.findAll();
        iter.forEach((schedule) -> list.add(schedule));
        return list;
    }

    @RequestMapping(value = "/schedules/{id}", method = { RequestMethod.GET })
    public Schedule getSchedule(@PathVariable long id) {
        return scheduleRepository.findOne(id);
    }

    @RequestMapping(value="/schedules/{id}", method = {RequestMethod.PUT })
    public void updateSchedule(@PathVariable long id, @RequestBody Schedule schedule) {
        System.out.println("Updating schedule " + schedule.getId());

        for (ScheduleItem item : schedule.getLights()) {
            if (item.getId() < 0) {

            }
        }

        scheduleRepository.save(schedule);
    }

    @RequestMapping(value="/schedules", method = {RequestMethod.POST })
    @ResponseBody
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        System.out.println("Creating schedule "+schedule.getName());

        return schedule;
    }

}
