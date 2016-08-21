<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<div id="portfolio" class="bottom-border-shadow">
	<div class="container bottom-border">
		<div class="row padding-top-40">
			<h2> Related Product search</h2>
			<p>related to the handicraft </p>
			<c:choose>
				<c:when test="${not empty noProductFound}">
					<h2>${noProductFound}</h2>
				</c:when>
				<c:otherwise>

					<ul class="portfolio-group">

						<c:forEach items="${products}" var="product">
							<li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
								<a href="${contextPath}/productShow/${product.product_id}">
									<figure class="animate fadeIn">
										<img alt="image5" src="${img}/${product.product_id}.png"
											style="height: 220px; width: 100%">
										<figcaption>
											<h3>${product.product_name}</h3>
											<span>${product.description}</span>
										</figcaption>
									</figure>
							</a>
							</li>

						</c:forEach>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

