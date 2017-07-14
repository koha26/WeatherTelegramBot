package com.bot.telegram.command;

import com.bot.telegram.util.ResoursesUtil;
import com.bot.telegram.util.enums.ErrorMessageEnum;
import com.bot.telegram.util.enums.OutInfoEnum;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.objects.Update;

import java.util.MissingResourceException;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(Update update) {
        String language = update.getMessage().getText().toLowerCase();
        String res;
        try {
            ResoursesUtil.changeLanguage(language);
        } catch (MissingResourceException e){
            res = ResoursesUtil.getName(ErrorMessageEnum.CANT_CHANGE_LANGUAGE.getName());
            return res;
        }
        res = ResoursesUtil.getName(OutInfoEnum.LANGUAGE_CHANGED.getName());
        return EmojiParser.parseToUnicode(res);
    }
}
