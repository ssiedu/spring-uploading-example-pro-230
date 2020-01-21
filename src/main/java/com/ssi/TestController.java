package com.ssi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("hellolink")
	public String showHello() {
		return "hello";
	}
}
