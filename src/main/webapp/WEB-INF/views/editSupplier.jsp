
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
   
   <form:form action="${contextPath}/admin/adminAddSupplier?${_csrf.parameterName}=${_csrf.token}" method="post" commandName="supplier" enctype="multipart/form-data">
  <form:hidden path="supplier_id" value="${supplier.supplier_id}"/>
   <div class="form-group">
   <label for="name" >Name</label>
   <form:input path="supplier_name" id="name" class="form-control" value="${supplier.supplier_name}"/>
      <form:errors path="supplier_name" cssStyle="color:#ff0000;"/>
  
   </div>
   <div class="form-group">
   <label for="email" >Email</label>
   <form:input path="supplier_email" id="email" class="form-control" value="${supplier.supplier_email}"/>
      <form:errors path="supplier_email" cssStyle="color:#ff0000;"/>
  
   </div>
   <div class="form-group">
   <label for="contact" >Contact</label>
   <form:input path="supplier_contact" id="contact" class="form-control" value="${supplier.supplier_contact}"/>
      <form:errors path="supplier_contact" cssStyle="color:#ff0000;"/>
  
   </div>
   <div class="form-group">
   <label for="address" >Address</label>
   <form:textarea path="Supplier_address" id="address" class="form-control" value="${supplier_address}"/>
      <form:errors path="Supplier_address" cssStyle="color:#ff0000;"/>
  
   </div>
   <div class="form-group">
   <label class="control-label" for="image">Upload</label>
   <form:input id="image" path="imgUrl" type="file" class="form:input-large"/>
   </div>
   <br>
   <input type="submit" value="submit" class="btn btn-default"/>
   <a href="${contextPath}/admin/adminAddSupplier" class="btn btn-default">Cancel</a>
   
   
   </form:form>
  </div>
  </div>
  </div>
  
  
  