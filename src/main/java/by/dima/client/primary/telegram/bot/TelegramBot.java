package by.dima.client.primary.telegram.bot;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    @Deprecated
    public TelegramBot(@Qualifier("token") String token,
                       @Qualifier("username") String username) {
        super(token);
        this.username = username;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Пришло сообщеие от телеграм бота от пользователя: "+update.getMessage().getChat().getFirstName());
    }

}
