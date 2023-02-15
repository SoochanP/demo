package com.test.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.demo.Domain.ReplyVO;

@Mapper
public interface ReplyMapper {

	
//	댓글 전체조회
	@Select("SELECT * FROM scott.board_reply where del=0 and bno = #{bno} order by reno desc")
	List<ReplyVO> selectAll(int bno);
	
//	댓글 등록
	@Insert("INSERT INTO scott.board_reply"
			+  "(id,rememo,redate,bno, del)"
			+ " VALUES "
			+  "(#{replyVO.id}, #{replyVO.rememo}, now() ,#{replyVO.bno}, 0)")
	int register(@Param("replyVO") ReplyVO replyVO);
	
//	해당 글 댓글 갯수
	@Select("select count(reno) from scott.board_reply where del=0 and bno = #{bno}")
	int reCount(int bno);
	
//	댓글 수정
	@Update("UPDATE scott.board_reply"
			+ " SET "
			+ "rememo = #{replyVO.rememo}, "
			+ "redate = now() "
			+ "WHERE reno = #{replyVO.reno} ")
	int update(@Param("replyVO") ReplyVO replyVO);
	
//	댓글 수정
	@Update("UPDATE scott.board_reply"
			+ " SET "
			+ "del = 1 "
			+ "WHERE reno = #{replyVO.reno} ")
	int delete(@Param("replyVO") ReplyVO replyVO);
	
}
