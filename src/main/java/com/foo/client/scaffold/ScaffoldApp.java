package com.foo.client.scaffold;

import com.foo.client.managed.request.ApplicationEntityTypesProcessor;
import com.foo.client.scaffold.place.ProxyListPlace;
import com.foo.client.scaffold.gae.*;
import com.google.gwt.requestfactory.shared.EntityProxy;

import java.util.HashSet;
import java.util.Set;

public class ScaffoldApp {

	static boolean isMobile = false;

	public static boolean isMobile() {
		return isMobile;
	}

	public void run() {
	}

	protected HashSet<ProxyListPlace> getTopPlaces() {
		Set<Class<? extends EntityProxy>> types = ApplicationEntityTypesProcessor.getAll();
		HashSet<ProxyListPlace> rtn = new HashSet<ProxyListPlace>(types.size());

		for (Class<? extends EntityProxy> type : types) {
			rtn.add(new ProxyListPlace(type));
		}

		return rtn;
	}
}