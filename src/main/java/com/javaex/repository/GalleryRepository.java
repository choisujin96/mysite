package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public void galleryupload(GalleryVO galleryVO) {
		System.out.println("GalleryRepository.galleryupload");//ㅇㅋ
		 int count = sqlSession.insert("gallery.insert", galleryVO);
		System.out.println(galleryVO);
	}
	
	
}
