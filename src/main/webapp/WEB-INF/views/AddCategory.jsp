  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
   
   <form:form action="${contextPath}/AdminAddCategory" method="post" commandName="category">
   <div class="form-group">
   <label for="name" >Name</label>
   <form:input path="category_name" id="name" class="form-control"/>
   </div>
   <div class="form-group">
   <label for="description" >Description</label>
   <form:textarea path="description" id="description" class="form-control"/>
   </div>
   <br>
   <input type="submit" value="submit" class="btn btn-default"/>
   <a href="${contextPath}/AdminAddCategory" class="btn btn-default">Cancel</a>
   
   </form:form>
  </div>
  </div>
  </div>
  