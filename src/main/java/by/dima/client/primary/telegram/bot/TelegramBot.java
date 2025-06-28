package by.dima.client.primary.telegram.bot;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("classpath:application.properties")
@Getter
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final String username;
    private final RequestManager requestManager;

    @Autowired
    @Deprecated
    public TelegramBot(@Qualifier("token") String token,
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
    }

}
