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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/guestbook.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/modal.css">
    	<!-- js -->
    	<script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-3.7.1.js"></script>
        <!-- jquery문을 읽기 위해 연결. $나 해당문법들이 다 이걸 통해 읽을 수 있음 -->
    
    </head>


	<body>
		  <div class="wrap">
            <!-- 헤더 + 네비---------------------------------- -->
	        
	        <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	                 
	        <!-- 헤더 + 네비---------------------------------- -->
		
            <div class="content2 clearfix">
            
 	        <!-- 방명록 aside -->
		   <c:import url="/WEB-INF/views/include/asideGuestbook.jsp"></c:import>
	       <!-- 방명록 aside -->
		   
				<main>
					
				    <div class="main-head clearfix">
                        <h3>ajax방명록</h3>
                        <ol class="clearfix">
                            <li>홈</li>
                            <li>방명록</li>
                            <li>일반방명록</li>
                        </ol>
                    </div>

					<div id="guestbook-addlist">
						<form id="formAdd" class="form-box" action="" mthod="get">
							<table>
								<colgroup>
									<col style="width: 70px;">
									<col style="width: 340px;">
									<col style="width: 70px;">
									<col style="width: 340px;">
								</colgroup>
								<tbody>
									<tr>
										<th>
											<label for="txt-name">이름</label>
										</td>
										<td>
											<input id="txt-name" type="text" name="name" value="">
										</td>
										<th>
											<label for="txt-password">패스워드</label>
										</th>
										<td>
											<input id="txt-password"type="password" name="password" value="">
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<textarea id="text-content" name="content"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="4" class="btn-box">
											<button class="btn btn-blue btn-lg" type="submit">등록</button>
										</td>
									</tr>
								</tbody>
								
							</table>
						</form>	
						
						<button id="btnList" class="btn btn-blue btn-md" type="button"> 전체데이터요청 </button>
						
						<div id="gbListArea">
						
						<!-- 리스트 출력되는 자리 -->
						
						</div>
						
						
						
						
					<c:forEach items="${requestScope.guestbookList}" var="guestbookVO" >
						<table class="guestbook-item">
							<colgroup>
								<col style="width: 10%;">
								<col style="width: 40%;">
								<col style="width: 40%;">
								<col style="width: 10%;">
							</colgroup>
							<tbody>
								<tr>
									<td>[${guestbookVO.no}]</td>
									<td>${guestbookVO.name}</td>
									<td>${guestbookVO.regDate}</td>
									<td class="txt-center">
										<a class="btn btn-gray btn-sm" href="${pageContext.request.contextPath}/guestbook/rform?no=${guestbookVO.no}">삭제</a>
									</td>
								</tr>
								<tr>
									<td colspan=4>${guestbookVO.content}</td>
								</tr>
							</tbody>
						</table>
					</c:forEach>
						
					</div>
			    
                </main>
            </div>
            
            <!-- 푸터 -->
			  
   			 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
                 
			<!-- 푸터 -->

        </div>
    <!-- ------------------------------------------------------------- -->
    <!-- 모달창 -->
    <div class="modal-bg">
    
    	<div class="modal-content">
    		<p>비밓번호를 입력해 주세요.</p>
    		
    		<form id="modalForm" action="" method="" >
	    		<div>
	    			<input type="password" name="password" value="">
	    			<input type="text" name="no" value="">
	    		</div>
	 			<button type="submit" class="btn-del btn btn-blue btn-md">삭제</button>
	 			<button class="btn-close btn btn-gray btn-md">닫기</button>	
    		</form>
 		
    	</div>
    
    
    
    
    
    
    </div>
    
    
    
    
    
     
    <!-- ------------------------------------------------------------- --> 
    <script>
   $(document).ready(function(){
	   console.log('돔트리완성');
	   
	   fetchList(); //데이터리스트 요청해서 화면에 리스트 그리는 함수
	   
	
	   /*
	   //버튼 클릭할 때
	   $('#btnList').on('click',function(){
		   console.log('버튼클릭');
		   
		   fetchList(); //데이터리스트 요청해서 그린다. 
	   });
		*/
		
		
		//전송버튼을 클릭했을 때
		$('#formAdd').on('submit', function(event){
			console.log('전송버튼 클릭');
			event.preventDefault(); //기본동작을 실행하지 않도록 한다.
			
			
			//value값 수집
			let name = $('#txt-name').val();
			let pw = $('#txt-password').val();
			let content = $('#text-content').val();
			
			//VO묶기
			let guestbookVO = {
				name: name,
				password: pw,
				content: content	
			};
			
			console.log(guestbookVO);
			
			//서버에 저장 요청
			$.ajax({
				
				//보낼 때
				url : '${pageContext.request.contextPath }/api/guestbooks',		
				type : 'post',
				//contentType : "application/json",
				data : guestbookVO,
				
				//받을 때
				dataType : 'json',
				success : function(jsonResult){
					/*성공시 처리해야될 코드 작성*/
					console.log(jsonResult);
					console.log(jsonResult.result);
					console.log(jsonResult.apiData);
					
					if(jsonResult.result == 'success'){
						
						/* 화면에 그리기 */
						render(jsonResult.apiData, 'up');
						
						/* 입력폼 비우기 */
						$('#txt-name').val('');
						$('#txt-password').val('');
						$('#text-content').val('')
					}else {
						console.log("등록 실패");
					}
					
				
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});

			
		});
		
		
	
		/*삭제버튼은 클릭했을 때 --> 삭제모달창*/
		$('#gbListArea').on('click', '.btn-modal', function(){
			console.log('모달창 떠라');
			
			$('.modal-bg').addClass('active');

			// 내가 가지고 있는 no값을 / 모달창의 no값 넣는 input박스에 넣어둔다.
			let $this = $(this);
			let no = $this.data('no');
			console.log(no);
			//번호추가
			$('[name="no"]').val(no);
			
			//패스워드는 비운다
			$('[name="password"]').val('');

		});
		
		
		
		//모달창의 닫기버튼을 클릭했을 때
		$('.btn-close').on('click', function(){
			console.log('모달창의 닫기버튼 클릭');
			
			$('.modal-bg').removeClass('active');
				
		});
		
		
		//모달창의 삭제 버튼을 클릭했을 때 (진짜삭제)
		$('#modalForm').on('submit', function(){
			console.log('진짜삭제클릭');
			
			event.preventDefault();
			

			//데이터수집
			//<input type="password" name="" value="">
   		//	<input type="text" name="no" value="">
   			
   			let pw = $('#modalForm input[name="password"]').val();
   			let no = $('#modalForm input[name="no"]').val();
   			
   			let guestbookVO = {
   				password: pw
   			};
			
   			console.log(guestbookVO);
   			
   		
			//전송
			$.ajax({
				
				url : '${pageContext.request.contextPath }/api/guestbooks/'+no,		
				type : 'delete',
				//contentType : 'application/json',
				data : guestbookVO,

				dataType : 'json',
				success : function(JsonResult){
					/*성공시 처리해야될 코드 작성*/
					console.log(JsonResult);
					console.log(JsonResult.result);
					
					if(JsonResult == 'success'){
						//리스트에서 선택한 거 화면에서 지우기	
						$('#t' + no).remove();//아이디를 매칭시킨다.
						$('.modal-bg').removeClass('active');	
					}
					//모달창 닫기
					$('.modal-bg').removeClass('active');	
					
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});
			
		}); 
	   
		
		
		
		
		
		
   }); 
   //리스트데이터 요청해서 그리는 함수
   function fetchList(){
	   
	   $.ajax({
			
			url : "${pageContext.request.contextPath }/api/guestbooks",
			/*남의 것 쓸 때 --> url : 'https://raw.githubusercontent.com/clz2025-red/api/refs/heads/main/guestbook',*/
			type : "get",
			//contentType : "application/json",
			//data : {name: "홍길동"}, 지금은 꼬랑지(list?id=ddd) 없으니 필요없음

			dataType : "json",
			success : function(jsonResult){
				/*성공시 처리해야될 코드 작성*/
				console.log(jsonResult);
				console.log(jsonResult.result); //success인지 fail인지
				console.log(jsonResult.apiData); //success면 데이터값을 알려준다
				
				
				if(jsonResult.result == 'success'){
					//화면에 그린다.
					for(let i=0; i<jsonResult.apiData.length; i++){
						render(jsonResult.apiData[i], 'down');	
					}					
				}else {
					console.log("알 수 없는 오류");
				}
				
			
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
   }
   
   
//guestboolVO 1개를 화면에 그린다.
function render(guestbookVO, updown){
	console.log(guestbookVO);
	
	
	let str = '';
	str += '<table id="t'+guestbookVO.no+'" class="guestbook-item">';
	str += '	<colgroup>';
	str += '		<col style="width: 10%;">';
	str += '		<col style="width: 40%;">';
	str += '		<col style="width: 40%;">';
	str += '		<col style="width: 10%;">';
	str += '	</colgroup>';
	str += '	<tbody>';
	str += '		<tr>';
	str += '			<td>' + guestbookVO.no + '</td>';
	str += '			<td>' + guestbookVO.name + '</td>';
	str += '			<td>' + guestbookVO.regDate + '</td>';
	str += '			<td class="txt-center">';
	
	str += '				<button class="btn-modal btn btn-gray btn-sm" data-no="'   +guestbookVO.no+  '">삭제</button>';
	
	str += '			</td>';
	str += '		</tr>';
	str += '		<tr>';
	str += '			<td colspan=4>' + guestbookVO.content + '</td>';
	str += '		</tr>';
	str += '	</tbody>';
	str += '</table>';
	
	
	
	if(updown == 'up'){
		$('#gbListArea').prepend(str);
	
	}else if(updown == 'down'){
		$('#gbListArea').append(str);
	}else {
		console.log('방향체크');
	}
};    
    
    
    </script>
     
     
     
     
     
    </body>
</html>