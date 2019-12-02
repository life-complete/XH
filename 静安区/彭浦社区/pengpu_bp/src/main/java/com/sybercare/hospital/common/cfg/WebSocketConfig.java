package com.sybercare.hospital.common.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.sybercare.hospital.monitor.handler.WebHandshakeInterceptor;
import com.sybercare.hospital.monitor.handler.WebRTCWebScoketHandler;
import com.sybercare.hospital.monitor.handler.WebSocketHandler;

//@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(this.doHandler(), "/montior").addInterceptors(this.handshake()).setAllowedOrigins("*");
		registry.addHandler(this.doHandler(), "/sockjs/montior").addInterceptors(this.handshake()).withSockJS();
		registry.addHandler(this.doWebrtcHandler(), "/webrtc").addInterceptors(this.handshake()).setAllowedOrigins("*");
	}

	@Bean
	public WebHandshakeInterceptor handshake() {
		return new WebHandshakeInterceptor();
	}

	@Bean
	public WebSocketHandler doHandler() {
		return new WebSocketHandler();
	}

	@Bean
	public WebRTCWebScoketHandler doWebrtcHandler() {
		return new WebRTCWebScoketHandler();
	}
}
