import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public interface WeatherService {
    @Path("/city/{city}")
    @Produces("application/json")
    @GET
    String getWeather(@PathParam("city") String city);
}
