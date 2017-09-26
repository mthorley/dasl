/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.dasl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sabsa.dasl.dasl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DaslFactoryImpl extends EFactoryImpl implements DaslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DaslFactory init()
  {
    try
    {
      DaslFactory theDaslFactory = (DaslFactory)EPackage.Registry.INSTANCE.getEFactory(DaslPackage.eNS_URI);
      if (theDaslFactory != null)
      {
        return theDaslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DaslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DaslPackage.SECURITY_MODEL: return createSecurityModel();
      case DaslPackage.IMPORT: return createImport();
      case DaslPackage.ZONE: return createZone();
      case DaslPackage.NODE: return createNode();
      case DaslPackage.COMPONENT: return createComponent();
      case DaslPackage.INFORMATION_ASSET: return createInformationAsset();
      case DaslPackage.FLOW: return createFlow();
      case DaslPackage.CONTROL: return createControl();
      case DaslPackage.ABSTRACT_ELEMENT: return createAbstractElement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DaslPackage.NODE_TYPE:
        return createNodeTypeFromString(eDataType, initialValue);
      case DaslPackage.CONTROL_TYPE:
        return createControlTypeFromString(eDataType, initialValue);
      case DaslPackage.CONFIDENTIALITY_TYPE:
        return createConfidentialityTypeFromString(eDataType, initialValue);
      case DaslPackage.INTEGRITY_TYPE:
        return createIntegrityTypeFromString(eDataType, initialValue);
      case DaslPackage.AVAILABILITY_TYPE:
        return createAvailabilityTypeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DaslPackage.NODE_TYPE:
        return convertNodeTypeToString(eDataType, instanceValue);
      case DaslPackage.CONTROL_TYPE:
        return convertControlTypeToString(eDataType, instanceValue);
      case DaslPackage.CONFIDENTIALITY_TYPE:
        return convertConfidentialityTypeToString(eDataType, instanceValue);
      case DaslPackage.INTEGRITY_TYPE:
        return convertIntegrityTypeToString(eDataType, instanceValue);
      case DaslPackage.AVAILABILITY_TYPE:
        return convertAvailabilityTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecurityModel createSecurityModel()
  {
    SecurityModelImpl securityModel = new SecurityModelImpl();
    return securityModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Zone createZone()
  {
    ZoneImpl zone = new ZoneImpl();
    return zone;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Component createComponent()
  {
    ComponentImpl component = new ComponentImpl();
    return component;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InformationAsset createInformationAsset()
  {
    InformationAssetImpl informationAsset = new InformationAssetImpl();
    return informationAsset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Flow createFlow()
  {
    FlowImpl flow = new FlowImpl();
    return flow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Control createControl()
  {
    ControlImpl control = new ControlImpl();
    return control;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement createAbstractElement()
  {
    AbstractElementImpl abstractElement = new AbstractElementImpl();
    return abstractElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeType createNodeTypeFromString(EDataType eDataType, String initialValue)
  {
    NodeType result = NodeType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertNodeTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ControlType createControlTypeFromString(EDataType eDataType, String initialValue)
  {
    ControlType result = ControlType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertControlTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfidentialityType createConfidentialityTypeFromString(EDataType eDataType, String initialValue)
  {
    ConfidentialityType result = ConfidentialityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertConfidentialityTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegrityType createIntegrityTypeFromString(EDataType eDataType, String initialValue)
  {
    IntegrityType result = IntegrityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIntegrityTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AvailabilityType createAvailabilityTypeFromString(EDataType eDataType, String initialValue)
  {
    AvailabilityType result = AvailabilityType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAvailabilityTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DaslPackage getDaslPackage()
  {
    return (DaslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DaslPackage getPackage()
  {
    return DaslPackage.eINSTANCE;
  }

} //DaslFactoryImpl