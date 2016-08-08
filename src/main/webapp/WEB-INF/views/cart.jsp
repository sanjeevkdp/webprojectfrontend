<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>

	
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

			<div class="container-wrapper">
				<div class="container">
					<section>
						<div class="jumbotron">
							<div class="container">
								<h1>Cart</h1>
								<p>All selected product in cart</p>
							</div>
						</div>

					</section>
					<section class="container" ng-app="cartApp">
						<div ng-controller="cartCtrl" ng-init="initCartId(${cart_id})">
							<div>
								<a class="btn btn-danger pull-left" ng-click="clearCart()"><span
									class="fa fa-remove-sign"></span>Clear Cart</a>

							</div>
							<table class="table table-hover">
								<tr>
									<td>Product</td>
									<td>Unit Price</td>
									<td>Quantity</td>
									<td>Price</td>
									<td>Action</td>
								</tr>
								<tr ng-repeat="item in cart.cartItem">
									<td>{{item.product.product_name}}</td>
									<td>{{item.product.unit_price}}</td>
									<td>{{item.quantity}}</td>
									<td>{{item.totalPrice}}</td>
									<td><a href="#" class="labe label-label-danger"
										ng-click="removeFromCart(item.product.product_id)"><span
											class="fa fa-remove-o"></span>Remove</a></td>


								</tr>
								<tr>
									<th></th>
									<th></th>
									<th>Grand Total</th>
									<th>{{cart.grandTotal}}</th>
									<th></th>
								</tr>

							</table>


							<a href="${contaxtPath}/product" class="btn btn-default">Continue
								Shopping</a>
						</div>


					</section>



				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${jqueryJs}/angular.js" charset="utf-8"></script>
<%@ include file="./shared/footer.jsp"%>