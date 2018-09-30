package nl.knmi.geoweb.converters.application;

import nl.knmi.geoweb.converters.service.JsonService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ConverterController {

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

}