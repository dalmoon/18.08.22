package com.test.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list.do")
	public String getBoardlist(BoardVO vo, Model model) {
		List<BoardVO> boardlist = boardService.boardlist(vo);
		model.addAttribute("boardlist", boardlist);
		return "WEB-INF/board/list";
	}
	
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.board(vo));
		return "WEB-INF/board/board";
	}
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard() {
		return "WEB-INF/board/insertBoard";
	}
	
	@RequestMapping(value = "/insert.do")
	public String insert(BoardVO vo) {
		boardService.insert(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/deleteBoard.do")
	public String delete(BoardVO vo) {
		boardService.delete(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/updateBoard.do")
	public String update(@ModelAttribute("board") BoardVO vo) {
		boardService.update(vo);
		return "redirect:list.do";
	}
}
