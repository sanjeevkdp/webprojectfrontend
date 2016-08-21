<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
		
			<h1>All the product</h1>
			<p class="lead">thats the very interesting items</p>
			<div id="custom-search-input">
                            <div class="input-group col-md-12">
                                <input type="text" class="  search-query form-control" ng-model="search" placeholder="Search" />
                                <span class="input-group-btn">
                                    <button class="btn btn-green" type="button">
                                        <span class="fa fa-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>

			 <br>
			<table class="table table-striped table-hover" ng-controller="allProductsCtrl as ctrl">
			
				<thead>
					<tr class="bg-success">

						
						<th>Image</th>
						<th>Name</th>
						<th>Category</th>
						<th>Description</th>
						<th>Price</th>
						<th>view</th>

					</tr>

				</thead>

	      <tr ng-repeat="p in ctrl.listOfProducts | filter:search">
						<td><img ng-src="${img}/{{p.product.product_id}}.png" alt="" style="height:85px;width:85px"/></td>
						<td>{{p.product.product_name}}</td>
						<td>{{p.categoryName}}</td>
						<td>{{p.product.description}}</td>
						<td>{{p.product.unit_price}}</td>
								
						<td><a
							href="${contextPath}/admin/adminAddProduct/adminProductView/{{p.product.product_id}}"><span
								class="fa fa-info-circle" title="View"> </span></a>
								 <a href="${contextPath}/admin/adminAddProduct/{{p.product.product_id}}">
                                    <span class="fa fa-trash-o" title="Delete"> </span></a>
								<a
							href="${contextPath}/admin/adminAddProduct/editProduct/{{p.product.product_id}}">
							 <span class="fa fa-pencil-square" title="Edit"></span></a></td>
					</tr>
				

			</table>
         		<br><br>
			<a href="${contextPath}/admin/adminAddProduct/addProduct" class="btn btn-green btn-lg">Add Product</a>
	

		</div>
	</div>
</div>