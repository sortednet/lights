package net.sorted.lights.services;

import java.util.HashMap;
import java.util.Map;

public class LightServiceInMem implements LightService {

    private Map<Long, Boolean> lightIdToStatus = new HashMap<>();

    public LightServiceInMem() {

        lightIdToStatus.put(new Long(0), Boolean.FALSE);
        lightIdToStatus.put(new Long(1), Boolean.TRUE);
        lightIdToStatus.put(new Long(2), Boolean.FALSE);
        lightIdToStatus.put(new Long(3), Boolean.TRUE);
    }

    @Override
    public void switchLight(long id, boolean on) {
        lightIdToStatus.put(Long.valueOf(id), Boolean.valueOf(on));
    }

    @Override
    public boolean isOn(long id) {
        return lightIdToStatus.get(Long.valueOf(id));
    }
}
