package by.dima.client.primary.telegram.bot;

import by.dima.client.business.GreetingProvider;
import by.dima.client.secondary.ExchangeMessageUseCase;
import com.example.grpc.GreetingServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
class RequestManager {

    private final GreetingProvider<GreetingServiceOuterClass.HelloRequest> greetingUseCase;
    private final ExchangeMessageUseCase exchangeMessageUseCase;


    @Autowired
    public RequestManager(
            GreetingProvider<GreetingServiceOuterClass.HelloRequest> greetingUseCase
            , ExchangeMessageUseCase exchangeMessageUseCase) {
        this.greetingUseCase = greetingUseCase;
        this.exchangeMessageUseCase = exchangeMessageUseCase;
    }

    String execute(Update update) {
        return greetingUseCase.greeting(RequestResponseMapper.getRequest(update));
    }

    String executeExchange(Update update) {
        return exchangeMessageUseCase.getAnswerFromServer(RequestResponseMapper.getUserRequest(update)).getAnswer();
    }

}
