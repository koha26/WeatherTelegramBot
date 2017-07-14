package com.bot.telegram.command;

import org.telegram.telegrambots.api.objects.Update;

public interface Command {
    String execute(Update update);
}
