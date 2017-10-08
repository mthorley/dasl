package org.sabsa.dasl;

import org.sabsa.dasl.dasl.Actor;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.FlowEndpoint;
import org.sabsa.dasl.dasl.Node;

public class DaslUtils {

	public static String getName(FlowEndpoint fe) {
		if (fe instanceof Actor) {
			return ((Actor)fe).getName();
		}
		else if (fe instanceof Node) {
			return ((Node)fe).getName();
		}
		else if (fe instanceof Component) {
			return ((Component)fe).getName();
		}
		else {
			throw new UnsupportedOperationException("Type " + fe.eClass() + " unknown");
		}
	}

}
