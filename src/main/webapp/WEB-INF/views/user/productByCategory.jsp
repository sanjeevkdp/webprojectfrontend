<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <c:forEach items="${products}" var="product"> --%>

<%-- 			<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 productDiv" href="${contextPath}/productDetail/${product.product_id}"> --%>
<%-- 					<img src="${images}/product/${product.productId}.png" --%>
<%-- 						class="img-rounded img-thumbnail" alt="${product.product_name }" --%>
<%-- 						title="${product.product_name }" --%>
<!-- 						style="height: 120px; width: 170px;" /> -->
<!-- 					<p class="pricePara"> -->
<%-- 						<b><span class="fa fa-inr"></span> ${product.unit_price}</b> --%>
<!-- 					</p> -->
<%-- 						<h4>${product.product_name}</h4>  --%>
<%-- 					<h5>${product.description}</h5> --%>

<!-- 				</div> -->
<%-- 		</c:forEach> --%>



<div id="portfolio" class="bottom-border-shadow">
                <div class="container bottom-border">
                    <div class="row padding-top-40">
                    <h2>Category Related Product</h2>
                    <p>related to category</p>
                        <c:if test="${productNotPresent==true }">
           <h2>Sorry, No Products available in this category</h2>
          </c:if>
	
                        <ul class="portfolio-group">
              
      		<c:forEach items="${productList}" var="product">

					
						         <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="${contextPath}/productShow/${product.product_id}">
                                    <figure class="animate fadeIn">
                                        <img alt="image5" src="${img}/${product.product_id}.png">
                                        <figcaption>
                                            <h3>${product.product_name}</h3>
                                            <span>${product.description}</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                        

		
					    </c:forEach>

		</div>
	</div>
</div>

