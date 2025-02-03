package cz.vsb.fei.pol0423.tamz.weather;

/**********************************
 * Forecast part interface with easy access to forecast data
 * Source: <a href="https://openweathermap.org/api/one-call-3">OpenWeatherMap.org</a>
 */
public interface WeatherInfo {
    /******************************
     * Gets timestamp for this particular type of forecast
     * @return Unix timestamp in seconds, UTC
     */
    int getTimestamp();

    /******************************
     * Gets sunrise timestamp for this particular type of forecast (if available)
     * @return Unix timestamp in seconds, UTC
     */
    int getSunrise();

    /******************************
     * Gets sunset timestamp for this particular type of forecast (if available)
     * @return Unix timestamp in seconds, UTC
     */
    int getSunset();

    /******************************
     * Gets temperature for this particular type of forecast
     * @return Temperature reading in Celsius
     */
    double getTemp();

    /******************************
     * Gets feels like temperature for this particular type of forecast
     * @return Temperature reading in Celsius
     */
    double getFeelsLikeTemp();

    /******************************
     * Gets humidity for this particular type of forecast
     * @return Humidity reading in percentage
     */
    double getHumidity();

    /******************************
     * Gets cloudiness for this particular type of forecast
     * @return Cloudiness reading in percentage
     */
    double getCloudiness();

    /******************************
     * Gets the wind speed for this particular type of forecast (if available)
     * @return Wind speed reading in metres per second (m/s)
     */
    double getWindSpeed();

    /******************************
     * Gets the wind direction for this particular type of forecast (if available)
     * Reading is measured in clockwise meteorological degrees based on direction from true north
     * - North = 0 deg
     * - East = 90 deg
     * - South = 180 deg
     * - West = 270 deg
     * @return Wind direction reading in meteorological degrees
     */
    double getWindDeg();

    /******************************
     * Gets the wind gust speed for this particular type of forecast (if available)
     * @return Wind gust speed reading in metres per second (m/s)
     */
    double getWindGust();

    /******************************
     * Gets the wind direction for this particular type of forecast (if available)
     * Direction is specified in indexed manner based on meteorological degrees reading
     *
     * DIRECTION;           MIDDLE DEGREES;     DEGREES RANGE
     * -----------------------------------------------------------
     * - 0 = North          0 (360)             0-22.5 (337.5-360)
     * - 1 = North East     45                  22.5-67.5
     * - 2 = East           90                  67.5-112.5
     * - 3 = South East     135                 112.5-157.5
     * - 4 = South          180                 157.5-202.5
     * - 5 = South West     225                 202.5-247.5
     * - 6 = West           270                 247.5-292.5
     * - 7 = North West     315                 292.5-337.5
     * @return Index of the wind direction reading
     */
    WindDirection getWindDirection();

    /*******************************
     * Gets the weather ID as specified in WeatherCondition.java
     * @return  Weather ID number
     */
    int getWeatherId();
}
