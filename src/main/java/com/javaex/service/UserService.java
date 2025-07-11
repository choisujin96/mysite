package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.UserRepository;
import com.javaex.vo.UserVO;
@Service
public class UserService {
	
	//필드
	@Autowired
	private UserRepository userRepository;
	
	//생성자
	
	//메소드 gs
	
	//메소드일반
	//-회원가입
	public int exeUserAdd(UserVO userVO) {
		
		System.out.println("UserService.UserAdd");//ㅇㅋ

		int count = userRepository.userInsert(userVO);
		
		return count;

	}
	
	
	//-로그인
	public UserVO exeLogin(UserVO userVO) {
		
		System.out.println("UserService.exeLogin");//ㅇㅋ
		
		UserVO authUSer = userRepository.userSelectOneByIdPw(userVO);
		
		return authUSer;
		
	}
	
	
	//회원수정폼
	public UserVO exeEditForm(int no) {
		System.out.println("UserService.exemodifyform");
		
	
		UserVO userVO = userRepository.userSelectByNo(no);
		
		return userVO;
	}
	
	
	public int exeEdit(UserVO userVO) {
		
		int count = userRepository.userUpdate(userVO);
		
		return count;
	}
	
	//아이디사용유무 체크 (회원가입)
	public boolean exeIdcheck(String id) {
		System.out.println("UserService.exeIdcheck");//ㅇㅋ
	
		UserVO userVO = userRepository.userSelectById(id);
		System.out.println("service");
		System.out.println(userVO);
		
		if(userVO == null) {
			//사용할 수 있는 아이디
			return true;
		}else {
			//사용중인 아이디
			return false;
		}
		
	}
	
	
}
