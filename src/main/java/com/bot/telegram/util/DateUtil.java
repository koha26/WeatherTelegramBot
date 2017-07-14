package com.bot.telegram.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    private static final String DATE_TIME_FORMAT = "dd.MM.yyyy hh:mm";
    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final String TIME_FORMAT = "hh:mm";

    public static String getDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.format(date);
    }

    public static Date getDate(String dateString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.parse(dateString);
    }

    public static String getDate(Instant time){
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        LocalDateTime ldt = LocalDateTime.ofInstant(time, ZoneId.systemDefault());
        Date date = new GregorianCalendar(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth()).getTime();
        return dateFormat.format(date);
    }

    public static String getTime(Instant time){
        DateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        LocalDateTime ldt = LocalDateTime.ofInstant(time, ZoneId.systemDefault());
        Date date = new GregorianCalendar(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute()).getTime();
        return dateFormat.format(date);
    }
}
