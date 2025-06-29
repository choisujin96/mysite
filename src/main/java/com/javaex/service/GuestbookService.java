package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.UserRepository;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {

	@Autowired
	private UserRepository userRepository;
	
	
	//메소드일반
	//-전체 리스트 가져오기
	public List<GuestbookVO> exeGetguestbookList() {
		System.out.println("GuestbookService.exeGetguestbookList");
		//List<GuestbookVO> phonebookVO = userRepository.guestbookSelect();

		//return GuestbookVO;
	}
	
	
	
	
	
	
}
