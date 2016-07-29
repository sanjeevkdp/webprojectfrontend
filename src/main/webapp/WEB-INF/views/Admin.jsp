
<%@ include file="./shared/header.jsp"%>



        <div id="body-bg">
            <!-- Phone/Email -->
            <div id="pre-header" class="background-gray-lighter">
                <div class="container no-padding">
                    <div class="row hidden-xs">
                        <div class="col-sm-6 padding-vert-5">
                            <strong>Phone:</strong>&nbsp;1-800-123-4567
                        </div>
                        <div class="col-sm-6 text-right padding-vert-5">
                            <strong>Email:</strong>&nbsp;info@joomla51.com
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Phone/Email -->
            <!-- Header -->
            <div id="header">
                <div class="container">
                    <div class="row">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="index.html" title="">
                                <img src="${img}/logo.png" alt="Logo" />
                            </a>
                        </div>
                        <!-- End Logo -->
                    </div>
                </div>
            </div>
            <!-- End Header -->
            <!-- Top Menu -->
            <div id="hornav" class="bottom-border-shadow">
                <div class="container no-padding border-bottom">
                    <div class="row">
                        <div class="col-md-8 no-padding">
                            <div class="visible-lg">
                                <ul id="hornavmenu" class="nav navbar-nav">
                                    <li>
                                        <a href="index.html" class="fa-home active">Home</a>
                                    </li>
                                    <li>
                                        <span class="fa-gears ">Service</span>
                                        <ul>
                                            <li class="parent">
                                                <span>Product</span>
                                                <ul>
                                                    <li>
                                                        <a href="features-typo-basic.html">List Product</a>
                                                    </li>
                                                    <li>
                                                        <a href="features-typo-blockquotes.html">Add Product</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="parent">
                                                <span>Category</span>
                                                <ul>
                                                    <li>
                                                        <a href="features-labels.html">List Category</a>
                                                    </li>
                                                    <li>
                                                        <a href="features-progress-bars.html">Add Category</a>
                                                    </li>
                                           
                                                </ul>
                                            </li>
                                            <li class="parent">
                                                <span>Supplier</span>
                                                <ul>
                                                    <li>
                                                        <a href="features-icons.html">List Supplier</a>
                                                    </li>
                                                    <li>
                                                        <a href="features-icons-social.html">Add Supplier</a>
                                                    </li>
                                                   
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span class="fa-copy ">Pages</span>
                                        <ul>
                                            <li>
                                                <a href="pages-about-us.html">About Us</a>
                                            </li>
                                            <li>
                                                <a href="pages-services.html">Services</a>
                                            </li>
                                            <li>
                                                <a href="pages-faq.html">F.A.Q.</a>
                                            </li>
                                            <li>
                                                <a href="pages-about-me.html">About Me</a>
                                            </li>
                                            <li>
                                                <a href="pages-Login.jsp">Login</a>
                                            </li>
                                            <li>
                                                <a href="pages-sign-up.html">Sign-Up</a>
                                            </li>
                                            <li>
                                                <a href="pages-404.html">404 Error Page</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span class="fa-th ">Category</span>
                                        <ul>
                                            <li>
                                                <a href="portfolio-2-column.html">2 column</a>
                                            </li>
                                            <li>
                                                <a href="portfolio-3-column.html">3 Column</a>
                                            </li>
                                            <li>
                                                <a href="portfolio-4-column.html">4 Column</a>
                                            </li>
                                            <li>
                                                <a href="portfolio-6-column.html">6 Column</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span class="fa-font ">product</span>
                                        <ul>
                                            <li>
                                                <a href="blog-list.html">Product</a>
                                            </li>
                                            <li>
                                                <a href="blog-single.html">Product Single Item</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="contact.html" class="fa-comment ">Contact</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-4 no-padding">
                            <ul class="social-icons pull-right">
                                <li class="social-rss">
                                    <a href="#" target="_blank" title="RSS"></a>
                                </li>
                                <li class="social-twitter">
                                    <a href="#" target="_blank" title="Twitter"></a>
                                </li>
                                <li class="social-facebook">
                                    <a href="#" target="_blank" title="Facebook"></a>
                                </li>
                                <li class="social-googleplus">
                                    <a href="#" target="_blank" title="Google+"></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Top Menu -->
            <!-- === END HEADER === -->

            

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
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                            <!-- End Carousel Controls -->
                        </div>
                        <!-- End Carousel Slideshow -->
                    </div>
                </div>
            </div>
          
            <div id="content" class="bottom-border-shadow">
                <div class="container background-white bottom-border">
                    <div class="row margin-vert-30">
                        <!-- Main Text -->
                        <div class="col-md-6">
                            <h2>Welcome to Habitat</h2>
                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit
                                lobortis nisl ut aliquip ex ea commodo consequat.</p>
                            <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit
                                augue duis dolore te feugait nulla facilisi. Cras non sem sem, at eleifend mi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Curabitur eget nisl
                                a risus.</p>
                        </div>
                        <!-- End Main Text -->
                        <div class="col-md-6">
                            <h3 class="padding-vert-10">Key Features</h3>
                            <p>Duis sit amet orci et lectus dictum auctor a nec enim. Donec suscipit fringilla elementum. Suspendisse nec justo ut felis ornare tincidunt vitae et lectus.</p>
                            <ul class="tick animate fadeInRight">
                                <li>Responsive Design</li>
                                <li>Built with LESS</li>
                                <li>Font Choosers</li>
                                <li>Replaceable Background Image</li>
                                <li>Custom Module Widths</li>
                                <li>All Module Extensions Included</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            
            
            <!-- Portfolio -->
            <div id="portfolio" class="bottom-border-shadow">
                <div class="container bottom-border">
                    <div class="row padding-top-40">
                        <ul class="portfolio-group">
                            <!-- Portfolio Item -->
                            <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="#">
                                    <figure class="animate fadeInLeft">
                                        <img alt="image1" src="${img}/frontpage/image1.jpg">
                                        <figcaption>
                                            <h3>Velit esse molestie</h3>
                                            <span>Vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui et everti tamquam suavitate mea.</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                            <!-- //Portfolio Item// -->
                            <!-- Portfolio Item -->
                            <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="#">
                                    <figure class="animate fadeIn">
                                        <img alt="image2" src="${img}/frontpage/image2.jpg">
                                        <figcaption>
                                            <h3>Quam nunc putamus</h3>
                                            <span>Vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui et everti tamquam suavitate mea.</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                            <!-- //Portfolio Item// -->
                            <!-- Portfolio Item -->
                            <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="#">
                                    <figure class="animate fadeInRight">
                                        <img alt="image3" src="${img}/frontpage/image3.jpg">
                                        <figcaption>
                                            <h3>Placerat facer possim</h3>
                                            <span>Vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui et everti tamquam suavitate mea.</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                            <!-- //Portfolio Item// -->
                            <!-- Portfolio Item -->
                            <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="#">
                                    <figure class="animate fadeInLeft">
                                        <img alt="image4" src="${img}/frontpage/image4.jpg">
                                        <figcaption>
                                            <h3>Nam liber tempor</h3>
                                            <span>Vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui et everti tamquam suavitate mea.</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                            <!-- //Portfolio Item// -->
                            <!-- Portfolio Item -->
                            <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="#">
                                    <figure class="animate fadeIn">
                                        <img alt="image5" src="${img}/frontpage/image5.jpg">
                                        <figcaption>
                                            <h3>Donec non urna</h3>
                                            <span>Vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui et everti tamquam suavitate mea.</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                            <!-- //Portfolio Item// -->
                            <!-- Portfolio Item -->
                            <li class="portfolio-item col-sm-4 col-xs-6 margin-bottom-40">
                                <a href="#">
                                    <figure class="animate fadeInRight">
                                        <img alt="image6" src="${img}/frontpage/image6.jpg">
                                        <figcaption>
                                            <h3>Nullam consectetur</h3>
                                            <span>Vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui et everti tamquam suavitate mea.</span>
                                        </figcaption>
                                    </figure>
                                </a>
                            </li>
                            <!-- //Portfolio Item// -->
                        </ul>
                    </div>
                </div>
            </div>
              <div id="icons" class="bottom-border-shadow">
                <div class="container background-grey bottom-border">
                    <div class="row padding-vert-60">
                        <!-- Icons -->
                        <div class="col-md-4 text-center">
                            <i class="fa-cogs fa-4x color-primary animate fadeIn"></i>
                            <h2 class="padding-top-10 animate fadeIn">Velit esse molestie</h2>
                            <p class="animate fadeIn">Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer.</p>
                        </div>
                        <div class="col-md-4 text-center">
                            <i class="fa-cloud-download fa-4x color-primary animate fadeIn"></i>
                            <h2 class="padding-top-10 animate fadeIn">Quam nunc putamus</h2>
                            <p class="animate fadeIn">Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer.</p>
                        </div>
                        <div class="col-md-4 text-center">
                            <i class="fa-bar-chart fa-4x color-primary animate fadeIn"></i>
                            <h2 class="padding-top-10 animate fadeIn">Placerat facer possim</h2>
                            <p class="animate fadeIn">Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer.</p>
                        </div>
                        <!-- End Icons -->
                    </div>
                </div>
            </div>


<%@ include file="./shared/footer.jsp"%>