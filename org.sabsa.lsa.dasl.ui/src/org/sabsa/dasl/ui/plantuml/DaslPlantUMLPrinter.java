package org.sabsa.dasl.ui.plantuml;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.sabsa.dasl.DaslUtils;
import org.sabsa.dasl.dasl.AbstractElement;
import org.sabsa.dasl.dasl.Actor;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.Import;
import org.sabsa.dasl.dasl.InformationAsset;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;
import org.sabsa.dasl.validation.Validator;
import org.sabsa.lsa.dasl.ui.internal.DaslActivator;

import com.google.inject.Injector;

public class DaslPlantUMLPrinter {
		
	public static String print(SecurityModel model) {
		StringBuffer buf = new StringBuffer();

		buf.append("skinparam componentArrowColor #696969 \n");
		
		if (model.getElements().size()==0)
			return "";
/*
		Injector injector = DaslActivator.getInstance().getInjector("org.sabsa.dasl.Dasl");
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		for (Import element : model.getImports()) {
			System.out.println(element.getImportURI());
			Resource resource = resourceSet.getResource(
			    URI.createURI("platform:/resource/working/alpha1/" + element.getImportURI()), true);
			System.out.println(resource.getClass());

			EObject eo = resource.getContents().get(0);
			System.out.println(eo.getClass());
			
			SecurityModel m = (SecurityModel)eo;
			// generate all zones first
			for (AbstractElement ae : m.getElements()) {
				if (ae instanceof Zone) {
					buf.append(print((Zone)ae));
				}
			}
			
			// generate all actors
			for (AbstractElement ae : m.getElements()) {
				if (ae instanceof Actor) {
					buf.append(print((Actor)ae));
				}
			}
		}
*/
		// generate all zones first
		for (AbstractElement element : model.getElements()) {
			if (element instanceof Zone) {
				buf.append(print((Zone)element));
			}
		}
		
		// generate all actors
		for (AbstractElement element : model.getElements()) {
			if (element instanceof Actor) {
				buf.append(print((Actor)element));
			}
		}
		
		// then generate all flows
		for (AbstractElement element : model.getElements()) {
			if (element instanceof Flow) {
				buf.append(print((Flow)element));
			}
		}
		return buf.toString();
	}
	
	public static String print(Actor actor) {
		StringBuffer buf = new StringBuffer();
		buf.append("actor " + actor.getName() + "\n");
		return buf.toString();
	}
	
	public static String print(Zone zone) {
		StringBuffer buf = new StringBuffer();
		buf.append("rectangle \"" + zone.getName() + "\" #D3D3D3 {\n");
		for (Node node : zone.getNodes()) {
			buf.append(print(node));
		}
		buf.append("}\n");
		return buf.toString();		
	}
	
	public static String print(Node node) {
		StringBuffer buf = new StringBuffer();
		buf.append("rectangle \"" + node.getName() + 
				" [" + node.getRef() + "]\" as " + node.getName() + " #FFFFFF {\n");
		for (Component comp : node.getComponents()) {
			buf.append(print(comp));
		}
		buf.append("}\n");
		return buf.toString();
	}
		
	public static String print(Flow flow) {
		StringBuffer buf = new StringBuffer();
		if (Validator.doesFlowViolateZoneRules(flow)) {
			// violation of zone rules - turn connector colour red
			buf.append(DaslUtils.getName(flow.getFrom()) + "-[#FF0000]-->" + DaslUtils.getName(flow.getTo()) + ": ");			
		}
		else {
			buf.append(DaslUtils.getName(flow.getFrom()) + "--->" + DaslUtils.getName(flow.getTo()) + ": ");
		}
		buf.append("<i>" + flow.getName() + ' ' + flow.getDesc() + "</i>\n");
		
		buf.append("note on link #white\n");
		// add all info assets to flow label
		for (InformationAsset asset : flow.getAssets()) {
			buf.append("<i>" + asset.getRef() + ' ' + asset.getName() + "</i>\n");
		}
		buf.append("end note");
		buf.append("\n");

		return buf.toString();
	}
	
	public static String print(InformationAsset asset) {
		return "<b>[" + asset.getRef() + "]</b> " + asset.getName() + "\n";
	}
	
	public static String print(Component comp) {
		StringBuffer buf = new StringBuffer();
		buf.append("rectangle " + comp.getName().replace(' ', '_') + "[\n");
		buf.append("<b>" + comp.getName() + " [" + comp.getRef() + "]</b>\n");
		buf.append("----\n");
		for (InformationAsset asset : comp.getAssets()) {
			buf.append(print(asset));
		}
		buf.append("]\n");
		return buf.toString();
	}
	
}
