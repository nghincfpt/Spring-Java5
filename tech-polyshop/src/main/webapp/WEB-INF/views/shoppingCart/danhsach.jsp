<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>ShoppingCarts</h2>
	<hr>
	<table>
		<tr>
			<td>No.</td>
			<td>image</td>
			<td>Name</td>
			<td>Quantity</td>
			<td>unitPrice</td>
			<td></td>
		</tr>
		<c:set var="no" value="1"></c:set>
		<c:forEach var="item" items="${cartitems}"> 
		<form action="/shoppingCart/update" method="post">
		<tr>
			<td>${no }</td>
			
<%-- 			<td th:src="@{${'/uploads/images/' + products.image}}" --%>
<%-- 				th:alt="${products.name}" ></td> --%>
			
			<td>${item.name }</td>
			<td>
			<input type="hidden" name="productId" value="${item.productId }">
			<input type="number" value="${item.quantity }" name="quantity"
			onblur="this.form.submit()"
			> 
			</td>
			<td>${item.unitPrice }</td>
			<td>
			<a href="/shoppingCart/remove/${item.productid }">remove</a>
			</td>
		</tr>
		</form>
		<c:set var="no" value="${no+1 }"></c:set>
		</c:forEach>
	</table>
	<a  href="/site/home"> Home </a>
		<a  href="/shoppingCart/checkout"> checkout </a>
</body>
</html>