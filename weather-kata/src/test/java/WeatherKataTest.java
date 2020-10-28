import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class WeatherKataTest {

    public static final int ONE_DAY = 1000 * 60 * 60 * 24 * 1;

    // https://www.metaweather.com/api/location/753692/  // Barcelona
    @Test
    public void test_weather_forecast_in_Barcelona() throws IOException {
        String actualPrediction = new Forecast().predict("Barcelona", new Date(), false);

        assertEquals("Light Cloud", actualPrediction);
    }

    @Test
    public void test_weather_forecast_in_Barcelona_with_testable_class() throws IOException {
        String actualPrediction = new TestableForecast().predict("Barcelona", new Date(), false);

        assertEquals("Heavy Cloud", actualPrediction);
    }

    @Test
    public void test_when_date_not_provided_returns_current_prediction() throws IOException {
        String actualPrediction = new TestableForecast().predict("Barcelona", null, false);

        assertEquals("Heavy Cloud", actualPrediction);
    }

    @Test
    public void when_wind_information_is_requested() throws IOException{
        String actualWindSpeed = new TestableForecast().predict("Barcelona", null, true);

        assertEquals("1.893522359458098", actualWindSpeed);
    }

    @Test
    public void when_date_is_more_than_a_week() throws IOException{
        String actualWindSpeed = new TestableForecast().predict("Barcelona", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)), false);

        assertEquals("", actualWindSpeed);
    }

    @Test
    public void when_date_is_less_that_a_week() throws IOException{
        String actualWindSpeed = new TestableForecast().predict("Barcelona", new Date(ONE_DAY), false);

        assertEquals("", actualWindSpeed);
    }


}
