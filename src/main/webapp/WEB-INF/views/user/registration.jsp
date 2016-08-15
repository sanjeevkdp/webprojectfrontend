<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
                 <h1>Customer Detals</h1>
                 <p>fill in the detail</p>
			<form:form action="${contextPath}/registration" method="post" commandName="customer" >
				<div class="form-group">
					<label for="name">Name</label>
					<form:input path="customer_name" id="name" class="form-control" />
				</div>
			    <div class="form-group">
					<label for="email">EmailAddress</label>
					<form:input path="emailAddress" id="email" class="form-control" />
				</div>
				 <div class="form-group">
					<label for="phone">PhoneNo</label>
					<form:input path="phoneNo" id="phone" class="form-control" />
				</div>
				 <div class="form-group">
					<label for="gender">Gender</label>
					<label class="checkbox-inline"><form:radiobutton path="gender" id="gender" value="male" />Male</label>
				<label class="checkbox-inline"><form:radiobutton path="gender" id="gender" value="female" />Female</label>
						
					
							</div>
				 <div class="form-group">
					<label for="username">Username</label>
					<form:input path="userName" id="username" class="form-control" />
				</div>
				 <div class="form-group">
					<label for="password">Password</label>
					<form:password path="password" id="password" class="form-control" />
				</div>
				<br>
				<input type="submit" value="submit" class="btn btn-default" />
				<a href="${contextPath}/admin/adminAddProduct" class="btn btn-default">Cancel</a>


			</form:form>
		</div>
	</div>
</div>


    