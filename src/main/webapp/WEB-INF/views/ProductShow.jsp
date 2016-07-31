
<div id="content" class="bottom-border-shadow">
	<div class="container background-white bottom-border">
		<div class="row margin-vert-30">

			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<img src="${img}/portfolio/${product.imageUrl}" alt="image" style="height:300px;width:100%" />
					</div>
					<div class="col-md-5">
						<h2>name:${product.product_name}</h2>
						<p>
							<strong> ID</strong>:${product.product_id}
						</p>
						
						
						<p>
							<strong> price</strong>:${product.unit_price}
						</p>
						
						<p>
							<strong>Category</strong>:${categoryName}
						</p>
						
						<p>
							<strong> description</strong>:${product.description}
						</p>
						<p>
							<strong>Supplier</strong>:${supplierName}
						</p>
						
						<button type="button" class="btn btn-red active">Add to Cart</button>
					<button type="button" class="btn btn-bronze active">Continue>></button>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>