package org.sabsa.dasl.ui.plantuml;

import org.sabsa.dasl.dasl.AbstractElement;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.InformationAsset;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;

public class DaslPlantUMLPrinter {
	
	public static String print(SecurityModel model) {
		StringBuffer buf = new StringBuffer();

		// generate all zones first
		for (AbstractElement element : model.getElements()) {
			if (element instanceof Zone) {
				buf.append(print((Zone)element));
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
		buf.append("rectangle \"" + node.getName() + " [" + node.getRef() + "]\" #FFFFFF {\n");
		for (Component comp : node.getComponents()) {
			buf.append(print(comp));
		}
		buf.append("}\n");
		return buf.toString();
	}
	
	public static String print(Flow flow) {
		StringBuffer buf = new StringBuffer();
		buf.append(flow.getFrom().getName() + "-->" + flow.getTo().getName() + ": ");
		buf.append(flow.getName());
//		for (InformationAsset asset : flow.getReferencedObjects()) {
//			buf.append(asset.getName() + " ");
//		}
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
