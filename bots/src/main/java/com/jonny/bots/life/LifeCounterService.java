package com.jonny.bots.life;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 *
 */
@Component
public class LifeCounterService {
    public void updateHandler(Update update){
        if (update.hasCallbackQuery())
            editMessageCallbackQuery(update);
        if (update.hasMessage() && update.getMessage().getText().equals("/life"))
            sendMessage(update);
    }



}
