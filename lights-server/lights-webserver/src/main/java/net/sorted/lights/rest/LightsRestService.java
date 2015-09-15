package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.List;
import net.sorted.lights.domain.Light;
import net.sorted.lights.domain.Schedule;
import net.sorted.lights.repository.LightRepository;
import net.sorted.lights.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightsRestService {

    @Autowired
    private LightRepository lightRepository;

    public LightsRestService() {
    }

    @RequestMapping(value = "/lights", method = { RequestMethod.GET})
    public List<Light> getLights() {

        //return lightRepository.findAll();
        ArrayList<Light> list = new ArrayList<>();
        Iterable<Light> iter = lightRepository.findAll();
        iter.forEach((light) -> list.add(light));
//        System.out.println("Found " + list.size() + " lights");
//        for (Light light : list) {
//            System.out.println("Light " + light.getName() + " has " + light.getLights().size() + " items");
//        }
        return list;

    }

    @RequestMapping(value = "/lights", method = { RequestMethod.PUT})
    public void switchLight(@RequestParam String name, boolean on) {

        System.out.println("Turn light " + name + " to " + ((on) ? "on" : "off"));
    }

}
