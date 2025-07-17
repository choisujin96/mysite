package com.javaex.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.repository.GalleryRepository;
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
	public String exeupload(GalleryVO galleryVO, MultipartFile file) {
		System.out.println("GalleryService.exeupload");//ㅇㅋ
		
		
		//파일저장경로
		String saveDir = "C:\\javaStudy\\upload\\";
		

	    // 1) 원본 파일명
	    String orgName = file.getOriginalFilename();
	    System.out.println("원본 파일명: " + orgName);

	    // 2) 확장자 추출
	    String ext = orgName.substring(orgName.lastIndexOf("."));
	    
	    // 3) 저장할 파일명 생성 (예: UUID + 확장자)
	    String saveName = System.currentTimeMillis() + ext;

	    // 4) 파일 저장 경로 전체
	    String filePath = saveDir + saveName;

	    try {
	        // 5) 실제 파일 저장
	        file.transferTo(new File(filePath));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "error";  // 저장 실패 시 에러 뷰 또는 메시지 반환
	    }

	    // 6) GalleryVO에 데이터 세팅 (예: content, orgName, saveName, filePath, fileSize, userNo 등)
	    galleryVO.setOrgName(orgName);
	    galleryVO.setSaveName(saveName);
	    galleryVO.setFilePath(filePath);
	    galleryVO.setFileSize(file.getSize());

	    // 7) DB 저장 호출
	    galleryRepository.galleryupload(galleryVO, file);

	    return "redirect:/gallery/list";  // 업로드 성공 후 이동할 페이지
		
	}
}
