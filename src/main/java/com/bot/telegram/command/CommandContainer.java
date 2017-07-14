package com.bot.telegram.command;

import java.util.Map;

public class CommandContainer {
    private Map<String, Command> commands;
    private Command noCommand;

    public CommandContainer(Map<String, Command> commands) {
        noCommand = new NoCommand();
        this.commands = commands;
    }

    public Command getCommand(String commandName){
        if (!commands.containsKey(commandName)){
            return noCommand;
        }
        return commands.get(commandName);
    }
}
