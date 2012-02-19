package com.foo.client.managed.activity;

import com.foo.client.managed.request.ApplicationRequestFactory;
import com.foo.client.managed.request.TimerProxy;
import com.foo.client.scaffold.ScaffoldMobileApp;
import com.foo.client.scaffold.activity.IsScaffoldMobileActivity;
import com.foo.client.scaffold.place.AbstractProxyListActivity;
import com.foo.client.scaffold.place.ProxyListView;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.view.client.Range;
import java.util.List;

public class TimerListActivity extends AbstractProxyListActivity<TimerProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public TimerListActivity(ApplicationRequestFactory requests, ProxyListView<com.foo.client.managed.request.TimerProxy> view, PlaceController placeController) {
        super(placeController, view, TimerProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Timers";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<com.foo.client.managed.request.TimerProxy>> createRangeRequest(Range range) {
        return requests.timerRequest().findTimerEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.timerRequest().countTimers().fire(callback);
    }
}
