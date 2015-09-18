package net.sorted.lights.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LightServiceArduino implements LightService {

    private Map<Long, Boolean> lightIdToStatus = new HashMap<>();

    private String rubySwitchScript; // = "/Users/dougbarthram/projects/ext/sorted/lights/lights-arduino/src/main/ruby/switch.rb";
    private String usbPort; // = "/dev/tty.usbmodem1421";

    public LightServiceArduino(String rubySwitchScript, String usbPort) {

        this.rubySwitchScript = rubySwitchScript;
        this.usbPort = usbPort;

        lightIdToStatus.put(new Long(0), Boolean.FALSE);
        lightIdToStatus.put(new Long(1), Boolean.TRUE);
        lightIdToStatus.put(new Long(2), Boolean.FALSE);
        lightIdToStatus.put(new Long(3), Boolean.TRUE);
    }

    @Override
    public void switchLight(long id, boolean on) {

        System.out.println("Switch light "+id+" to "+on);

        lightIdToStatus.put(Long.valueOf(id), Boolean.valueOf(on));
        String cmd = "ruby "+rubySwitchScript+" "+id+" "+ ((on?"1":"0") + " "+usbPort);
        executeCommand(cmd);
    }

    @Override
    public boolean isOn(long id) {
        return lightIdToStatus.get(Long.valueOf(id));
    }

    private String executeCommand(String command) {

        System.out.println("About to execute command "+command);
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
