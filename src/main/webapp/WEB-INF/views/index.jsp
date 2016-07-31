


<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>
     <!-- ==== AdminMpping start====== -->
     
      <c:if test="${isAddProductClicked==true }">
           <%@include file="AddProduct.jsp" %>
           </c:if>
           <c:if test="${isAdminAddCategoryClicked==true }">
           <%@include file="AdminAddCategoryList.jsp" %>
           </c:if>
           
            <c:if test="${isAddCategoryClicked==true }">
           <%@include file="AddCategory.jsp" %>
           </c:if>
           <c:if test="${isAddSupplierClicked==true }">
           <%@include file="AddSupplier.jsp" %>
           </c:if>
     
     
     
     
     
     
     
<!--      =====AdminMappingg End======= -->







           <c:if test="${isHomeClicked==true }">
           <%@include file="Home.jsp" %>
           </c:if>

<!-- Pages  Mapping -->

           <c:if test="${isAboutClicked==true }">
           <%@include file="About.jsp" %>
           </c:if>
            <c:if test="${isFAQClicked==true }">
           <%@include file="Admin.jsp" %>
           </c:if>
            <c:if test="${isLoginClicked==true }">
           <%@include file="Login.jsp" %>
           </c:if>
            <c:if test="${isRegisterClicked==true }">
           <%@include file="Register.jsp" %>
           </c:if>

           <c:if test="${isCategoryClicked==true }">
           <%@include file="Category.jsp" %>
           </c:if>


           <c:if test="${isProductClicked==true }">
           <%@include file="Product.jsp" %>
           </c:if>
            <c:if test="${isProductShowClicked==true }">
           <%@include file="ProductShow.jsp" %>
           </c:if>
           <c:if test="${isProductItemClicked==true }">
           <%@include file="ProductItem.jsp" %>
           </c:if>
           
           <c:if test="${isContactClicked==true }">
           <%@include file="contact.jsp" %>
           </c:if>
           

<%@ include file="./shared/footer.jsp"%>