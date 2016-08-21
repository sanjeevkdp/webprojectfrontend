<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>

<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
		<h1>Administrator</h1>
		
			<p class="lead">Administrator can do these task</p>
		
		<c:url value="/logout" var="logoutUrl" />
     <form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     </form>
     <c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>
		
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a  href="${contextPath}/admin/adminAddProduct">ADD PRODUCT</a></button>
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a  href="${contextPath}/admin/adminAddCategory">ADD CATEGORY</a></button>
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a href="${contextPath}/admin/adminAddSupplier" >ADD SUPPLIER</a></button>
     </div></div></div>