package nl.knmi.geoweb.converters.application;

import fi.fmi.avi.converter.AviMessageConverter;
import fi.fmi.avi.converter.AviMessageSpecificConverter;
import fi.fmi.avi.model.taf.TAF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nl.knmi.geoweb.converters.json.JsonService;
import nl.knmi.geoweb.converters.json.configuration.JsonConverter;

@Configuration
@Import(JsonConverter.class)
@EnableWebMvc
public class ConverterApplicationContext implements WebMvcConfigurer {

  @Autowired
  @Qualifier("fmiTafJsonStringSerializer")
  private AviMessageSpecificConverter<TAF, String> fmiTafJsonStringSerializer;
  
  @Autowired
  @Qualifier("fmiTafJsonStringParser")
  private AviMessageSpecificConverter<String, TAF> fmiTafJsonStringParser;

  @Bean
  public JsonService jsonService() {
    return new JsonService();
  }

  @Bean
  public AviMessageConverter aviMessageConverter() {
    AviMessageConverter aMessConv = new AviMessageConverter();
    aMessConv.setMessageSpecificConverter(JsonConverter.TAF_FMI_POJO_TO_JSON_STRING, fmiTafJsonStringSerializer);
    aMessConv.setMessageSpecificConverter(JsonConverter.TAF_JSON_STRING_TO_FMI_POJO, fmiTafJsonStringParser);
    return aMessConv;
  }
}