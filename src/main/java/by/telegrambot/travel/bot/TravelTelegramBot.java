package by.telegrambot.travel.bot;

import by.telegrambot.travel.dto.City;
import by.telegrambot.travel.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:bot.properties")
public class TravelTelegramBot extends TelegramLongPollingBot {

    @Autowired
    private CityServiceImpl cityService;

    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String answer = messageHandler(message);
                try {
                    execute(
                            SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text(answer)
                            .build());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
        }
    }

    public String messageHandler(Message message) {
        City city = null;
        if (message.hasText()) {
            String cityName = message.getText().trim();
            city = cityService.findCity(cityName);
            if (city == null) return "Я не знаю город " + message.getText() + "!";
            return city.getMessage();
        }
        return "Введите корректное название города!";
    }

}
