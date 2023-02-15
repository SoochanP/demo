package com.test.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class uploadController {
	
	@GetMapping("upload/file")
	public String file() {
		return "upload/file";
	}
}