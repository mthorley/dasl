/*
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class DaslAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/sabsa/dasl/parser/antlr/internal/InternalDasl.tokens");
	}
}
