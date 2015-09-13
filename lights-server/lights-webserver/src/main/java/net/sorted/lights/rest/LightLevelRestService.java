package net.sorted.lights.rest;

import java.util.ArrayList;
import java.util.List;
import net.sorted.lights.domain.Light;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightLevelRestService {

    @RequestMapping(value = "/lightLevel", method = { RequestMethod.GET})
    public Integer getLightLevel() {
        return 10;
    }
}
