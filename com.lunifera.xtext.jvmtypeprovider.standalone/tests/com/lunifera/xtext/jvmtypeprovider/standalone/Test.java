package com.lunifera.xtext.jvmtypeprovider.standalone;

import java.util.ArrayList;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

@SuppressWarnings("restriction")
public class Test {

	@org.junit.Test
	public void test() {
		
		// create the factory and the type provider
		IJvmTypeProvider.Factory factory = JvmTypeFactoryProvider.getTypeProviderFactory(getClass().getClassLoader());
		IJvmTypeProvider typeProvider = factory.createTypeProvider();
		
		// resolve jvm type
		JvmGenericType jvmType = (JvmGenericType) typeProvider.findTypeByName(ArrayList.class.getName());
		jvmType.getAllFeatures().forEach(f -> System.out.println(f));
	}

	public static void main(String[] args) {
		new Test().test();
	}

}
