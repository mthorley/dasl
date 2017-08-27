/*
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.ui;

import com.google.inject.Injector;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.sabsa.lsa.dasl.ui.internal.DaslActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class DaslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return DaslActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return DaslActivator.getInstance().getInjector(DaslActivator.ORG_SABSA_DASL_DASL);
	}
	
}
