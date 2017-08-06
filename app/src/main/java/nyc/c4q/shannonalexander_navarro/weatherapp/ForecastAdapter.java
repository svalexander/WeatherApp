package nyc.c4q.shannonalexander_navarro.weatherapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.weatherapp.models.Period;

/**
 * Created by shannonalexander-navarro on 8/6/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    List<Period> weatherList = new ArrayList<>();

    public ForecastAdapter(List<Period> weatherList) {
        this.weatherList = weatherList;
    }


    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder forecastViewHolder, int position) {

        Period aForecast = weatherList.get(position);
        forecastViewHolder.bind(aForecast);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }
}
