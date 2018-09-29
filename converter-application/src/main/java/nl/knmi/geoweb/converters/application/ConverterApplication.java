package nl.knmi.geoweb.converters.application;

import nl.knmi.geoweb.converters.service.JsonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "nl.knmi.geoweb.converters")
@RestController
public class ConverterApplication {

    private final JsonService jsonService;

    public ConverterApplication(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @GetMapping("/")
    public String home() {
        return jsonService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConverterApplication.class, args);
    }

}
