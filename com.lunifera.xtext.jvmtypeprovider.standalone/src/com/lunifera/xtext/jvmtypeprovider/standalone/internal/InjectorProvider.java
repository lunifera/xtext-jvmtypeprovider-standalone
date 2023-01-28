package com.lunifera.xtext.jvmtypeprovider.standalone.internal;

import org.eclipse.xtext.xbase.XtypeStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectorProvider {

	public static Injector createInjector(ClassLoader cl) {
		return new InjectorProvider().internalCreateInjector(cl);
	}

	protected Injector internalCreateInjector(ClassLoader cl) {
		XtypeStandaloneSetup.doSetup();

		Module module = new Module() {
			@Override
			public ClassLoader bindClassLoaderToInstance() {
				return cl;
			}
		};
		return Guice.createInjector(module);
	}
}
