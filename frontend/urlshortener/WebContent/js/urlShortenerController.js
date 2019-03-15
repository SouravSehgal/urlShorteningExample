'use strict';
angular.module('urlShortenerApp', ['serviceFactory'])
.controller('urlShortenerController',['serviceFactory','$http','$scope', function (serviceFactory,$http,$scope){
	
	$scope.url = '';
	$scope.result = '';
	$scope.shortUrl = '';
	$scope.createShortUrl = function() {
		if($scope.url != '') {
			let data = {};
			data.url = $scope.url;
			let request=serviceFactory.getPacket('shortenerService','POST',data);
			$http(request).then(function(response){
	  			$scope.result = 'Your Short URL is: ' + response.data.result;
	  			let data = response.data.result.split("/");
	  			//console.log(data[data.length-1]);
	  			$scope.getUrl(data[data.length-1]);
	  		},function(response){
	  			$scope.result = 'Invalid url sent';
	  		});
		}
		else {
			$scope.result = 'Empty url';
		}
	}
	
	$scope.getUrl = function (id) {
		let request = serviceFactory.getPacket('getOriginalUrl', 'GET', id);
		$http(request).then(function(response){
  			$scope.shortUrl = response.data.result;
  		},function(response){
  			$scope.result = 'Invalid url sent';
  		});
	}
}]);