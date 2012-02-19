package com.foo.client.managed.activity;

import com.foo.client.managed.request.ApplicationRequestFactory;
import com.foo.client.managed.request.TimerProxy;
import com.foo.client.managed.request.TimerRequest;
import com.foo.client.managed.ui.TimerDetailsView;
import com.foo.client.managed.ui.TimerEditView;
import com.foo.client.managed.ui.TimerListView;
import com.foo.client.managed.ui.TimerMobileDetailsView;
import com.foo.client.managed.ui.TimerMobileEditView;
import com.foo.client.scaffold.ScaffoldApp;
import com.foo.client.scaffold.place.CreateAndEditProxy;
import com.foo.client.scaffold.place.FindAndEditProxy;
import com.foo.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;

public class TimerActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public TimerActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new TimerDetailsActivity((EntityProxyId<TimerProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? TimerMobileDetailsView.instance() : TimerDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<com.foo.client.managed.request.TimerProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<TimerProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        TimerEditView.instance().setCreating(true);
        final TimerRequest request = requests.timerRequest();
        Activity activity = new CreateAndEditProxy<TimerProxy>(TimerProxy.class, request, ScaffoldApp.isMobile() ? TimerMobileEditView.instance() : TimerEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(TimerProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new TimerEditActivityWrapper(requests, ScaffoldApp.isMobile() ? TimerMobileEditView.instance() : TimerEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        TimerEditView.instance().setCreating(false);
        EntityProxyId<TimerProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<TimerProxy>(proxyId, requests, ScaffoldApp.isMobile() ? TimerMobileEditView.instance() : TimerEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(TimerProxy proxy) {
                TimerRequest request = requests.timerRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new TimerEditActivityWrapper(requests, ScaffoldApp.isMobile() ? TimerMobileEditView.instance() : TimerEditView.instance(), activity, proxyId);
    }
}
