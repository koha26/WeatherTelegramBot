package com.bot.telegram.controller;

import com.bot.telegram.command.Command;
import com.bot.telegram.command.CommandContainer;

public class CommandController {
    private CommandContainer container;

    public CommandController(CommandContainer container) {
        this.container = container;
    }

    public Command getCommand(String name){
        return container.getCommand(name);
    }
}
