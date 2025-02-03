package cz.vsb.fei.pol0423.tamz.weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class ForecastData implements Forecast {
    private double latitude;
    private double longitude;
    int timezoneOffset;
    String timezone;
    WeatherInfo currentWeatherInfo;
    List<WeatherInfo> hourlyForecast;
    List<WeatherInfo> dailyForecast;

    /***********************************
     * Constuctor that creates a forecast data object with interface to access weather data
     * @param weatherData   JSON object containing raw data
     */
    public ForecastData(JsonObject weatherData) {
        // Create with the update method
        update(weatherData);
    }

    /***********************************
     * Gets the latitude of the forecast location
     * @return Latitude in GPS degrees
     */
    @Override
    public double getLatitude() {
        return latitude;
    }

    /***********************************
     * Gets the longitude of the forecast location
     * @return Longitude in GPS degrees
     */
    @Override
    public double getLongitude() {
        return longitude;
    }

    /***********************************
     * Gets the location name of the forecast location
     * Uses geocoding API of MapBox
     * @return Name of the location down to town level
     */
    @Override
    public String getLocationName() {
        return "";
    }

    /***********************************
     * Gets the timezone offset of the forecast location from UTC in seconds
     * @return Timezone offset from the UTC Unix timestamp in seconds
     */
    @Override
    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    /***********************************
     * Gets the timezone identifier of the forecast location
     * Formatted like "Continent/CapitalCity"
     * @return Timezone identifier string
     */
    @Override
    public String getTimezoneName() {
        return timezone;
    }

    /***********************************
     * Gets the current weather info object
     * @return
     */
    @Override
    public WeatherInfo getCurrentWeatherInfo() {
        return currentWeatherInfo;
    }

    /***********************************
     * Gets the hourly forecast info object given by the specified index
     * @param index Index of the hourly forecast object
     * @return Specified hourly forecast object
     */
    @Override
    public WeatherInfo getHourlyForecastInfo(int index) {
        return hourlyForecast.get(index);
    }

    /***********************************
     * Gets the daily forecast info object given by the specified index
     * @param index Index of the daily forecast object
     * @return Specified daily forecast object
     */
    @Override
    public WeatherInfo getDailyForecastInfo(int index) {
        return dailyForecast.get(index);
    }

    /***********************************
     * Gets the complete list of the hourly forecast object for the next 24 hours
     * @return List of hourly forecast objects
     */
    @Override
    public List<WeatherInfo> getHourlyForecastInfoList() {
        return hourlyForecast;
    }

    /***********************************
     * Gets the complete list of the daily forecast object for the next 7 days
     * @return List of daily forecast objects
     */
    @Override
    public List<WeatherInfo> getDailyForecastInfoList() {
        return dailyForecast;
    }

    /***********************************
     * Updates the weather forecast using the raw JSON data retrieved from a remote server
     * @param weatherData   JSON object containing raw data
     */
    @Override
    public void update(JsonObject weatherData) {
        // Fill in basic information
        //---------------------------------------------------------------
        latitude = weatherData.get("lat").getAsDouble();
        longitude = weatherData.get("lon").getAsDouble();
        timezoneOffset = weatherData.get("timezone_offset").getAsInt();
        timezone = weatherData.get("timezone").getAsString();

        // Get current weather data and parse them
        //---------------------------------------------------------------
        JsonObject currentData = weatherData.get("current").getAsJsonObject();
        currentWeatherInfo = new WeatherInfoData(currentData.get("dt").getAsInt(),
                currentData.get("sunrise").getAsInt(),
                currentData.get("sunset").getAsInt(),
                currentData.get("temp").getAsDouble(),
                currentData.get("feels_like").getAsDouble(),
                currentData.get("humidity").getAsDouble(),
                currentData.get("clouds").getAsDouble(),
                currentData.get("wind_speed").getAsDouble(),
                currentData.get("wind_deg").getAsDouble(),
                currentData.get("wind_gust").getAsDouble(),
                currentData.get("weather.id").getAsInt());

        // Get hourly forecast data and parse them, limit output to 24h
        //---------------------------------------------------------------

        // Create new list
        hourlyForecast = new ArrayList<>();

        // Get data
        JsonArray hourlyData = weatherData.get("hourly").getAsJsonArray();
        for (int i = 0; i < hourlyData.size(); i++) {
            if(i == 24) break;      // Break after 24 hours

            // Get data
            JsonObject hourData = hourlyData.get(i).getAsJsonObject();
            WeatherInfoData newHourData = new WeatherInfoData(hourData.get("dt").getAsInt(), 0, 0,
                    hourData.get("temp").getAsDouble(),
                    hourData.get("feels_like").getAsDouble(),
                    hourData.get("humidity").getAsDouble(),
                    hourData.get("clouds").getAsDouble(),
                    hourData.get("wind_speed").getAsDouble(),
                    hourData.get("wind_deg").getAsDouble(),
                    hourData.get("wind_gust").getAsDouble(),
                    hourData.get("weather.id").getAsInt());
            hourlyForecast.add(newHourData);
        }

        // Get daily forecast data and parse them, limit output to 7d
        //--------------------------------------------------------------

        // Create new list
        dailyForecast = new ArrayList<>();

        // Get data
        JsonArray dailyData = weatherData.get("daily").getAsJsonArray();
        for (int i = 1; i < dailyData.size(); i++) {
            if(i == 8) break;       // Break after 7th day

            // Get data
            JsonObject dayData = dailyData.get(i).getAsJsonObject();
            WeatherInfoData newDayData = new WeatherInfoData(dayData.get("dt").getAsInt(),
                    dayData.get("sunrise").getAsInt(),
                    dayData.get("sunset").getAsInt(),
                    (dayData.get("temp.min").getAsDouble()
                            + dayData.get("temp_max").getAsDouble()) / 2,
                    (dayData.get("feels_like.morn").getAsDouble()
                            + dayData.get("feels_like.day").getAsDouble()
                            + dayData.get("feels_like.eve").getAsDouble()
                            + dayData.get("feels_like.night").getAsDouble()) / 4,
                    dayData.get("humidity").getAsDouble(),
                    dayData.get("clouds").getAsDouble(),
                    dayData.get("wind_speed").getAsDouble(),
                    dayData.get("wind_deg").getAsDouble(),
                    dayData.get("wind_gust").getAsDouble(),
                    dayData.get("weather.id").getAsInt());
        }
    }
}
