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
import java.util.Collection;

import org.myextension.model.MyCustomer;
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

	private MyProductFacade myProductFacade;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistration(final Model model)
	{
		final MyCustomer myCustomerForm = new MyCustomer();
		model.addAttribute("myCustomerForm", myCustomerForm);

		final Collection<String> genders = new ArrayList<>();
		genders.add("Male");
		genders.add("Female");
		genders.add("others");
		model.addAttribute("genders", genders);

		return "Registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("myCustomerForm") final MyCustomer myCustomer, final Model model)
	{

		model.addAttribute("success", "Registration Successfull");
		return "Registration";
	}


}
