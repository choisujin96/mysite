package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GalleryRepository;

@Service
public class GalleryService {

	@Autowired
	private GalleryRepository galleryRepository;
	
	public void exeGalleryList() {
		System.out.println("GalleryService.exeGalleryList");
		galleryRepository.SelectList();
	}
	
}
