package pl.pjatk.joawalk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfiguration {
    @Bean
    public CarPOJO carPOJO(){
        return new CarPOJO("audi", "A4",2006);
    }
    @Bean
    public List<String> defaultData(){
        return List.of("1","2");
    }
    @Bean
    public List<String>anotherDefaultData(){
        return List.of("2","1");
    }
    @Bean
    public List<CarPOJO> carPOJOS(CarPOJO carPOJO){
        return List.of(carPOJO);
    }

}
