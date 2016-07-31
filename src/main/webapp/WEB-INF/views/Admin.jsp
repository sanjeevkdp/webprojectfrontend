<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>

<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
		<h1>Administrator</h1>
			<p class="lead">Administrator can do these task</p>
		
		
		
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a  href="${contextPath}/AddProduct">ADD PRODUCT</a></button>
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a  href="${contextPath}/AdminAddCategory">ADD CATEGORY</a></button>
        <button type="button" class="btn btn-outline-secondary btn-lg btn-block" ><a href="${contextPath}/AddSupplier" >ADD SUPPLIER</a></button>
      