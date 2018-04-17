/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package org.myextensionfacade.facades.impl;

import de.hybris.platform.servicelayer.model.ModelService;

import org.myextensioncore.model.MyCustomerModel;
import org.myextensioncore.service.CustomerAccountService;
import org.myextensionfacade.MyCustomerData;
import org.myextensionfacade.facades.CustomerFacade;


/**
 *
 */
public class CustomerFacadeImpl implements CustomerFacade
{
	private ModelService modelService;
	private CustomerAccountService customerAccountService;



	@Override
	public void register(final MyCustomerData data)
	{

		final MyCustomerModel customerModel = getModelService().create(MyCustomerModel.class);
		customerModel.setFirstName(data.getFirstname());
		customerModel.setLastName(data.getLastname());
		customerModel.setEmail(data.getEmail());
		customerModel.setEncodedPassword(data.getPassword());
		customerModel.setPhone(data.getPhone());
		try
		{
			customerAccountService.internalSaveCustomer(customerModel);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService
	 *           the modelService to set
	 */
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	/**
	 * @return the customerAccountService
	 */
	public CustomerAccountService getCustomerAccountService()
	{
		return customerAccountService;
	}

	/**
	 * @param customerAccountService
	 *           the customerAccountService to set
	 */
	public void setCustomerAccountService(final CustomerAccountService customerAccountService)
	{
		this.customerAccountService = customerAccountService;
	}

}
