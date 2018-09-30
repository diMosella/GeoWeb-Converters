package nl.knmi.geoweb.converters.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nl.knmi.geoweb.converters.service.JsonService;

@Configuration
@EnableWebMvc
public class ConverterApplicationContext implements WebMvcConfigurer {

  @Bean
  public JsonService jsonService() {
    return new JsonService();
  }
}