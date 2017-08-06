package nyc.c4q.shannonalexander_navarro.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.weatherapp.models.ForecastedWeather;
import nyc.c4q.shannonalexander_navarro.weatherapp.models.Period;
import nyc.c4q.shannonalexander_navarro.weatherapp.network.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ForecastAdapter forecastAdapter;
    private List<Period> weatherList = new ArrayList<>();
    private static final String BASE_URL = "https://api.aerisapi.com/";
    private static final String CLIENT_ID = "2Lxx12kMKk5QXEkOgzb23";
    private static final String CLIENT_SECRET = "Ro7iXq41e7I0wc73bjLmdOAMScGGmJ7zx9gfx6tI";
    private static final String TAG = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRV();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAerisWeatherJSON();
    }

    private void initRV() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        forecastAdapter = new ForecastAdapter(weatherList);
        rv.setAdapter(forecastAdapter);
    }

    void getAerisWeatherJSON() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<ForecastedWeather> call = weatherService.getResults(CLIENT_ID, CLIENT_SECRET);

        call.enqueue(new Callback<ForecastedWeather>() {
            @Override
            public void onResponse(Call<ForecastedWeather> call, retrofit2.Response<ForecastedWeather> response) {
                ForecastedWeather forecastedWeather = response.body();
                List<Period> days = forecastedWeather.getResponse().get(0).getPeriods();

                weatherList.clear();
                weatherList.addAll(days);
                forecastAdapter.notifyDataSetChanged();

                if (response.isSuccessful()) {
                    Log.d(TAG, "Success: " + forecastedWeather.getResponse().get(0).getPeriods().get(0).getDateTimeISO());
                } else {
                    try {
                        Log.d(TAG, "Error: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ForecastedWeather> call, Throwable t) {

            }
        });
    }
}
