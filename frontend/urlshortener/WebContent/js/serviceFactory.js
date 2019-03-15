'use strict';
angular.module('serviceFactory', [])
.service('serviceFactory',['$http', function($http) {
		var self = this;
		self.timeout = 30000;
		self.developmentUrl = 'http://localhost:8081/api/urlshortener', 
		self.urlConfiguration = {
			'shortenerService': '/',
			'getOriginalUrl': '/'	
		};
		self.getPacket = function(url, method, data) {
			console.log(url);
			let request = {};
			let realUrl = self.developmentUrl + self.urlConfiguration[url];
			if (method == 'GET') {
				if(data != null) {
					realUrl += data;
				}
				request = {
					url : realUrl,
					method : method,
					timeout : self.timeout,
					cache : true
				};
			} 
			else if (method == 'POST' && (data != null)) {
				request = {
					method : 'POST',
					url : realUrl,
					data : data,
					timeout : self.timeout,
					cache : true
				};
			}
			return request;
		};
		return self;
	} 
]);
