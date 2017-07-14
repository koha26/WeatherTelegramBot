package com.bot.telegram.command;

import org.telegram.telegrambots.api.objects.Update;

import static com.bot.telegram.util.ForecastUtil.EOL;

public class StartCommand implements Command {
    @Override
    public String execute(Update update) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hello!").append(EOL)
                .append("/weather current forecast").append(EOL)
                .append("/weather7 forecast for the next week").append(EOL)
                .append("/weather2 forecast for the next two days").append(EOL)
                .append(EOL)
                .append("After pushing tag you should type <city name> of <latitude and longitude>.").append(EOL)
                .append("Have a nice day and excellent weather.").append(EOL).append(EOL)
                .append("Best regards, @KohaBot");
        return sb.toString();
    }
}
