package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import net.sorted.lights.domain.Schedule;
import net.sorted.lights.domain.ScheduleItem;
import net.sorted.lights.repository.ScheduleRepository;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
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
    //private static final Logger log = LogManager.getLogger(ScheduleRestService.class);
    private Log log = LogFactory.getLog(ScheduleRestService.class);

    @Autowired
    private ScheduleRepository scheduleRepository;

    @RequestMapping(value = "/schedules", method = { RequestMethod.GET})
    public List<Schedule> getAllSchedules() {

        ArrayList<Schedule> list = new ArrayList<>();
        System.out.println("finding all schedules");
        Iterable<Schedule> iter = scheduleRepository.findAll();
        iter.forEach((schedule) -> list.add(schedule));
        log.info("Returning " + list.size() + "schedules");
                System.out.println("Returning " + list.size() + " schedules");
        return list;
    }

    @RequestMapping(value = "/schedules/{id}", method = { RequestMethod.GET })
    public Schedule getSchedule(@PathVariable long id) {
        Schedule s = scheduleRepository.findOne(id);
        return s;
    }

    @RequestMapping(value="/schedules/{id}", method = {RequestMethod.PUT })
    public void updateSchedule(@PathVariable long id, @RequestBody Schedule schedule) {
        log.info("Updating schedule " + schedule);

        scheduleRepository.save(schedule);
    }

    @RequestMapping(value="/schedules", method = {RequestMethod.POST })
    public void createSchedule(@RequestBody Schedule schedule) {
        log.info("Creating schedule " + schedule.getName());

        scheduleRepository.save(schedule);
    }

}
