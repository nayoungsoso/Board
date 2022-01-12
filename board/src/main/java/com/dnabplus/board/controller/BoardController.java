package com.dnabplus.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dnabplus.board.domain.BoardDTO;
import com.dnabplus.board.domain.UserDTO;
import com.dnabplus.board.service.BoardService;
import com.dnabplus.board.service.UserService;

@Controller
@RequestMapping("/board")

public class BoardController {
	@Autowired
	BoardService boardService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/main", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView main(HttpServletRequest request, @ModelAttribute UserDTO user) {
		ModelAndView myModel = new ModelAndView();
		List<BoardDTO> list = boardService.boardList();
		
		int count = boardService.countBoard();
		System.out.println(count);
		System.out.println(list);
		myModel.addObject("list", list);
		myModel.addObject("count", count);
		myModel.setViewName("main");
		
		
		return myModel;
	}

	@RequestMapping(value="/member_main", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView member_main(HttpServletRequest request, @ModelAttribute UserDTO user) {
		ModelAndView myModel = new ModelAndView();
		List<BoardDTO> list = boardService.boardList();
		
		int count = boardService.countBoard();
		myModel.addObject("list", list);
		myModel.addObject("count", count);
		myModel.setViewName("member_main");
			
		
		return myModel;
	}
	
	@RequestMapping(value="/writing")
	public ModelAndView writing(HttpServletRequest request, @ModelAttribute BoardDTO board) {
		
		ModelAndView myModel = new ModelAndView();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String writer = userService.selectNick(userId);
		board.setWriter(writer);

		myModel.addObject("id", userId);
		myModel.addObject("writer", writer);
		myModel.setViewName("/writing");
		
		return myModel;
	}
	
	@RequestMapping(value="/writing_sucess", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute BoardDTO board) {
		ModelAndView myModel = new ModelAndView();

		int count = boardService.countBoard();
		board.setCount(count);
		int insert = boardService.insertBoard(board);
		
		myModel.addObject("result", insert);
		myModel.setViewName("/writing_sucess");
		
		return myModel;
	}

	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String boardNum = request.getParameter("boardNum");

		System.out.println(boardNum);
		
		BoardDTO board = boardService.selectBoard(boardNum);

		System.out.println(userId);
		
		myModel.addObject("result", board);
		myModel.addObject("boardNum", boardNum);
		
		if (userId != null) {
			if(userId.equals(board.getId())) {
				myModel.addObject("myDetail", "Y");
			}
			
		}
		
		myModel.setViewName("/detail");
		
		return myModel;
	}

	@RequestMapping(value="/board_mod", method=RequestMethod.GET)
	public ModelAndView board_mod(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();
		String boardNum = request.getParameter("boardNum");
		System.out.println(boardNum);

		BoardDTO board = boardService.selectBoard(boardNum);

		myModel.addObject("result", board);
		myModel.setViewName("board_mod");
		
		return myModel;
	}
	
	@RequestMapping(value="/board_do_mod")
	public ModelAndView doModify(@ModelAttribute BoardDTO board) {
		ModelAndView mv = new ModelAndView();

		int up = boardService.updateBoard(board);
		if (up > 0) {
			System.out.println("update");
		}
		else {
			System.out.println("안됨");
		}
		
		mv.addObject("result", board);
		mv.setViewName("/my_detail");
		
		return mv;
	}
	
	@RequestMapping(value="/board_x", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView member_out(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();
		String boardNum = request.getParameter("boardNum");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		int board = boardService.deleteBoard(boardNum);
		if(board!=0) {
			System.out.println("�궘�젣�맖");
			session.removeAttribute("userId");
			session.removeAttribute("userPasswd");
		}
		else
			System.out.println("�궘�젣�븞�맖");
		myModel.setViewName("/board_x");
		
		
		return myModel;
	}
}
