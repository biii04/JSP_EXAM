<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="../include/header.jsp"%>
    <script src ="../js/member.js"></script>

<div class="jumbotron jumbotron-fluid">

</div>

<div class="container">

<form action = "list" method ="post">

<h1>MEMBER LIST(${count})</h1>
<table class="table table-hover">
	<tbody>
	<thead>
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>구분</td>
			<td>삭제</td>
		</tr>

	</thead>
	</tbody>
	<c:forEach items="${members}" var="member">
	<tr>
		<td> ${member.name }</td>
		<td><a href="view?userid=${member.userid}"> ${member.userid }</a> </td>
		<td> ${member.phone }</td>
		<td> ${member.email }</td>
		<td> ${member.admin }</td>
		</tr>
	</c:forEach>
	
</table>

</form>
</div>

<%@ include file="../include/footer.jsp"%>
