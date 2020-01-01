/*
 * generated by Xtext 2.19.0
 */
package org.sabsa.dasl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.sabsa.dasl.dasl.Actor;
import org.sabsa.dasl.dasl.BaseControl;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.Control;
import org.sabsa.dasl.dasl.DaslPackage;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.Import;
import org.sabsa.dasl.dasl.InformationAsset;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;
import org.sabsa.dasl.services.DaslGrammarAccess;

@SuppressWarnings("all")
public class DaslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DaslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == DaslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case DaslPackage.ACTOR:
				sequence_Actor(context, (Actor) semanticObject); 
				return; 
			case DaslPackage.BASE_CONTROL:
				sequence_BaseControl(context, (BaseControl) semanticObject); 
				return; 
			case DaslPackage.COMPONENT:
				sequence_Component(context, (Component) semanticObject); 
				return; 
			case DaslPackage.CONTROL:
				sequence_Control(context, (Control) semanticObject); 
				return; 
			case DaslPackage.FLOW:
				sequence_Flow(context, (Flow) semanticObject); 
				return; 
			case DaslPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case DaslPackage.INFORMATION_ASSET:
				sequence_InformationAsset(context, (InformationAsset) semanticObject); 
				return; 
			case DaslPackage.NODE:
				sequence_Node(context, (Node) semanticObject); 
				return; 
			case DaslPackage.SECURITY_MODEL:
				sequence_SecurityModel(context, (SecurityModel) semanticObject); 
				return; 
			case DaslPackage.ZONE:
				sequence_Zone(context, (Zone) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Actor returns Actor
	 *     AbstractElement returns Actor
	 *     FlowEndpoint returns Actor
	 *
	 * Constraint:
	 *     (name=ID desc=STRING roles=STRING)
	 */
	protected void sequence_Actor(ISerializationContext context, Actor semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.ACTOR__DESC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.ACTOR__DESC));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.ACTOR__ROLES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.ACTOR__ROLES));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getActorAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getActorAccess().getDescSTRINGTerminalRuleCall_4_0(), semanticObject.getDesc());
		feeder.accept(grammarAccess.getActorAccess().getRolesSTRINGTerminalRuleCall_6_0(), semanticObject.getRoles());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     BaseControl returns BaseControl
	 *     AbstractElement returns BaseControl
	 *
	 * Constraint:
	 *     (name=ID family=NIST80053ARev4_FamilyType title=STRING desc=STRING)
	 */
	protected void sequence_BaseControl(ISerializationContext context, BaseControl semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.BASE_CONTROL__FAMILY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.BASE_CONTROL__FAMILY));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.BASE_CONTROL__TITLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.BASE_CONTROL__TITLE));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.BASE_CONTROL__DESC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.BASE_CONTROL__DESC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBaseControlAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getBaseControlAccess().getFamilyNIST80053ARev4_FamilyTypeEnumRuleCall_4_0(), semanticObject.getFamily());
		feeder.accept(grammarAccess.getBaseControlAccess().getTitleSTRINGTerminalRuleCall_6_0(), semanticObject.getTitle());
		feeder.accept(grammarAccess.getBaseControlAccess().getDescSTRINGTerminalRuleCall_8_0(), semanticObject.getDesc());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Component returns Component
	 *     AbstractElement returns Component
	 *     FlowEndpoint returns Component
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         ref=ID 
	 *         stereotype=STRING 
	 *         vendor=STRING? 
	 *         desc=STRING 
	 *         version=STRING 
	 *         assets+=[InformationAsset|QualifiedName]* 
	 *         controls+=[Control|ID]* 
	 *         components+=Component*
	 *     )
	 */
	protected void sequence_Component(ISerializationContext context, Component semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Control returns Control
	 *     AbstractElement returns Control
	 *
	 * Constraint:
	 *     (name=ID ref=ID base=[BaseControl|ID] desc=STRING att=STRING)
	 */
	protected void sequence_Control(ISerializationContext context, Control semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.CONTROL__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.CONTROL__REF));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.CONTROL__BASE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.CONTROL__BASE));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.CONTROL__DESC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.CONTROL__DESC));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.CONTROL__ATT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.CONTROL__ATT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getControlAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getControlAccess().getRefIDTerminalRuleCall_4_0(), semanticObject.getRef());
		feeder.accept(grammarAccess.getControlAccess().getBaseBaseControlIDTerminalRuleCall_6_0_1(), semanticObject.eGet(DaslPackage.Literals.CONTROL__BASE, false));
		feeder.accept(grammarAccess.getControlAccess().getDescSTRINGTerminalRuleCall_8_0(), semanticObject.getDesc());
		feeder.accept(grammarAccess.getControlAccess().getAttSTRINGTerminalRuleCall_10_0(), semanticObject.getAtt());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Flow returns Flow
	 *     AbstractElement returns Flow
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         desc=STRING? 
	 *         from=[FlowEndpoint|ID] 
	 *         to=[FlowEndpoint|ID] 
	 *         assets+=[InformationAsset|QualifiedName]* 
	 *         controls+=[Control|ID]*
	 *     )
	 */
	protected void sequence_Flow(ISerializationContext context, Flow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.IMPORT__IMPORT_URI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     InformationAsset returns InformationAsset
	 *     AbstractElement returns InformationAsset
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         ref=ID 
	 *         desc=STRING 
	 *         confidentiality=ConfidentialityType 
	 *         integrity=IntegrityType 
	 *         availability=AvailabilityType
	 *     )
	 */
	protected void sequence_InformationAsset(ISerializationContext context, InformationAsset semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.ABSTRACT_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__REF));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__DESC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__DESC));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__CONFIDENTIALITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__CONFIDENTIALITY));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__INTEGRITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__INTEGRITY));
			if (transientValues.isValueTransient(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__AVAILABILITY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DaslPackage.Literals.INFORMATION_ASSET__AVAILABILITY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getInformationAssetAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getInformationAssetAccess().getRefIDTerminalRuleCall_4_0(), semanticObject.getRef());
		feeder.accept(grammarAccess.getInformationAssetAccess().getDescSTRINGTerminalRuleCall_6_0(), semanticObject.getDesc());
		feeder.accept(grammarAccess.getInformationAssetAccess().getConfidentialityConfidentialityTypeEnumRuleCall_8_0(), semanticObject.getConfidentiality());
		feeder.accept(grammarAccess.getInformationAssetAccess().getIntegrityIntegrityTypeEnumRuleCall_10_0(), semanticObject.getIntegrity());
		feeder.accept(grammarAccess.getInformationAssetAccess().getAvailabilityAvailabilityTypeEnumRuleCall_12_0(), semanticObject.getAvailability());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Node returns Node
	 *     AbstractElement returns Node
	 *     FlowEndpoint returns Node
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         ref=ID 
	 *         host=STRING 
	 *         os=STRING 
	 *         value=NodeType 
	 *         components+=[Component|ID]* 
	 *         controls+=[Control|ID]* 
	 *         assets+=[InformationAsset|QualifiedName]*
	 *     )
	 */
	protected void sequence_Node(ISerializationContext context, Node semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SecurityModel returns SecurityModel
	 *
	 * Constraint:
	 *     ((imports+=Import+ elements+=AbstractElement+) | elements+=AbstractElement+)?
	 */
	protected void sequence_SecurityModel(ISerializationContext context, SecurityModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Zone returns Zone
	 *     AbstractElement returns Zone
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         trust=INT 
	 *         ingressZones+=[Zone|ID]* 
	 *         egressZones+=[Zone|ID]* 
	 *         nodes+=[Node|ID]* 
	 *         controls+=[Control|ID]*
	 *     )
	 */
	protected void sequence_Zone(ISerializationContext context, Zone semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
