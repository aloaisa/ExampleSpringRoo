package com.foo.client.managed.activity;

import com.foo.client.managed.activity.TimerEditActivityWrapper.View;
import com.foo.client.managed.request.ApplicationRequestFactory;
import com.foo.client.managed.request.TimerProxy;
import com.foo.client.scaffold.activity.IsScaffoldMobileActivity;
import com.foo.client.scaffold.place.ProxyEditView;
import com.foo.client.scaffold.place.ProxyListPlace;
import com.foo.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TimerEditActivityWrapper extends TimerEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<TimerProxy> proxyId;

    public TimerEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<com.foo.client.managed.request.TimerProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(TimerProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New Timer" : "Edit Timer";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends com.foo.client.scaffold.place.ProxyEditView<com.foo.client.managed.request.TimerProxy, V>> extends View_Roo_Gwt<V> {
    }
}
