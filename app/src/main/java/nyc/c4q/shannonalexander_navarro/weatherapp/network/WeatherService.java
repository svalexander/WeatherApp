package nyc.c4q.shannonalexander_navarro.weatherapp.network;

import nyc.c4q.shannonalexander_navarro.weatherapp.models.ForecastedWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shannonalexander-navarro on 8/6/17.
 */

public interface WeatherService {

    @GET("forecasts/11101")
    Call<ForecastedWeather> getResults(@Query("client_id") String client_id, @Query("client_secret") String client_secret);
}
