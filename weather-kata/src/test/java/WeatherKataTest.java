import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class WeatherKataTest {

    public static final int ONE_DAY = 1000 * 60 * 60 * 24 * 1;

    // https://www.metaweather.com/api/location/753692/  // Barcelona
    @Test
    public void check_madrids_weather() throws IOException {
        String madridForecast = new Forecast().predict("Madrid", new Date(), false);

        assertEquals("Heavy Cloud", madridForecast);
    }

    @Test
    public void check_barcelonas_weather() throws IOException {
        String barcelonaForecast = new FakeBarcelonaForecast().predict("Barcelona", new Date(), false);

        assertEquals("Light Cloud", barcelonaForecast);
    }
    private class FakeBarcelonaForecast extends Forecast {
        protected String getCityIDFromCityNameFromAPI(String city) throws IOException {
            return "753692";
        }
        protected String getPredictionsForTheCityFromAPI(String woeid) throws IOException {
            return "{\"consolidated_weather\":[{\"id\":6123901273767936,\"weather_state_name\":\"Light Cloud\",\"weather_state_abbr\":\"lc\",\"wind_direction_compass\":\"W\",\"created\":\"2020-10-28T09:52:42.168228Z\",\"applicable_date\":\"2020-10-28\",\"min_temp\":13.184999999999999,\"max_temp\":20.015,\"the_temp\":18.619999999999997,\"wind_speed\":4.212061418916196,\"wind_direction\":266.78683798264336,\"air_pressure\":1020.0,\"humidity\":59,\"visibility\":14.557173606140141,\"predictability\":70},{\"id\":6470933285961728,\"weather_state_name\":\"Heavy Cloud\",\"weather_state_abbr\":\"hc\",\"wind_direction_compass\":\"S\",\"created\":\"2020-10-28T09:52:45.674201Z\",\"applicable_date\":\"2020-10-29\",\"min_temp\":14.815,\"max_temp\":20.28,\"the_temp\":19.549999999999997,\"wind_speed\":4.0462309213499825,\"wind_direction\":178.32637451400018,\"air_pressure\":1026.0,\"humidity\":72,\"visibility\":12.52746460669689,\"predictability\":71},{\"id\":5856360110489600,\"weather_state_name\":\"Clear\",\"weather_state_abbr\":\"c\",\"wind_direction_compass\":\"WSW\",\"created\":\"2020-10-28T09:52:48.180250Z\",\"applicable_date\":\"2020-10-30\",\"min_temp\":14.459999999999999,\"max_temp\":21.265,\"the_temp\":20.455,\"wind_speed\":3.591116509334818,\"wind_direction\":240.45675271974062,\"air_pressure\":1025.5,\"humidity\":64,\"visibility\":13.94450161059413,\"predictability\":68},{\"id\":5879372545261568,\"weather_state_name\":\"Clear\",\"weather_state_abbr\":\"c\",\"wind_direction_compass\":\"SW\",\"created\":\"2020-10-28T09:52:51.667172Z\",\"applicable_date\":\"2020-10-31\",\"min_temp\":14.899999999999999,\"max_temp\":20.615,\"the_temp\":19.865,\"wind_speed\":4.691161357270871,\"wind_direction\":214.28122193772572,\"air_pressure\":1023.5,\"humidity\":73,\"visibility\":13.880189692197566,\"predictability\":68},{\"id\":6412246923083776,\"weather_state_name\":\"Light Cloud\",\"weather_state_abbr\":\"lc\",\"wind_direction_compass\":\"SW\",\"created\":\"2020-10-28T09:52:54.675026Z\",\"applicable_date\":\"2020-11-01\",\"min_temp\":15.775,\"max_temp\":21.44,\"the_temp\":20.14,\"wind_speed\":4.378073836353032,\"wind_direction\":229.96992084881646,\"air_pressure\":1023.5,\"humidity\":77,\"visibility\":13.630087787322038,\"predictability\":70},{\"id\":6538904032247808,\"weather_state_name\":\"Heavy Cloud\",\"weather_state_abbr\":\"hc\",\"wind_direction_compass\":\"SW\",\"created\":\"2020-10-28T09:52:57.550212Z\",\"applicable_date\":\"2020-11-02\",\"min_temp\":15.67,\"max_temp\":21.34,\"the_temp\":19.5,\"wind_speed\":5.972214268670961,\"wind_direction\":229.0,\"air_pressure\":1019.0,\"humidity\":80,\"visibility\":9.999726596675416,\"predictability\":71}],\"time\":\"2020-10-28T12:12:14.972214+01:00\",\"sun_rise\":\"2020-10-28T07:18:27.823710+01:00\",\"sun_set\":\"2020-10-28T17:51:07.513902+01:00\",\"timezone_name\":\"LMT\",\"parent\":{\"title\":\"Spain\",\"location_type\":\"Country\",\"woeid\":23424950,\"latt_long\":\"39.894890,-2.988310\"},\"sources\":[{\"title\":\"BBC\",\"slug\":\"bbc\",\"url\":\"http://www.bbc.co.uk/weather/\",\"crawl_rate\":360},{\"title\":\"Forecast.io\",\"slug\":\"forecast-io\",\"url\":\"http://forecast.io/\",\"crawl_rate\":480},{\"title\":\"Met Office\",\"slug\":\"met-office\",\"url\":\"http://www.metoffice.gov.uk/\",\"crawl_rate\":180},{\"title\":\"OpenWeatherMap\",\"slug\":\"openweathermap\",\"url\":\"http://openweathermap.org/\",\"crawl_rate\":360},{\"title\":\"Weather Underground\",\"slug\":\"wunderground\",\"url\":\"https://www.wunderground.com/?apiref=fc30dc3cd224e19b\",\"crawl_rate\":720},{\"title\":\"World Weather Online\",\"slug\":\"world-weather-online\",\"url\":\"http://www.worldweatheronline.com/\",\"crawl_rate\":360}],\"title\":\"Barcelona\",\"location_type\":\"City\",\"woeid\":753692,\"latt_long\":\"41.385578,2.168740\",\"timezone\":\"Europe/Madrid\"}";
        }
    }

    @Test
    public void check_barcelona_wind() throws IOException {
        String barcelonaForecast = new FakeBarcelonaForecast().predict("Barcelona", new Date(), true);

        assertEquals("4.212061418916196", barcelonaForecast);
    }

    @Test
    public void check_barcelona_without_datetime() throws IOException {
        String barcelonaForecast = new FakeBarcelonaForecast().predict("Barcelona", null, true);

        assertEquals("4.212061418916196", barcelonaForecast);
    }

    @Test
    public void check_barcelona_with_a_distant_date() throws IOException {
        Date datetime = new Date( new Date().getTime() + (1000 * 60 * 60 * 24 * 6) );
        String barcelonaForecast = new FakeBarcelonaForecast().predict("Barcelona", datetime, true);

        assertEquals("", barcelonaForecast);
    }

}

