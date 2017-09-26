package org.sabsa.dasl.validation;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.sabsa.dasl.dasl.AbstractElement;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;

public class Validator {
	
	/**
	 * Does a flow violate network zoning rules?
	 * @param f flow to test
	 * @return boolean
	 */
	public static boolean doesFlowViolateZoneRules(Flow f) {
		// get all nodes for the source component of the flow 
		EList<Node> fromNodes = getNodesForComponent(f.getFrom());		
		// if no nodes have been found, then assume a violation
		if (fromNodes==null || fromNodes.size()==0)
			return true; 
		
		// get the first (and only) zone for the source node
		Zone fromZone = getZoneForNode(fromNodes.get(0));
		
		// get all nodes for the target component of the flow
		EList<Node> toNodes = getNodesForComponent(f.getTo());
		// if no nodes have been found, then assume a violation
		if (toNodes==null || toNodes.size()==0)
			return true; 
		
		// get the first (and only) zone for the target node
		Zone toZone = getZoneForNode(toNodes.get(0));
		
		// if the flow is within the same zone its ok
		if (fromZone.equals(toZone))
			return false;
		
		// if the target zone has ingress for source zone its ok
		if (toZone.getIngressZones().contains(fromZone))
			return false;
		
		// assume failure
		return true;
	}
	
	/**
	 * Get Zone for a given Node n
	 * @param n
	 * @return Zone single zone
	 */
	public static Zone getZoneForNode(Node n) {
		EObject eObject = n.eContainer();
		if (eObject instanceof SecurityModel) {
			SecurityModel model = (SecurityModel)eObject;
			// traverse all zones looking for node
			for(AbstractElement e : model.getElements()) {
				if (e instanceof Zone) {
					Zone z = (Zone)e;
					if (z.eCrossReferences().contains(n))
						return z;
				}
			}
		}
		return null;
	}
	
	public static boolean doesFlowHaveAtLeastOneInformationAsset(Flow f) {
		return f.getAssets().size()>0 ? true : false;
	}

	/**
	 * Are there nodes that exist in the model that 
	 * are not in any zone?
	 * @param n Node
	 * @return boolean
	 */
	public static boolean isNodeInAtLeastOneZone(Node n) {
		EObject eObject = n.eContainer();
		if (eObject instanceof SecurityModel) {
			SecurityModel model = (SecurityModel)eObject;
			// traverse all zones looking for node
			for(AbstractElement e : model.getElements()) {
				if (e instanceof Zone) {
					Zone z = (Zone)e;
					for(Node searchNode : z.getNodes()) {
						if (searchNode.getName().equals(n.getName())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private static EList<Node> getNodesForComponent(Component c) {
		EList<Node> nodes = new BasicEList<Node>();
		EObject eObject = c.eContainer();
		if (eObject instanceof SecurityModel) {
			SecurityModel model = (SecurityModel)eObject;
			for(AbstractElement e : model.getElements()) {
				if (e instanceof Node) {
					Node n = (Node)e;
					if (n.getComponents().contains(c)) {
						nodes.add(n);
					}
				}
			}
		}
		return nodes;
	}

	/*
	private static EList<AbstractElement> getFilteredCollection(
			AbstractElement start,
			Class<AbstractElement> clazz) {
		SecurityModel model = (SecurityModel)start.eContainer();
		return model.getElements()
			.stream()
			.filter(e -> e.eClass().getName().equals(clazz.getName()))
			.collect(Collectors.toCollection(BasicEList::new));
	}
	*/
	
	// end to end flow must be encrypted for confirmation assets
	
	
	
}
