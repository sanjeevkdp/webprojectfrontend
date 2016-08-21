  
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

<%
				int i = 1;
			%>

<h1>Edit the Category</h1>
			<p>Edit by administrator</p>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-success">

						<th>serial</th>
						<th>Image</th>
						<th>Name</th>
						<th>Description</th>
						<th> </th>
					</tr>
                 </thead>
				<c:forEach items="${categories}" var="category">

					<tr>
						<td>
							<%
								out.println(i);
							%>

						</td>
						<td><img src="${img}/${category.category_id}.png" alt="" style="height:85px;width:85px"/></td>
						<td>${category.category_name}</td>
						<td>${category.description}</td>
						<td>
							  <a href="${contextPath}/productviewbyCategory/${category.category_id}">
						 <span class="fa fa-info-circle"> </span></a>
                                  <a href="${contextPath}/admin/adminAddCategory/${category.category_id}">
                                    <span class="fa fa-trash-o" title="Delete"> </span></a>
                                     <a href="${contextPath}/admin/adminAddCategory/editCategory/${category.category_id}">
                                     <span class="fa fa-pencil-square" title="Edit"> </span></a>
                                   
                                   </td>

					</tr>
					<%
						i++;
					%>
                     </c:forEach>

			</table>
			<br><br>
			<a href="${contextPath}/admin/adminAddCategory/addCategory"    class="btn btn-green btn-lg">Add Category</a>
		</div>
		</div>
		</div>
		