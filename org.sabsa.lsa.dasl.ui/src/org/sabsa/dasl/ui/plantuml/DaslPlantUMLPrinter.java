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
import org.sabsa.dasl.dasl.Control;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.Import;
import org.sabsa.dasl.dasl.InformationAsset;
import org.sabsa.dasl.dasl.Metadata;
import org.sabsa.dasl.dasl.MetadataType;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;
import org.sabsa.dasl.validation.Validator;
import org.sabsa.lsa.dasl.ui.internal.DaslActivator;

import com.google.inject.Injector;

public class DaslPlantUMLPrinter {
	
	public static String LINE_SEPERATOR = "----\n";
	
	public static class Metadata {
		public boolean showControlsOnComponents = false;
		public boolean showAssetsOnFlows = false;
		public boolean showControlsOnFlows = false;
		public boolean showAssetsOnComponents = false;
	}
		
	public static Metadata getMetadata(SecurityModel model) {
		
		Metadata md = new DaslPlantUMLPrinter.Metadata();
		
		if (model.getMetadata()==null)
			return md;
		
		if (model.getMetadata().getKeys().size()>0) {
			md.showControlsOnComponents = model.getMetadata().getKeys().contains(MetadataType.SHOW_CONTROLS_ON_COMPONENTS) ? true : false;
			md.showAssetsOnFlows = model.getMetadata().getKeys().contains(MetadataType.SHOW_ASSETS_ON_FLOWS) ? true : false;
			md.showControlsOnFlows = model.getMetadata().getKeys().contains(MetadataType.SHOW_CONTROLS_ON_FLOWS) ? true : false;
			md.showAssetsOnComponents = model.getMetadata().getKeys().contains(MetadataType.SHOW_ASSETS_ON_COMPONENTS) ? true : false;			
		}
		return md;
	}
		
	public static String print(SecurityModel model) {
		StringBuffer buf = new StringBuffer();

		buf.append("skinparam componentArrowColor #696969 \n");
		
		if (model.getElements().size()==0)
			return "";
		
		
		Metadata md = getMetadata(model);
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
				buf.append(print((Zone)element, md));
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
				buf.append(print((Flow)element, md));
			}
		}
		return buf.toString();
	}
	
	public static String print(Actor actor) {
		StringBuffer buf = new StringBuffer();
		buf.append("actor " + actor.getName() + "\n");
		return buf.toString();
	}
	
	public static String print(Zone zone, Metadata md) {
		StringBuffer buf = new StringBuffer();
		buf.append("rectangle \"" + zone.getName() + "\" #D3D3D3 {\n");
		for (Node node : zone.getNodes()) {
			buf.append(print(node, md));
		}
		buf.append("}\n");
		return buf.toString();		
	}
	
	public static String print(Node node, Metadata md) {
		StringBuffer buf = new StringBuffer();
		buf.append("rectangle \"" + node.getName() + 
				" [" + node.getRef() + "]\" as " + node.getName() + " #FFFFFF {\n");
		for (Component comp : node.getComponents()) {
			buf.append(print(comp, md));
		}
		buf.append("}\n");
		return buf.toString();
	}
		
	public static String print(Flow flow, Metadata md) {
		StringBuffer buf = new StringBuffer();
		if (Validator.doesFlowViolateZoneRules(flow)) {
			// violation of zone rules - turn connector colour red
			buf.append(DaslUtils.getName(flow.getFrom()) + "-[#FF0000]-->" + DaslUtils.getName(flow.getTo()) + ": ");			
		}
		else {
			buf.append(DaslUtils.getName(flow.getFrom()) + "--->" + DaslUtils.getName(flow.getTo()) + ": ");
		}
		buf.append("<i>" + flow.getName() + ' ' + flow.getDesc() + "</i>\n");
		
		if (md.showAssetsOnFlows || md.showControlsOnFlows) {
			buf.append("note on link #white\n");
			
			// assets
			if (md.showAssetsOnFlows) {
				// add all info assets to flow label
				if (flow.getAssets().size() > 0 ) {
					for (InformationAsset asset : flow.getAssets()) {
						buf.append("<i>" + asset.getRef() + ' ' + asset.getName() + "</i>\n");
					}
				}
				else {
					buf.append("<i> No information assets</i>\n");
				}
			}
			
			// controls
			if (md.showControlsOnFlows) {
				if (flow.getControls().size() > 0) {
					buf.append(LINE_SEPERATOR);
					for (Control c : flow.getControls()) {
						buf.append("<i>" + c.getRef() + ' ' + c.getName() + "</i>\n");
					}
				}
				else {
					buf.append("<i> No controls</i>\n");
				}
			}
			buf.append("end note");
		}

		buf.append("\n");
		return buf.toString();
	}
	
	public static String print(InformationAsset asset) {
		return "<b>[" + asset.getRef() + "]</b> " + asset.getName() + "\n";
	}
	
	public static String print(Component comp, Metadata md) {
		StringBuffer buf = new StringBuffer();
		buf.append("rectangle " + comp.getName().replace(' ', '_') + "[\n");
		buf.append("<b>" + comp.getName() + " [" + comp.getRef() + "]</b>\n");
		if (md.showAssetsOnComponents) {
			buf.append(LINE_SEPERATOR);
			for (InformationAsset asset : comp.getAssets()) {
				buf.append(print(asset));
			}
		}
		
		if (md.showControlsOnComponents && comp.getControls().size()>0) {
			buf.append(LINE_SEPERATOR);
			for (Control c : comp.getControls()) {
				buf.append(print(c));
			}
		}
		
		buf.append("]\n");
		return buf.toString();
	}
	
	public static String print(Control c) {
		return "<b>[" + c.getRef() + "]</b> " + c.getName() + "\n";
	}
	
}
