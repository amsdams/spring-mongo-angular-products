var productControllers = angular.module('productControllers', []);
var shopControllers = angular.module('shopControllers', []);

productControllers.controller('ProductListController', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/api/products').success(function(products) {
				$scope.products = products;
			}).error(function() {
				alert("Couldn't load products");
			});

		} ]);

shopControllers.controller('ShopListController', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/api/shops').success(function(shops) {
				$scope.shops = shops;
			}).error(function() {
				alert("Couldn't load shops");
			});

		} ]);

shopControllers.controller('ShopDetailController', [ '$scope', '$http', function(url) {
	$http.get(url).success(function(shop) {
		$scope.shop = shop;
	}).error(function() {
		alert("Couldn't load shop");
	});
} ]);
