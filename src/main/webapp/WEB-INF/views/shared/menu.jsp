<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div id="body-bg">

	<!-- Header -->
	<!-- Logo -->
	<div id="header">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 ">
					<!-- Logo -->
					<div class="logo ">
						<a href="index.html" title="handcraft"> <img
							src="${img}/2.png" alt="Logo"  />
						</a>
					</div>
				</div>
					<div class="col-sm-6 text-right padding-vert-50">
					<form:form action="${contextPath}/productItems/" method="get">
					<form role="search">
						<div class="input-group add-on">
							<input class="form-control" placeholder="Search" name="keyword""
								id="srch-term" type="text" title="search">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit" title="search">
									<i class="fa-search"></i>
								</button>
								
							</div>
						</div>
					</form>
					</form:form>
				</div>
					
				<br>
				<!-- End Logo -->
			</div>

		</div>
	</div>
</div>
<!-- End Logo -->

<!-- End Header -->
<!-- Top Menu -->
<div id="hornav" class="bottom-border-shadow">
	<div class="container no-padding border-bottom">
		<div class="row">
			<div class="no-padding">
				<div class="visible-lg">
					<ul id="hornavmenu" class="nav navbar-nav">
						<li><a id="home" href="${contextPath}/home" class="fa-home">home</a>
						</li>

						<li><span id="pages" class="fa-copy ">Setting</span>
							<ul>

								<c:if test="${pageContext.request.userPrincipal.name == null }">
									<li><a id="login" href="${contextPath}/login"> Login</a></li>
									<li><a href="${contextPath}/registration">Sign-Up</a></li>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name != null }">
									<c:url value="/logout" var="logoutUrl" />
									<form id="logout" action="${logoutUrl}" method="post">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
									<c:if test="${pageContext.request.userPrincipal.name != null}">
										<li><a
											href="javascript:document.getElementById('logout').submit()">
												Logout</a></li>
									</c:if>
								</c:if>


							</ul></li>
						<li><span id="category" class="fa-th ">Category</span>

							<ul>
								<c:forEach items="${categories}" var="category">
									<li><a
										href="${contextPath}/productviewbyCategory/${category.category_id}">${category.category_name}</a></li>
								</c:forEach>

								<li><a id="category" href="${contextPath}/category">View</a></li>
							</ul></li>
						<li><span id="product" class="fa-font ">product</span>
							<ul>
								<li><a id="product" href="${contextPath}/product">PRODUCTS</a></li>

							</ul></li>
						<li><a id="contact" href="${contextPath}/contact"
							class="fa-comment ">Contact</a></li>



						<%-- 									li class="col-float-right"><a id="Login" href="${contextPath}/login" class="fa-sign-in">Login</a></li> --%>


						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="pull-right"><a id="admin"
								href="${contextPath}/admin" class="fa-user">Admin</a>
								<ul>
									<li><a href="${contextPath}/admin/adminAddProduct">ADD
											PRODUCT</a></li>
									<li><a href="${contextPath}/admin/adminAddCategory">ADD
											CATEGORY</a></li>
									<li><a href="${contextPath}/admin/adminAddSupplier">ADD
											SUPPLIER</a></li>

								</ul></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<li class="pull-right"><a id="user"
								href="${contextPath}/customer/cart" class="fa-shopping-cart">Cart<span
									class="badge">${noOfProducts}</span></a></li>
							<li class="pull-right"><a id="user"
								href="${contextPath}/product" class="fa-user">hi!
									${pageContext.request.userPrincipal.name}</a></li>

						</sec:authorize>

					</ul>
				</div>
			</div>

		</div>
	</div>
</div>
<!-- End Top Menu -->
<!-- === END HEADER === -->