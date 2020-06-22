import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.net.URL;


@Component
public class WeatherServiceImpl implements WeatherService {
    private final static String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?";
    private static final String WEATHER_KEY = "9bc9127b5ca9be05751bd273761634d4";
    private final static String UNITS = "metric";

    @Override
    @SneakyThrows
    public String getWeather(String city) {
        Weather currentWeather = new ObjectMapper().readValue(
                new URL(BASE_URL +
                        "q=" + city +
                        "&units=" + UNITS +
                        "&appid=" + WEATHER_KEY),
                Weather.class);
        return currentWeather.toString();
    }
}
