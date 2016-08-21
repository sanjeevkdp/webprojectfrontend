
 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
   <h3>Add Category</h3>
   <p>You can add category</p>
   <form:form action="${contextPath}/admin/adminAddCategory?${_csrf.parameterName}=${_csrf.token}" method="post" commandName="category" enctype="multipart/form-data">
   <div class="form-group">
   <label for="name" >Name</label>
   <form:input path="category_name" id="name" class="form-control"/>
   <form:errors path="category_name" cssStyle="color:#ff0000;"/>
   </div>
   <div class="form-group">
   <label for="description" >Description</label>
   <form:textarea path="description" id="description" class="form-control"/>
   <form:errors path="description" cssStyle="color:#ff0000;"/>
   </div>
   
   
   <div class="form-group">
   <label class="control-label" for="image">Upload</label>
   <form:input id="image" path="imgUrl" type="file" class="form:input-large"/>
   </div>
   <br>
   <input type="submit" value="submit" class="btn btn-green"/>
   <a href="${contextPath}/admin/adminAddCategory" class="btn btn-danger">Cancel</a>
   
   </form:form>
  </div>
  </div>
  </div>
  