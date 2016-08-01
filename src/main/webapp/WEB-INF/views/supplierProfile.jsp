<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<img src="${img}/${supplier.supplier_id}.png" alt="image" style="height:300px;width:100%" />
					</div>
					<div class="col-md-5">
						<h2>name:${supplier.supplier_name}</h2>
						<p>
							<strong> Emai</strong>:${supplier.supplier_email}
						</p>
						
						
						<p>
							<strong>Contact</strong>:${supplier.supplier_contact}
						</p>
						
						<p>
							<strong>Address</strong>:${supplier.supplier_address}
						</p>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>