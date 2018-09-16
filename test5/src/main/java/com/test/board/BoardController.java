package com.test.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.dao.PageMaker;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list.do")
	public String getBoardlist(HttpServletRequest request) throws Exception {
		PageMaker pageMaker = new PageMaker();
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");
		int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum = Integer.parseInt(contentnum);
		
		pageMaker.setTotalcount(boardService.testcount());//전체 게시글 개수를 지정한다
		pageMaker.setPagenum(cpagenum-1);//현재 페이지를 페이지 객체에 지정한다 01을 해야 쿼리에서 사용 할 수 있습니다
		pageMaker.setContentnum(ccontentnum);//한 페이지에 몇개씩 게시글을 보여줄지 지정한다
		pageMaker.setCurrentblock(cpagenum);//현재 페이지 블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
		pageMaker.setLastblock(pageMaker.getTotalcount());//마지막 블록 번호를 전체 게시글 수를 통해서 정한다
		
		pageMaker.prevnext(cpagenum);//현재 페이지 번호로 화살표를 나타낼지 정한다
		pageMaker.setStartPage(pageMaker.getCurrentblock());//시작 페이지를 페이지 블록 번호로 정한다
		pageMaker.setEndPage(pageMaker.getLastblock(), pageMaker.getCurrentblock());
		//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정한다
		System.out.println(cpagenum);
		System.out.println(ccontentnum);
		List<BoardVO> testlist = boardService.testlist(cpagenum, ccontentnum);

		request.setAttribute("list", testlist);
		request.setAttribute("page", pageMaker);
		
		return "list";
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
