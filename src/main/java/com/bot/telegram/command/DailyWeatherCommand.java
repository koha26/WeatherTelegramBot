package com.bot.telegram.command;

import com.bot.telegram.MyBot;
import com.bot.telegram.util.ForecastUtil;
import com.google.maps.model.LatLng;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.objects.Update;
import tk.plogitech.darksky.api.jackson.DarkSkyJacksonClient;
import tk.plogitech.darksky.forecast.*;
import tk.plogitech.darksky.forecast.model.Forecast;

import static com.bot.telegram.util.MapUtil.getCoordinatesName;
import static com.bot.telegram.util.MapUtil.getGeoCodeFromInput;
import static com.bot.telegram.util.Settings.DARK_SKY_API_KEY;

public class DailyWeatherCommand implements Command {
    private Logger logger = org.apache.log4j.Logger.getLogger(DailyWeatherCommand.class);

    public String execute(Update update) {
        String input = update.getMessage().getText();
        LatLng latLng = getGeoCodeFromInput(input);

        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey(DARK_SKY_API_KEY))
                .language(ForecastRequestBuilder.Language.en)
                .location(new GeoCoordinates(new Longitude(latLng.lng), new Latitude(latLng.lat))).build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        Forecast forecast = null;
        try {
            forecast = client.forecast(request);
        } catch (ForecastException e) {
            logger.error("Cant't obtain forecast.", e);
        }

        return ForecastUtil.getForecastInfoDaily(forecast, getCoordinatesName(latLng));
    }
}
