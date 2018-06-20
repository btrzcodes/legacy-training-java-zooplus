import java.util.Date;

public interface ForecastService {
    String predictWeather(String cityName, Date when);

    String predictWind(String cityName, Date when);
}
