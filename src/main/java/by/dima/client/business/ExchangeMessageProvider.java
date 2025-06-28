package by.dima.client.business;


import com.example.grpc.TelegramBotExchangeMessage;

public interface ExchangeMessageProvider {
    TelegramBotExchangeMessage.ClientLayerResponse getAnswerFromServer(TelegramBotExchangeMessage.UserRequest userRequest);
}
