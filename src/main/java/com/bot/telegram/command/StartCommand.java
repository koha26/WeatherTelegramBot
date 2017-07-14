package com.bot.telegram.command;

import com.bot.telegram.util.ResoursesUtil;
import com.bot.telegram.util.enums.OutInfoEnum;
import org.telegram.telegrambots.api.objects.Update;

public class StartCommand implements Command {
    @Override
    public String execute(Update update) {
        StringBuffer sb = new StringBuffer();
        sb.append(ResoursesUtil.getName(OutInfoEnum.START_MENU.getName()));
        return sb.toString();
    }
}
