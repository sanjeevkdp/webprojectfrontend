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
					<%
				int i = 1;
					int j=0;
			%>
						<div>
						<c:choose>
	     	<c:when test="${not empty cartEmpty}">
			<h2 style="margin: auto;text-align:center;">No products in cart</h2>
	       	</c:when>
	            	<c:otherwise>
	
<!-- 							<div> -->
<!-- 								<a class="btn btn-danger pull-left" ><span -->
<!-- 									class="fa fa-remove-sign"></span>Clear Cart</a> -->

<!-- 							</div> -->
							<table class="table table-hover">
								<tr>
								<c:forEach items="${cartItems}" var="cartItem">
							<%
								j++;
							%>
						</c:forEach>
						
						<td>Sr.No <span>( <%
							out.println(j);
						%> )
						</span></td>
									<td>Image</td>
									<td>Product</td>
									<td>Quantity</td>
									<td>Price</td>
									<td><a >Action</a></td>
								</tr>
								<c:forEach items="${cartItems}" var="c">
								<tr>
								<td>
							<%
								out.println(i);
							%>
								</td>
								    <td><img src="${img}/${c.cartItem.product_id}.png"
						                                                        alt="" style="height:85px;width:85px"></td>
									<td>${c.productName}</td>
<%-- 								<td>${c.cartItem.product.unit_price}</td> --%>
									<td>${c.cartItem.quantity}</td>
									<td>${c.cartItem.totalPrice} </td>
									<td><a href="${contextPath}/customer/cart/remove/${c.cartItem.cartItemId}" class="btn btn-danger  btn-xs" ><span
									class="fa fa-remove-sign"></span>remove</a></td>
<%
						i++;
					%>
                  
                                  </c:forEach>
								</tr>
								<tr>
									<th></th>
									<th></th>
									<th>Grand Total</th>
									<th>${grandTotal}</th>
									<th></th>
								</tr>
                
							</table>
							<a class="btn btn-green pull-right" href="${contextPath}/checkout">CheckOut</a>

              </c:otherwise>
	</c:choose>
							<a href="${contextPath}/product" class="btn btn-blue pull-left">Continue
								Shopping</a>
						</div>


					</section>



				</div>
			</div>
		</div>
	</div>
</div>

