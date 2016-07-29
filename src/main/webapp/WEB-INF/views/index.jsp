


<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>

           <c:if test="${isHomeClicked==true }">
           <%@include file="Home.jsp" %>
           </c:if>

<!-- Pages  Mapping -->

           <c:if test="${isAboutClicked==true }">
           <%@include file="About.jsp" %>
           </c:if>
            <c:if test="${isServiceClicked==true }">
           <%@include file="Service.jsp" %>
           </c:if>
            <c:if test="${isFAQClicked==true }">
           <%@include file="FAQ.jsp" %>
           </c:if>
            <c:if test="${isLoginClicked==true }">
           <%@include file="Login.jsp" %>
           </c:if>
            <c:if test="${isRegisterClicked==true }">
           <%@include file="Register.jsp" %>
           </c:if>
            <c:if test="${isErrorClicked==true }">
           <%@include file="Error.jsp" %>
           </c:if>

           <c:if test="${isCategoryClicked==true }">
           <%@include file="Category.jsp" %>
           </c:if>


           <c:if test="${isProductClicked==true }">
           <%@include file="Product.jsp" %>
           </c:if>
           <c:if test="${isProductItemClicked==true }">
           <%@include file="ProductItem.jsp" %>
           </c:if>
           


<%@ include file="./shared/footer.jsp"%>