package com.bot.telegram.util;

import com.bot.telegram.util.enums.WeatherInfoEnum;
import tk.plogitech.darksky.forecast.model.*;

import static com.bot.telegram.setting.Settings.EOL;
import static com.bot.telegram.util.DateUtil.getDate;
import static com.bot.telegram.util.DateUtil.getTime;
import static com.bot.telegram.util.ResoursesUtil.getName;

public class ForecastUtil {
    public static String getForecastInfoCurrently(Forecast forecast, String location) {
        StringBuffer sb = new StringBuffer();
        sb.append(EOL)
                .append(getEmojiByForecast(forecast.getCurrently().getIcon()))
                .append(getName(WeatherInfoEnum.DATE.getName())).append(": ").append(getDate(forecast.getCurrently().getTime())).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.LOCATION.getName())).append(": ").append(location).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.TIME.getName())).append(": ").append(getTime(forecast.getCurrently().getTime())).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.TEMPERATURE.getName())).append(": ").append(Math.round(forecast.getCurrently().getTemperature())).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.NOW.getName())).append(": ").append(forecast.getCurrently().getSummary()).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.WINDY.getName())).append(": ").append(forecast.getCurrently().getWindSpeed()).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.PRESSURE.getName())).append(": ").append(forecast.getCurrently().getPressure()).append(EOL)
                .append("•").append(getName(WeatherInfoEnum.HUMIDITY.getName())).append(": ").append(forecast.getCurrently().getHumidity() * 100).append(EOL);
        return sb.toString();
    }

    public static String getForecastInfoDaily(Forecast forecast, String location) {
        StringBuffer sb = new StringBuffer();
        Daily daily = forecast.getDaily();
        sb.append(getName(WeatherInfoEnum.FORECAST_7.getName())).append(EOL).append(EOL);
        for (DailyDataPoint data : daily.getData()) {
            sb.append(EOL)
                    .append(getEmojiByForecast(data.getIcon()))
                    .append(getName(WeatherInfoEnum.DATE.getName())).append(": ").append(getDate(data.getTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.LOCATION.getName())).append(": ").append(location).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.NOW.getName())).append(": ").append(data.getSummary()).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.SUNRISE_TIME.getName())).append(": ").append(getTime(data.getSunriseTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.SUNSET_TIME.getName())).append(": ").append(getTime(data.getSunsetTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.TEMPERATURE_MIN.getName())).append(": ").append(Math.round(data.getApparentTemperatureMin())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.TEMPERATURE_MIN_TIME.getName())).append(": ").append(getTime(data.getApparentTemperatureMinTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.TEMPERATURE_MAX.getName())).append(": ").append(Math.round(data.getApparentTemperatureMax())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.TEMPERATURE_MAX_TIME.getName())).append(": ").append(getTime(data.getApparentTemperatureMaxTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.CLOUD_COVER.getName())).append(": ").append(data.getCloudCover() * 100).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.WINDY.getName())).append(": ").append(data.getWindSpeed()).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.PRESSURE.getName())).append(": ").append(data.getPressure()).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.HUMIDITY.getName())).append(": ").append(data.getHumidity() * 100).append(EOL)
                    .append(EOL);
        }
        return sb.toString();
    }

    public static String getForecastInfoHourly(Forecast forecast, String location) {
        StringBuffer sb = new StringBuffer();
        Hourly hourly = forecast.getHourly();
        sb.append(getName(WeatherInfoEnum.FORECAST_2.getName())).append(EOL).append(EOL);
        int count = 0;
        for (DataPoint data : hourly.getData()) {
            count++;
            if (count % 3 != 0) {
                continue;
            }
            sb.append(EOL)
                    .append(getEmojiByForecast(data.getIcon()))
                    .append(getName(WeatherInfoEnum.DATE.getName())).append(": ").append(getDate(data.getTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.TIME.getName())).append(": ").append(getTime(data.getTime())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.LOCATION.getName())).append(": ").append(location).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.NOW.getName())).append(": ").append(data.getSummary()).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.TEMPERATURE.getName())).append(": ").append(Math.round(data.getTemperature())).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.CLOUD_COVER.getName())).append(": ").append(data.getCloudCover() * 100).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.WINDY.getName())).append(": ").append(data.getWindSpeed()).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.PRESSURE.getName())).append(": ").append(data.getPressure()).append(EOL)
                    .append("•").append(getName(WeatherInfoEnum.HUMIDITY.getName())).append(": ").append(data.getHumidity() * 100).append(EOL)
                    .append(EOL);
        }
        return sb.toString();
    }

    private static String getEmojiByForecast(String icon) {
        return ResoursesUtil.getName(icon);
    }
}
