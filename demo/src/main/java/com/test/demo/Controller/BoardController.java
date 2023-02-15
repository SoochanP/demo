package com.test.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.demo.Domain.BoardVO;
import com.test.demo.Domain.PageVO;
import com.test.demo.Domain.ReplyVO;
import com.test.demo.Service.BoardService;
import com.test.demo.Service.replyService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@Autowired
	replyService rs;
	
//	메인
	@GetMapping("/")
	public String main() {
		return "index";
	}
//	게시판 이동
	@GetMapping("board/list")
	public String list(@RequestParam(value ="num",required = false, defaultValue = "1") int num, Model model) {
		
		
		PageVO page = new PageVO();
		
		page.setNum(num);
		page.setCount(bs.count());

		List<BoardVO> list = null; 
		list = bs.getListP(page.getDisplayPost(),page.getPostNum());

		model.addAttribute("list", list);   
		model.addAttribute("pageNum", page.getPageNum());
		model.addAttribute("startPageNum", page.getStartPageNum());
		model.addAttribute("endPageNum", page.getEndPageNum());
		model.addAttribute("prev", page.getPrev());
		model.addAttribute("next", page.getNext());
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

		//조회수 증가
		bs.cnt(bno);
		model.addAttribute("item", bs.getDetail(bno));
		
		//댓글 리스트 
		List<ReplyVO> list = rs.selectAll(bno);
		model.addAttribute("reply", list);
		
		//댓글 갯수
		int cnt = rs.count(bno);
		model.addAttribute("cnt", cnt);
		
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
	
//	페이징 + 검색  리스트
	@GetMapping("board/searchList")
	public String searchList(Model model, @RequestParam(value="num",required = false, defaultValue = "1") int num, 
			@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
			   @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword ){
		
		PageVO pg = new PageVO();

//		pageVO setting
		pg.setNum(num);
		pg.setCount(bs.searchCount(searchType, keyword));
		pg.setKeyword(keyword);
		pg.setSearchType(searchType);
		
//		리스트 
		List<BoardVO> list = bs.searchList(pg.getDisplayPost(), pg.getPostNum(), searchType, keyword);
		
//		던지기
		model.addAttribute("page", pg);
		model.addAttribute("list", list);
		
		return "board/searchList";
	}
}
