/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl;

import org.sabsa.dasl.DaslStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class DaslStandaloneSetup extends DaslStandaloneSetupGenerated {
  public static void doSetup() {
    new DaslStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
