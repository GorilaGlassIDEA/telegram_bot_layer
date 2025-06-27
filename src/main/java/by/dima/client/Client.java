package by.dima.client;

import by.dima.client.business.GreetingFacade;
import by.dima.client.x.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Client {
    public static void main(String[] args) {
        SpringApplication.run(Client.class);
//        ApplicationContext applicationContext = new Context(SpringConfig.class);
//        GreetingFacade facade = applicationContext.getBean("greetingFacade", GreetingFacade.class);
//        System.out.println(facade.getGreet("Dima"));
    }
}
