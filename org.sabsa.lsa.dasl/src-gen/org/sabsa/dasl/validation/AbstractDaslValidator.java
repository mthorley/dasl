/*
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;

@ComposedChecks(validators = {NamesAreUniqueValidator.class})
public abstract class AbstractDaslValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(org.sabsa.dasl.dasl.DaslPackage.eINSTANCE);
		return result;
	}
	
}