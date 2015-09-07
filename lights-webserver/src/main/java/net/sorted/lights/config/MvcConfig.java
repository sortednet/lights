package net.sorted.lights.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MvcConfig {

}

//@Configuration
//@ComponentScan(basePackages = {"net.sorted"})
//@EnableWebMvc
//public class MvcConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(  "/**")
//                .addResourceLocations("/");
//    }
//}
