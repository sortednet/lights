package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.List;
import net.sorted.lights.domain.Light;
import net.sorted.lights.domain.Schedule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightsRestService {

    private List<Light> lights = new ArrayList();

    public LightsRestService() {
        lights.add(new Light("l1", true));
        lights.add(new Light("l2", true));
        lights.add(new Light("l3", false));
        lights.add(new Light("l4", true));
    }

    @RequestMapping(value = "/lights", method = { RequestMethod.GET})
    public List<Light> getLights() {

        return lights;
    }

    @RequestMapping(value = "/lights", method = { RequestMethod.PUT})
    public void switchLight(@RequestParam String name, boolean on) {

        System.out.println("Turn light " + name + " to " + ((on) ? "on" : "off"));
    }

}
