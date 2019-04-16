package com.jonny.bots.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class LifeCounterBot extends TelegramLongPollingBot {
    @Value(value = "${bot.token}")
    private static String BOT_TOKEN;

    @Value(value = "${bot.username}")
    private static String BOT_NAME;

    private static int basicLife = 20;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            updateHandler(update);
        } catch (Exception e){
            //todo warp it!
        }
    }

    /**
     * This method should check any upd and manage answers actions
     * @param update
     * @throws Exception
     */
    private synchronized void updateHandler(Update update) throws Exception{
        if (update.hasCallbackQuery())
            execute(editMessageCallbackQuery(update)
                    .setReplyMarkup(getMarkup()));
        if (update.hasMessage() && update.getMessage().getText().equals("/life"))
            execute(sendMessage(update)
                    .setReplyMarkup(getMarkup()));
    }

    /**
     * Configured Inline UI for the message
     * @return - inline UI for current message
     */
    private InlineKeyboardMarkup getMarkup(){
        List<InlineKeyboardButton> row_buttons_1 = new ArrayList<>();
        row_buttons_1.add(new InlineKeyboardButton().setText("-1").setCallbackData("-1"));
        row_buttons_1.add(new InlineKeyboardButton().setText("+1").setCallbackData("+1"));

        List<InlineKeyboardButton> row_buttons_2 = new ArrayList<>();
        row_buttons_2.add(new InlineKeyboardButton().setText("Reset").setCallbackData("reset"));

        List<List<InlineKeyboardButton>> inline_buttons = new ArrayList<>();
        for (:
             ) {
            
        }
        inline_buttons.add(row_buttons_1);
        inline_buttons.add(row_buttons_2);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        return markupKeyboard.setKeyboard(inline_buttons);
    }

    /**
     * The method for sending messages from LifeCounterBot.
     * @param update
     * @return
     */
    private synchronized SendMessage sendMessage(Update update) {
        SendMessage message = new SendMessage();
        message.enableHtml(true);
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("<strong>"+"YOU:"+basicLife+"</strong>");
        return message;
    }

    /**
     * The method which will change content for messages with InlineButtons
     * @param update - status point object for telegram.
     * @return
     */
    private synchronized EditMessageText editMessageCallbackQuery(Update update) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.enableHtml(true);
        editMessageText.setChatId(update.getCallbackQuery().getMessage().getChatId());
        editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        lifeCounter(update.getCallbackQuery().getData());
        editMessageText.setText("<strong>"+"YOU:"+basicLife+"</strong>");
        return editMessageText;
    }

    /**
     * Life lifeCounter logic
     * @param string - data string from update with callBackQuery
     */
    private void lifeCounter(String string){
        if(string.equals("-1"))
            basicLife--;
        if(string.equals("+1"))
            basicLife++;
        if(string.equals("reset"))
            basicLife=20;
    }

    @Override
    public String getBotUsername() {return BOT_NAME;}

    @Override
    public String getBotToken() {return BOT_TOKEN;}
}

