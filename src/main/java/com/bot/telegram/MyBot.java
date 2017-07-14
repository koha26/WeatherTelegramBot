package com.bot.telegram;

import com.bot.telegram.command.*;
import com.bot.telegram.controller.CommandController;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

public class MyBot extends TelegramLongPollingBot {

    private CommandController controller;

    public MyBot() {
        Map<String, Command> commands = new HashMap<>();
        commands.put(CommandEnum.WEATHER.getName(), new CurrentWeatherCommand());
        commands.put(CommandEnum.WEATHER_7.getName(), new DailyWeatherCommand());
        commands.put(CommandEnum.WEATHER_2.getName(), new HourlyWeatherCommand());
        commands.put(CommandEnum.START.getName(), new StartCommand());

        controller = new CommandController(new CommandContainer(commands));
    }

    private Logger logger = org.apache.log4j.Logger.getLogger(MyBot.class);
    /**
     * A map chat id -> handling command
     */
    public Map<Long, CommandEnum> commandInChats = new HashMap<>();

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();

            long chatId = update.getMessage().getChatId();
            if (messageText.equalsIgnoreCase(CommandEnum.WEATHER.getName())) {
                commandInChats.put(chatId, CommandEnum.WEATHER);

                String resp = "Enter <city name> or <latitude longitude>";
                sendResponse(chatId, resp);
                return;
            } else if (messageText.equalsIgnoreCase(CommandEnum.START.getName())) {
                commandInChats.put(chatId, CommandEnum.START);

            } else if (messageText.equalsIgnoreCase(CommandEnum.WEATHER_7.getName())) {
                commandInChats.put(chatId, CommandEnum.WEATHER_7);

                String resp = "Enter <city name> or <latitude longitude>";
                sendResponse(chatId, resp);
                return;
            } else if (messageText.equalsIgnoreCase(CommandEnum.WEATHER_2.getName())) {
                commandInChats.put(chatId, CommandEnum.WEATHER_2);

                String resp = "Enter <city name> or <latitude longitude>";
                sendResponse(chatId, resp);
                return;
            }
            handle(chatId, update);
        }
    }

    private void handle(long chatId, Update update) {
        if (commandInChats.containsKey(chatId)) {
            String res = controller.getCommand(commandInChats.get(chatId).getName()).execute(update);
            sendResponse(chatId, res);
        }
    }

    private void sendResponse(long chatId, String text) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(text);
        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            logger.error("Can't send response.", e);
        }
    }

    public String getBotUsername() {
        return "KohaBot";
    }

    public String getBotToken() {
        return "404589372:AAHxedt0WS-2EqMBBlL9bhSNArJKFeqMzXs";
    }
}
