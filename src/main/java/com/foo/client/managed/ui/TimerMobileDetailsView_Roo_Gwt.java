// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.foo.client.managed.ui;

import com.foo.client.managed.request.TimerProxy;
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

public abstract class TimerMobileDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<TimerProxy> {

    @UiField
    Element id;

    @UiField
    Element version;

    @UiField
    Element userName;

    @UiField
    Element startDate;

    TimerProxy proxy;

    public void setValue(TimerProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        userName.setInnerText(proxy.getUserName() == null ? "" : String.valueOf(proxy.getUserName()));
        startDate.setInnerText(proxy.getStartDate() == null ? "" : DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_MEDIUM).format(proxy.getStartDate()));
    }
}
