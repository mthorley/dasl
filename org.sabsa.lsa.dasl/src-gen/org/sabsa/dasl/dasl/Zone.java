/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.dasl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Zone</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sabsa.dasl.dasl.Zone#getName <em>Name</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Zone#getTrust <em>Trust</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Zone#getIngressZones <em>Ingress Zones</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Zone#getEgressZones <em>Egress Zones</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Zone#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Zone#getControls <em>Controls</em>}</li>
 * </ul>
 *
 * @see org.sabsa.dasl.dasl.DaslPackage#getZone()
 * @model
 * @generated
 */
public interface Zone extends AbstractElement
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
   * @see org.sabsa.dasl.dasl.DaslPackage#getZone_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Zone#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Trust</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trust</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trust</em>' attribute.
   * @see #setTrust(int)
   * @see org.sabsa.dasl.dasl.DaslPackage#getZone_Trust()
   * @model
   * @generated
   */
  int getTrust();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Zone#getTrust <em>Trust</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trust</em>' attribute.
   * @see #getTrust()
   * @generated
   */
  void setTrust(int value);

  /**
   * Returns the value of the '<em><b>Ingress Zones</b></em>' reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.Zone}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ingress Zones</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ingress Zones</em>' reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getZone_IngressZones()
   * @model
   * @generated
   */
  EList<Zone> getIngressZones();

  /**
   * Returns the value of the '<em><b>Egress Zones</b></em>' reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.Zone}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Egress Zones</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Egress Zones</em>' reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getZone_EgressZones()
   * @model
   * @generated
   */
  EList<Zone> getEgressZones();

  /**
   * Returns the value of the '<em><b>Nodes</b></em>' reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.Node}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getZone_Nodes()
   * @model
   * @generated
   */
  EList<Node> getNodes();

  /**
   * Returns the value of the '<em><b>Controls</b></em>' reference list.
   * The list contents are of type {@link org.sabsa.dasl.dasl.Control}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Controls</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Controls</em>' reference list.
   * @see org.sabsa.dasl.dasl.DaslPackage#getZone_Controls()
   * @model
   * @generated
   */
  EList<Control> getControls();

} // Zone
