// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.foo.client.managed.request;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("com.foo.Timer")
@ServiceName("com.foo.Timer")
public interface TimerRequest extends RequestContext {

    abstract InstanceRequest<com.foo.client.managed.request.TimerProxy, java.lang.Void> persist();

    abstract InstanceRequest<com.foo.client.managed.request.TimerProxy, java.lang.Void> remove();

    abstract Request<java.lang.Long> countTimers();

    abstract Request<com.foo.client.managed.request.TimerProxy> findTimer(Long id);

    abstract Request<java.util.List<com.foo.client.managed.request.TimerProxy>> findAllTimers();

    abstract Request<java.util.List<com.foo.client.managed.request.TimerProxy>> findTimerEntries(int firstResult, int maxResults);
}