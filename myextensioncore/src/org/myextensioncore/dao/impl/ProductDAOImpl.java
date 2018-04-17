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
package org.myextensioncore.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myextensioncore.dao.MyProductDAO;


/**
 *
 */
public class ProductDAOImpl implements MyProductDAO
{

	private FlexibleSearchService flexibleSearchService;

	/**
	 * @return the flexibleSearchService
	 */
	public FlexibleSearchService getFlexibleSearchService()
	{
		return flexibleSearchService;
	}

	/**
	 * @param flexibleSearchService
	 *           the flexibleSearchService to set
	 */
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	@Override
	public List<ProductModel> getProducts()
	{
		//final String query = "SELECT {p: " + ProductModel.PK + "}" + " FROM { " + ProductModel._TYPECODE + " AS p}";

		final String string = "select {p:pk} from {Product as p}";
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(string);
		final SearchResult<ProductModel> result = flexibleSearchService.search(fsq);
		final List<ProductModel> list = result.getResult();
		return list;
	}

	@Override
	public List<ProductModel> getProductByCode(final String code)
	{
		//		final String query = "SELECT {p:" + ProductModel.PK + "} FROM " + "{" + ProductModel._TYPECODE + " AS p}" + " WHERE {"
		//				+ ProductModel.CODE + "} = ?code";

		final String query = "select {p:pk} from {Product as p} where {p:code} = ?code";

		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query);
		final Map<String, Object> params = new HashMap<>();
		params.put("code", code);
		//fsq.addQueryParameters(params);

		fsq.addQueryParameter("code", code);

		final SearchResult<ProductModel> result = flexibleSearchService.search(fsq);
		final List<ProductModel> list = result.getResult();
		return list;
	}

}












