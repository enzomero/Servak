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
    private String BOT_TOKEN;

    @Value(value = "${bot.username}")
    private String BOT_NAME;

    int basicLife = 20;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            updateHandler(update);
        } catch (Exception e){
            //todo warp it!
        }

        //TODO Remove
        System.out.println(update);
        if (update.hasMessage() && update.getMessage().getText().equals("/life"))
            updateHandler(update.getMessage(), "<strong>"+"YOU:"+basicLife+"</strong>");
        else if (update.hasCallbackQuery()){
            if(update.getCallbackQuery().getData().equals("-1"))
                basicLife--;
            if(update.getCallbackQuery().getData().equals("+1"))
                basicLife++;
            if(update.getCallbackQuery().getData().equals("reset"))
                basicLife=20;

            editMsg(update, "Your life is: " + basicLife);
        }
        else
        {

        }
    }

    /**
     * This method should check any upd and manage answers actions
     * @param update
     * @throws Exception
     */
    private synchronized void updateHandler(Update update) throws Exception{
        if (update.hasCallbackQuery())
            execute(editMessageCallbackQuery(update));
        if (update.hasMessage() && update.getMessage().getText().equals("/life"))
            execute(sendMessage(update));
    }

    private synchronized void editMsg(Update update, String s) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.enableHtml(true);
        editMessageText.setChatId(update.getCallbackQuery().getMessage().getChatId());
        editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        editMessageText.setText(s);
        setInline(editMessageText);
        try{
            execute(editMessageText);
            System.out.println(editMessageText);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void answerCallbackQuery(String callbackId, String message) {
        AnswerCallbackQuery answer = new AnswerCallbackQuery();
        answer.setCallbackQueryId(callbackId);
        answer.setText(message);
        answer.setShowAlert(true);
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setInline(SendMessage msg) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        //first row
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("-1").setCallbackData("-1"));
        buttons1.add(new InlineKeyboardButton().setText("+1").setCallbackData("+1"));

        //second row
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        buttons2.add(new InlineKeyboardButton().setText("Reset").setCallbackData("reset"));

        buttons.add(buttons1);
        buttons.add(buttons2);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();

        markupKeyboard.setKeyboard(buttons);
        msg.setReplyMarkup(markupKeyboard);
    }

    private void setInline(EditMessageText msg) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        //first row
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("-1").setCallbackData("-1"));
        buttons1.add(new InlineKeyboardButton().setText("+1").setCallbackData("+1"));

        //second row
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        buttons2.add(new InlineKeyboardButton().setText("Reset").setCallbackData("reset"));

        buttons.add(buttons1);
        buttons.add(buttons2);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();

        markupKeyboard.setKeyboard(buttons);
        msg.setReplyMarkup(markupKeyboard);
    }

    private synchronized  void setButtons(SendMessage msg){
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        msg.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true).setResizeKeyboard(true).setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton().setText("Ready").setRequestContact(true));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    private synchronized  void setLifeCounter(SendMessage msg){
        int lifeCounter = 20;
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        msg.setReplyMarkup(replyKeyboardMarkup);

        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow emptyRow = new KeyboardRow();
        emptyRow.add(new KeyboardButton().setText("reset"));

        // Первая строчка клавиатуры
        KeyboardRow infoRow = new KeyboardRow();
        infoRow.add(new KeyboardButton().setText("Your life is:"));
        infoRow.add(new KeyboardButton().setText("" +lifeCounter));

        KeyboardRow buttons = new KeyboardRow();
        buttons.add(new KeyboardButton().setText("+1"));
        buttons.add(new KeyboardButton().setText("-1"));

        keyboard.add(emptyRow);
        keyboard.add(infoRow);
        keyboard.add(buttons);

        replyKeyboardMarkup.setKeyboard(keyboard);

    }

    /**
     * The method for sending messages from LifeCounterBot.
     * @param update
     * @return
     */
    private SendMessage sendMessage(Update update) {
        SendMessage message = new SendMessage();
        message.enableHtml(true);
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(s);
        //setInline(message);
        return message;
    }

    /**
     * The method which will change content for messages with InlineButtons
     * @param update - status point object for telegram.
     * @return
     */
    private EditMessageText editMessageCallbackQuery(Update update) {
        return new EditMessageText();
    }

    @Override
    public String getBotUsername() {return BOT_NAME;}

    @Override
    public String getBotToken() {return BOT_TOKEN;}
}

