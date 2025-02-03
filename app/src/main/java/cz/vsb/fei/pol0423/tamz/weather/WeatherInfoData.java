package cz.vsb.fei.pol0423.tamz.weather;

public class WeatherInfoData implements WeatherInfo {
    private final int timestamp;
    private final int sunrise;
    private final int sunset;
    private final double temperature;
    private final double feelsLikeTemperature;
    private final double humidity;
    private final double cloudiness;
    private final double windSpeed;
    private final double windDirection;
    private final double windGust;
    private final int weatherId;

    /******************************
     * Constructor that creates a weather info data object
     * @param timestamp                 Reading/forecast Unix timestamp in UTC
     * @param sunrise                   Sunrise Unix timestamp in UTC
     * @param sunset                    Sunset Unix timestamp in UTC
     * @param temperature               Temperature reading in Celsius
     * @param feelsLikeTemperature      Feels like temperature reading in Celius
     * @param humidity                  Humidity reading in percentage
     * @param cloudiness                Cloudiness reading in percentage
     * @param windSpeed                 Wind speed reading in metres per second (m/s)
     * @param windDirection             Wind direction reading in meteorological degrees
     * @param windGust                  Wind gust speed reading in metres per second (m/s)
     * @param weatherId                 Weather ID number
     */
    public WeatherInfoData(int timestamp,
                           int sunrise,
                           int sunset,
                           double temperature,
                           double feelsLikeTemperature,
                           double humidity,
                           double cloudiness,
                           double windSpeed,
                           double windDirection,
                           double windGust,
                           int weatherId) {
        this.timestamp = timestamp;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.humidity = humidity;
        this.cloudiness = cloudiness;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.windGust = windGust;
        this.weatherId = weatherId;
    }

    /******************************
     * Gets timestamp for this particular type of forecast
     * @return Unix timestamp in seconds, UTC
     */
    @Override
    public int getTimestamp() {
        return timestamp;
    }

    /******************************
     * Gets sunrise timestamp for this particular type of forecast (if available)
     * @return Unix timestamp in seconds, UTC
     */
    @Override
    public int getSunrise() {
        return sunrise;
    }

    /******************************
     * Gets sunset timestamp for this particular type of forecast (if available)
     * @return Unix timestamp in seconds, UTC
     */
    @Override
    public int getSunset() {
        return sunset;
    }

    /******************************
     * Gets temperature for this particular type of forecast
     * @return Temperature reading in Celsius
     */
    @Override
    public double getTemp() {
        return temperature;
    }

    /******************************
     * Gets feels like temperature for this particular type of forecast
     * @return Temperature reading in Celsius
     */
    @Override
    public double getFeelsLikeTemp() {
        return feelsLikeTemperature;
    }

    /******************************
     * Gets humidity for this particular type of forecast
     * @return Humidity reading in percentage
     */
    @Override
    public double getHumidity() {
        return humidity;
    }

    /******************************
     * Gets cloudiness for this particular type of forecast
     * @return Cloudiness reading in percentage
     */
    @Override
    public double getCloudiness() {
        return cloudiness;
    }

    /******************************
     * Gets the wind speed for this particular type of forecast (if available)
     * @return Wind speed reading in metres per second (m/s)
     */
    @Override
    public double getWindSpeed() {
        return windSpeed;
    }

    /******************************
     * Gets the wind direction for this particular type of forecast (if available)
     * Reading is measured in clockwise meteorological degrees based on direction from true north
     * - North = 0 deg
     * - East = 90 deg
     * - South = 180 deg
     * - West = 270 deg
     * @return Wind direction reading in meteorological degrees
     */
    @Override
    public double getWindDeg() {
        return windDirection;
    }

    /******************************
     * Gets the wind gust speed for this particular type of forecast (if available)
     * @return Wind gust speed reading in metres per second (m/s)
     */
    @Override
    public double getWindGust() {
        return windGust;
    }

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
    @Override
    public WindDirection getWindDirection() {
        if(windDirection >= 0.0 && windDirection < 22.5 || windDirection >= 337.5 && windDirection < 360.0)
            return WindDirection.NORTH;

        if(windDirection >= 22.5 && windDirection < 67.5)
            return WindDirection.NORTH_EAST;

        if(windDirection >= 67.5 && windDirection < 112.5)
            return WindDirection.EAST;

        if(windDirection >= 112.5 && windDirection < 157.5)
            return WindDirection.SOUTH_EAST;

        if(windDirection >= 157.5 && windDirection < 202.5)
            return WindDirection.SOUTH;

        if(windDirection >= 202.5 && windDirection < 247.5)
            return WindDirection.SOUTH_WEST;

        if(windDirection >= 247.5 && windDirection < 292.5)
            return WindDirection.WEST;

        if(windDirection >= 292.5 && windDirection < 337.5)
            return WindDirection.NORTH_WEST;

        // Invalid direction has been given (valid values are between 0-360 deg)
        return null;
    }

    /*******************************
     * Gets the weather ID as specified in WeatherCondition.java
     * @return Weather ID number
     */
    @Override
    public int getWeatherId() {
        return 0;
    }
}
