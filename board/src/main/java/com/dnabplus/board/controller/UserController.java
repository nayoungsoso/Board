package com.dnabplus.board.controller;



import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dnabplus.board.domain.BoardDTO;
import com.dnabplus.board.domain.UserDTO;
import com.dnabplus.board.service.BoardService;
import com.dnabplus.board.service.UserService;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BoardService boardService;

	
	@RequestMapping(value = "/index")
	public String index() {
		
		//UserData = userService.insertUser();
		
		return "index";
	}
	
	@RequestMapping(value="/loginx", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginx(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();

		myModel.setViewName("/loginx");
		
		return myModel;
	}

	
	@RequestMapping(value="/login", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();

		myModel.setViewName("/login");
		
		return myModel;
	}

	@RequestMapping(value = "/login_ok")
	public ModelAndView login_ok(HttpServletRequest request, @ModelAttribute UserDTO user) {
		
		ModelAndView myModel = new ModelAndView();
		
		String id = user.getId();
		String passwd = user.getPasswd();
		
		HttpSession session = request.getSession();
		String userPasswd = userService.selectUser(id);
		
		if(id != null) {
			if(passwd.equals(userPasswd)) {
				session.setAttribute("userId", id);
				session.setAttribute("userPasswd", passwd);
				myModel.setViewName("login_ok");
			}
			else {
				myModel.setViewName("login_fail");
			}
		}
		else {
			myModel.setViewName("/login_ok");
		}
		
		return myModel;
	}
	
	@RequestMapping(value = "/sign_up")
	public String join() {
		
		//UserData = userService.insertUser();
		
		return "sign_up";
	}
	
	@RequestMapping(value="/main", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView main(HttpServletRequest request, @ModelAttribute UserDTO user) {
		ModelAndView myModel = new ModelAndView();
		List<BoardDTO> list = boardService.boardList();
		
		int count = boardService.countBoard();
		myModel.addObject("list", list);
		myModel.addObject("count", count);
		myModel.setViewName("main");
			
		
		return myModel;
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute UserDTO user) {
		ModelAndView myModel = new ModelAndView();
		/*
		 * 1. 파라메터를 받은상태
		 * 2. DBINSERT
		 * 3. 회원가입 완료 화면
		 * */
		System.out.println(user);
		int UserData = userService.insertUser(user);
		
		myModel.addObject("result", UserData);
		myModel.setViewName("register");
		
		return myModel;
	}
	

	@RequestMapping(value="/member_mod")
	public ModelAndView member_mod(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		UserDTO user = userService.selectData(userId);
		
		myModel.addObject("result",user);
		myModel.setViewName("member_mod");
		
		return myModel;
	}

	@RequestMapping(value="/member_out", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView member_out(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		int user = userService.deleteUser(userId);
		if(user!=0) {
			System.out.println("삭제됨");
			session.removeAttribute("userId");
			session.removeAttribute("userPasswd");
		}
		else
			System.out.println("삭제안됨");
		myModel.addObject("result", user);
		myModel.setViewName("/member_out");
		
		
		return myModel;
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		
		ModelAndView myModel = new ModelAndView();
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userPasswd");
		
		myModel.setViewName("/logout");
		
		return myModel;
	}
	
	@RequestMapping(value="/doModify")
	public ModelAndView doModify(@ModelAttribute UserDTO user) {
		ModelAndView mv = new ModelAndView();

		int up = userService.updateUser(user);
		
		if(up > 0) {
			System.out.println("업데이트 됨");
		}
		mv.addObject("result", user);
		mv.setViewName("/member_mod");
		
		return mv;
	}
}
