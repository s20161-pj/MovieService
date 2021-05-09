package pl.pjatk.joawalk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PiesConfiguration {
    @Bean
    public Pies pies() {
        return new Pies("Gila", "czarny","mieszaniec",8);
    }
    @Bean
    public Pies pies2(){
        return new Pies("As","laciaty","mieszaniec",7);
    }
}
