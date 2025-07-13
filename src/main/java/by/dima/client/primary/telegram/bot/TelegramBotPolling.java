package by.dima.client.primary.telegram.bot;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:application.properties")
@Getter
@Slf4j
public class TelegramBotPolling extends TelegramLongPollingBot {

    private final String username;
    private final RequestManager requestManager;

    @Autowired
    @Deprecated
    public TelegramBotPolling(@Qualifier("token") String token,
                              @Qualifier("username") String username,
                              RequestManager requestManager) {
        super(token);
        this.username = username;
        this.requestManager = requestManager;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Пришло сообщение от пользователя: " + update.getMessage().getChat().getFirstName());
        System.out.println(requestManager.executeExchange(update));
        SendMessage sendMessage = new SendMessage(String.valueOf(update.getMessage().getChatId()),requestManager.executeExchange(update));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.warn("Ошибка api телеграм бота!");
        }
    }

}
