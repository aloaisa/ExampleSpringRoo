package com.foo.client.managed.ui;

import com.foo.client.managed.request.TimerProxy;
import com.foo.client.managed.ui.TimerMobileDetailsView.Binder;
import com.foo.client.scaffold.place.ProxyDetailsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class TimerMobileDetailsView extends TimerMobileDetailsView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static com.foo.client.managed.ui.TimerMobileDetailsView instance;

    @UiField
    HasClickHandlers delete;

    private Delegate delegate;

    public TimerMobileDetailsView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static com.foo.client.managed.ui.TimerMobileDetailsView instance() {
        if (instance == null) {
            instance = new TimerMobileDetailsView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public TimerProxy getValue() {
        return proxy;
    }

    @UiHandler("delete")
    public void onDeleteClicked(ClickEvent e) {
        delegate.deleteClicked();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, TimerMobileDetailsView> {
    }
}
