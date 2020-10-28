import org.json.JSONArray;

import java.io.IOException;

public class TestableForecast extends Forecast {

    @Override
    protected JSONArray getPredictionsForCity(String woeid) throws IOException {
        JSONArray result = new JSONArray("[{\"visibility\":10.307616022429015,\"created\":\"2020-10-28T09:36:57.156207Z\",\"applicable_date\":\"2020-10-28\",\"wind_direction\":183.28070730825183,\"predictability\":71,\"wind_direction_compass\":\"S\",\"weather_state_name\":\"Heavy Cloud\",\"min_temp\":7.695,\"weather_state_abbr\":\"hc\",\"the_temp\":13.01,\"humidity\":82,\"wind_speed\":1.893522359458098,\"id\":4618705154605056,\"max_temp\":15.035,\"air_pressure\":1023},{\"visibility\":10.835160164638511,\"created\":\"2020-10-28T09:37:00.238792Z\",\"applicable_date\":\"2020-10-29\",\"wind_direction\":64.93354757997469,\"predictability\":70,\"wind_direction_compass\":\"ENE\",\"weather_state_name\":\"Light Cloud\",\"min_temp\":8.285,\"weather_state_abbr\":\"lc\",\"the_temp\":15.47,\"humidity\":72,\"wind_speed\":2.125333380622498,\"id\":6086243940040704,\"max_temp\":18.33,\"air_pressure\":1026.5},{\"visibility\":13.863723355603277,\"created\":\"2020-10-28T09:37:03.797606Z\",\"applicable_date\":\"2020-10-30\",\"wind_direction\":69.05246676751156,\"predictability\":68,\"wind_direction_compass\":\"ENE\",\"weather_state_name\":\"Clear\",\"min_temp\":8.685,\"weather_state_abbr\":\"c\",\"the_temp\":18.23,\"humidity\":64,\"wind_speed\":2.4704787426681514,\"id\":6290788469178368,\"max_temp\":20.130000000000003,\"air_pressure\":1025},{\"visibility\":14.348082199952279,\"created\":\"2020-10-28T09:37:06.194021Z\",\"applicable_date\":\"2020-10-31\",\"wind_direction\":113.58285550772018,\"predictability\":68,\"wind_direction_compass\":\"ESE\",\"weather_state_name\":\"Clear\",\"min_temp\":9.885,\"weather_state_abbr\":\"c\",\"the_temp\":19.29,\"humidity\":58,\"wind_speed\":1.673491222304409,\"id\":5903332758519808,\"max_temp\":21.02,\"air_pressure\":1024.5},{\"visibility\":14.063804879503698,\"created\":\"2020-10-28T09:37:09.257748Z\",\"applicable_date\":\"2020-11-01\",\"wind_direction\":138.43518567864132,\"predictability\":70,\"wind_direction_compass\":\"SE\",\"weather_state_name\":\"Light Cloud\",\"min_temp\":10.075,\"weather_state_abbr\":\"lc\",\"the_temp\":18.77,\"humidity\":63,\"wind_speed\":1.9355699442084893,\"id\":6703380475936768,\"max_temp\":20.36,\"air_pressure\":1024},{\"visibility\":9.999726596675416,\"created\":\"2020-10-28T09:37:12.660916Z\",\"applicable_date\":\"2020-11-02\",\"wind_direction\":255,\"predictability\":68,\"wind_direction_compass\":\"WSW\",\"weather_state_name\":\"Clear\",\"min_temp\":10.81,\"weather_state_abbr\":\"c\",\"the_temp\":19.33,\"humidity\":61,\"wind_speed\":2.428171677403961,\"id\":4883255275814912,\"max_temp\":20.945,\"air_pressure\":1018}]");
        return result;
    }

    @Override
    protected String getCityId(String city) throws IOException {
        return "766273";
    }
}
