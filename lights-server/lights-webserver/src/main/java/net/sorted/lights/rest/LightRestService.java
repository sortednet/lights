package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.List;
import net.sorted.lights.clientdomain.ClientLight;
import net.sorted.lights.domain.Light;
import net.sorted.lights.domain.Schedule;
import net.sorted.lights.repository.LightRepository;
import net.sorted.lights.repository.ScheduleRepository;
import net.sorted.lights.services.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightRestService {

    @Autowired
    private LightRepository lightRepository;

    @Autowired
    private LightService lightService;

    public LightRestService() {
    }

    @RequestMapping(value = "/lights", method = { RequestMethod.GET})
    public List<ClientLight> getLights() {

        ArrayList<ClientLight> list = new ArrayList<>();
        Iterable<Light> iter = lightRepository.findAll();
        iter.forEach((light) -> list.add(toClient(light)));
        System.out.println("Returning " + list.size() + " lights");
        return list;
    }

    @RequestMapping(value="/lights/{id}", method = {RequestMethod.PUT })
    public void updateLight(@PathVariable long id, @RequestBody ClientLight light) {
        System.out.println("Updating light " + light);

        lightService.switchLight(id, light.isOn());
        lightRepository.save(fromClient(light));
    }

    private ClientLight toClient(Light l) {
        return new ClientLight(l.getId(), l.getName(), l.getDescription(), lightService.isOn(l.getId()));
    }

    private Light fromClient(ClientLight l) {
        return new Light(l.getId(), l.getName(), l.getDescription());
    }
}
