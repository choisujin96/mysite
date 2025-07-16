package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVO;

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
	@RequestMapping(value="/gallery/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload() {
		System.out.println("GalleryController.upload");//ㅇㅇ
	
		galleryService.exeupload(null);
		
		return "";
	}
	
	
}
