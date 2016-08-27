  
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

<%
				int i = 1;
			%>

         <h1>ADD SUPPLIER</h1>
			<p>Added by administrator</p>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-primary">

						<th>serial</th>
						<th>Image</th>
						<th>Name</th>
						<th>Email</th>
						<th> </th>
					</tr>
                 </thead>
				<c:forEach items="${suppliers}" var="supplier">

					<tr>
						<td>
							<%
								out.println(i);
							%>

						</td>
						<td><img src="${img}/${supplier.supplier_id}.png" alt="" style="height:85px;width:85px"/></td>
						<td>${supplier.supplier_name}</td>
						<td>${supplier.supplier_email}</td>
							<td>

                                  <a href="${contextPath}/admin/adminAddSupplier/profile/${supplier.supplier_id}">
                                  <span class="fa fa-info-circle"> </span></a>
                                  <a href="${contextPath}/admin/adminAddSupplier/${supplier.supplier_id}">
                                    <span class="fa fa-trash-o"> </span></a>
                                     <a href="${contextPath}/admin/adminAddSupplier/editSupplier/${supplier.supplier_id}">
                                     <span class="fa fa-pencil-square"> </span></a>
                                   
                                   </td>

					</tr>
					<%
						i++;
					%>
                     </c:forEach>

			</table>
			<br><br>
			<a href="${contextPath}/admin/adminAddSupplier/addSupplier"    class="btn btn-green btn-lg">Add Supplier</a>
		</div>
		</div>
		</div>
		