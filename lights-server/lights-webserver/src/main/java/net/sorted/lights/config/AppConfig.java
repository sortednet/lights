package net.sorted.lights.config;

import net.sorted.lights.services.LightService;
import net.sorted.lights.services.LightServiceInMem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public LightService lightService() {
        return new LightServiceInMem();
    }
}
