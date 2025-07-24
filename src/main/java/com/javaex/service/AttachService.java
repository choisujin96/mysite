package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.javaex.MysiteApplication;
import com.javaex.vo.FileVO;

@Service
public class AttachService {

    private final MysiteApplication mysiteApplication;

    AttachService(MysiteApplication mysiteApplication) {
        this.mysiteApplication = mysiteApplication;
    }
	
	//필드
	
	//생성자
	
	//메소드 일반
	public String exeupload(MultipartFile file) {
		System.out.println("AttachService.exeupload()");
		
		//현대 os명 정보
		String osName = System.getProperty("os.name").toLowerCase();
	
		String saveDir = "";
		if(osName.contains("win")) {//윈도우면
			System.out.println("지금 os 윈도우");
			saveDir = "C:\\javaStudy\\upload\\";
		}else { //리눅스면
			saveDir = "/data/upload/";
		}
		
	
		
		//(1)파일 정보를 추출 저장(DB)
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		System.out.println(orgName);
		
		//확장자
		//아래코드를 간단하게 한 것
		String exName = orgName.substring(orgName.lastIndexOf(".")+1); 
		System.out.println(exName);
		
		/*
		int index = orgName.lastIndexOf(".");  //몇번째 방에 .이 있냐 (0번방부터 시작)
		System.out.println(index);
		
		String exName = orgName.substring(8); //8번앞까지 앞에이름 짤라내라
		System.out.println(exName);
		*/
		
		//저장파일명(덮어쓰기방지용)
		String saveName = System.currentTimeMillis()+UUID.randomUUID().toString()+"."+exName;
		System.out.println(saveName);
		
		//파일경로
		String filePath = saveDir + saveName;
		System.out.println(filePath);


		//파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		//vo에 묶는다 
		FileVO fileVO = new FileVO (orgName, exName,saveName, filePath, fileSize);
		System.out.println(fileVO);

		//--> 저장 레파지토리 생성하기
		//과제 file table 생성. 일렬번호 하나씩 주기
		
		
		//(2)실물파일을 하드디스크에 저장
		
		 try {			 
			 byte[] fileData = file.getBytes();
			 
			  OutputStream os= new FileOutputStream(filePath);
			  BufferedOutputStream bos = new BufferedOutputStream(os);
			  
			  bos.write(fileData);
			  bos.close();
			  
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		 return saveName;
		 
	}
	

	
	
}
