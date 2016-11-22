var productControllers = angular.module('productControllers', []);

productControllers.controller('ProductListController', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/api/products').success(function(products) {
				$scope.products = products;
			}).error(function() {
				alert("Couldn't load products");
			});
		} ]);