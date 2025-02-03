package cz.vsb.fei.pol0423.tamz;

import android.util.Log;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import cz.vsb.fei.pol0423.tamz.errors.AuthorizationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataObject implements WeatherData {
    private JsonObject data;

    public WeatherDataObject(String requestUrl) throws IOException {
        updateWeatherData(requestUrl);
    }
    @Override
    public void updateWeatherData(String requestUrl) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                data = new JsonParser().parse(new InputStreamReader(urlConnection.getInputStream())).getAsJsonObject();
            } else if (responseCode == 401) {
                throw new AuthorizationException("Authorization failed");
            } else {
                throw new RuntimeException("Other response code: " + responseCode);
            }
        } catch (RuntimeException e) {
            Log.e("WeatherDataObject", e.getMessage());
            e.printStackTrace();
        } {
            urlConnection.disconnect();
        }
    }

    @Override
    public JsonObject getForecast() {
        return data;
    }
}
