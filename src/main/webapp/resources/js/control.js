///<reference path = "./angular.min.js"/>

(function() {
	var myApp = angular.module('app', []);
	myApp.controller('allProductsCtrl',['$scope','$http', function($scope, $http) {
		var me = this;
		me.listOfProducts =  [];
		
		$http.get('/WebProject/product/all').success(function(data) {
			me.listOfProducts = data;
			
		});
	}]);
})();

