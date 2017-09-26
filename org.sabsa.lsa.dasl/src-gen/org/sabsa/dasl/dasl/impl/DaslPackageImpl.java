/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.dasl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sabsa.dasl.dasl.AbstractElement;
import org.sabsa.dasl.dasl.AvailabilityType;
import org.sabsa.dasl.dasl.Component;
import org.sabsa.dasl.dasl.ConfidentialityType;
import org.sabsa.dasl.dasl.Control;
import org.sabsa.dasl.dasl.ControlType;
import org.sabsa.dasl.dasl.DaslFactory;
import org.sabsa.dasl.dasl.DaslPackage;
import org.sabsa.dasl.dasl.Flow;
import org.sabsa.dasl.dasl.Import;
import org.sabsa.dasl.dasl.InformationAsset;
import org.sabsa.dasl.dasl.IntegrityType;
import org.sabsa.dasl.dasl.Node;
import org.sabsa.dasl.dasl.NodeType;
import org.sabsa.dasl.dasl.SecurityModel;
import org.sabsa.dasl.dasl.Zone;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DaslPackageImpl extends EPackageImpl implements DaslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass securityModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass zoneEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass informationAssetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass flowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass controlEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum nodeTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum controlTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum confidentialityTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum integrityTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum availabilityTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.sabsa.dasl.dasl.DaslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DaslPackageImpl()
  {
    super(eNS_URI, DaslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link DaslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DaslPackage init()
  {
    if (isInited) return (DaslPackage)EPackage.Registry.INSTANCE.getEPackage(DaslPackage.eNS_URI);

    // Obtain or create and register package
    DaslPackageImpl theDaslPackage = (DaslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DaslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DaslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDaslPackage.createPackageContents();

    // Initialize created meta-data
    theDaslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDaslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DaslPackage.eNS_URI, theDaslPackage);
    return theDaslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecurityModel()
  {
    return securityModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecurityModel_Elements()
  {
    return (EReference)securityModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getZone()
  {
    return zoneEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getZone_Name()
  {
    return (EAttribute)zoneEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getZone_Trust()
  {
    return (EAttribute)zoneEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getZone_IngressZones()
  {
    return (EReference)zoneEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getZone_EgressZones()
  {
    return (EReference)zoneEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getZone_Nodes()
  {
    return (EReference)zoneEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getZone_Controls()
  {
    return (EReference)zoneEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNode()
  {
    return nodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNode_Name()
  {
    return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNode_Ref()
  {
    return (EAttribute)nodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNode_Host()
  {
    return (EAttribute)nodeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNode_Os()
  {
    return (EAttribute)nodeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNode_Value()
  {
    return (EAttribute)nodeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNode_Components()
  {
    return (EReference)nodeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponent()
  {
    return componentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Name()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Ref()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Stereotype()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Vendor()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Desc()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponent_Version()
  {
    return (EAttribute)componentEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponent_Assets()
  {
    return (EReference)componentEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponent_Components()
  {
    return (EReference)componentEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInformationAsset()
  {
    return informationAssetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformationAsset_Name()
  {
    return (EAttribute)informationAssetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformationAsset_Ref()
  {
    return (EAttribute)informationAssetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformationAsset_Desc()
  {
    return (EAttribute)informationAssetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformationAsset_Confidentiality()
  {
    return (EAttribute)informationAssetEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformationAsset_Integrity()
  {
    return (EAttribute)informationAssetEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformationAsset_Availability()
  {
    return (EAttribute)informationAssetEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFlow()
  {
    return flowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFlow_Name()
  {
    return (EAttribute)flowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFlow_From()
  {
    return (EReference)flowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFlow_To()
  {
    return (EReference)flowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFlow_Assets()
  {
    return (EReference)flowEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFlow_Controls()
  {
    return (EReference)flowEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getControl()
  {
    return controlEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getControl_Name()
  {
    return (EAttribute)controlEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getControl_Ref()
  {
    return (EAttribute)controlEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getControl_Area()
  {
    return (EAttribute)controlEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getControl_Implementation()
  {
    return (EAttribute)controlEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractElement()
  {
    return abstractElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getNodeType()
  {
    return nodeTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getControlType()
  {
    return controlTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getConfidentialityType()
  {
    return confidentialityTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getIntegrityType()
  {
    return integrityTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAvailabilityType()
  {
    return availabilityTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaslFactory getDaslFactory()
  {
    return (DaslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    securityModelEClass = createEClass(SECURITY_MODEL);
    createEReference(securityModelEClass, SECURITY_MODEL__ELEMENTS);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    zoneEClass = createEClass(ZONE);
    createEAttribute(zoneEClass, ZONE__NAME);
    createEAttribute(zoneEClass, ZONE__TRUST);
    createEReference(zoneEClass, ZONE__INGRESS_ZONES);
    createEReference(zoneEClass, ZONE__EGRESS_ZONES);
    createEReference(zoneEClass, ZONE__NODES);
    createEReference(zoneEClass, ZONE__CONTROLS);

    nodeEClass = createEClass(NODE);
    createEAttribute(nodeEClass, NODE__NAME);
    createEAttribute(nodeEClass, NODE__REF);
    createEAttribute(nodeEClass, NODE__HOST);
    createEAttribute(nodeEClass, NODE__OS);
    createEAttribute(nodeEClass, NODE__VALUE);
    createEReference(nodeEClass, NODE__COMPONENTS);

    componentEClass = createEClass(COMPONENT);
    createEAttribute(componentEClass, COMPONENT__NAME);
    createEAttribute(componentEClass, COMPONENT__REF);
    createEAttribute(componentEClass, COMPONENT__STEREOTYPE);
    createEAttribute(componentEClass, COMPONENT__VENDOR);
    createEAttribute(componentEClass, COMPONENT__DESC);
    createEAttribute(componentEClass, COMPONENT__VERSION);
    createEReference(componentEClass, COMPONENT__ASSETS);
    createEReference(componentEClass, COMPONENT__COMPONENTS);

    informationAssetEClass = createEClass(INFORMATION_ASSET);
    createEAttribute(informationAssetEClass, INFORMATION_ASSET__NAME);
    createEAttribute(informationAssetEClass, INFORMATION_ASSET__REF);
    createEAttribute(informationAssetEClass, INFORMATION_ASSET__DESC);
    createEAttribute(informationAssetEClass, INFORMATION_ASSET__CONFIDENTIALITY);
    createEAttribute(informationAssetEClass, INFORMATION_ASSET__INTEGRITY);
    createEAttribute(informationAssetEClass, INFORMATION_ASSET__AVAILABILITY);

    flowEClass = createEClass(FLOW);
    createEAttribute(flowEClass, FLOW__NAME);
    createEReference(flowEClass, FLOW__FROM);
    createEReference(flowEClass, FLOW__TO);
    createEReference(flowEClass, FLOW__ASSETS);
    createEReference(flowEClass, FLOW__CONTROLS);

    controlEClass = createEClass(CONTROL);
    createEAttribute(controlEClass, CONTROL__NAME);
    createEAttribute(controlEClass, CONTROL__REF);
    createEAttribute(controlEClass, CONTROL__AREA);
    createEAttribute(controlEClass, CONTROL__IMPLEMENTATION);

    abstractElementEClass = createEClass(ABSTRACT_ELEMENT);

    // Create enums
    nodeTypeEEnum = createEEnum(NODE_TYPE);
    controlTypeEEnum = createEEnum(CONTROL_TYPE);
    confidentialityTypeEEnum = createEEnum(CONFIDENTIALITY_TYPE);
    integrityTypeEEnum = createEEnum(INTEGRITY_TYPE);
    availabilityTypeEEnum = createEEnum(AVAILABILITY_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    importEClass.getESuperTypes().add(this.getAbstractElement());
    zoneEClass.getESuperTypes().add(this.getAbstractElement());
    nodeEClass.getESuperTypes().add(this.getAbstractElement());
    componentEClass.getESuperTypes().add(this.getAbstractElement());
    informationAssetEClass.getESuperTypes().add(this.getAbstractElement());
    flowEClass.getESuperTypes().add(this.getAbstractElement());
    controlEClass.getESuperTypes().add(this.getAbstractElement());

    // Initialize classes and features; add operations and parameters
    initEClass(securityModelEClass, SecurityModel.class, "SecurityModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecurityModel_Elements(), this.getAbstractElement(), null, "elements", null, 0, -1, SecurityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(zoneEClass, Zone.class, "Zone", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getZone_Name(), ecorePackage.getEString(), "name", null, 0, 1, Zone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getZone_Trust(), ecorePackage.getEInt(), "trust", null, 0, 1, Zone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getZone_IngressZones(), this.getZone(), null, "ingressZones", null, 0, -1, Zone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getZone_EgressZones(), this.getZone(), null, "egressZones", null, 0, -1, Zone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getZone_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Zone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getZone_Controls(), this.getControl(), null, "controls", null, 0, -1, Zone.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNode_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNode_Host(), ecorePackage.getEString(), "host", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNode_Os(), ecorePackage.getEString(), "os", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNode_Value(), this.getNodeType(), "value", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNode_Components(), this.getComponent(), null, "components", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComponent_Name(), ecorePackage.getEString(), "name", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Vendor(), ecorePackage.getEString(), "vendor", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Desc(), ecorePackage.getEString(), "desc", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComponent_Version(), ecorePackage.getEString(), "version", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponent_Assets(), this.getInformationAsset(), null, "assets", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponent_Components(), this.getComponent(), null, "components", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(informationAssetEClass, InformationAsset.class, "InformationAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInformationAsset_Name(), ecorePackage.getEString(), "name", null, 0, 1, InformationAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInformationAsset_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, InformationAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInformationAsset_Desc(), ecorePackage.getEString(), "desc", null, 0, 1, InformationAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInformationAsset_Confidentiality(), this.getConfidentialityType(), "confidentiality", null, 0, 1, InformationAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInformationAsset_Integrity(), this.getIntegrityType(), "integrity", null, 0, 1, InformationAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInformationAsset_Availability(), this.getAvailabilityType(), "availability", null, 0, 1, InformationAsset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(flowEClass, Flow.class, "Flow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFlow_Name(), ecorePackage.getEString(), "name", null, 0, 1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFlow_From(), this.getComponent(), null, "from", null, 0, 1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFlow_To(), this.getComponent(), null, "to", null, 0, 1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFlow_Assets(), this.getInformationAsset(), null, "assets", null, 0, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFlow_Controls(), this.getControl(), null, "controls", null, 0, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(controlEClass, Control.class, "Control", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getControl_Name(), ecorePackage.getEString(), "name", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getControl_Ref(), ecorePackage.getEString(), "ref", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getControl_Area(), this.getControlType(), "area", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getControl_Implementation(), ecorePackage.getEString(), "implementation", null, 0, 1, Control.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractElementEClass, AbstractElement.class, "AbstractElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(nodeTypeEEnum, NodeType.class, "NodeType");
    addEEnumLiteral(nodeTypeEEnum, NodeType.PHYSICAL);
    addEEnumLiteral(nodeTypeEEnum, NodeType.VIRTUAL);
    addEEnumLiteral(nodeTypeEEnum, NodeType.CONTAINER);

    initEEnum(controlTypeEEnum, ControlType.class, "ControlType");
    addEEnumLiteral(controlTypeEEnum, ControlType.IDENTITY_VALIDATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.USER_PROVISIONING);
    addEEnumLiteral(controlTypeEEnum, ControlType.SYSTEM_USER_PROVISIONING);
    addEEnumLiteral(controlTypeEEnum, ControlType.IDENTITY_TRANSFORMATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.USER_REGISTRIES);
    addEEnumLiteral(controlTypeEEnum, ControlType.CREDENTIAL_MANAGEMENT);
    addEEnumLiteral(controlTypeEEnum, ControlType.AUTHENTICATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.AUTHORISATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.PRIVILEGE_MANAGEMENT);
    addEEnumLiteral(controlTypeEEnum, ControlType.REDUCED_SIGN_ON);
    addEEnumLiteral(controlTypeEEnum, ControlType.FEDERATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.ACCESS_ENTITLEMENT_GOVERNANCE);
    addEEnumLiteral(controlTypeEEnum, ControlType.FIREWALLS_NETWORK);
    addEEnumLiteral(controlTypeEEnum, ControlType.FIREWALLS_APPLICATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.DENIALOF_SERVICE);
    addEEnumLiteral(controlTypeEEnum, ControlType.NETWORK_ADMISSION_CONTROL);
    addEEnumLiteral(controlTypeEEnum, ControlType.REMOTE_ACCESS_GATEWAY);
    addEEnumLiteral(controlTypeEEnum, ControlType.INTRUSION_PREVENTION_DETECTION);
    addEEnumLiteral(controlTypeEEnum, ControlType.ANTIVIRUS);
    addEEnumLiteral(controlTypeEEnum, ControlType.CONTENT_FILTER);
    addEEnumLiteral(controlTypeEEnum, ControlType.MESSAGE_SECURITY);
    addEEnumLiteral(controlTypeEEnum, ControlType.TRANSPORT_SECURITY);
    addEEnumLiteral(controlTypeEEnum, ControlType.STORED_DATA_SECURITY);
    addEEnumLiteral(controlTypeEEnum, ControlType.DATA_LOSS_PREVENTION);
    addEEnumLiteral(controlTypeEEnum, ControlType.DATA_OBFUSCATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.DATA_DESTRUCTION);
    addEEnumLiteral(controlTypeEEnum, ControlType.FRAUD_SECURITY);
    addEEnumLiteral(controlTypeEEnum, ControlType.DATA_TRANSACTION_SECURITY);
    addEEnumLiteral(controlTypeEEnum, ControlType.CENTRALISED_HSM_CA_PKI);
    addEEnumLiteral(controlTypeEEnum, ControlType.STANDALONE);
    addEEnumLiteral(controlTypeEEnum, ControlType.SECURITY_TESTING);
    addEEnumLiteral(controlTypeEEnum, ControlType.PATCH_MANAGEMENT);
    addEEnumLiteral(controlTypeEEnum, ControlType.VULNERABILITY_MANAGEMENT);
    addEEnumLiteral(controlTypeEEnum, ControlType.CENTRALISED_REPORTING);
    addEEnumLiteral(controlTypeEEnum, ControlType.EVENT_CORRELATION);
    addEEnumLiteral(controlTypeEEnum, ControlType.SECURITY_AUDIT_LOG_MONITORING);
    addEEnumLiteral(controlTypeEEnum, ControlType.COMPLIANCE_TESTING);
    addEEnumLiteral(controlTypeEEnum, ControlType.INCIDENT_MANAGEMENT);
    addEEnumLiteral(controlTypeEEnum, ControlType.FORENSIC);
    addEEnumLiteral(controlTypeEEnum, ControlType.LEGAL);

    initEEnum(confidentialityTypeEEnum, ConfidentialityType.class, "ConfidentialityType");
    addEEnumLiteral(confidentialityTypeEEnum, ConfidentialityType.PUBLIC);
    addEEnumLiteral(confidentialityTypeEEnum, ConfidentialityType.INTERNAL);
    addEEnumLiteral(confidentialityTypeEEnum, ConfidentialityType.RESTRICTED);

    initEEnum(integrityTypeEEnum, IntegrityType.class, "IntegrityType");
    addEEnumLiteral(integrityTypeEEnum, IntegrityType.ACCURATE);
    addEEnumLiteral(integrityTypeEEnum, IntegrityType.HIGHLY_TRUSTED);
    addEEnumLiteral(integrityTypeEEnum, IntegrityType.TRUSTED);
    addEEnumLiteral(integrityTypeEEnum, IntegrityType.UNCONTROLLED);

    initEEnum(availabilityTypeEEnum, AvailabilityType.class, "AvailabilityType");
    addEEnumLiteral(availabilityTypeEEnum, AvailabilityType.PLATINUM);
    addEEnumLiteral(availabilityTypeEEnum, AvailabilityType.GOLD);
    addEEnumLiteral(availabilityTypeEEnum, AvailabilityType.SILVER);
    addEEnumLiteral(availabilityTypeEEnum, AvailabilityType.BRONZE);
    addEEnumLiteral(availabilityTypeEEnum, AvailabilityType.PLASTIC);

    // Create resource
    createResource(eNS_URI);
  }

} //DaslPackageImpl