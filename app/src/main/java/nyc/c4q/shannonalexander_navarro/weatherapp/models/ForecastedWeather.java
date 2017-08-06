package nyc.c4q.shannonalexander_navarro.weatherapp.models;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 8/6/17.
 */

public class ForecastedWeather {

    private Boolean success;
    private Object error;
    private List<Response> response;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}

