package com.test.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.Domain.BoardVO;
import com.test.demo.Domain.Criteria;
import com.test.demo.Mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	BoardMapper bm;
	
//	전체조회
	public List<BoardVO> getList(){
		return bm.getList();
	}
	
//	전체조회-페이징
	public List<BoardVO> getListP(Criteria cri){
		return bm.getListP(cri);
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
}
