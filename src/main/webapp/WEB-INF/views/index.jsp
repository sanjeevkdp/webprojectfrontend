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
	<%@include file="editCategory.jsp"%>
</c:if>
<c:if test="${isAdminAddCategoryClicked==true }">
	<%@include file="adminAddCategoryList.jsp"%>
</c:if>

<c:if test="${isAddCategoryClicked==true }">
	<%@include file="addCategory.jsp"%>
</c:if>

<!-- product -->


<c:if test="${isProductClicked==true }">
	<%@include file="product.jsp"%>
</c:if>

<c:if test="${isAdminAddProductClicked==true }">
	<%@include file="adminAddProductList.jsp"%>
</c:if>
<c:if test="${isEditProductClicked==true }">
	<%@include file="editProduct.jsp"%>
</c:if>
<c:if test="${isAddProductClicked==true }">
	<%@include file="addProduct.jsp"%>
</c:if>
<c:if test="${isProductShowClicked==true }">
	<%@include file="productShow.jsp"%>
</c:if>

<!--   =================        supplier========================== -->
<c:if test="${isAdminAddSupplierClicked==true }">
	<%@include file="adminAddSupplierList.jsp"%>
</c:if>
<c:if test="${isAddSupplierClicked==true }">
	<%@include file="addSupplier.jsp"%>
</c:if>
<c:if test="${isProfileClicked==true }">
	<%@include file="supplierProfile.jsp"%>
</c:if>
<c:if test="${isEditSupplierClicked==true }">
	<%@include file="editSupplier.jsp"%>
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






<%@ include file="./shared/footer.jsp"%>