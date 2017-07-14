package com.bot.telegram.command;

import com.bot.telegram.setting.InfoMessages;
import com.bot.telegram.util.ForecastUtil;
import com.bot.telegram.util.ResoursesUtil;
import com.bot.telegram.util.enums.ErrorMessageEnum;
import com.google.maps.model.LatLng;
import com.vdurmont.emoji.EmojiParser;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.objects.Update;
import tk.plogitech.darksky.api.jackson.DarkSkyJacksonClient;
import tk.plogitech.darksky.forecast.*;
import tk.plogitech.darksky.forecast.model.Forecast;

import static com.bot.telegram.util.MapUtil.getCoordinatesName;
import static com.bot.telegram.util.MapUtil.getGeoCodeFromInput;
import static com.bot.telegram.setting.Settings.getDarkSkyApiKey;

public class DailyWeatherCommand implements Command {
    private Logger logger = org.apache.log4j.Logger.getLogger(DailyWeatherCommand.class);

    public String execute(Update update) {
        String input = update.getMessage().getText();
        LatLng latLng = getGeoCodeFromInput(input);
        if (latLng == null){
            return ResoursesUtil.getName(ErrorMessageEnum.CANT_OBTAIN_GEOLOCATION.getName());
        }

        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey(getDarkSkyApiKey()))
                .language(ForecastRequestBuilder.Language.en)
                .location(new GeoCoordinates(new Longitude(latLng.lng), new Latitude(latLng.lat))).build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        Forecast forecast = null;
        try {
            forecast = client.forecast(request);
        } catch (ForecastException e) {
            logger.error(InfoMessages.CANT_OBTAIN_FORECAST, e);
        }

        return ForecastUtil.getForecastInfoDaily(forecast, getCoordinatesName(latLng));
    }
}
