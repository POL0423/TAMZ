package cz.vsb.fei.pol0423.tamz.weather;

import com.google.gson.JsonObject;

import java.util.List;

/***************************************
 * Forecast interface for easy access to forecast data
 * Source: <a href="https://openweathermap.org/api/one-call-3">OpenWeatherMap.org</a>
 */
public interface Forecast {
    /***********************************
     * Gets the latitude of the forecast location
     * @return Latitude in GPS degrees
     */
    double getLatitude();

    /***********************************
     * Gets the longitude of the forecast location
     * @return Longitude in GPS degrees
     */
    double getLongitude();

    /***********************************
     * Gets the location name of the forecast location
     * Uses geocoding API of MapBox
     * @return Name of the location down to town level
     */
    String getLocationName();

    /***********************************
     * Gets the timezone offset of the forecast location from UTC in seconds
     * @return Timezone offset from the UTC Unix timestamp in seconds
     */
    int getTimezoneOffset();

    /***********************************
     * Gets the timezone identifier of the forecast location
     * Formatted like "Continent/CapitalCity"
     * @return Timezone identifier string
     */
    String getTimezoneName();

    /***********************************
     * Gets the current weather info object
     * @return
     */
    WeatherInfo getCurrentWeatherInfo();

    /***********************************
     * Gets the hourly forecast info object given by the specified index
     * @param index Index of the hourly forecast object
     * @return      Specified hourly forecast object
     */
    WeatherInfo getHourlyForecastInfo(int index);

    /***********************************
     * Gets the daily forecast info object given by the specified index
     * @param index Index of the daily forecast object
     * @return      Specified daily forecast object
     */
    WeatherInfo getDailyForecastInfo(int index);

    /***********************************
     * Gets the complete list of the hourly forecast object for the next 24 hours
     * @return      List of hourly forecast objects
     */
    List<WeatherInfo> getHourlyForecastInfoList();

    /***********************************
     * Gets the complete list of the daily forecast object for the next 7 days
     * @return      List of daily forecast objects
     */
    List<WeatherInfo> getDailyForecastInfoList();

    /***********************************
     * Updates the weather forecast using the raw JSON data retrieved from a remote server
     * @param weatherData   JSON object containing raw data
     */
    void update(JsonObject weatherData);
}
