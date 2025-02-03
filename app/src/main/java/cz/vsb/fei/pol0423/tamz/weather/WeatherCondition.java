package cz.vsb.fei.pol0423.tamz.weather;

/*****************************************************
 * Source: <a href="https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2">OpenWeatherMap.org</a>
 */
public class WeatherCondition {
    // 2xx: Thunderstorm
    public static final int THUNDERSTORM_WITH_LIGHT_RAIN = 200;
    public static final int THUNDERSTORM_WITH_RAIN = 201;
    public static final int THUNDERSTORM_WITH_HEAVY_RAIN = 202;
    public static final int LIGHT_THUNDERSTORM = 210;
    public static final int THUNDERSTORM = 211;
    public static final int HEAVY_THUNDERSTORM = 212;
    public static final int RAGGED_THUNDERSTORM = 221;
    public static final int THUNDERSTORM_WITH_LIGHT_DRIZZLE = 230;
    public static final int THUNDERSTORM_WITH_DRIZZLE = 231;
    public static final int THUNDERSTORM_WITH_HEAVY_DRIZZLE = 232;

    // 3xx: Drizzle
    public static final int LIGHT_INTENSITY_DRIZZLE = 300;
    public static final int DRIZZLE = 301;
    public static final int HEAVY_INTENSITY_DRIZZLE = 302;
    public static final int LIGHT_INTENSITY_DRIZZLE_RAIN = 310;
    public static final int DRIZZLE_RAIN = 311;
    public static final int HEAVY_INTENSITY_DRIZZLE_RAIN = 312;
    public static final int SHOWER_RAIN_AND_DRIZZLE = 313;
    public static final int HEAVY_SHOWER_RAIN_AND_DRIZZLE = 314;
    public static final int SHOWER_DRIZZLE = 321;

    // 5xx: Rain
    public static final int LIGHT_RAIN = 500;
    public static final int MODERATE_RAIN = 501;
    public static final int HEAVY_INTENSITY_RAIN = 502;
    public static final int VERY_HEAVY_RAIN = 503;
    public static final int EXTREME_RAIN = 504;
    public static final int FREEZING_RAIN = 511;
    public static final int LIGHT_INTENSITY_SHOWER_RAIN = 520;
    public static final int SHOWER_RAIN = 521;
    public static final int HEAVY_INTENSITY_SHOWER_RAIN = 522;
    public static final int RAGGED_SHOWER_RAIN = 531;

    // 6xx: Snow
    public static final int LIGHT_SNOW = 600;
    public static final int SNOW = 601;
    public static final int HEAVY_SNOW = 602;
    public static final int SLEET = 611;
    public static final int LIGHT_SHOWER_SLEET = 612;
    public static final int SHOWER_SLEET = 613;
    public static final int LIGHT_RAIN_AND_SNOW = 615;
    public static final int RAIN_AND_SNOW = 616;
    public static final int LIGHT_SHOWER_SNOW = 620;
    public static final int SHOWER_SNOW = 621;
    public static final int HEAVY_SHOWER_SNOW = 622;

    // 7xx: Atmosphere
    public static final int MIST = 701;
    public static final int SMOKE = 711;
    public static final int HAZE = 721;
    public static final int SAND_DUST_WHIRLS = 731;
    public static final int FOG = 741;
    public static final int SAND = 751;
    public static final int DUST = 761;
    public static final int VOLCANIC_ASH = 762;
    public static final int SQUALLS = 771;
    public static final int TORNADO = 781;

    // 800: Clear
    public static final int CLEAR = 800;

    // 80x: Clouds
    public static final int FEW_CLOUDS = 801;
    public static final int SCATTERED_CLOUDS = 802;
    public static final int BROKEN_CLOUDS = 803;
    public static final int OVERCAST_CLOUDS = 804;
}
