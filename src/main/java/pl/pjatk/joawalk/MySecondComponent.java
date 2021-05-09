package pl.pjatk.joawalk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MySecondComponent {
    public MySecondComponent(@Value("${my.custom.random: default value}") String randomValueFromProperties) {
        System.out.println("Hello from MySecondComponent");
        System.out.println(randomValueFromProperties);
    }

    public void helloFromMethod() {
        System.out.println("Second-method");
    }
}
