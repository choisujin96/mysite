package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService; 
	
	
	// 방명록 리스트
	@RequestMapping(value="/guestbook/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list");
		
		List<GuestbookVO> gList = guestbookService.exeGetguestbookList();
		
		model.addAttribute("gList", gList); 
		
	
		return "guestbook/addList";
	}

	
	
	//방명록 등록
	
	

	
}
