package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;

	
	//메소드일반
	//-회워가입폼									//주소창에 값 넣는 건 무조건 get방식
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm");//ㅇㅋ
		
		return "user/joinform";
	}
	
	
	
	//-회원가입
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST}) //포스트는 주소에 값을 숨겨서 보낸다.
	public String join(@ModelAttribute UserVO userVO) {
		System.out.println("UserController.join");// ㅇㅋ
		
		System.out.println(userVO);
		
		try{
			userService.exeUserAdd(userVO);
			//no값은 db에서 가져올때는 찍히지만, 등록할때는 원래 0이 나오고, 워크벤치에서 no 값을 확인해야함.
			return "user/joinOk";
			
		} catch (Exception e) {
			System.out.println(e);

			return "redirect:http://localhost:8888/user/joinform";
		}

	}
	
	
	
	//-로그인폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})	
	public String loginForm() {

		System.out.println("UserController.loginForm");//ㅇㅋ

		return "user/loginform";

	}
	
	
	
	//-로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("UserController.login");//ㅇㅋ
		UserVO authUser = userService.exeLogin(userVO);
		
		//세션에 로그인 확인용 값을 넣어준다. --> 로그인했다
		session.setAttribute("authUser", authUser); //별명 / 번호
		//세션이 번호표를 알려줬을 거ㅏㄷ.                      
	
		return "redirect:/";

	}
	
	
	//로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout");
		
		//섹션의 확인용 값을 지운다
		//session.removeAttribute("authUser"); //얘는 값만 지우는 거
		session.invalidate(); //얘는 다 지우는 거
		
		return "redirect:/";
	
	}
	
	
	
	
	
}
