package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;

	
	//메소드일반
	//-회워가입폼									//주소창에 값 넣는 건 무조건 get방식
	@RequestMapping(value="/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm");//ㅇㅋ
		
		return "user/joinform";
	}
	
	
	
	//-회원가입
	@RequestMapping(value="/join", method= {RequestMethod.GET, RequestMethod.POST}) //포스트는 주소에 값을 숨겨서 보낸다.
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
	@RequestMapping(value="/loginform", method= {RequestMethod.GET, RequestMethod.POST})	
	public String loginForm() {

		System.out.println("UserController.loginForm");//ㅇㅋ

		return "user/loginform";

	}
	
	
	
	//-로그인
	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVO userVO, HttpSession session) {
		System.out.println("UserController.login");//ㅇㅋ
		UserVO authUser = userService.exeLogin(userVO);
		
		//세션에 로그인 확인용 값을 넣어준다. --> 로그인했다
		session.setAttribute("authUser", authUser); //별명 / 번호
		//세션이 번호표를 알려줬을 거ㅏㄷ.                      
	
		return "redirect:/";

	}
	
	
	//로그아웃
	@RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout");
		
		//섹션의 확인용 값을 지운다
		//session.removeAttribute("authUser"); //얘는 값만 지우는 거
		session.invalidate(); //얘는 다 지우는 거
		
		return "redirect:/";
	
	}
	
	
	//회원정보수정폼
	@RequestMapping(value="/editform", method= {RequestMethod.GET, RequestMethod.POST})
	public String editform(HttpSession session, Model model) {
		
		System.out.println("UserController.editform");//ㅇㅋ
		
		//세션에 값이 있는지 가져온다
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		System.out.println(authUser);
		
		if(authUser == null) {//로그인 안했으면
			System.out.println(authUser);
			return "redirect:/user/loginform";
			
		} else {//로그인 했으면
			
			//세션에서 no값을 가져온다(지금 접속한(로그인 된) 사용자의 no값)
			//*파라미터로 안 받고 왜 세션에서 꺼내쓸까?
			//UserVO authUser = (UserVO)session.getAttribute("authUser");
			int no = authUser.getNo();
			
			
			//no를 서비스에 넘겨서 no회원의 정보를 userVO형태로 받는다.
			UserVO userVO = userService.exeEditForm(no);
			
			//userVO 모델에 담는다 --> D.S request의 어트리뷰트에 넣어라
			model.addAttribute("userVO", userVO);
		}

		return "user/editform";

	}
	
	//--회원정보 수정
	@RequestMapping(value="/edit", method= {RequestMethod.GET, RequestMethod.POST})
	public String edit(@ModelAttribute UserVO userVO, HttpSession session ) {
		
		//0.DS가 파라미터 값을 묶어서 준다
		System.out.println("UserController.edit");//ㅇㅋ
		
		
		//1.세션에서 묶어준userVO에 세션에서 꺼낸 no를 추가한다.
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		int no =authUser.getNo();
		

		//2. DS 가 묶어준 userVO에 세션에서 꺼낸 no를 추가한다.
		userVO.setNo(no);
	
		
		//3.서비스에 묶어둔 userVO를 넘긴다.
		int count = userService.exeEdit(userVO);
		
		
		//4.해더의 이름 변경 --> 세션의 이름변경
		//위에 1번에서 가져온 authUser에 이름을 변경한다
		authUser.setName(userVO.getName());
						
		
		//메인으로 리다이렉트 시킨다.
		return "redirect:/";
		
	}
	
	
	
}
