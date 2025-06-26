package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

@Controller
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;

	//메소드일반
	
	//-회워가입폼
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm");//ㅇㅋ
		
		return "user/joinform";
	}
	
	
	
	//-회원가입
	@RequestMapping(value="/user/joinOk", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinOk(@ModelAttribute UserVO userVO) {
		System.out.println("UserController.join");// ㅇㅋ
		
		userService.exeUserAdd(userVO);
		//no값은 db에서 가져올때는 찍히지만, 등록할때는 원래 0이 나오고, 워크벤치에서 no 값을 확인해야함.
		
		return "user/joinOk";
	}
	
	
	
	
	//-로그인폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})	
	public String loginForm() {

		System.out.println("UserController.loginForm");//ㅇㅋ
		return "user/loginform";

		
	}
	
}
