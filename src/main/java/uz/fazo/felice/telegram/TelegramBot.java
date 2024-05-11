/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uz.fazo.felice.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.bot.chatId}")
    private Long chatId;

    @Value("${telegram.bot.username}")
    private String username;


    public Long getChatId() {
        return chatId;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Handle incoming updates if needed
    }

    @Override
    public String getBotUsername() {
        return username; // Replace with your bot's username
    }

    @Override
    public String getBotToken() {
        return token; // Replace with the token obtained from BotFather
    }

}