/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.sabsa.dasl.DaslRuntimeModule;
import org.sabsa.dasl.DaslStandaloneSetup;
import org.sabsa.dasl.ide.DaslIdeModule;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class DaslIdeSetup extends DaslStandaloneSetup {
  public Injector createInjector() {
    DaslRuntimeModule _daslRuntimeModule = new DaslRuntimeModule();
    DaslIdeModule _daslIdeModule = new DaslIdeModule();
    return Guice.createInjector(Modules2.mixin(_daslRuntimeModule, _daslIdeModule));
  }
}
