package com.foo.client.managed.ui;

import com.foo.client.managed.request.TimerProxy;
import com.google.gwt.requestfactory.ui.client.ProxyRenderer;

public class TimerProxyRenderer extends ProxyRenderer<TimerProxy> {

    private static com.foo.client.managed.ui.TimerProxyRenderer INSTANCE;

    protected TimerProxyRenderer() {
        super(new String[] { "userName" });
    }

    public static com.foo.client.managed.ui.TimerProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TimerProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TimerProxy object) {
        if (object == null) {
            return "";
        }
        return object.getUserName() + " (" + object.getId() + ")";
    }
}
