package nyc.c4q.shannonalexander_navarro.weatherapp.models;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 8/6/17.
 */

public class Response {

    private Loc loc;
    private String interval;
    private List<Period> periods;

    public Response(Loc loc, String interval, List<Period> periods) {
        this.loc = loc;
        this.interval = interval;
        this.periods = periods;
    }

    public Loc getLoc() {
        return loc;
    }

    public void setLoc(Loc loc) {
        this.loc = loc;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }
}
