package com.example.lab7_8.configs;

import com.example.lab7_8.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.example.lab7_8")
@EnableWebMvc
public class Config implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;
    @Autowired
    public Config (ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
@Bean
    public Film firstFilm(){
        return new Film("Mirror","Tarkovsky","Good film","132132",130);
}
@Bean
    public Film secondFilm(){
        return new Film("Fantasic Mr Fox","Wes Anderson","Very good film","039209", 135);
}

@Bean
    public Film thirdFilm(){
        return new Film("Little women","Greta Gerwig","Nice acting","875949854", 90);
}


}
