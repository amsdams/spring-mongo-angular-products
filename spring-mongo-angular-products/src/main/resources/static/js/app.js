var productApp = angular.module('productApp',
		[ 'ngRoute', 'productControllers' ]);

productApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		controller : 'ProductListController',
		templateUrl : 'view/product-list.html'
	});
} ]);