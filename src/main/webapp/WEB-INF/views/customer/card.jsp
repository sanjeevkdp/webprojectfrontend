<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="../shared/header.jsp"%>


<%@ include file="../shared/menu.jsp"%>
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
                 <h1>Card Details</h1>
                 <p>fill in the detail</p>
                 <form:form  commandName="card" >
				<div class="form-group">
					<label for="cardNumber">CardNumber</label>
					<form:input path="cardNumber" id="cardNumber" class="form-control" />
					<form:errors path="cardNumber" cssStyle="color:#ff0000;"/>
				</div>
			    <div class="form-group">
					<label for="expiryMonth">expiryMonth</label>
					<form:input path="expiryMonth" id="expiryMonth" class="form-control" />
							<form:errors path="expiryMonth" cssStyle="color:#ff0000;"/>
				
				</div>
				 <div class="form-group">
					<label for="expiryYear">expiryYear</label>
					<form:input path="expiryYear" id="expiryYear" class="form-control" />
							<form:errors path="expiryYear" cssStyle="color:#ff0000;"/>
				
				</div>
					 <div class="form-group">
					<label for="nameOnCard">nameOnCard</label>
					<form:input path="nameOnCard" id="nameOnCard" class="form-control" />
							<form:errors path="nameOnCard" cssStyle="color:#ff0000;"/>
				
				</div>
				 <div class="form-group">
					<label for=cvNumber>cvNumber</label>
					<form:password path="cvNumber" id="cvNumber" class="form-control" />
							<form:errors path="cvNumber" cssStyle="color:#ff0000;"/>
				
				</div>
				 
				<br>
				<div class="col-md-offset-3">
							<input type="submit" value="Checkout"
								name="_eventId_confirmCheckout" class="btn btn-md btn-success">
							<input type="submit" value="Cancel" name="_eventId_cancel"
								class="btn btn-md btn-danger">
						</div>
			</form:form>
		</div>
	</div>
</div>		
		
		<%@ include file="../shared/footer.jsp"%>	