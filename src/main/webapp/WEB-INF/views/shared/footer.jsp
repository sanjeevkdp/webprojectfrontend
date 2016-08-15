
            <!-- Footer -->
            <div id="footer" class="background-gray">
                <div class="container">
                    <div class="row">
                        <!-- Footer Menu -->
                        <div id="footermenu" class="col-md-8">
                            <ul class="list-unstyled list-inline">
                                <li>
                                    <a href="#" target="_blank">Sample Link</a>
                                </li>
                            </ul>
                        </div>
                        <!-- End Footer Menu -->
                        <!-- Copyright -->
                        <div id="copyright" class="col-md-4">
                            <p class="pull-right"> Copyright &#169 Info</p>
                        </div>
                        <!-- End Copyright -->
                    </div>
                </div>
            </div>
            <!-- End Footer -->
            <!-- JS -->
           	 <script>
           		window.activeMenu='${active}';
            </script>
            <spring:url value="/resources/js" var="jqueryJs" />
            <script type="text/javascript" src="${jqueryJs}/jquery.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="${jqueryJs}/bootstrap.min.js" type="text/javascript"></script>
            <script type="text/javascript" src="${jqueryJs}/scripts.js"></script>
                <!--             angularjs -->
<%--      <script type="text/javascript" src="${jqueryJs}/angular.js" type="text/javascript"></script> --%>
                <!-- Isotope - Portfolio Sorting -->
            
            <script type="text/javascript" src="${jqueryJs}/jquery.isotope.js" type="text/javascript"></script>
            <!-- Mobile Menu - Slicknav -->
            <script type="text/javascript" src="${jqueryJs}/jquery.slicknav.js" type="text/javascript"></script>
            <!-- Animate on Scroll-->
            <script type="text/javascript" src="${jqueryJs}/jquery.visible.js" charset="utf-8"></script>
            <!-- Sticky Div -->
            <script type="text/javascript" src="${jqueryJs}/jquery.sticky.js" charset="utf-8"></script>
            <!-- Slimbox2-->
            <script type="text/javascript" src="${jqueryJs}/slimbox2.js" charset="utf-8"></script>
            <!-- Modernizr -->
            <script src="${jqueryJs}/modernizr.custom.js" type="text/javascript"></script>
            <script src="${jqueryJs}/webapp.js" type="text/javascript"></script>
<%--              <script type="text/javascript" src="${jqueryJs}/angula.js" charset="utf-8"></script> --%>
            <!-- End JS -->
    </body>
</html>
<!-- === END FOOTER === -->