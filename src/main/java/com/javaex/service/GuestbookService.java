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
	
	
	
	//-전체 리스트 가져오기2(페이징)
	public List<GuestbookVO> exeGetguestbookList2() {
		System.out.println("GuestbookService.exeGetguestbookList22");//ㅇㅋ
		guestbookRepository.guestbookSelect2();

		return null;
	}
	
	

	
	//방명록 저장하기
	public int exeGuestbookAdd(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookAdd");//ㅇㅋ
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		
		return count;
		
		
	}
	
	
	//방명록 저장하기_키값 조회(ajax)
	public GuestbookVO exeGuestbookAddKey(GuestbookVO guestbookVO){
		
		System.out.println("GuestbookService.exeGuestbookAddKey");
		int count = guestbookRepository.guestbookInsertKey(guestbookVO);
		System.out.println(guestbookVO);
		
		//추가된 방명록 글 가져오기
		GuestbookVO gVO = guestbookRepository.guestbookSelectOne(guestbookVO.getNo());
		
		return gVO;
	}
	
	
	
	
	//-방명록 삭제하기
	public int exeGuestbookRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeGuestbookRemove");
		
		
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		
		return count;
		
	}
		
	
	
	
}
