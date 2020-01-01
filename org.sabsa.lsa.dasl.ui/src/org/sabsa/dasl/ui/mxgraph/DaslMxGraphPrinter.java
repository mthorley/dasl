package org.sabsa.dasl.ui.mxgraph;

import org.sabsa.dasl.DaslUtils;
import org.sabsa.dasl.dasl.AbstractElement;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;

// @EXPERIMENTAL

/*
 * var col1 = graph.insertVertex(parent, null, '', 0, 0, 120, 0, 'column');
 * var zone1 = graph.insertVertex(col1, null, "zonename", 0, 0, 100, 40)
 * var node1 = graph.insertVertex(zone1, null, "nodename", 0, 0, 100, 40)
 * var comp1 = graph.insertVertex(node1, null, "comp", 0, 0, 100, 40)
 * var e1 = graph.insertEdge(parent, null, "Flow", v1, v2);
 * 
 */
public class DaslMxGraphPrinter {

	public String print(SecurityModel model) {
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
	
	private String print(Zone zone) {
		StringBuffer buf = new StringBuffer();
		String zoneName = zone.getName();
		String zoneCol = zoneName + "col";
		buf.append("var " + zoneCol + " = graph.insertVertex(parent, null, '', 0, 0, 120, 0, 'column');\n");
		buf.append("var " + zoneName + " = graph.insertVertex(" + zoneCol + ", null, '" 
				+ zone.getName() + "', 0, 0, 100, 40);\n");
		for (Node node : zone.getNodes()) {
			buf.append(print(node, zone));
		}
		buf.append("\n");
		return buf.toString();		
	}
	
	private String print(Node node, Zone zone) {
		StringBuffer buf = new StringBuffer();
		//buf.append("rectangle \"" + node.getName() + " [" + node.getRef() + "]\" #FFFFFF {\n");
		buf.append("var " + node.getName() + " = graph.insertVertex(" + 
				zone.getName() + ", null, '" + node.getName() + "', 0, 0, 100, 40);\n");
				 
		for (Component comp : node.getComponents()) {
			buf.append(print(comp, node));
		}
		return buf.toString();
	}
	
	private String print(Flow flow) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("var " + flow.getName() + 
				"= graph.insertEdge(parent, null, '" + flow.getName() + "', " +
				DaslUtils.getName(flow.getTo()) + ", " + 
				DaslUtils.getName(flow.getFrom()) + ");");
		
		buf.append("\n");
		return buf.toString();
	}
		
	private String print(Component comp, Node node) {
		StringBuffer buf = new StringBuffer();
		buf.append("var " + comp.getName() + 
				" = graph.insertVertex(" + node.getName() + ", null, '" + comp.getName() + "', 0, 0, 100, 40);");
		
		//buf.append("rectangle " + comp.getName().replace(' ', '_') + "[\n");
		//buf.append("<b>" + comp.getName() + " [" + comp.getRef() + "]</b>\n");
		//buf.append("----\n");
		//for (InformationAsset asset : comp.getAssets()) {
		//	buf.append(print(asset));
		//}
		buf.append("\n");
		return buf.toString();
	}
	
}
