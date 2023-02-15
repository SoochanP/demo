package com.test.demo.ApiController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.Domain.ReplyVO;
import com.test.demo.Service.replyService;

@RestController
@RequestMapping("/board/api")
public class BoardApiController {

	@Autowired
	private replyService rs;
	
	@PostMapping("/register")
	public void register(@RequestBody ReplyVO replyVO) {
		rs.register(replyVO);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody ReplyVO replyVO) {
		rs.update(replyVO);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody ReplyVO replyVO) {
		rs.delete(replyVO);
	}
}
