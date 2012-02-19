// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.foo.client.managed.ui;

import com.foo.client.managed.request.TimerProxy;
import com.foo.client.scaffold.place.AbstractProxyListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import java.util.HashSet;
import java.util.Set;

public abstract class TimerListView_Roo_Gwt extends AbstractProxyListView<TimerProxy> {

    @UiField
    CellTable<TimerProxy> table;

    protected Set<String> paths = new HashSet<String>();

    public void init() {
        paths.add("id");
        table.addColumn(new TextColumn<TimerProxy>() {

            Renderer<java.lang.Long> renderer = new AbstractRenderer<java.lang.Long>() {

                public String render(java.lang.Long obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TimerProxy object) {
                return renderer.render(object.getId());
            }
        }, "Id");
        paths.add("version");
        table.addColumn(new TextColumn<TimerProxy>() {

            Renderer<java.lang.Integer> renderer = new AbstractRenderer<java.lang.Integer>() {

                public String render(java.lang.Integer obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TimerProxy object) {
                return renderer.render(object.getVersion());
            }
        }, "Version");
        paths.add("userName");
        table.addColumn(new TextColumn<TimerProxy>() {

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                    return obj == null ? "" : String.valueOf(obj);
                }
            };

            @Override
            public String getValue(TimerProxy object) {
                return renderer.render(object.getUserName());
            }
        }, "User Name");
        paths.add("startDate");
        table.addColumn(new TextColumn<TimerProxy>() {

            Renderer<java.util.Date> renderer = new DateTimeFormatRenderer(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_MEDIUM));

            @Override
            public String getValue(TimerProxy object) {
                return renderer.render(object.getStartDate());
            }
        }, "Start Date");
    }
}
