package by.dima.client.secondary;

import by.dima.client.business.Answer;
import by.dima.client.business.ExchangeMessageProvider;
import com.example.grpc.TelegramBotExchangeMessage;
import com.example.grpc.TelegramBotServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeMessageUseCase implements ExchangeMessageProvider {
    private final TelegramBotServiceGrpc.TelegramBotServiceBlockingStub stub;

    @Autowired
    public ExchangeMessageUseCase(TelegramBotServiceGrpc.TelegramBotServiceBlockingStub stub) {
        this.stub = stub;
    }

    @Override
    public TelegramBotExchangeMessage.ClientLayerResponse getAnswerFromServer(TelegramBotExchangeMessage.UserRequest userRequest) {
        return stub.getResponse(userRequest);
    }


}
