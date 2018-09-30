package nl.knmi.geoweb.converters.application;

import nl.knmi.geoweb.converters.service.JsonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ConverterController {

  @Autowired
  ResourceLoader resourceLoader;

  @Autowired
  JsonService jsonService;

  @RequestMapping("/")
  public String index() {
    return jsonService.message();
  }

  @RequestMapping("/json")
  public String json() {
    try {
      InputStream json = resourceLoader.getResource("classpath:data/employees.dat").getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(json));
      String result = reader.lines()
        .collect(Collectors.joining("\n"));
      return result;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return "Couldn\'t load json file!";
	  }
  }

}