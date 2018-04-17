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

import de.hybris.platform.core.model.product.ProductModel;

import java.util.ArrayList;
import java.util.List;

import org.myextensioncore.service.MyProductService;
import org.myextensionfacade.MyProductData;
import org.myextensionfacade.facades.MyProductFacade;


/**
 *
 */
public class MyProductFacadeImpl implements MyProductFacade
{

	private MyProductService myProductService;

	/**
	 * @return the myProductService
	 */
	public MyProductService getMyProductService()
	{
		return myProductService;
	}

	/**
	 * @param myProductService
	 *           the myProductService to set
	 */
	public void setMyProductService(final MyProductService myProductService)
	{
		this.myProductService = myProductService;
	}

	@Override
	public List<MyProductData> getProductsFacade()
	{


		final List<ProductModel> productModels = myProductService.getProductsService();
		final List<MyProductData> datas = new ArrayList<>();

		for (final ProductModel model : productModels)
		{
			final MyProductData data = new MyProductData();
			data.setCode(model.getCode());
			data.setName(model.getName());
			data.setManufacturerName(model.getManufacturerName());
			datas.add(data);
		}
		// YTODO Auto-generated method stub
		return datas;
	}

}
