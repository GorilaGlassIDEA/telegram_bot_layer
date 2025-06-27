package by.dima.client.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingFacade {

    private final GreetingProvider greetingProvider;

    @Autowired
    public GreetingFacade(GreetingProvider greetingProvider) {
        this.greetingProvider = greetingProvider;
    }

    public String getGreet(String name) {
        return greetingProvider.greeting(name);
    }
}
