<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="../include/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>회원 수정</h1>
	</div>
</div>
	<div class="container">
	
		<form action="update" method="post" id="frm">
		<input type="hidden" name="userid" id="userid" value=${member.userid } />
			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" name="name" class="form-control"  value=${member.name }>
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> 
				<input type="password" name="pwd" class="form-control" value=${member.pwd } >
			</div>

			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="text" name="eamil" class="form-control" value=${member.email } >
			</div>

			<div class="form-group">
				<label for="phone">Phone:</label> 
				<input type="text" name="phone" class="form-control" id="phone" value=${member.phone } >
			</div> 
	
	<tr>
	<td colspan="2" >
	<input type="submit" class="btn btn-primary"  value="수정">
	<input type="button" value="삭제"   class="btn btn-danger" onclick="location.href='delete?userid=${member.userid}'">
	<input type = "reset" class="btn btn-primary" value="취소">
	<input type="button" value="전체보기" class="btn btn-secondary" onclick="location.href='list'">
	</td>
	</tr>
	</table>
	</form>
	</div>





    <%@ include file="../include/footer.jsp"%>