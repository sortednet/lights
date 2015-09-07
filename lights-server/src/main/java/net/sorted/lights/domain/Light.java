package net.sorted.lights.domain;


public class Light {
    private String name;
    private boolean on;

    public Light(String name, boolean on) {
        this.name = name;
        this.on = on;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return on;
    }
}
