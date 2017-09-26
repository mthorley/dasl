/**
 * generated by Xtext 2.12.0
 */
package org.sabsa.dasl.dasl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sabsa.dasl.dasl.Control#getName <em>Name</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Control#getRef <em>Ref</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Control#getArea <em>Area</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.Control#getImplementation <em>Implementation</em>}</li>
 * </ul>
 *
 * @see org.sabsa.dasl.dasl.DaslPackage#getControl()
 * @model
 * @generated
 */
public interface Control extends AbstractElement
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
   * @see org.sabsa.dasl.dasl.DaslPackage#getControl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Control#getName <em>Name</em>}' attribute.
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
   * @see org.sabsa.dasl.dasl.DaslPackage#getControl_Ref()
   * @model
   * @generated
   */
  String getRef();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Control#getRef <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' attribute.
   * @see #getRef()
   * @generated
   */
  void setRef(String value);

  /**
   * Returns the value of the '<em><b>Area</b></em>' attribute.
   * The literals are from the enumeration {@link org.sabsa.dasl.dasl.ControlType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Area</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Area</em>' attribute.
   * @see org.sabsa.dasl.dasl.ControlType
   * @see #setArea(ControlType)
   * @see org.sabsa.dasl.dasl.DaslPackage#getControl_Area()
   * @model
   * @generated
   */
  ControlType getArea();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Control#getArea <em>Area</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Area</em>' attribute.
   * @see org.sabsa.dasl.dasl.ControlType
   * @see #getArea()
   * @generated
   */
  void setArea(ControlType value);

  /**
   * Returns the value of the '<em><b>Implementation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implementation</em>' attribute.
   * @see #setImplementation(String)
   * @see org.sabsa.dasl.dasl.DaslPackage#getControl_Implementation()
   * @model
   * @generated
   */
  String getImplementation();

  /**
   * Sets the value of the '{@link org.sabsa.dasl.dasl.Control#getImplementation <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation</em>' attribute.
   * @see #getImplementation()
   * @generated
   */
  void setImplementation(String value);

} // Control