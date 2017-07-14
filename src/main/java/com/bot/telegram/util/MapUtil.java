package com.bot.telegram.util;

import com.bot.telegram.MyBot;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;

public class MapUtil {
    public static LatLng getGeocodingResults(String cityName){
        GeoApiContext context = new GeoApiContext().setApiKey(MyBot.GOOGLE_MAPS_API_KEY);
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context, cityName).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return results[0].geometry.location;
    }

    public static String getCoordinatesName(LatLng latLng){
        GeoApiContext context = new GeoApiContext().setApiKey(MyBot.GOOGLE_MAPS_API_KEY);
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.reverseGeocode(context, latLng).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return results[0].formattedAddress;
    }

    public static LatLng getGeoCodeFromInput(String input){
        String doubleNumRegEx = "[+-]?\\d*\\.?\\d+";
        LatLng latLng;
        if (input.matches(doubleNumRegEx+" +"+"[+-]?\\d*\\.?\\d+")){
            double lat = Double.valueOf(input.replaceFirst(doubleNumRegEx, ""));
            double lng = Double.valueOf(input.replaceFirst(doubleNumRegEx, ""));
            latLng = new LatLng(lat, lng);
        } else {
            latLng = MapUtil.getGeocodingResults(input.trim());
        }
        return latLng;
    }

}
