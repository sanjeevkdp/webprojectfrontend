
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
   
   <form:form action="${contextPath}/adminAddSupplier" method="post" commandName="supplier" enctype="multipart/form-data">
   <div class="form-group">
   <label for="name" >Name</label>
   <form:input path="supplier_name" id="name" class="form-control"/>
   </div>
   <div class="form-group">
   <label for="email" >Email</label>
   <form:input path="supplier_email" id="email" class="form-control"/>
   </div>
   <div class="form-group">
   <label for="contact" >Cantact</label>
   <form:input path="supplier_contact" id="contact" class="form-control"/>
   </div>
   <div class="form-group">
   <label for="address" >Address</label>
   <form:textarea path="Supplier_address" id="address" class="form-control"/>
   </div>
   <div class="form-group">
   <label class="control-label" for="image">Upload</label>
   <form:input id="image" path="imgUrl" type="file" class="form:input-large"/>
   </div>
   <br>
   <input type="submit" value="submit" class="btn btn-default"/>
   <a href="${contextPath}/adminAddSupplier" class="btn btn-default">Cancel</a>
   
   
   </form:form>
  </div>
  </div>
  </div>
  
  
  