<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>

<script>
$(function(){
	$("#writeBtn").click(function(){
		if(${empty sessionScope.suser}){
			alert("로그인 하세요");
			location.href="../member/login"
			return false;
		}
		location.href="write"
	})
})
</script>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Board List(${count })</h1>
	</div>
</div>
 
<div class="container">
	<div class="mb-3">
		<a href="write"><button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button></a>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board" varStatus="st">
				<tr>
					<td>${board.num}</td>
					<td><a href="boardDetail?num=${board.num }">${board.subject }</a></td>
					<td>${board.userid }</td>
					<td>${board.regdate }</td>
					<td>${board.readcount }</td>
				</tr>


			</c:forEach>

		</tbody>
	</table>

	<ul class="pagination">
	<!--  이전 -->
	<c:if test="${p.startPage > p.blockPage }">
		<li class="page-item">
		<a class="page-link" href="boardlist?pageNum=${p.startPage-p.blockPage}&field=${p.field}&word=${p.word}">Previous</a></li>
	</c:if>
	<!-- 페이지 번호 -->
	<c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
		<!--  현재페이지가 아니면 -->
		<c:if test="${p.currentPage != i }">
			<li class="page-item ">
			<a class="page-link" href="boardlist?pageNum=${i }&field=${p.field}&word=${p.word}">${i }</a></li>
		</c:if>
		<!-- 현재페이지 -->
		<c:if test="${p.currentPage == i }" >
			<li class="page-item active"><a class="page-link" href="">${i }</a></li>
		</c:if>
	</c:forEach>	
	<!--  다음 -->	
	<c:if test="${p.endPage < p.totPage }">
		<li class="page-item">
		<a class="page-link" href="boardlist?pageNum=${p.endPage+1}&field=${p.field}&word=${p.word}">Next</a></li>
	</c:if>	
		
	</ul>



	<form class="form-inline" action="boardlist">
		<select class="form-control mr-sm-1" id="field" name="field">
			<option value="subject">제목</option>
			<option value="content">내용</option>
			<option value="userid">작성자</option>
		</select> <input class="form-control" type="text" placeholder="Search"
			id="word" name="word">
		<button class="btn btn-success" type="submit">Search</button>
	</form>

</div>
<%@ include file="../include/footer.jsp"%>