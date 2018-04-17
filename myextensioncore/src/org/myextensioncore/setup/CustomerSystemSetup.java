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
package org.myextensioncore.setup;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */
@SystemSetup(extension = "myextensioncore")
public class CustomerSystemSetup
{


	private static final Logger LOG = LoggerFactory.getLogger(CustomerSystemSetup.class);
	private ImportService importService;

	/**
	 * @return the importService
	 */
	public ImportService getImportService()
	{
		return importService;
	}

	/**
	 * @param importService
	 *           the importService to set
	 */
	public void setImportService(final ImportService importService)
	{
		this.importService = importService;
	}

	@SystemSetup(type = SystemSetup.Type.ESSENTIAL, process = SystemSetup.Process.ALL)
	public boolean putInMyEssentialData()
	{
		LOG.info("Starting custom essential data loading for the myextension extension");
		impexImport("/impex/products.impex");
		LOG.info("Custom essential data loading for the myextension completed.");
		return true;
	}

	@SystemSetup(type = SystemSetup.Type.PROJECT, process = SystemSetup.Process.ALL)
	public boolean addMyProjectData()
	{
		LOG.info("Starting custom project data loading for the myextension");
		impexImport("/impex/samplecustomers.impex");
		LOG.info("Custom project data loading for the myextension completed.");
		return true;
	}

	/**
	 *
	 */
	private boolean impexImport(final String filename)
	{
		final String message = "Concerttours impexing [" + filename + "]...";
		try
		{
			LOG.info(message);
			final InputStream resourceAsStream = getClass().getResourceAsStream(filename);
			final ImportConfig importConfig = new ImportConfig();
			importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
			importConfig.setLegacyMode(Boolean.FALSE);
			final ImportResult importResult = getImportService().importData(importConfig);
			if (importResult.isError())
			{
				LOG.error(message + " FAILED");
				return false;
			}
		}
		catch (final Exception e)
		{
			LOG.error(message + " FAILED", e);
			return false;
		}
		return true;
	}
}
