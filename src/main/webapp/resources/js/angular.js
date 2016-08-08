/**var cartApp=angular.
* cartApp Module

cartApp.controller("cartCtrl",function($scope,$http) {

	// body...
	$scope.refreshCart=function(cart_id){
	$http.get('/WebProject/user/cart'+$scope.cart_id).success(function(data){$scope.cart=data});
	};
	$scope.clearCart=function(){
	$http.delete('/WebProject/user/cart'+$scope.cart_id).success($scope.refreshCart($scope.cart_id));
	};

})*
* Description
*/
var cartApp=angular.module('cartApp', []);
cartApp.controller("cartCtrl",function($scope,$http) {

	// body...
	$scope.refreshCart=function(cart_id){
		$http.get('/WebProject/user/cart/'+$scope.cart_id).success(function(data){$scope.cart=data});
	};
	$scope.clearCart=function(){
		$http.delete('/WebProject/user/cart/'+$scope.cart_id).success($scope.refreshCart($scope.cart_id));
	};
	$scope.initCartId=function(cart_id) {
		// body...
		$scope.cart_id=cart_id;
		$scope.refreshCart(cart_id);
	};
	$scope.addToCart=function(product_id) {

		// body...
		$http.put("/WebProject/user/cart/"+product_id).success(function(data) {
			// body...
			$scope.refreshCart($http.get("/WebProject/user/cart/cart_id"));
			alert("product successfully added to the cart ")
		});

	};
	$scope.removeFromCart=function(product_id) {
		// body...
		$http.put("/WebProject/user/cart/remove/"+product_id).success(function(data) {
			// body...
			$scope.refreshCart($http.get("/WebProject/user/cart/cart_id"));
		});
	};

});