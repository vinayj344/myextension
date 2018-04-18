/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Apr 18, 2018 4:46:33 PM                     ---
 * ----------------------------------------------------------------
 */
package org.myextensioncore.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.Customer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.myextensioncore.constants.MyextensioncoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.user.Customer MyCustomer}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedMyCustomer extends Customer
{
	/** Qualifier of the <code>MyCustomer.firstName</code> attribute **/
	public static final String FIRSTNAME = "firstName";
	/** Qualifier of the <code>MyCustomer.lastName</code> attribute **/
	public static final String LASTNAME = "lastName";
	/** Qualifier of the <code>MyCustomer.phone</code> attribute **/
	public static final String PHONE = "phone";
	/** Qualifier of the <code>MyCustomer.email</code> attribute **/
	public static final String EMAIL = "email";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Customer.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(FIRSTNAME, AttributeMode.INITIAL);
		tmp.put(LASTNAME, AttributeMode.INITIAL);
		tmp.put(PHONE, AttributeMode.INITIAL);
		tmp.put(EMAIL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.email</code> attribute.
	 * @return the email
	 */
	public String getEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.email</code> attribute.
	 * @return the email
	 */
	public String getEmail()
	{
		return getEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.email</code> attribute. 
	 * @param value the email
	 */
	public void setEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.email</code> attribute. 
	 * @param value the email
	 */
	public void setEmail(final String value)
	{
		setEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.firstName</code> attribute.
	 * @return the firstName
	 */
	public String getFirstName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, FIRSTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.firstName</code> attribute.
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return getFirstName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.firstName</code> attribute. 
	 * @param value the firstName
	 */
	public void setFirstName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, FIRSTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.firstName</code> attribute. 
	 * @param value the firstName
	 */
	public void setFirstName(final String value)
	{
		setFirstName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.lastName</code> attribute.
	 * @return the lastName
	 */
	public String getLastName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, LASTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.lastName</code> attribute.
	 * @return the lastName
	 */
	public String getLastName()
	{
		return getLastName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.lastName</code> attribute. 
	 * @param value the lastName
	 */
	public void setLastName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, LASTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.lastName</code> attribute. 
	 * @param value the lastName
	 */
	public void setLastName(final String value)
	{
		setLastName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.phone</code> attribute.
	 * @return the phone
	 */
	public String getPhone(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PHONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyCustomer.phone</code> attribute.
	 * @return the phone
	 */
	public String getPhone()
	{
		return getPhone( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.phone</code> attribute. 
	 * @param value the phone
	 */
	public void setPhone(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PHONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyCustomer.phone</code> attribute. 
	 * @param value the phone
	 */
	public void setPhone(final String value)
	{
		setPhone( getSession().getSessionContext(), value );
	}
	
}
