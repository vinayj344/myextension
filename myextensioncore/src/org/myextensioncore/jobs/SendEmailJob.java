package org.myextensioncore.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.mail.MailUtils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.myextensioncore.model.MyCustomerModel;


public class SendEmailJob extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(SendEmailJob.class);

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		LOG.info("Sending New mails. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.");
		// final List<NewsModel> newsItems = newsService.getNewsOfTheDay(new Date());
		final List<MyCustomerModel> list = new ArrayList<>();
		final MyCustomerModel customerModel = new MyCustomerModel();
		customerModel.setFirstName("vinay");
		customerModel.setLastName("more");
		customerModel.setEmail("vinay.j344@gmail.com");
		list.add(customerModel);

		if (list.isEmpty())
		{
			LOG.info("No New Customers today, skipping send of mails");
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		final StringBuilder mailContentBuilder = new StringBuilder(2000);
		final int index = 1;
		mailContentBuilder.append("Todays New Customers:\n\n");
		for (final MyCustomerModel customer : list)
		{
			mailContentBuilder.append(index);
			mailContentBuilder.append(". ");
			mailContentBuilder.append(customer.getFirstName() + " " + customer.getLastName());
			mailContentBuilder.append("\n");
			mailContentBuilder.append(customer.getEmail());
			mailContentBuilder.append("\n");
			mailContentBuilder.append("\n\n");
		}
		try
		{
			sendEmail(mailContentBuilder.toString());
		}
		catch (final EmailException e)
		{
			LOG.error("Problem sending new email. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.)");
			return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
		}
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	private void sendEmail(final String message) throws EmailException
	{
		final String subject = "Daily Email Summary";
		// get mail service configuration
		final Email email = MailUtils.getPreConfiguredEmail();
		//send message
		email.addTo(Config.getString("mailing_address", null));
		email.setSubject(subject);
		email.setMsg(message);
		email.setTLS(true);
		email.send();
		LOG.info(subject);
		LOG.info(message);
	}
}