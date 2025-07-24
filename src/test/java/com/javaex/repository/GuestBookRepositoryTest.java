/*
package com.javaex.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaex.vo.GuestbookVO;

@SpringBootTest
public class GuestBookRepositoryTest {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@Test
	public void selectAll() {
		List<GuestbookVO> guestbookList =  guestbookRepository.guestbookSelect();
		System.out.println("-----------------------------------------------");
		System.out.println(guestbookList);
		System.out.println("-----------------------------------------------");
		
		assertThat(guestbookList).isNotNull();
		//assertThat(guestbookList).isEqualTo('1');
	}
	
	
	@Test
	public void delete() {
		GuestbookVO guestbookVO = new GuestbookVO();
		guestbookVO.setNo(27);
		guestbookVO.setPassword("333");
		System.out.println(guestbookVO);
		
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		assertThat(count).isEqualTo(0);
	}
	
	@Test
	public void insert() {
		
		GuestbookVO guestbookVO = new GuestbookVO("최수진", "000", "하이헬로");

		//guestbookVO.setName("스타벅스");
		//guestbookVO.setPassword("000");
		//guestbookVO.setContent("하이헬로");
		//System.out.println(count);
		
		
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		assertThat(count).isEqualTo(1);

	}
	
	
}

*/