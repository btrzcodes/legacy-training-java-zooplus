import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class WeatherKataTest {

    public static final int ONE_DAY = 1000 * 60 * 60 * 24 * 1;

    // https://www.metaweather.com/api/location/753692/  // Barcelona
    @Test
    public void xxx() throws IOException {
        String str = new ForecastTester().predict("Barcelona", new Date(), false);
        assertEquals("Light Cloud", str);
    }

    @Test
    public void no_date() throws IOException {
        String str = new ForecastTester().predict("Barcelona", null, false);
        assertEquals("Light Cloud", str);
    }

    @Test
    public void with_wind() throws IOException {
        String str = new ForecastTester().predict("Barcelona", null, true);
        assertEquals("4.212061418916196", str);
    }

    @Test
    public void after_1_week() throws IOException {
        String str = new ForecastTester().predict("Barcelona", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)), true);
        assertEquals("", str);
    }

    @Test
    public void no_results() throws IOException {
        String str = new ForecastEmptyTester().predict("Barcelona", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)), true);
        assertEquals("", str);
    }
}
