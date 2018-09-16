package com.test.board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardService {
	public List<BoardVO> testlist(int cpagenum, int ccontentnum) throws Exception;
	public int testcount();
	public BoardVO board(BoardVO vo);
	public int insert(BoardVO vo);
	public int delete(BoardVO vo);
	public int update(BoardVO vo);
}
