/**
 * generated by Xtext 2.19.0
 */
package org.sabsa.dasl.dasl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getRef <em>Ref</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getVendor <em>Vendor</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getVersion <em>Version</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getAssets <em>Assets</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getControls <em>Controls</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Component#getComponents <em>Components</em>}</li>
 * </ul>
 *
 * @see org.sabsa.dasl.dasl.DaslPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends AbstractElement, FlowEndpoint
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' attribute.
   * @see #setRef(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Component#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype</em>' attribute.
   * @see #setStereotype(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Stereotype()
   * @model
   * @generated
   */
  String getStereotype();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Component#getStereotype <em>Stereotype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stereotype</em>' attribute.
   * @see #getStereotype()
   * @generated
   */
  void setStereotype(String value);

  /**
   * Returns the value of the '<em><b>Vendor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vendor</em>' attribute.
   * @see #setVendor(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Vendor()
   * @model
   * @generated
   */
  String getVendor();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Component#getVendor <em>Vendor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Vendor</em>' attribute.
   * @see #getVendor()
   * @generated
   */
  void setVendor(String value);

  /**
   * Returns the value of the '<em><b>Desc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Desc</em>' attribute.
   * @see #setDesc(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Desc()
   * @model
   * @generated
   */
  String getDesc();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Component#getDesc <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desc</em>' attribute.
   * @see #getDesc()
   * @generated
   */
  void setDesc(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Version()
   * @model
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Component#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Assets</b></em>' reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.InformationAsset}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assets</em>' reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Assets()
   * @model
   * @generated
   */
  EList<InformationAsset> getAssets();

  /**
   * Returns the value of the '<em><b>Controls</b></em>' reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.Control}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Controls</em>' reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Controls()
   * @model
   * @generated
   */
  EList<Control> getControls();

  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.Component}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getComponent_Components()
   * @model containment="true"
   * @generated
   */
  EList<Component> getComponents();

} // Component
