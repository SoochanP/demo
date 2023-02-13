package com.test.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.demo.Domain.BoardVO;
import com.test.demo.Domain.Criteria;
import com.test.demo.Domain.PageDTO;
import com.test.demo.Service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
//	메인
	@GetMapping("/")
	public String main() {
		return "index";
	}
//	게시판 이동
	@GetMapping("board/list")
	public String list(Model model) {
		model.addAttribute("list",bs.getList());
		return "board/list";
	}
	
//	글 작성 실행
 	@PostMapping("board/registerPro")
 	public String register(BoardVO vo) {
 		bs.register(vo);
 		return "redirect:/board/list";
 	}
	
	
//	선택조회 이동
	@GetMapping("board/getDetail")
	public String getDetail(@RequestParam("bno") int bno, Model model ) {
//		조회수 증가
		bs.cnt(bno);
		model.addAttribute("item", bs.getDetail(bno));
		return "board/getDetail";
	}
	
//	수정페이지 이동
	@GetMapping("board/update")
	public String update(@RequestParam("bno") int bno,Model model) {
		model.addAttribute("item", bs.getDetail(bno));
		return "board/update";
	}
//	수정 실행
	@PostMapping("board/updatePro")
	public String update(@RequestParam("bno") int bno, BoardVO vo) {
		bs.update(vo);
		return "redirect:/board/list";
	}
//	삭제 실행
	@GetMapping("board/delete")
	public String delete(@RequestParam("bno") int bno) {
		bs.delete(bno);
		return "redirect:/board/list";
	}
	
//	페이징
	@GetMapping("board/listP")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list",bs.getListP(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}
}
