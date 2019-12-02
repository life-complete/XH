package com.sybercare.hospital.monitor.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {

	protected static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiverHandler.class);

	public static final Map<String, WebSocketSession> sessionMaps;
	static {
		sessionMaps = new HashMap<String, WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionMaps.put(UUID.randomUUID().toString(), session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
		WebSocketHandler.LOGGER.info("[" + session.getId() + "]处理消息,[message = " + message.getPayload().toString() + "]");
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) {
		WebSocketHandler.LOGGER.info("[" + session.getId() + "]处理消息传出错误");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		WebSocketHandler.LOGGER.info("[" + session.getId() + "]处理连接关闭");
	}

	public void sendMessage(String message) {
		TextMessage text = new TextMessage(message.getBytes());
		for (Iterator<String> it = WebSocketHandler.sessionMaps.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			WebSocketSession session = WebSocketHandler.sessionMaps.get(key);
			try {
				if (session.isOpen())
					session.sendMessage(text);
			} catch (Exception e) {
				LOGGER.error("发送消息失败");
			}
		}
	}
}
