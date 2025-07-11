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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css">
        
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
                    <h2>유저</h2>
                    <ul>
                        <li><a href="">회원정보</a></li>
                        <li><a href="">로그인</a></li>
                        <li><a href="">회원가입</a></li>
                    </ul>
                </aside>


                <main>
                    <div class="main-head clearfix">
                        <h3>회원정보</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>유저</li>
                            <li>회원가입</li>
                        </ol>
                    </div>

                    <div id="user-joinform">
                        
                        <form class="form-box" action="http://localhost:8888/user/join" method="get">
                            <div class="info-row">
                                <label class="info-title" for="txt-idcheck">아이디</label>
                                <input id="txt-idcheck" type="text" name="id" value="">
                                <button id="btnCheck" class="btn btn-gray btn-input"  type="button">중복체크</button>
                                <p id="checkMsg">ㅇㄴㅇㄴㅇㅇㄴ</p>
                                
                             
                            </div>
                            <div class="info-row">
                                <label class="info-title" for="txt-pwd">패스워드</label>
                                <input id="txt-pwd" type="password" name="password" value="">
                            </div>
                            <div class="info-row">
                                <label class="info-title" for="txt-name">이름</label>
                                <input id="txt-name" type="text" name="name" value="">
                            </div>
                            <div class="info-row">
                                <span class="info-title">성별</span>
                                <label>남</label>
                                <input type="radio" name="gender" value="male">
                                <label>여</label>
                                <input type="radio" name="gender" value="female">
                            </div>
                            <div class="info-row">
                                <span class="info-title">약관동의</span>
                                <input type="checkbox" name="" value="">
                                <lable>서비스 약관에 동의합니다.</lable>
                            </div>
                            <div class="btn-group">
                                <button class="btn btn-blue btn-lg" type="submit">회원가입</button>
                            </div>
                        </form>
                        
                    </div>

                    
                </main>
            </div>
            
            <!-- 푸터 -->
			  
   			 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
                 
			<!-- 푸터 -->

        </div>
 <!-- -----------------------------------------------------------------------------------------  -->   
<script>
//돔이 완료되었을 때
$(document).ready(function(){
	console.log('돔트리오ㅘㄴ료');
	
	//아이디체크 버튼을 클릭했을 때
	console.log($('#btnCheck'))
	$('#btnCheck').on('click',function(){
		console.log('아이디체크 버튼 클릭');
		
		//입력한 아이디
		let id = $('#txt-idcheck').val();
		console.log(id);
		
		//*서버랑 통신(주소치고 엔터)-->데이터만 받을거야*/
		$.ajax({
			
			url : "${pageContext.request.contextPath }/user/idcheck",		
			type : "post",
			//contentType : "application/json",
			data : {id: id}, //꼬랑지 없으면 안써도 됨

			dataType : "json",  // 서버에서 JSON 형식의 데이터를 받겠다는 뜻
			success : function(result){
				/*성공시 처리해야될 코드 작성*/
				console.log(result);
				console.log(result.isUse);
				
				if(result.isUse == true){
					$('#checkMsg').text('사용 가능한 아이디입니다.');
					$('#checkMsg').css('color', '#0000ff');
					$('#checkMsg').css('font-weight', 'bold'); 
				}else{
					$('#checkMsg').text('이미 사용 중인 아이디입니다.');
					$('#checkMsg').css('color', '#ff0000');
					$('#checkMsg').css('font-weight', 'bold');
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});

		
		
	});
	
	
	
});
	
	
	
	


</script>
     
     
    </body>
</html>