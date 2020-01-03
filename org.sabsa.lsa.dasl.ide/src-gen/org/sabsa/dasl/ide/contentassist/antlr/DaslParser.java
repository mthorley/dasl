/*
 * generated by Xtext 2.19.0
 */
package org.sabsa.dasl.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.sabsa.dasl.ide.contentassist.antlr.internal.InternalDaslParser;
import org.sabsa.dasl.services.DaslGrammarAccess;

public class DaslParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(DaslGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, DaslGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAbstractElementAccess().getAlternatives(), "rule__AbstractElement__Alternatives");
			builder.put(grammarAccess.getFlowEndpointAccess().getAlternatives(), "rule__FlowEndpoint__Alternatives");
			builder.put(grammarAccess.getNodeTypeAccess().getAlternatives(), "rule__NodeType__Alternatives");
			builder.put(grammarAccess.getMetadataTypeAccess().getAlternatives(), "rule__MetadataType__Alternatives");
			builder.put(grammarAccess.getNIST80053ARev4_FamilyTypeAccess().getAlternatives(), "rule__NIST80053ARev4_FamilyType__Alternatives");
			builder.put(grammarAccess.getConfidentialityTypeAccess().getAlternatives(), "rule__ConfidentialityType__Alternatives");
			builder.put(grammarAccess.getIntegrityTypeAccess().getAlternatives(), "rule__IntegrityType__Alternatives");
			builder.put(grammarAccess.getAvailabilityTypeAccess().getAlternatives(), "rule__AvailabilityType__Alternatives");
			builder.put(grammarAccess.getSecurityModelAccess().getGroup(), "rule__SecurityModel__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getMetadataAccess().getGroup(), "rule__Metadata__Group__0");
			builder.put(grammarAccess.getZoneAccess().getGroup(), "rule__Zone__Group__0");
			builder.put(grammarAccess.getZoneAccess().getGroup_11(), "rule__Zone__Group_11__0");
			builder.put(grammarAccess.getNodeAccess().getGroup(), "rule__Node__Group__0");
			builder.put(grammarAccess.getNodeAccess().getGroup_11(), "rule__Node__Group_11__0");
			builder.put(grammarAccess.getNodeAccess().getGroup_12(), "rule__Node__Group_12__0");
			builder.put(grammarAccess.getNodeAccess().getGroup_13(), "rule__Node__Group_13__0");
			builder.put(grammarAccess.getComponentAccess().getGroup(), "rule__Component__Group__0");
			builder.put(grammarAccess.getComponentAccess().getGroup_7(), "rule__Component__Group_7__0");
			builder.put(grammarAccess.getComponentAccess().getGroup_12(), "rule__Component__Group_12__0");
			builder.put(grammarAccess.getComponentAccess().getGroup_13(), "rule__Component__Group_13__0");
			builder.put(grammarAccess.getInformationAssetAccess().getGroup(), "rule__InformationAsset__Group__0");
			builder.put(grammarAccess.getFlowAccess().getGroup(), "rule__Flow__Group__0");
			builder.put(grammarAccess.getFlowAccess().getGroup_3(), "rule__Flow__Group_3__0");
			builder.put(grammarAccess.getFlowAccess().getGroup_8(), "rule__Flow__Group_8__0");
			builder.put(grammarAccess.getFlowAccess().getGroup_9(), "rule__Flow__Group_9__0");
			builder.put(grammarAccess.getActorAccess().getGroup(), "rule__Actor__Group__0");
			builder.put(grammarAccess.getControlAccess().getGroup(), "rule__Control__Group__0");
			builder.put(grammarAccess.getBaseControlAccess().getGroup(), "rule__BaseControl__Group__0");
			builder.put(grammarAccess.getSecurityModelAccess().getImportsAssignment_0(), "rule__SecurityModel__ImportsAssignment_0");
			builder.put(grammarAccess.getSecurityModelAccess().getMetadataAssignment_1(), "rule__SecurityModel__MetadataAssignment_1");
			builder.put(grammarAccess.getSecurityModelAccess().getElementsAssignment_2(), "rule__SecurityModel__ElementsAssignment_2");
			builder.put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
			builder.put(grammarAccess.getMetadataAccess().getKeysAssignment_2(), "rule__Metadata__KeysAssignment_2");
			builder.put(grammarAccess.getZoneAccess().getNameAssignment_1(), "rule__Zone__NameAssignment_1");
			builder.put(grammarAccess.getZoneAccess().getTrustAssignment_4(), "rule__Zone__TrustAssignment_4");
			builder.put(grammarAccess.getZoneAccess().getIngressZonesAssignment_6(), "rule__Zone__IngressZonesAssignment_6");
			builder.put(grammarAccess.getZoneAccess().getEgressZonesAssignment_8(), "rule__Zone__EgressZonesAssignment_8");
			builder.put(grammarAccess.getZoneAccess().getNodesAssignment_10(), "rule__Zone__NodesAssignment_10");
			builder.put(grammarAccess.getZoneAccess().getControlsAssignment_11_1(), "rule__Zone__ControlsAssignment_11_1");
			builder.put(grammarAccess.getNodeAccess().getNameAssignment_1(), "rule__Node__NameAssignment_1");
			builder.put(grammarAccess.getNodeAccess().getRefAssignment_4(), "rule__Node__RefAssignment_4");
			builder.put(grammarAccess.getNodeAccess().getHostAssignment_6(), "rule__Node__HostAssignment_6");
			builder.put(grammarAccess.getNodeAccess().getOsAssignment_8(), "rule__Node__OsAssignment_8");
			builder.put(grammarAccess.getNodeAccess().getValueAssignment_10(), "rule__Node__ValueAssignment_10");
			builder.put(grammarAccess.getNodeAccess().getComponentsAssignment_11_1(), "rule__Node__ComponentsAssignment_11_1");
			builder.put(grammarAccess.getNodeAccess().getControlsAssignment_12_1(), "rule__Node__ControlsAssignment_12_1");
			builder.put(grammarAccess.getNodeAccess().getAssetsAssignment_13_1(), "rule__Node__AssetsAssignment_13_1");
			builder.put(grammarAccess.getComponentAccess().getNameAssignment_1(), "rule__Component__NameAssignment_1");
			builder.put(grammarAccess.getComponentAccess().getRefAssignment_4(), "rule__Component__RefAssignment_4");
			builder.put(grammarAccess.getComponentAccess().getStereotypeAssignment_6(), "rule__Component__StereotypeAssignment_6");
			builder.put(grammarAccess.getComponentAccess().getVendorAssignment_7_1(), "rule__Component__VendorAssignment_7_1");
			builder.put(grammarAccess.getComponentAccess().getDescAssignment_9(), "rule__Component__DescAssignment_9");
			builder.put(grammarAccess.getComponentAccess().getVersionAssignment_11(), "rule__Component__VersionAssignment_11");
			builder.put(grammarAccess.getComponentAccess().getAssetsAssignment_12_1(), "rule__Component__AssetsAssignment_12_1");
			builder.put(grammarAccess.getComponentAccess().getControlsAssignment_13_1(), "rule__Component__ControlsAssignment_13_1");
			builder.put(grammarAccess.getComponentAccess().getComponentsAssignment_14(), "rule__Component__ComponentsAssignment_14");
			builder.put(grammarAccess.getInformationAssetAccess().getNameAssignment_1(), "rule__InformationAsset__NameAssignment_1");
			builder.put(grammarAccess.getInformationAssetAccess().getRefAssignment_4(), "rule__InformationAsset__RefAssignment_4");
			builder.put(grammarAccess.getInformationAssetAccess().getDescAssignment_6(), "rule__InformationAsset__DescAssignment_6");
			builder.put(grammarAccess.getInformationAssetAccess().getConfidentialityAssignment_8(), "rule__InformationAsset__ConfidentialityAssignment_8");
			builder.put(grammarAccess.getInformationAssetAccess().getIntegrityAssignment_10(), "rule__InformationAsset__IntegrityAssignment_10");
			builder.put(grammarAccess.getInformationAssetAccess().getAvailabilityAssignment_12(), "rule__InformationAsset__AvailabilityAssignment_12");
			builder.put(grammarAccess.getFlowAccess().getNameAssignment_1(), "rule__Flow__NameAssignment_1");
			builder.put(grammarAccess.getFlowAccess().getDescAssignment_3_1(), "rule__Flow__DescAssignment_3_1");
			builder.put(grammarAccess.getFlowAccess().getFromAssignment_5(), "rule__Flow__FromAssignment_5");
			builder.put(grammarAccess.getFlowAccess().getToAssignment_7(), "rule__Flow__ToAssignment_7");
			builder.put(grammarAccess.getFlowAccess().getAssetsAssignment_8_1(), "rule__Flow__AssetsAssignment_8_1");
			builder.put(grammarAccess.getFlowAccess().getControlsAssignment_9_1(), "rule__Flow__ControlsAssignment_9_1");
			builder.put(grammarAccess.getActorAccess().getNameAssignment_1(), "rule__Actor__NameAssignment_1");
			builder.put(grammarAccess.getActorAccess().getDescAssignment_4(), "rule__Actor__DescAssignment_4");
			builder.put(grammarAccess.getActorAccess().getRolesAssignment_6(), "rule__Actor__RolesAssignment_6");
			builder.put(grammarAccess.getControlAccess().getNameAssignment_1(), "rule__Control__NameAssignment_1");
			builder.put(grammarAccess.getControlAccess().getRefAssignment_4(), "rule__Control__RefAssignment_4");
			builder.put(grammarAccess.getControlAccess().getBaseAssignment_6(), "rule__Control__BaseAssignment_6");
			builder.put(grammarAccess.getControlAccess().getDescAssignment_8(), "rule__Control__DescAssignment_8");
			builder.put(grammarAccess.getControlAccess().getAttAssignment_10(), "rule__Control__AttAssignment_10");
			builder.put(grammarAccess.getBaseControlAccess().getNameAssignment_1(), "rule__BaseControl__NameAssignment_1");
			builder.put(grammarAccess.getBaseControlAccess().getFamilyAssignment_4(), "rule__BaseControl__FamilyAssignment_4");
			builder.put(grammarAccess.getBaseControlAccess().getTitleAssignment_6(), "rule__BaseControl__TitleAssignment_6");
			builder.put(grammarAccess.getBaseControlAccess().getDescAssignment_8(), "rule__BaseControl__DescAssignment_8");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private DaslGrammarAccess grammarAccess;

	@Override
	protected InternalDaslParser createParser() {
		InternalDaslParser result = new InternalDaslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public DaslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DaslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
