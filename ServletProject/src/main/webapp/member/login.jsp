<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>LOGIN</h1>
	</div>
</div>
	<div class="container">
		<form action="login" method="post" id="frm">
			<div class="form-group">
				<label for="userid">UserID:</label> <input type="text"
					class="form-control" id="userid" placeholder="Enter userid" name="userid">
			</div>
		
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter Password"
					name="pwd">
			</div>
			<button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
		</form>
	</div>
	<script>
	$("#loginBtn").click(function(){
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}//userid  
		if($("#pwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		}//pwd
		$.ajax({
			type:"post",
			url : "login",
			data : {
				"userid" : $("#userid").val(),
			    "pwd" :	$("#pwd").val()
			},
			success:function(resp){
				if(resp.trim()==-1){
					alert("회원이 아닙니다. 회원가입하세요");
				}else if(resp.trim()==0){
					//일반회원 ==>memberView.jsp  관리자==>memberList.jsp
					alert("일반회원 로그인 성공")  
					$(location).attr("href","../board/boardlist")
				}else if(resp.trim()==1){
					alert("관리자 로그인 성공")  
					$(location).attr("href","../board/boardlist")
				}else if(resp.trim() ==2){
					alert("비밀번호가 틀립니다. 비밀 번호를 확인하세요");
				}

			},
			error:function(e){
				alert(e + "error")
			}
		})  //ajax
	
	})	//loginBtn
	
	
	</script>
<%@ include file="../include/footer.jsp"%>