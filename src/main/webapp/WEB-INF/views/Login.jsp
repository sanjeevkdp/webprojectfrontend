<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%> 
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">
	
	
	<c:if test="${not empty message}"><div>${message}</div></c:if>
	 <div class="col-md-6 col-md-offset-3 col-sm-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Login</b>
					</div>
					<div class="panel-body">
						<form role="login" action="${contextPath}/j_spring_security_check" method="post">
						
<!-- 							<label for="username">Username:</label> -->
							<c:if test="${not empty error}"><div>${error}</div></c:if>
							<div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-user"></i>
                                        </span>
                                        <input type="username"
								class="form-control" name="username" id="username"
								placeholder="Enter username" >
                                    </div>
							
								
								
								
								
<!-- 								 <label for="password">Password:</label> -->

<div class="input-group margin-bottom-20">
                                        <span class="input-group-addon">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                       <input type="password" class="form-control" name="password"
								id="password" placeholder="Enter password" >
                                    </div>
							
								<br>
<!-- 							<div class="checkbox"> -->
<!-- 								<label><input type="checkbox"> Remember me</label> -->
<!-- 							</div> -->

							<button type="submit" class="btn btn-green">Submit</button>
							<p>please <a href="${contextPath}/registration"><span style='color:red;text-decoration:underline'>Click</span></a> to register</p>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>

<%-- 	<form name='login' action="${contextPath}/j_spring_security_check" method='POST'> --%>
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td>UserName:</td> -->
<!-- 				<td><input type="username" id="username" name="username"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Password:</td> -->
<!-- 				<td><input  type="password" name="password" id="password"/></td>	 -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td colspan='2'><input name="submit" type="submit" value="submit" /></td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<%-- 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
<!-- 	</form> -->
</div>
</div>
</div>