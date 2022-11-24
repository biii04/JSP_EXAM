<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
 <div class="jumbotron jumbotron-fluid mb-5">
   	<div class="container">
   		<h1>상품상세보기</h1>
   	</div>
  </div> 
  <div class="d-flex container">
	  <div class="card" style="width:400px">
		  <img class="card-img-top" src="/upload/${product.filename}" alt="Card image">
	  </div>
	  <div class="container">
		   <table class="table table-borderless">
		   	<tr>
		   	 <td width="200px">상품명(분류)</td>
		   	 <td>${product.pname}(${product.category })</td>
		   	</tr>
		   	<tr>
		   	 <td>가격</td>
		   	 <td>${product.unitPrice}</td>
		   	</tr>
		   	<tr>
		   	 <td>상품설명</td>
		   	 <td>${product.description}</td>
		   	</tr>
		   	<tr>
		   	 <td>제조사</td>
		   	 <td>${product.manufacturer}</td>
		   	</tr>
		   	<tr>  
		   	 <td>재고수</td>
		   	 <td>${product.unitsInStock}</td>
		   	</tr>
		   	<tr>
		   	 <td>구분</td>
		   	 <td>${product.condition}</td>
		   	</tr>
		   	<tr>
		   		<td colspan="2">
		   			<button class="btn btn-primary">장바구니</button>
		   			<button class="btn btn-info">구매하기</button>
		   		</td>
		   	</tr>
		   </table>
	</div>
  </div>

<%@ include file="../include/footer.jsp" %>  