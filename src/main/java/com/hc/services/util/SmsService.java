package com.hc.services.util;

public interface SmsService {
	
	public void sendMessage(String toNumber, String body) throws Exception;

}
