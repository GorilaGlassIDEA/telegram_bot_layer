package by.dima.client.business;

import lombok.Data;

@Data
public class Answer {
    private String username;
    private String surname;
    private String message;
    private Integer telegramId;
}
