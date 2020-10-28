import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Forecast {
    public String predict(String city, Date datetime, boolean wind) throws IOException {
        // When date is not provided we look for the current prediction
        if (datetime == null) {
            datetime = new Date();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd").format(datetime);

        // If there are predictions
        if (datetime.before(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6)))) {

            // Find the id of the city on metawheather
            String woeid = getId(city);

            JSONArray results = getWeather(woeid);

            for (int i = 0; i < results.length(); i++) {
//            // When the date is the expected
                if (format.equals(results.getJSONObject(i).get("applicable_date").toString())) {
//                // If we have to return the wind information
                    if (wind) {
                        return results.getJSONObject(i).get("wind_speed").toString();
                    } else {
                        return results.getJSONObject(i).get("weather_state_name").toString();
                    }
                }
            }
        } else {
            return "";
        }
        return "";
    }

    protected JSONArray getWeather(String woeid) throws IOException {
        String rawResponse;
        HttpRequest request;
        HttpRequestFactory requestFactory;
        // Find the predictions for the city
        requestFactory = new NetHttpTransport().createRequestFactory();
        request = requestFactory.buildGetRequest(
                new GenericUrl("https://www.metaweather.com/api/location/" + woeid));
        rawResponse = request.execute().parseAsString();
        return new JSONObject(rawResponse).getJSONArray("consolidated_weather");
    }

    protected String getId(String city) throws IOException {
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(
                new GenericUrl("https://www.metaweather.com/api/location/search/?query=" + city));
        String rawResponse = request.execute().parseAsString();
        JSONArray jsonArray = new JSONArray(rawResponse);
        return jsonArray.getJSONObject(0).get("woeid").toString();
    }
}
