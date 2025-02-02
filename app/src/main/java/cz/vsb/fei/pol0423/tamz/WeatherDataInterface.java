package cz.vsb.fei.pol0423.tamz;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;

public interface WeatherDataInterface {
    void updateWeatherData(String requestUri) throws IOException;
    JsonObject getCurrentForecast();
    JsonArray getHourlyForecast();
    JsonArray getDailyForecast();
    JsonArray getAlerts();
}
