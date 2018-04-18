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

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.myextension.model.MyCustomer;
import org.myextensionfacade.MyCustomerData;
import org.myextensionfacade.facades.CustomerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 */
@Controller
public class HomeController
{
	private static final Logger LOG = Logger.getLogger(HomeController.class);

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	/**
	 * @return the customerFacade
	 */
	public CustomerFacade getCustomerFacade()
	{
		return customerFacade;
	}

	/**
	 * @param customerFacade
	 *           the customerFacade to set
	 */
	public void setCustomerFacade(final CustomerFacade customerFacade)
	{
		this.customerFacade = customerFacade;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistrationPage(final Model model)
	{
		final MyCustomer myCustomerForm = new MyCustomer();
		model.addAttribute("myCustomerForm", myCustomerForm);
		initLists(model);
		return "Registration";
	}

	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	public String registerCustomer(@Valid @ModelAttribute("myCustomerForm") final MyCustomer myCustomer,
			final BindingResult bindingResult, final Model model) throws Exception
	{
		if (bindingResult.hasErrors())
		{
			LOG.warn(bindingResult);
			return "Registration";
		}
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
		getCustomerFacade().register(customerData);

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
