package com.test.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.demo.Domain.BoardVO;
import com.test.demo.Domain.Criteria;

@Mapper
public interface BoardMapper {

//	전체조회
	@Select("select * from board where del=0 order by bno desc")
	List<BoardVO> getList();
	
//	전체조회-페이징
	@Select("select * from board where del=0 order by bno desc limit 10")
	List<BoardVO> getListP(Criteria cri);

//	페이징처리
	@Select("select * from board where del=0 order by bno desc limit #{pageNum},")
	List<BoardVO> getListpage();
	
//	선택조회
	@Select("select * from board where bno = #{bno} and del=0")
	BoardVO getDetail(int bno);

//	글작성
	@Insert("insert into board (title, content, regdate) values (#{title}, #{content}, now())")
	int register(BoardVO vo);
	
//	글수정
	@Update("update board set title = #{title}, content=#{content}, regdate=now(), etc=#{etc} where bno=#{bno}")
	int update(BoardVO vo);
	
//	글삭제
	@Update("update board set del=1 where bno=#{bno}")
	int delete(int bno);
	
//	조회수 증가
	@Update("update board set readcnt=readcnt+1 where #{bno}")
	int cnt(int bno);
	
	
}
