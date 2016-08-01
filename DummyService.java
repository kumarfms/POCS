package com.fdc.ucompetrol.service;

import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.joda.time.DateTimeZone;

import com.fdc.mgateway.common.config.ConfigManager;
import com.fdc.mgateway.common.config.GatewayConfig;
import com.fdc.mgateway.common.message.AbstractDynamicMessageService;
import com.fdc.mgateway.core.MessageParams;
import com.fdc.mgateway.core.MessageWrapperFactory;
import com.fdc.mgateway.core.exception.MobileGatewayException;

public class Dummyservice extends AbstractDynamicMessageService {

	private static final Logger LOGGER = Logger.getLogger(UCPService.class);
	
	
	public UCPService(final MessageWrapperFactory messageWrapperFactory) {
		super(messageWrapperFactory);
		try{
			final GatewayConfig systemConfig = ConfigManager.getPartyConfig("UCP_SYSTEM", null, null, null, null);
			System.out.println("###############################TIME_ZONE####################"+systemConfig.getString("TIME_ZONE"));
			TimeZone.setDefault(TimeZone.getTimeZone(systemConfig.getString("TIME_ZONE")));
			DateTimeZone.setDefault(DateTimeZone.forTimeZone(TimeZone.getDefault()));
			LOGGER.info("Successfull initiated the object");
		} catch(MobileGatewayException exException){
			throw new IllegalStateException("System TimeZone value not set", exException);
		} catch(SecurityException ex) {
			throw new IllegalStateException("System TimeZone value not set", ex);
		}
	}

	@Override
	public Object processMessage(Object message, MessageParams messageParams) throws MobileGatewayException {
		// TODO Auto-generated method stub
		return null;
	}

	}
