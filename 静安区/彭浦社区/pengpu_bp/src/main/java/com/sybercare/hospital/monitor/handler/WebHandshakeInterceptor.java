package com.sybercare.hospital.monitor.handler;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class WebHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
		super.afterHandshake(request, response, wsHandler, ex);
	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> map) throws Exception {
		return super.beforeHandshake(request, response, handler, map);
	}
}
