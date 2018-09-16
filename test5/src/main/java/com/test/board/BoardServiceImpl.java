package com.test.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mapper.BoardMap;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMap boardMap;
	
	
	public BoardVO board(BoardVO vo) {
		return boardMap.board(vo);
	}
	
	public int insert(BoardVO vo) {
		return boardMap.insert(vo);
	}
	
	public int delete(BoardVO vo) {
		return boardMap.delete(vo);
	}
	
	public int update(BoardVO vo) {
		return boardMap.update(vo);
	}

	@Override
	public List<BoardVO> testlist(int cpagenum, int ccontentnum) throws Exception{
		return boardMap.testlist(cpagenum, ccontentnum);
	}

	@Override
	public int testcount() {
		return boardMap.testcount();
	}

}
