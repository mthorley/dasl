/**
 * generated by Xtext 2.19.0
 */
package org.sabsa.dasl.dasl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sabsa.dasl.dasl.Actor#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Actor#getRoles <em>Roles</em>}</li>
 * </ul>
 *
 * @see org.sabsa.dasl.dasl.DaslPackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends AbstractElement, FlowEndpoint
{
  /**
   * Returns the value of the '<em><b>Desc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Desc</em>' attribute.
   * @see #setDesc(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getActor_Desc()
   * @model
   * @generated
   */
  String getDesc();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Actor#getDesc <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desc</em>' attribute.
   * @see #getDesc()
   * @generated
   */
  void setDesc(String value);

  /**
   * Returns the value of the '<em><b>Roles</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Roles</em>' attribute.
   * @see #setRoles(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getActor_Roles()
   * @model
   * @generated
   */
  String getRoles();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Actor#getRoles <em>Roles</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Roles</em>' attribute.
   * @see #getRoles()
   * @generated
   */
  void setRoles(String value);

} // Actor
