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
package org.myextensioncore.service.impl;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import org.myextensioncore.dao.MyProductDAO;
import org.myextensioncore.service.MyProductService;


/**
 *
 */
public class ProductServiceImpl implements MyProductService
{

	private MyProductDAO myProductDAO;

	/**
	 * @return the myProductDAO
	 */
	public MyProductDAO getMyProductDAO()
	{
		return myProductDAO;
	}

	/**
	 * @param myProductDAO
	 *           the myProductDAO to set
	 */
	public void setMyProductDAO(final MyProductDAO myProductDAO)
	{
		this.myProductDAO = myProductDAO;
	}

	@Override
	public List<ProductModel> getProductsService()
	{

		return myProductDAO.getProducts();
	}

}
