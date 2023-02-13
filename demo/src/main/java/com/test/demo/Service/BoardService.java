package com.test.demo.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.Domain.BoardVO;
import com.test.demo.Mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper bm;
	
	
//	전체조회 및 페이징
	public List<BoardVO> getListP(int displayPost, int postNum ){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("dNum", displayPost);
		map.put("pNum", postNum);
		
		return bm.getListP(map);
	}
	
	
//	선택조회
	public BoardVO getDetail(int bno) {
		return bm.getDetail(bno);
	}
	
//	글작성
	public int register(BoardVO vo) {
		return bm.register(vo);
	}
	
//	글수정
	public int update(BoardVO vo) {
		return bm.update(vo);
	}
	
//	글삭제
	public int delete(int bno) {
		return bm.delete(bno);
	}
	
//	조회수 증가
	public int cnt(int bno) {
		return bm.cnt(bno);
	}
	
//	전체글 카운트
	public int count() {
		return bm.count();
	}
	

	public List<BoardVO> searchList( int displayPost, int postNum, 
			String searchType, String keyword){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		 
		 map.put("displayPost", displayPost);
		 map.put("postNum", postNum);
		 
		 map.put("searchType", searchType);
		 map.put("keyword", keyword);
		
		return bm.searchList(map);
	}
	
//	검색 후 데이타 갯수
	public int searchCount(String searchType, String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchType", searchType);
		map.put("Keyword", keyword);
		return bm.searchCount(map);
	}
}
