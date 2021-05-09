package pl.pjatk.joawalk;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyThirdComponent {
    public MyThirdComponent(ApplicationContext applicationContext)
    {
        MyFirstComponent firstComponent = applicationContext.getBean("myFirstComponent",MyFirstComponent.class);
        MySecondComponent secondComponent = applicationContext.getBean("mySecondComponent",MySecondComponent.class);
        //System.out.println("Hello from MyThirdComponent");
        //System.out.println(mySimpleClass.getName());
    }
}