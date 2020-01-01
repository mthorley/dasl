/**
 * generated by Xtext 2.19.0
 */
package org.sabsa.dasl.dasl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sabsa.dasl.dasl.BaseControl;
import org.sabsa.dasl.dasl.Control;
import org.sabsa.dasl.dasl.DaslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sabsa.dasl.dasl.impl.ControlImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.impl.ControlImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.impl.ControlImpl#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.sabsa.dasl.dasl.impl.ControlImpl#getAtt <em>Att</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ControlImpl extends AbstractElementImpl implements Control
{
  /**
   * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected static final String REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected String ref = REF_EDEFAULT;

  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected BaseControl base;

  /**
   * The default value of the '{@link #getDesc() <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesc()
   * @generated
   * @ordered
   */
  protected static final String DESC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDesc() <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDesc()
   * @generated
   * @ordered
   */
  protected String desc = DESC_EDEFAULT;

  /**
   * The default value of the '{@link #getAtt() <em>Att</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtt()
   * @generated
   * @ordered
   */
  protected static final String ATT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAtt() <em>Att</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtt()
   * @generated
   * @ordered
   */
  protected String att = ATT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ControlImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DaslPackage.Literals.CONTROL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRef(String newRef)
  {
    String oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DaslPackage.CONTROL__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BaseControl getBase()
  {
    if (base != null && base.eIsProxy())
    {
      InternalEObject oldBase = (InternalEObject)base;
      base = (BaseControl)eResolveProxy(oldBase);
      if (base != oldBase)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DaslPackage.CONTROL__BASE, oldBase, base));
      }
    }
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BaseControl basicGetBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBase(BaseControl newBase)
  {
    BaseControl oldBase = base;
    base = newBase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DaslPackage.CONTROL__BASE, oldBase, base));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDesc()
  {
    return desc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDesc(String newDesc)
  {
    String oldDesc = desc;
    desc = newDesc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DaslPackage.CONTROL__DESC, oldDesc, desc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getAtt()
  {
    return att;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAtt(String newAtt)
  {
    String oldAtt = att;
    att = newAtt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DaslPackage.CONTROL__ATT, oldAtt, att));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DaslPackage.CONTROL__REF:
        return getRef();
      case DaslPackage.CONTROL__BASE:
        if (resolve) return getBase();
        return basicGetBase();
      case DaslPackage.CONTROL__DESC:
        return getDesc();
      case DaslPackage.CONTROL__ATT:
        return getAtt();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DaslPackage.CONTROL__REF:
        setRef((String)newValue);
        return;
      case DaslPackage.CONTROL__BASE:
        setBase((BaseControl)newValue);
        return;
      case DaslPackage.CONTROL__DESC:
        setDesc((String)newValue);
        return;
      case DaslPackage.CONTROL__ATT:
        setAtt((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DaslPackage.CONTROL__REF:
        setRef(REF_EDEFAULT);
        return;
      case DaslPackage.CONTROL__BASE:
        setBase((BaseControl)null);
        return;
      case DaslPackage.CONTROL__DESC:
        setDesc(DESC_EDEFAULT);
        return;
      case DaslPackage.CONTROL__ATT:
        setAtt(ATT_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DaslPackage.CONTROL__REF:
        return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
      case DaslPackage.CONTROL__BASE:
        return base != null;
      case DaslPackage.CONTROL__DESC:
        return DESC_EDEFAULT == null ? desc != null : !DESC_EDEFAULT.equals(desc);
      case DaslPackage.CONTROL__ATT:
        return ATT_EDEFAULT == null ? att != null : !ATT_EDEFAULT.equals(att);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (ref: ");
    result.append(ref);
    result.append(", desc: ");
    result.append(desc);
    result.append(", att: ");
    result.append(att);
    result.append(')');
    return result.toString();
  }

} //ControlImpl
