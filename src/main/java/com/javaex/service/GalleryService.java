package com.javaex.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.repository.GalleryRepository;
import com.javaex.vo.FileVO;
import com.javaex.vo.GalleryVO;

@Service
public class GalleryService {

	@Autowired
	private GalleryRepository galleryRepository;
	
	public List<GalleryVO> exeGalleryList() {
		System.out.println("GalleryService.exeGalleryList");
		List<GalleryVO> galleryList = galleryRepository.SelectList();
	
		return galleryList;
	}
	
	
	//사진업로드
	public String exeupload(MultipartFile file) {
		System.out.println("GalleryService.exeupload");//ㅇㅋ
		galleryRepository.galleryupload();
		
		//파일저장경로
		String saveDir = "C:\\javaStudy\\upload\\";
		
		//(1)파일 정보를 추출 저장(DB)
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		
		//확장자
		
		
		
		
		return null;
		
	}
}
