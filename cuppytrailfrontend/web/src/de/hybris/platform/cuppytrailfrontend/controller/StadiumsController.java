

package de.hybris.platform.cuppytrailfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StadiumsController
{

	@RequestMapping(value = "/stadiums")
	public String showStadiums(final Model model)
	{
		return "StadiumListing";
	}

}

