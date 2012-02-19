package com.foo.client.managed.activity;

import com.foo.client.managed.request.ApplicationEntityTypesProcessor;
import com.foo.client.managed.request.ApplicationRequestFactory;
import com.foo.client.managed.request.TimerProxy;
import com.foo.client.managed.ui.TimerListView;
import com.foo.client.managed.ui.TimerMobileListView;
import com.foo.client.scaffold.ScaffoldApp;
import com.foo.client.scaffold.place.ProxyListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
