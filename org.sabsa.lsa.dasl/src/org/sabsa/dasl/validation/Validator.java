package org.sabsa.dasl.validation;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.sabsa.dasl.dasl.AbstractElement;
import org.sabsa.dasl.dasl.Actor;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.InformationAsset;
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
		
		// ensure both from and to are not actors
		if (f.getFrom() instanceof Actor || f.getTo() instanceof Actor) {
			return false;
		}

		Zone fromZone = null;
		if (f.getFrom() instanceof Component) {
			// get all nodes for the source component of the flow
			EList<Node> fromNodes = getNodesForComponent((Component)f.getFrom());		
			// if no nodes have been found, then assume a violation
			if (fromNodes==null || fromNodes.size()==0)
				return true; 
			// get the first (and only) zone for the source node
			fromZone = getZoneForNode(fromNodes.get(0));
		}
		else if (f.getFrom() instanceof Node) {
			fromZone = getZoneForNode((Node)f.getFrom());
		}
		else {
			return false;
		}

		Zone toZone = null;
		if (f.getTo() instanceof Component) {
			// get all nodes for the target component of the flow
			EList<Node> toNodes = getNodesForComponent((Component)f.getTo());
			// if no nodes have been found, then assume a violation
			if (toNodes==null || toNodes.size()==0)
				return true; 
			// get the first (and only) zone for the target node
			toZone = getZoneForNode(toNodes.get(0));
		}
		else if (f.getTo() instanceof Node){
			toZone = getZoneForNode((Node)f.getTo());
		}
		else {
			return false;
		}
		
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
	
	/**
	 * Is the informationasset stored on at least one component or node? 
	 * @param n Node
	 * @return boolean
	 */
	public static boolean isInformationAssetStored(InformationAsset ia) {
		EObject eObject = ia.eContainer();

		// if sec model doesn't contain zones then exit - its an include file			
		int zoneCount = 0;

		if (eObject instanceof SecurityModel) {
			SecurityModel model = (SecurityModel)eObject;
			
			// traverse all components or nodes looking for information asset
			for(AbstractElement e : model.getElements()) {
				if (e instanceof Zone) {
					Zone z = (Zone)e;
					zoneCount++;
					for(Node searchNode : z.getNodes()) {
						if (searchNode.getAssets().contains(ia))
							return true;
						// search components
						for(Component searchComp : searchNode.getComponents()) {
							if (searchComp.getAssets().contains(ia))
								return true;
						}
					}
				}
			}
		}
		if (zoneCount==0)
			return true;
		else
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
