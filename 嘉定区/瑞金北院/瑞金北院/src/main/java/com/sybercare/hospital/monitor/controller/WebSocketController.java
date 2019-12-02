package com.sybercare.hospital.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "heartTime";
	}

	@RequestMapping("/webrtc")
	public String webrtc(Model model) {
		return "webrtc";
	}
}
