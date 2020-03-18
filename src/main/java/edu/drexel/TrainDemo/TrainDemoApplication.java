package edu.drexel.TrainDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TrainDemoApplication implements WebMvcConfigurer{
    public static void main(String[] args) {
        SpringApplication.run(TrainDemoApplication.class, args);
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatter(new PathFormatter());
    }
}
