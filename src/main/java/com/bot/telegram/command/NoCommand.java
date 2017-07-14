package com.bot.telegram.command;

import org.telegram.telegrambots.api.objects.Update;

public class NoCommand implements Command {
    @Override
    public String execute(Update update) {
        return null;
    }
}
