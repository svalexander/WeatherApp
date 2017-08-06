package nyc.c4q.shannonalexander_navarro.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.shannonalexander_navarro.weatherapp.models.Period;

/**
 * Created by shannonalexander-navarro on 8/6/17.
 */

public class ForecastViewHolder extends RecyclerView.ViewHolder {

    private TextView dayTV;
    private TextView minTempFTV;
    private TextView maxTempFTV;
    private TextView minTempCTV;
    private TextView maxTempCTV;
    private ImageView imageView;
    private final Context context;


    public ForecastViewHolder(View itemView) {
        super(itemView);
        context =itemView.getContext();
        imageView = (ImageView) itemView.findViewById(R.id.weatherIconIV);
        dayTV = (TextView) itemView.findViewById(R.id.dateTV);
        minTempFTV = (TextView) itemView.findViewById(R.id.farenheitLowTV);
        maxTempFTV = (TextView) itemView.findViewById(R.id.farenheitHighTV);
        minTempCTV = (TextView) itemView.findViewById(R.id.celciusLowTV);
        maxTempCTV = (TextView) itemView.findViewById(R.id.celciusHighTV);
    }


    public void bind(Period aForecast) {

        String day = aForecast.getDateTimeISO();
        String minTempF = " Min temp Farenheit: " + aForecast.getMinTempF();
        String maxTempF = "High temp Farenheit: " + aForecast.getMaxTempF() + " ";
        String minTempC = " Min temp Celcius: " + aForecast.getMinTempC();
        String maxTempC = "High temp Celcius: " + aForecast.getMaxTempC() + " ";

        dayTV.setText(day.substring(0,10));
        minTempFTV.setText(minTempF);
        maxTempFTV.setText(maxTempF);
        minTempCTV.setText(minTempC);
        maxTempCTV.setText(maxTempC);

        Picasso.with(context).load(R.drawable.clear).into(imageView);
    }
}
