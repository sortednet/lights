package net.sorted.lights.services;


public interface LightService {
    void switchLight(long id, boolean on);
    boolean isOn(long id);
}
