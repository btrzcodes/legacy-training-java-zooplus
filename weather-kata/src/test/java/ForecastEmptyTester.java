import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class ForecastEmptyTester extends Forecast {
    @Override
    protected JSONArray getWeather(String woeid) throws IOException {
        return new JSONObject("key: []").getJSONArray("key");
    }
}
