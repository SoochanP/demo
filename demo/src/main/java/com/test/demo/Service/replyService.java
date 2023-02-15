package com.test.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.Domain.ReplyVO;
import com.test.demo.Mapper.ReplyMapper;

@Service
public class replyService {
	
	@Autowired
	private ReplyMapper rm;
	
//	해당 댓글 전체 불러오기
	public List<ReplyVO> selectAll(int bno) {
		return rm.selectAll(bno);
	}
	
//	댓글 등록
	public int register(ReplyVO replyVO) {
		return rm.register(replyVO);
	}
	
//	해당 글 댓글 수
	public int count(int bno) {
		return rm.reCount(bno);
	}
	
//	댓글 수정
	public int update(ReplyVO replyVO) {
		return rm.update(replyVO);
	}
	
//	댓글 삭제
	
	public int delete(ReplyVO replyVO) {
		return rm.delete(replyVO);
	}
}
