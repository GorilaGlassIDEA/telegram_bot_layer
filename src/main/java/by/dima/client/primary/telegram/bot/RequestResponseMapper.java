package by.dima.client.primary.telegram.bot;

import com.example.grpc.GreetingServiceOuterClass;
import com.example.grpc.TelegramBotExchangeMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RequestResponseMapper {

    static GreetingServiceOuterClass.HelloRequest getRequest(Update update) {
        return GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName(update.getMessage().getText())
                .build();
    }

    static TelegramBotExchangeMessage.UserRequest getUserRequest(Update update) {
        return TelegramBotExchangeMessage.UserRequest.newBuilder()
                .setUsername(update.getMessage().getChat().getUserName())
                .setSurname(update.getMessage().getChat().getLastName())
                .setMessage(update.getMessage().getText())
                .setTelegramId(update.getMessage().getChatId())
                .build();
    }

}
