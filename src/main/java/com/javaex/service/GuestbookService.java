package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GuestbookRepository;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	
	//메소드일반
	//-전체 리스트 가져오기
	public List<GuestbookVO> exeGetguestbookList() {
		System.out.println("GuestbookService.exeGetguestbookList");//ㅇㅋ
		List<GuestbookVO> guestbookList = guestbookRepository.guestbookSelect();
	
		

		return guestbookList;
	}
	
	//방명록 저장하기
	public int exeGuestbookAdd(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookAdd");//ㅇㅋ
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		
		return count;
		
		
	}
	
	//-방명록 삭제하기
	public int exeGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookRemove");
		
		
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		
		return 0;
		
	}
		
	
	
	
}
