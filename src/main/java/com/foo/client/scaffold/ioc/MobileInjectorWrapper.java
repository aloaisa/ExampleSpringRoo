package com.foo.client.scaffold.ioc;

import com.google.gwt.core.client.GWT;

public class MobileInjectorWrapper implements InjectorWrapper {

	@Override
	public ScaffoldInjector getInjector() {
		return GWT.create(MobileInjector.class);
	}
}
