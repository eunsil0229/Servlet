package com.koreait.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;
import com.koreait.board.db.DbCon;
import com.koreait.board.vo.BoardVO;

// jsp : view 담당
// survlet : 로직 담당
// request.getRequestDispatcher	: 주소값은 안 변함, 연결고리가 있음, 주로 jsp 파일을 열 때 씀
//								: WEB-INF에다가 jsp 파일을 갖다놓고 그 파일을 열 때 사용
// response.sendredirect	: 주소값이 변함, 연결고리가 없음
// request.getRequestDispatcher는 doGet에서는 get, doPost는 post방식으로 날아감
// response.sendredirect 사용하면  doGet이든 doPost는 무조건 get방식으로 날아감

@WebServlet("/boardList") // 주소값 매핑 : 주소에 boardList.jsp 라는 파일 이름이 나타나지 않음
// 이렇게 안 할거면 xml에 적어야 함
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// doGetr과 doPost 중에서 꼭 필요한 것만 사용하면 됨

	
	// 보통 doGet은 화면 띄우는 담딩
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<BoardVO> list = BoardDAO.selBoardList();
    	request.setAttribute("data", list);
    	

    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
    	rd.forward(request, response);
    	// 중요한 것은 request! response는 별로 안 중요함
    	// "/WEB-INF/view/boardList.jsp" 정보를 response 객체를 이용해서 리턴
    	
	}

    
    // 보통 doPost는 처리 담당
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    
    // request	: 요청 들어왔고 응답했을 때 죽음(개인용, 개인마다 발행)
    // session	: 브라우저 끄는 순간 죽음(개인용, 개인마다 발행)
    // pageContext(page)	: 페이지 열릴 때 살아나고 응답했을 때 죽음(개인용, 개인마다 발행)
    // application	: 서버 키는 순간 생성, 끄는 순간 죽음(개인용이 아니라 전체용, 하나밖에 생성 안됨)
}
