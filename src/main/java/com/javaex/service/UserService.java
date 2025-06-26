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

}
