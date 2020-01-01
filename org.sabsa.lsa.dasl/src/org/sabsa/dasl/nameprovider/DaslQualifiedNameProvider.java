package org.sabsa.dasl.nameprovider;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.sabsa.dasl.dasl.SecurityModel;

public class DaslQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	QualifiedName qualifiedName(SecurityModel sm) {
		return QualifiedName.create(sm.eResource().getURI().trimFileExtension().lastSegment(), 
				sm.eResource().getURI().fileExtension());
	}	
}
