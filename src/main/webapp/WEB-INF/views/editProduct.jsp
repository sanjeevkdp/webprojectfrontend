<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

			<form:form action="${contextPath}/adminAddProduct" method="post" commandName="product" enctype="multipart/form-data" >
				<form:hidden path="product_id" value="${product.product_id}"/>
				<div class="form-group">
					<label for="name">Name</label>
					<form:input path="product_name" id="name" class="form-control" value="${product.product_name}" />
				</div>
				<div class="form-group">
					<label for="category_id">Category</label>
					 <form:select path="category_id" class="selection form-control" name="category">
						<c:forEach  items="${categories}" var="category">
							<form:option value="${category.category_id}">${category.category_name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="quantity">Quantity</label>
					<form:input path="quantity" id="quantity" class="form-control" />
				</div>
				<div class="form-group">
					<label for="supplier_id">Supplier</label> 
					<form:select
						path="supplier_id" class="selection form-control" name="category">
						<c:forEach  items="${suppliers}" var="supplier">
							<form:option value="${supplier.supplier_id}">${supplier.supplier_name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label for="price">Price</label>
					<form:input path="unit_price" id="price" class="form-control" />
				</div>
				<div class="form-group">
					<label for="outOfStock">Out Of Stock</label>
					<form:input path="out_of_stock" id="outOfStock"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea path="description" id="description"
						class="form-control" value="${product.description}" />
				</div>
				<div class="form-group">
					<label class="control-label" for="image">Upload</label>
					<form:input id="image" path="imgUrl" type="file"
						class="form:input-large" />
				</div>
				<br>
				<input type="submit" value="submit" class="btn btn-default" />
				<a href="${contextPath}/adminAddProduct" class="btn btn-default">Cancel</a>


			</form:form>
		</div>
	</div>
</div>


    