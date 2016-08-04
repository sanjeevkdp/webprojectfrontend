
 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
   <h3>Edit Category</h3>
   <p>You can edit category</p>
   <form:form action="${contextPath}/admin/adminAddCategory" method="post" commandName="category" enctype="multipart/form-data">
  <form:hidden path="category_id" value="${category.category_id}"/>
   <div class="form-group">
   <label for="name" >Name</label>
   <form:input path="category_name" id="name" class="form-control" value="${category.category_name}"/>
   </div>
   <div class="form-group">
   <label for="description" >Description</label>
   <form:textarea path="description" id="description" class="form-control" value="${category.description}"/>
   </div>
   
   
   <div class="form-group">
   <label class="control-label" for="image">Upload</label>
   <form:input id="image" path="imgUrl" type="file" class="form:input-large"/>
   </div>
   <br>
   <input type="submit" value="submit" class="btn btn-default"/>
   <a href="${contextPath}/admin/adminAddCategory" class="btn btn-default">Cancel</a>
   
   </form:form>
  </div>
  </div>
  </div>
  