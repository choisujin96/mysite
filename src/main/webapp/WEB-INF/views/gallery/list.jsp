<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <title>MySite</title>
	     <!-- css -->
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mysite.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/gallery.css">
	    
	    <!-- js -->
		<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-3.7.1.js"></script>
	</head>

    <body>
		<div class="wrap">

	     	<!-- 헤더 + 네비---------------------------------- -->
	        <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	        <!-- 헤더 + 네비---------------------------------- -->

			<div class="content2 clearfix">
          
          
				<aside>
				    <h2>갤러리</h2>
				    <ul>
				        <li><a href="">일반갤러리</a></li>
				        <li><a href="">첨부파일연습</a></li>
				    </ul>
				</aside>

		 	 	<main>
					<div class="main-head clearfix">
						<h3>일반갤러리</h3>
						<ol class="clearfix">
						    <li>홈</li>
						    <li>갤러리</li>
						    <li>일반갤러리</li>
						</ol>
					</div>

              		<div id="gallery-list">
             			<c:if test="${sessionScope.authUser != null}">
               				<form action="${pageContext.request.contextPath}/gallery/list" method="post" enctype="multipart/form-data">
                   				<div class="btn-box">
                       				<button id="upbtn" class="btn btn-blue btn-md" type="submit">이미지올리기</button>
                  				</div>
			                </form>
			            </c:if>   
			                 
		                <ul class="clearfix">
		
						<!-- 이미지반복영역 -->
						<c:forEach var="galleryVO" items="${galleryList}">
			                <li>
			                    <div class="card" >
			                        <img src="${pageContext.request.contextPath}/upload/${galleryVO.saveName}">
			                        <div class="writer">
			                            작성자: <strong>${galleryVO.userName}</strong>
			                        </div>
			                    </div>
			                </li>
		                </c:forEach>
			        
						<!-- 이미지반복영역 -->
					
						</ul>
           			</div>
                  
              	</main>
         	 </div>
          
	          <!-- 푸터 -->
				  
	   			 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	                 
			  <!-- 푸터 -->

		</div>

        
 <!-- ------------------------------------------------------------- -->


<!-- 모달창 -->
<!-- 업로드 모달창 -->
<div id="modal-upload" class="modal-bg">

	<div class="modal-content" >
    
        <div class="clearfix">
            <button class="btn-close">X</button>
        </div>
        
		<p class="title">이미지등록 모달창</p>
		
		<form id="imgupload-form" action="/gallery/upload" method="post" enctype="multipart/form-data">
			<div class="info-row">
                <label for="txt-content">글작성</label>
				<input id="txt-content" type="text" name="content" value="">
			</div>

            <div class="info-row">
                <label for="txt-file">이미지선택</label>
				<input id="txt-file" type="file" name="file" value="">
			</div>
            <div class="btn-box">
			    <button type="submit" class="btn-upload btn btn-blue btn-md">등록</button>
            </div>
        </form>
		
	</div>

</div>


<!-- 이미지보기 모달창 -->
<div id="modal-view" class="modal-bg">

	<div class="modal-content" >
    
        <div class="clearfix">
            <button class="btn-close">X</button>
        </div>
        
		<p class="title">이미지보기 모달창</p>
		
		<div id="img-view">
            <img src="">


            <div class="img-content">
                여기는 입력한 코멘트가 나옵니다.
            </div>

            <div class="btn-box">
			    <button type="submit" class="btn-del btn btn-blue btn-md">삭제</button>
            </div>

        </div>
			
		
	</div>

</div>

<script>
$(document).ready(function(){
	   console.log('돔트리완성');//ㅇㅋ
	   
	//이미지 올리기 버튼 눌렀을 때   
	$('#upbtn').on('click', function(event){
		event.preventDefault(); 
		console.log('버튼클릭');
		
		//모달창 열기
		$('#modal-upload').addClass('active');
		
	 });
	
	
		//등록버튼 클릭했을 때
		$('.btn-upload').on('click', function(event){
			console.log('등록버튼 클릭');
			//event.preventDefault();
			
			//value값 수집
			let content = $('#txt-content').val();
		    let file = $('#txt-file')[0].files[0]; // ← 파일 객체!
		
		    // 확인용
		    console.log("작성 내용:", content);
		    console.log("선택된 파일:", file);
		
		    // VO처럼 묶기 (주의: JS 객체는 실제 파일 업로드용이 아님)
		    let guestbookVO = {
		        content: content,
		        file: file.name  //파일 이름만 예시로 넣음 (파일 자체는 FormData로 보내야 함)
		    };
		
		    console.log(guestbookVO);
		});
		
				
		//모달창의 닫기버튼을 클릭했을 때
		$('.btn-close').on('click', function(){
			console.log('모달창의 닫기버튼 클릭');
			
			$('.modal-bg').removeClass('active');
				
		});
		
		
		// 이미지 클릭 시 모달 오픈
	    $('.card').on('click', function(){
	    	console.log('이미지 클릭');
	        let imgSrc = $(this).data('file');
	        let content = $(this).data('content');

	     

	        // 모달에 데이터 삽입
	        $('#modal-view img').attr('src', imgSrc);
	        $('#modal-view .img-content').text(content);

	        // 모달창 활성화
	        $('#modal-view').addClass('active');
	    });

	    // 모달 닫기
	    $('.btn-close').on('click', function(){
	        $('.modal-bg').removeClass('active');
	    });
		
		
		
	});	  


	
</script>

	</body>
</html>
