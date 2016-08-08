<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

			<div class="container" ng-app="cartApp ">
				<div class="row">
					<div class="col-md-5">
						<img src="${img}/${product.product_id}.png" alt="image"
							style="height: 300px; width: 100%" />
					</div>
					<div class="col-md-5">
						<h2>name:${product.product_name}</h2>
						<p>
							<strong> ID</strong>:${product.product_id}
						</p>


						<p>
							<strong> price</strong>:${product.unit_price}
						</p>

						<p>
							<strong>Category</strong>:${categoryName}
						</p>

						<p>
							<strong> description</strong>:${product.description}
						</p>
						<p>
							<strong>Supplier</strong>:${supplierName}
						</p>
						<br>
						<c:set var="role" scope="page" value="${param.role }" />
						<c:set var="url" scope="page" value="${contextPath}/product" />
						<%--                          <c:if test="${role="admin"}">				 --%>
						<%--                                   <c:set var="url" scope="page" value="${contextPath}/admin/adminAddProduct/addProduct"/> --%>
						<p ng-controller="cartCtrl">
							<a href="${contextPath}/product" class="btn btn-default">Back</a>
							<a href="#" class="btn btn-warnning"
								ng-click="addToCart(${product.product_id})">Order Now</a> <a
								href="${contextPath}/cart" class="btn btn-default">View Cart</a>
						</p>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${jqueryJs}/angular.js" charset="utf-8"></script>
