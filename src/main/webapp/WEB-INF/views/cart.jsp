<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
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
					<section class="container" >
						<div>
							<div>
								<a class="btn btn-danger pull-left" ><span
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
								<tr>
									<td>${product.product_id}</td>
									<td>${product.unit_price}</td>
									<td></td>
									<td></td>
									<td><a href="#" class="labe label-label-danger"><span
											class="fa fa-remove-o"></span>Remove</a></td>


								</tr>
								<tr>
									<th></th>
									<th></th>
									<th>Grand Total</th>
									<th></th>
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

