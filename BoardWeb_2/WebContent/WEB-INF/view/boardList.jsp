<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.koreait.board.vo.BoardVO"%>
    
<%
	List<BoardVO> list = (List)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	body {
		width: 100%;
		height: 100%;
		margin: 0;
		padding: 0;
	}
	.container {
		width: 500px;
		height: 500px;
		border: 1px solid black;
		display: flex;
        justify-content: center;
        align-items: center;
	}
	.container .contents {
		width: auto;
		border: 3px solid black;
	
	}
	.container .contents .header {
		width: 100%;
		display: flex;
		justify-content: flex-end;
	}
    table {
        border-collapse: collapse;
    }
    .itemRow:hover {
    	background: #ecf0f1;
    	cursor: pointer;
    }
    tr, td, th {
        border: 1px solid black;
        width: 100px;
        text-align: center;
    }
</style>
</head>
<body>
	<div class="container">
		<div class="contents">
		<p>게시판 리스트</p>
			<header class="header">
				<a href="/boardWrite"><button>글쓰기</button></a> <!-- 글쓰는 화면 띄우는 용도인 boardWrite.jsp와 -->
					<!-- 폼으로 받아서 insert 날리고 실제 처리하는 boardWriteProc.jsp 파일 두 개가 필요함 -->
			</header>
			<table>
				<tr class="itemRow">
					<th>No</th>
					<th>제목</th>
					<th>작성자</th>
				</tr>
				<% for(BoardVO vo : list) {%>
				<tr class="itemRow" onclick="moveToDetail(<%=vo.getI_board()%>)">
					<td><%=vo.getI_board() %></td>
					<td><%=vo.getTitle() %></td>
					<td><%=vo.getI_student() %> </td>
				</tr>
				<% } %> 
			</table>
		</div>
	</div>
	<script>
		function moveToDetail(i_board) {
			console.log('moveToDetail - i_board : ' + i_board);
			location.href = 'boardDetail?i_board=' + i_board;
		}
	</script>
</body>
</html>

