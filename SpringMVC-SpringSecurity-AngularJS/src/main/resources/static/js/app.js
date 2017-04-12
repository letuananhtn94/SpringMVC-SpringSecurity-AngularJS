
var app = angular.module("myApp", ['ui.router', 'ngResource']);
var BASE_URL = "http://localhost:8080/FM/";

app.config(function($stateProvider) {
	  var homeState = {
	    name: 'home',
	    url: '/',
	    templateUrl: '/FM/views/wellcome.html'
	  }
	  
	  var fresherState = {
	    name: 'fresherlist',
	    url: '/fresherlist',
	    templateUrl: '/FM/views/fresher.html'
	  }

	  var aboutState = {
	    name: 'about',
	    url: '/about',
	    templateUrl: '/FM/views/about.html'
	  }

	  $stateProvider.state(homeState);
	  $stateProvider.state(fresherState);
	  $stateProvider.state(aboutState);
	});