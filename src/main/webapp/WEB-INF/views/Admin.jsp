<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>

<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
		<h1>Administrator</h1>
			<p class="lead">Administrator can do these task</p>
		
		
		
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a  href="${contextPath}/adminAddProduct">ADD PRODUCT</a></button>
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a  href="${contextPath}/adminAddCategory">ADD CATEGORY</a></button>
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a href="${contextPath}/adminAddSupplier" >ADD SUPPLIER</a></button>
      