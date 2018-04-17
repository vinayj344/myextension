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
package org.myextensioncore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;


/**
 *
 */
@IntegrationTest
public class DefaultProductDAOIntegrationTest extends ServicelayerTransactionalTest
{

	@Resource
	private MyProductDAO productDAO;

	@Resource
	private ModelService modelService;

	private ProductService productService;

	private static final String CODE = "2019735";
	private static final String NAME = "SAP Beer";
	private static final String manufacturerName = "SAP";
	@Resource(name = "catalogVersionService")
	private CatalogVersionService catalogVersionService;


	@Test
	public void daoTest()
	{
		List<ProductModel> productByCode = productDAO.getProductByCode(CODE);
		assertTrue("no product should be returned", productByCode.isEmpty());

		final List<ProductModel> allProducts = productDAO.getProducts();
		final int size = allProducts.size();

		//		final ProductModel productModel = modelService.create(ProductModel.class);
		//		productModel.setCode(CODE);
		//		productModel.setName(NAME);
		//		productModel.setManufacturerName(manufacturerName);
		//		productModel.setCatalogVersion(catalogVersionService.getCatalogVersion("MyExtensionProductCatalog", "Online"));

		//modelService.save(productModel);

		assertEquals(size, allProducts.size());
		System.out.println(size);
		productByCode = productDAO.getProductByCode(CODE);
		//		assertEquals("did not find the model we were looking for", "2019735", productByCode.get(0).getCode());
		//		assertEquals("Name is wrong", "SAP Beer", productByCode.get(0).getName());
		//		assertEquals("did not get manufacturerName we were looking for", "SAP", productByCode.get(0).getManufacturerName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testfindBands_NullParam()
	{
		//calling getMyCustomerByCode with null should throw an IllegalArgumentException
		productDAO.getProductByCode(null); //method's return value not captured
	}


	@Test
	public void testFindProducts_EmptyStringParam()
	{
		final List<ProductModel> list = productDAO.getProductByCode("");
		Assert.assertTrue("No Product should be returned", list.isEmpty());
	}
}







