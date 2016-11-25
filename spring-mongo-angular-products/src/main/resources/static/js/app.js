var productApp = angular.module('productApp', [ 'ngRoute',
		'productControllers', 'shopControllers' ]);

productApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/products', {
		controller : 'ProductListController',
		templateUrl : 'view/product-list.html'
	});

	$routeProvider.when('/api/products/:id', {
		controller : 'ProductDetailController',
		templateUrl : 'view/product-detail.html'
	});

	$routeProvider.when('/shops', {
		controller : 'ShopListController',
		templateUrl : 'view/shop-list.html'
	});

	$routeProvider.when('/api/shops/:id', {
		controller : 'ShopDetailController',
		templateUrl : 'view/shop-detail.html'
	});
} ]);