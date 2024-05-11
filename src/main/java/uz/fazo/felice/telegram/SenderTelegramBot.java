package uz.fazo.felice.telegram;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.fazo.felice.payload.FeedBackDto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class SenderTelegramBot {

    private final TelegramBot telegramBot;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void sendContact(FeedBackDto contact) {
        executorService.submit(() -> {
            long chatId = telegramBot.getChatId();

            try {
                telegramBot.execute(new SendMessage(String.valueOf(chatId), formatContact(contact)));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }


    private String formatContact(FeedBackDto contact) {
        return "Contact" + "\n" + "\n" + "Email: " + contact.getEmail() + "\n" + "Message: " + contact.getMessage();
    }


    public void shutdown() {
        executorService.shutdown();
    }
}
