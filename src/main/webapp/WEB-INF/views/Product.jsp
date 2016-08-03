<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
			<%
				int i = 1;
			%>
			<h1>All the product</h1>
			<p class="lead">thats the very interesting items</p>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="bg-success">

						<th>serial</th>
						<th>Image</th>
						<th>Name</th>
						<th>Category</th>
						<th>Description</th>
						<th>Price</th>
						<th>view</th>

					</tr>

				</thead>

				<c:forEach items="${products}" var="p">

					<tr>
						<td>
							<%
								out.println(i);
							%>

						</td>
						<td><img src="${img}/${p.product.product_id}.png" alt="" style="height:85px;width:85px"/></td>
						<td>${p.product.product_name}</td>
						<td>${p.categoryName}</td>
						<td>${p.product.description}</td>
						<td>${p.product.unit_price}</td>
						<td><a
							href="${contextPath}/productShow/${p.product.product_id}"><span
								class="fa fa-info-circle"> </span></a></td>
					</tr>
					<%
						i++;
					%>
                     </c:forEach>

			</table>
         

		</div>
	</div>
</div>