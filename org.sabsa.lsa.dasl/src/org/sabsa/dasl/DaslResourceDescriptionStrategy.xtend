package org.sabsa.dasl

import com.google.inject.Inject
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.impl.ImportUriResolver
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.emf.ecore.EObject
import java.util.HashMap
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.naming.QualifiedName
import org.sabsa.dasl.dasl.SecurityModel

class DaslResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	
	public static final String IMPORTS = "imports"
	
	@Inject
	ImportUriResolver uriResolver

	override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if(eObject instanceof SecurityModel) {
			this.createEObjectDescriptionForModel(eObject, acceptor)
			return true
		}
		else {
			super.createEObjectDescriptions(eObject, acceptor)
		}
	}

	def void createEObjectDescriptionForModel(SecurityModel model, IAcceptor<IEObjectDescription> acceptor) {
		val uris = newArrayList()
		model.imports.forEach[uris.add(uriResolver.apply(it))]
		val userData = new HashMap<String,String>
		userData.put(IMPORTS, uris.join(","))
		acceptor.accept(EObjectDescription.create(QualifiedName.create(model.eResource.URI.toString), model, userData))
	}
}
