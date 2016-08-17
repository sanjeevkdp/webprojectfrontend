<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ include file="./shared/header.jsp"%>


<%@ include file="./shared/menu.jsp"%>


<c:if test="${isHomeClicked==true }">
	<%@include file="home.jsp"%>
</c:if>

<!-- ==== AdminMpping start====== -->




<!--   category -->

<c:if test="${isCategoryClicked==true }">
	<%@include file="category.jsp"%>
</c:if>
<c:if test="${isEditCategoryClicked==true }">
	<%@include file="./admin/editCategory.jsp"%>
</c:if>
<c:if test="${isAdminAddCategoryClicked==true }">
	<%@include file="./admin/adminAddCategoryList.jsp"%>
</c:if>

<c:if test="${isAddCategoryClicked==true }">
	<%@include file="./admin/addCategory.jsp"%>
</c:if>

<!-- product -->


<c:if test="${isProductClicked==true }">
	<%@include file="product.jsp"%>
</c:if>

<c:if test="${isAdminAddProductClicked==true }">
	<%@include file="./admin/adminAddProductList.jsp"%>
</c:if>
<c:if test="${isEditProductClicked==true }">
	<%@include file="./admin/editProduct.jsp"%>
</c:if>
<c:if test="${isAddProductClicked==true }">
	<%@include file="./admin/addProduct.jsp"%>
</c:if>
<c:if test="${isProductShowClicked==true }">
	<%@include file="productShow.jsp"%>
</c:if>

<!--   =================        supplier========================== -->
<c:if test="${isAdminAddSupplierClicked==true }">
	<%@include file="./admin/adminAddSupplierList.jsp"%>
</c:if>
<c:if test="${isAddSupplierClicked==true }">
	<%@include file="./admin/addSupplier.jsp"%>
</c:if>
<c:if test="${isProfileClicked==true }">
	<%@include file="supplierProfile.jsp"%>
</c:if>
<c:if test="${isEditSupplierClicked==true }">
	<%@include file="./admin/editSupplier.jsp"%>
</c:if>



<!--      =====AdminMappingg End======= -->



<!-- Pages  Mapping -->


<c:if test="${isAdminClicked==true }">
	<%@include file="admin.jsp"%>
</c:if>

<c:if test="${isLoginClicked==true }">
	<%@include file="login.jsp"%>
</c:if>
<c:if test="${isRegisterClicked==true }">
	<%@include file="register.jsp"%>
</c:if>




<c:if test="${isProductItemClicked==true }">
	<%@include file="productItem.jsp"%>
</c:if>

<c:if test="${isContactClicked==true }">
	<%@include file="contact.jsp"%>
</c:if>

<c:if test="${isCartClicked==true }">
	<%@include file="cart.jsp"%>
</c:if>
<!--    userRegitration -->
<c:if test="${isRegistrationClicked==true }">
	<%@include file="./user/registration.jsp"%>
</c:if>
<c:if test="${isRegistrationSuccessClicked==true }">
	<%@include file="login.jsp"%>
</c:if>



<%@ include file="./shared/footer.jsp"%>