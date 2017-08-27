/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.dasl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information Asset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sabsa.dasl.dasl.InformationAsset#getName <em>Name</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.InformationAsset#getRef <em>Ref</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.InformationAsset#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.InformationAsset#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.InformationAsset#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.InformationAsset#getAvailability <em>Availability</em>}</li>
 * </ul>
 *
 * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset()
 * @model
 * @generated
 */
public interface InformationAsset extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.InformationAsset#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.InformationAsset#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>Desc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Desc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Desc</em>' attribute.
   * @see #setDesc(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset_Desc()
   * @model
   * @generated
   */
  String getDesc();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.InformationAsset#getDesc <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desc</em>' attribute.
   * @see #getDesc()
   * @generated
   */
  void setDesc(String value);

  /**
   * Returns the value of the '<em><b>Confidentiality</b></em>' attribute.
   * The literals are from the enumeration {@link org.sabsa.dasl.dasl.ConfidentialityType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Confidentiality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Confidentiality</em>' attribute.
   * @see org.sabsa.dasl.dasl.ConfidentialityType
   * @see #setConfidentiality(ConfidentialityType)
   * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset_Confidentiality()
   * @model
   * @generated
   */
  ConfidentialityType getConfidentiality();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.InformationAsset#getConfidentiality <em>Confidentiality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Confidentiality</em>' attribute.
   * @see org.sabsa.dasl.dasl.ConfidentialityType
   * @see #getConfidentiality()
   * @generated
   */
  void setConfidentiality(ConfidentialityType value);

  /**
   * Returns the value of the '<em><b>Integrity</b></em>' attribute.
   * The literals are from the enumeration {@link org.sabsa.dasl.dasl.IntegrityType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integrity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integrity</em>' attribute.
   * @see org.sabsa.dasl.dasl.IntegrityType
   * @see #setIntegrity(IntegrityType)
   * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset_Integrity()
   * @model
   * @generated
   */
  IntegrityType getIntegrity();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.InformationAsset#getIntegrity <em>Integrity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integrity</em>' attribute.
   * @see org.sabsa.dasl.dasl.IntegrityType
   * @see #getIntegrity()
   * @generated
   */
  void setIntegrity(IntegrityType value);

  /**
   * Returns the value of the '<em><b>Availability</b></em>' attribute.
   * The literals are from the enumeration {@link org.sabsa.dasl.dasl.AvailabilityType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Availability</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Availability</em>' attribute.
   * @see org.sabsa.dasl.dasl.AvailabilityType
   * @see #setAvailability(AvailabilityType)
   * @see org.sabsa.dasl.dasl.DaslPackage#getInformationAsset_Availability()
   * @model
   * @generated
   */
  AvailabilityType getAvailability();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.InformationAsset#getAvailability <em>Availability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Availability</em>' attribute.
   * @see org.sabsa.dasl.dasl.AvailabilityType
   * @see #getAvailability()
   * @generated
   */
  void setAvailability(AvailabilityType value);

} // InformationAsset
