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
package org.myextension;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.myextension.model.MyCustomer;
import org.myextensionfacade.MyCustomerData;
import org.myextensionfacade.facades.CustomerFacade;
import org.myextensionfacade.facades.MyProductFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 */
@Controller
public class HomeController
{

	private CustomerFacade customerFacade;

	private static final Logger LOG = Logger.getLogger(HomeController.class);

	private MyProductFacade myProductFacade;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistrationPage(final Model model)
	{
		final MyCustomer myCustomerForm = new MyCustomer();
		model.addAttribute("myCustomerForm", myCustomerForm);
		initLists(model);
		return "Registration";
	}

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("myCustomerForm") final MyCustomer myCustomer, final Model model)
			throws Exception
	{
		LOG.info(myCustomer);
		initLists(model);

		final MyCustomerData customerData = new MyCustomerData();
		customerData.setFirstname(myCustomer.getFirstname());
		customerData.setLastname(myCustomer.getLastname());
		customerData.setGender(myCustomer.getGender());
		customerData.setEmail(myCustomer.getEmail());
		customerData.setPassword(myCustomer.getPassword());
		customerData.setPhone(myCustomer.getPhone());
		customerData.setAddress(myCustomer.getAddress());
		customerFacade.register(customerData);

		model.addAttribute("success", "Registration Successfull");
		return "Registration";
	}

	void initLists(final Model model)
	{

		final List<String> genderList = new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Others");
		model.addAttribute("genderList", genderList);

	}


}
