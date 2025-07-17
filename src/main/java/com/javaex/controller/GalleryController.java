package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVO;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	//갤러리 리스트
	@RequestMapping(value="/gallery/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model){
		System.out.println("GalleryController.list()");
		List<GalleryVO> galleryList = galleryService.exeGalleryList();
		
		model.addAttribute("galleryList", galleryList);
		
		
		return "gallery/list";
	}
	
	
	//업로드
	@RequestMapping(value="/gallery/upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute GalleryVO galleryVO, 
	                     @RequestParam("file") MultipartFile file, 
	                     HttpSession session,
	                     Model model) {
	    System.out.println("GalleryController.upload");
	    
	    // 세션에서 로그인 사용자 번호 꺼내기 (authUser에 UserVO가 있다고 가정)
	    UserVO authUser = (UserVO) session.getAttribute("authUser");
	    if(authUser != null) {
	        galleryVO.setUserNo(authUser.getNo());  // userNo 세팅
	    } else {
	        // 로그인 안된 상태 처리 (예: 리다이렉트)
	        return "redirect:/user/login";
	    }

	    galleryService.exeupload(galleryVO, file);

	    // 업로드 성공 후 이동할 경로 지정 (예: 리스트 페이지)
	    return "redirect:/gallery/list";
	}
	
}
