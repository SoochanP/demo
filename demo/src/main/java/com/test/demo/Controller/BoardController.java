package com.test.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	@GetMapping("board/list")
	public String list() {
		return "board/list";
	}
}
