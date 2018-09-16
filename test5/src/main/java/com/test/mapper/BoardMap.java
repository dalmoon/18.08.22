package com.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.board.BoardVO;

@Repository(value="boardMap")
public interface BoardMap {
	public BoardVO board(BoardVO vo);
	public int insert(BoardVO vo);
	public int delete(BoardVO vo);
	public int update(BoardVO vo);
	public List<BoardVO> testlist(int cpagenum, int ccontentnum)throws Exception;
	public int testcount();
}
