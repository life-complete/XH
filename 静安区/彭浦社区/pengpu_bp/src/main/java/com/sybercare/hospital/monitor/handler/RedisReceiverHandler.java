package com.sybercare.hospital.monitor.handler;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisReceiverHandler {

	protected static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiverHandler.class);
	@Autowired
	private CountDownLatch latch;
	@Autowired
	private WebSocketHandler websocketHandler;

	@Autowired
	public RedisReceiverHandler(CountDownLatch latch) {
		this.latch = latch;
	}

	public void receiveMessage(String message) {
		this.websocketHandler.sendMessage(message);
		latch.countDown();
	}
}