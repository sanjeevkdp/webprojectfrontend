<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
			<h1>Shipping Details</h1>
			<p>fill in the detail</p>
			<form:form action="${contextPath}/registration" method="post"
				commandName="customer">
				<div class="form-group">
					<label for="streetName">StreetName</label>
					<form:input path="streetName" id="streetName" class="form-control" />
					<form:errors path="streetName" cssStyle="color:#ff0000;" />
				</div>
				<div class="form-group">
					<label for="apartmentNumber">apartmentNumber</label>
					<form:input path="apartmentNumber" id="apartmentNumber"
						class="form-control" />
					<form:errors path="apartmentNumber" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="city">city</label>
					<form:input path="city" id="city" class="form-control" />
					<form:errors path="city" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="state">state</label>
					<form:input path="state" id="username" class="form-control" />
					<form:errors path="state" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for=country>country</label>
					<form:password path="country" id="country" class="form-control" />
					<form:errors path="country" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<form:password path="zipCode" id="password" class="form-control" />
					<form:errors path="zipCode" cssStyle="color:#ff0000;" />
				</div>


				<h1>Billing Address</h1>
				<p>fill in the detail</p>

				<div class="form-group">
					<label for="streetName">StreetName</label>
					<form:input path="streetName" id="streetName" class="form-control" />
					<form:errors path="streetName" cssStyle="color:#ff0000;" />
				</div>
				<div class="form-group">
					<label for="apartmentNumber">apartmentNumber</label>
					<form:input path="apartmentNumber" id="apartmentNumber"
						class="form-control" />
					<form:errors path="apartmentNumber" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="city">city</label>
					<form:input path="city" id="city" class="form-control" />
					<form:errors path="city" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="state">state</label>
					<form:input path="state" id="username" class="form-control" />
					<form:errors path="state" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for=country>country</label>
					<form:password path="country" id="country" class="form-control" />
					<form:errors path="country" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<form:password path="zipCode" id="password" class="form-control" />
					<form:errors path="zipCode" cssStyle="color:#ff0000;" />

				</div>


				<h1>Card Details</h1>
				<p>fill in the detail</p>

				<div class="form-group">
					<label for="streetName">StreetName</label>
					<form:input path="streetName" id="streetName" class="form-control" />
					<form:errors path="streetName" cssStyle="color:#ff0000;" />
				</div>
				<div class="form-group">
					<label for="apartmentNumber">apartmentNumber</label>
					<form:input path="apartmentNumber" id="apartmentNumber"
						class="form-control" />
					<form:errors path="apartmentNumber" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="city">city</label>
					<form:input path="city" id="city" class="form-control" />
					<form:errors path="city" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="state">state</label>
					<form:input path="state" id="username" class="form-control" />
					<form:errors path="state" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for=country>country</label>
					<form:password path="country" id="country" class="form-control" />
					<form:errors path="country" cssStyle="color:#ff0000;" />

				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<form:password path="zipCode" id="password" class="form-control" />
					<form:errors path="zipCode" cssStyle="color:#ff0000;" />
				</div>


			</form:form>
		</div>
	</div>
</div>
