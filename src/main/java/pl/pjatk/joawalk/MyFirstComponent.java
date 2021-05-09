package pl.pjatk.joawalk;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyFirstComponent {
    public MyFirstComponent(MySecondComponent mySecondComponent,
                            CustomProperties properties,
                            CarPOJO carPOJO,
                            List<String> defaultData,
                            List<String>anotherDefaultData,
                            List<CarPOJO>carPOJOS,
                            Pies pies,
                            Pies pies2

    ){
        //System.out.println("Hello from MyFirstComponent");
        //mySecondComponent.helloFromMethod();
        //carPOJO.print();
        //System.out.println(defaultData);
        //System.out.println(anotherDefaultData);
        //System.out.println(carPOJOS);
        System.out.println(properties.getProperty());
        System.out.println(pies.getImie());
        System.out.println(pies2.getImie());
    }
}

