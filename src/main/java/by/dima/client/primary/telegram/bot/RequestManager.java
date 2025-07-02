package by.dima.client.primary.telegram.bot;


import by.dima.client.secondary.ExchangeMessageUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
class RequestManager {

    private final ExchangeMessageUseCase exchangeMessageUseCase;


    @Autowired
    public RequestManager(
            ExchangeMessageUseCase exchangeMessageUseCase) {
        this.exchangeMessageUseCase = exchangeMessageUseCase;
    }

    String executeExchange(Update update) {
        return exchangeMessageUseCase.getAnswerFromServer(RequestResponseMapper.getUserRequest(update)).getAnswer();
    }

}
