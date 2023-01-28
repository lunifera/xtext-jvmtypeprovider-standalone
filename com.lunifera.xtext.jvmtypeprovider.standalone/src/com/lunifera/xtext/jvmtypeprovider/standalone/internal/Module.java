package com.lunifera.xtext.jvmtypeprovider.standalone.internal;

import java.util.Properties;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ClasspathBasedTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.IgnoreCaseLinking;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

@SuppressWarnings("all")
public class Module extends AbstractGenericModule {

	public java.lang.ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}

	public TypesFactory bindTypesFactoryToInstance() {
		return TypesFactory.eINSTANCE;
	}

	public Class<? extends IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return ClasspathTypeProviderFactory.class;
	}

	public Class<? extends AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return ClasspathBasedTypeScopeProvider.class;
	}

	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return TypesAwareDefaultGlobalScopeProvider.class;
	}
	
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return DefaultDeclarativeQualifiedNameProvider.class;
	}
	
	public void configureIResourceDescriptions(Binder binder) {
		binder.bind(IResourceDescriptions.class).to(ResourceSetBasedResourceDescriptions.class);
	}
	
}
