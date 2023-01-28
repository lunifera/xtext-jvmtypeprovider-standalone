package com.lunifera.xtext.jvmtypeprovider.standalone;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.inject.Injector;
import com.lunifera.xtext.jvmtypeprovider.standalone.internal.InjectorProvider;

@SuppressWarnings("restriction")
public class JvmTypeFactoryProvider {

	private JvmTypeFactoryProvider() {
		super();
	}

	public static IJvmTypeProvider.Factory getTypeProviderFactory(ClassLoader cl) {
		Injector injector = InjectorProvider.createInjector(cl);
		IJvmTypeProvider.Factory delegateFactory = injector.getInstance(IJvmTypeProvider.Factory.class);

		return delegateFactory;
	}

}
