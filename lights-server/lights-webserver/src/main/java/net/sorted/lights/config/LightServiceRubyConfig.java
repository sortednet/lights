package net.sorted.lights.config;

import net.sorted.lights.services.LightService;
import net.sorted.lights.services.LightServiceArduino;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(locations="classpath:lightservice.properties", prefix="lightservice.ruby", ignoreUnknownFields = false)
public class LightServiceRubyConfig {

    private String switchScriptPath;
    private String usb;

    public void setSwitchScriptPath(String switchScriptPath) {
        this.switchScriptPath = switchScriptPath;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    @Bean
    public LightService lightService() {
        return new LightServiceArduino(switchScriptPath, usb);
    }
}
