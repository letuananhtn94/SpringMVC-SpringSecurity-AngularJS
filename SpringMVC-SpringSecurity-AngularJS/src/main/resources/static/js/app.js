
var app = angular.module("myApp", ['ngRoute', 'ngResource']);
var BASE_URL = "http://localhost:8080/FM/";
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/fresher.html"
    })
    .when("/fresherlist", {
        templateUrl : "views/fresher.html",       
    })
    .when("/about", {
        templateUrl : "views/about.html"
    })
    .when("/login", {
        templateUrl : "views/login.html"
    })
    .otherwise({
		redirectTo : '/'
	});
});

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'views/fresher.html',
    controller  : 'MainController'
  })

  .when('/fresherlist', {
    templateUrl : 'views/fresher.html',
    controller  : 'FreshersController as ctrl'
  })

  .when('/about', {
    templateUrl : 'views/about.html',
    controller  : 'AboutController'
  })
  
  .when('/login', {
    templateUrl : 'views/login.html',
    controller  : 'AboutController'
  })

  .otherwise({redirectTo: '/'});
});