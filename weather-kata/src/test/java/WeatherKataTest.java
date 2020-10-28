import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class WeatherKataTest {

    public static final int ONE_DAY = 1000 * 60 * 60 * 24 * 1;

    // https://www.metaweather.com/api/location/753692/  // Barcelona
    @Test
    public void weather_in_madrid_28_oct_should_be_heavy_cloud() throws IOException {
        String prediction = new TestableForecast().predict("Madrid", new Date(), false);
        assertEquals("Heavy Cloud", prediction);
    }

    @Test
    public void should_initialize_if_the_date_is_not_passed() throws IOException {
        String prediction = new TestableForecast().predict("Madrid", null, false);
        assertEquals("Heavy Cloud", prediction);
    }

    @Test
    public void should_return_empty_if_date_is_older_than_six_days() throws IOException {
        Date date = new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 5));
        System.out.println(date);
        String prediction = new TestableForecast().predict("Madrid", date, false);
        assertEquals("", prediction);
    }

    @Test
    public void should_return_wind_info_when_is_requested_by_parameter() throws IOException {
        String prediction = new TestableForecast().predict("Madrid", new Date(), true);
        assertEquals("1.893522359458098", prediction);
    }




}
