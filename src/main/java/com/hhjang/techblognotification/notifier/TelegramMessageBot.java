package com.hhjang.techblognotification.notifier;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramMessageBot extends TelegramLongPollingBot {
    private final String AUTH_KEY = "auth_key 입력";
    private final String BOT_NAME = "bot name 입력";

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return AUTH_KEY;
    }

    public void notifyMessage(String msg) {
        SendMessage sendMessage = new SendMessage()
                .setChatId("채팅방번호 입력")                         // 채팅방 번호, 봇을 그룹에 초대한 후 채팅번호 따서 보내면된다.
                .setText(msg);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
