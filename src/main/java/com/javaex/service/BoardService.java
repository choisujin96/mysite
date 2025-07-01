package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

    private final GuestbookService guestbookService;

	@Autowired
	private BoardRepository boardRepository;

    BoardService(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }
	
	//--게시판 전체 리스트
	public List<BoardVO> exeList() {
		System.out.println("BoardService.exeList");	//ㅇㅋ
		List<BoardVO> boardList = boardRepository.boardSelect();
		return boardList;

	}
	
	
	//--게시판 전체 리스트2(페이징)
		public Map<String, Object> exeList2(int crtPage) {
			System.out.println("BoardService.exeList22");	//ㅇㅋ
			System.out.println(crtPage);
			
			///리스트가져오기///
			
			// 한페이지 출력갯수
			int lsitCnt = 10;
			
			//시작번호
			/*
			 1--> (0, 10)
		     2--> (10, 10)
		     startRowNo = (crtpage -1)*listCnt 
			 */
			int startRowNo = (crtPage -1)*lsitCnt;
			
			
			//두개의 데이터를 묶는다가 --> Map사용
			Map<String, Integer> limitMap = new HashMap<String, Integer>();
			limitMap.put("startRowNo", startRowNo);
			limitMap.put("lsitCnt", lsitCnt);
	
			//묶은 걸 레파지토리에 보낸다.
			List<BoardVO> boardList = boardRepository.boardSelect2(limitMap);
			
			
			
			/////////////////////////////////////////////
			//// 페이징버튼 (하단버튼)
			/////////////////////////////////////////////
			
			//페이지당 버튼갯수
			int pgaeBtncount = 5;
			

			//마지막 버튼 번호 endPageBtnNo
			/*
			 1  2  3  4  5  >
			 1->(1, 5)
			 2->(1, 5)
			 3->(1, 5)
			 4->(1, 5)
			 5->(1, 5)
			 6->(6, 10)
			 7->(6, 10)
			 ...
			 10->(6, 10)
			 11->(11, 15)	
			 
			 1->  올림(1/5)5  --> 0.2(1)*5  -->5
			 2->  올림(2/5)5  --> 0.4(1)*5  -->5
			 3->  올림(3/5)5  --> 0.6(1)*5  -->5
			 4->  올림(4/5)5  --> 0.8(1)*5  -->5
			 5->  올림(5/5)5  --> 1.0(1)*5  -->5
			 6->  올림(6/5)5  --> 1.2(2)*5  -->10
			 11-> 올림(11/5)5 --> 2.2(3)*5  -->15
			*/
	
			//올림처리                                       //실수로 바꿔준다. 왜? 소수점이 나와야 올림을 할 수 있으니가.
			int endPageBtnNo = ((int)Math.ceil(crtPage/((double)pgaeBtncount)))*pgaeBtncount;
			
			
			
			//시작 버튼 번호 startPageBtnNo
			int startPageBtnNo = (endPageBtnNo - pgaeBtncount)+1;
		
			
			
		
			//전체 글 갯수
			int totalCount = boardRepository.selectTotalCount();
			//다음 화상표 유무 next
			boolean next = false;
			if(lsitCnt*endPageBtnNo < totalCount) {
				next=true;
			}else {//다음화살표가 false일때 마지막 버튼 번호를 다시 계산해야한다
				
				endPageBtnNo = (int)Math.ceil(totalCount/((double)lsitCnt));    
			}
			
			
			//이전 화살표 유무 prev
			boolean prev = false;
			if(startPageBtnNo != 1) {
				prev =true;
			}
			
			//모두 묶어서 컨트롤러에 리턴해준다. --> Map 사용
			Map<String, Object>pMap = new HashMap<String, Object>();
			pMap.put("boardList", boardList); //리스트
			pMap.put("prev", prev); //이전버튼 유무
			pMap.put("next", next); //다음버튼 유무
			pMap.put("startPageBtnNo", startPageBtnNo); //시작버튼 번호
			pMap.put("endPageBtnNo", endPageBtnNo); //마지막버튼 번호
			//pMap.put("pgaeBtncount", pgaeBtncount); //한페이지 노출되는 번호
			
			return pMap;

		}
	
	
	
		
		
		
		
	
	
	//글등록
	public int exeBoardAdd() {
		System.out.println("BoardService.exeBoardAdd");//ㅇㅋ
		boardRepository.boardInsert();
		
		return 0;
		
		
	}
	
}
