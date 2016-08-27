<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

            <!-- === BEGIN CONTENT === -->
            <div id="slideshow" class="bottom-border-shadow">
                <div class="container no-padding background-white bottom-border">
                    <div class="row">
                        <!-- Carousel Slideshow -->
                        <div id="carousel-example" class="carousel slide" data-ride="carousel">
                            <!-- Carousel Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example" data-slide-to="1"></li>
                                <li data-target="#carousel-example" data-slide-to="2"></li>
                            </ol>
                            <div class="clearfix"></div>
                            <!-- End Carousel Indicators -->
                            <!-- Carousel Images -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="${img}/slideshow/slide1.jpg">
                                </div>
                                <div class="item">
                                    <img src="${img}/slideshow/slide2.jpg">
                                </div>
                                <div class="item">
                                    <img src="${img}/slideshow/slide3.jpg">
                                </div>
                                <div class="item">
                                    <img src="${img}/slideshow/slide4.jpg">
                                </div>
                            </div>
                            <!-- End Carousel Images -->
                            <!-- Carousel Controls -->
                            <a class="left carousel-control" href="#carousel-example" data-slide="prev">
                                <span class="fa fa-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                <span class="fa fa-chevron-right"></span>
                            </a>
                            <!-- End Carousel Controls -->
                        </div>
                        <!-- End Carousel Slideshow -->
                    </div>
                </div>
            </div>
          
           
            
            
            <!-- Portfolio -->
            <div id="portfolio" class="bottom-border-shadow">
                <div class="container bottom-border">
                    <div class="row padding-top-40">
                        <ul class="portfolio-group">
                            <!-- Portfolio Item -->
                            
                            
                            
                            <c:forEach items="${list}" var="product">

					
						         <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="${contextPath}/productShow/${product.product_id}">
                                    <figure class="animate fadeIn">
                                        <img src="${img}/${product.product_id}.png" >
                                        <figcaption>
                                              <p>Please click over the image to buy the product</p>
                                            <h3>${product.product_name}</h3>
                                            <span>${product.description}</span>
                                            <h1>Rs.${product.unit_price}</h1>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                        

		
					    </c:forEach>
                            
                    
                        <!-- End Icons -->
                    </div>
                </div>
            </div>
