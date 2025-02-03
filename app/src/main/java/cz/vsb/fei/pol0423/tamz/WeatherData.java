package cz.vsb.fei.pol0423.tamz;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cz.vsb.fei.pol0423.tamz.errors.AuthorizationException;

import java.io.IOException;

/*********************************
 * Interface for working with raw data
 * Source: <a href="https://openweathermap.org/api/one-call-3">OpenWeatherMap.org</a>
 */
public interface WeatherData {
    /*****************************
     * Updates the raw weather forecast data
     * @param requestUrl                URL provided to request new data
     * @throws IOException              If web socket fails to open
     */
    void updateWeatherData(String requestUrl) throws IOException;

    /*****************************
     * Gets the raw forecast data parsed by Gson
     * @return  Raw forecast data in JSON object format
     */
    JsonObject getForecast();
}
