package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService; 

	//방명록 리스트
	@RequestMapping(value="/guestbook/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list");
		
		List<GuestbookVO> guestbookList = guestbookService.exeGetguestbookList();
		
		model.addAttribute("guestbookList", guestbookList); 
		
	
		return "guestbook/addList";
	}

	
	//방명록 등록
	@RequestMapping(value="/guestbook/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookController.add"); //ㅇㅋ
		
		guestbookService.exeGuestbookAdd(guestbookVO);
		
		System.out.println(guestbookVO);
		return "redirect:/guestbook/list";
		
	}
	
	
	//방명록 삭제폼
	@RequestMapping(value="/guestbook/rform", method= {RequestMethod.GET , RequestMethod.POST})
	public String removeform() {

		System.out.println("GuestbookController/rform");//ㅇㅋ
		
		return "guestbook/removeForm";
	}
	
	
	//방명록 삭제
	@RequestMapping(value="/guestbook/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String remove(@ModelAttribute GuestbookVO guestbookVO) {
		System.out.println("GuestbookXontroller.remove()");//oㅋ

		System.out.println(guestbookVO);
		guestbookService.exeGuestbookRemove(guestbookVO);
		
		return "redirect:/guestbook/list";
	}
	
	
}
