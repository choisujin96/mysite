package com.javaex.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.GalleryVO;

@Repository
public class GalleryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVO> SelectList() {
		System.out.println("GalleryRepository.SelectList");	
		List<GalleryVO> galleryList = sqlSession.selectList("gallery.selectList");	
		
		return galleryList;
	}
	
	
	//업로드
	public int galleryupload(GalleryVO galleryVO, MultipartFile file) {
		System.out.println("GalleryRepository.galleryupload");//ㅇㅋ
		 System.out.println("GalleryRepository.galleryupload");
		    System.out.println("sqlSession : " + sqlSession);

		    int count = sqlSession.insert("gallery.insert", galleryVO);
		    System.out.println("insert count: " + count);

		    return count;
	
	}
		
	
}
