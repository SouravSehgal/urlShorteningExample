'use strict';
'use strict';
angular.module('urlApp', ['serviceFactory','ngRoute'])
.controller('urlController',['serviceFactory','$http','$scope', function (serviceFactory,$http,$scope){
	
	$scope.url = '';
	$scope.result = '';
	$scope.createShortUrl = function() {
		if($scope.url != '') {
			let data = {};
			data.url = $scope.url;
			let request=serviceFactory.getPacket('shortenerService','POST',data);
			$http(request).then(function(response){
	  			$scope.result = 'Your Short URL is: ' + response.data.result;
	  		},function(response){
	  			$scope.result = 'Invalid url sent';
	  		});
		}
		else {
			$scope.result = 'Empty url';
		}
	}
	$scope.getUrl = function () {
		let request = serviceFactory.getPacket('getOriginalUrl', 'GET');
		$http(request).then(function(response){
  			$scope.result = response.data.result;
  		},function(response){
  			$scope.result = 'Invalid url sent';
  		});
	}
	$scope.getUrl();
}]);