/* $Id: oct. 2, 2015 14:59:46$
 * File is automatically generated by the Xtext language generator. Do not change it.
 *
 */
package io.sarl.lang;

import org.eclipse.xtext.junit4.GlobalRegistries;
import org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;

import com.google.inject.Injector;

public class SARLInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
	
    protected GlobalStateMemento stateBeforeInjectorCreation;
	protected GlobalStateMemento stateAfterInjectorCreation;
	protected Injector injector;

	static {
		GlobalRegistries.initializeDefaults();
	}

	@Override
	public Injector getInjector()
	{
		if (injector == null) {
			stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
			this.injector = internalCreateInjector();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}
	
	protected Injector internalCreateInjector() {
	    return new SARLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	@Override
	public void restoreRegistry() {
		stateBeforeInjectorCreation.restoreGlobalState();
	}

	@Override
	public void setupRegistry() {
		getInjector();
		stateAfterInjectorCreation.restoreGlobalState();
	}
}
