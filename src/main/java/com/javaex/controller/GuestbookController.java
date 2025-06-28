package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService; 
	
	// 방명록 리스트
	@RequestMapping(value="/guestbook/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list() {
		System.out.println("GuestbookController.list"); //ㅇㅋ
		
		return "guestbook/addList";
	}
	
	
	//방명록 등록
	
	
	
	//
	
}
