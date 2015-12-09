'use strict';

//var appModule = angular.module('appModule', [ 'ngRoute', 'ngCookies', 'ui.bootstrap']);
var appModule = angular.module('appModule', [ 'ngRoute', 'ngCookies']);

appModule.config([ '$routeProvider', function($routeProvider, $rootScope, $location) {
	
	$routeProvider.when('/characters', { templateUrl : 'html/character/character-list.html', controller : 'CharacterListCtrl'
	}).when('/character/:id', { templateUrl : 'html/character/character-detail.html', controller : 'CharacterDetailCtrl'
	}).when('/campaigns', { templateUrl : 'html/campaign/campaign-list.html', controller : 'CampaignListCtrl'
	}).when('/campaign/:id', { templateUrl : 'html/campaign/campaign-detail.html', controller : 'CharacterDetailCtrl'
	}).when('/', { templateUrl : 'html/main.html'
	}).otherwise({ templateUrl : 'html/404.html'
	});
} ]);

/*
appModule.directive('typeahead', function() {
	return {
		require : 'ngModel',
		link : function(scope, element, attrs, modelCtrl) {
			var checkObject = function(value) {
				return (value == '' || typeof value === 'string') ? null : value;
			};
			modelCtrl.$parsers.push(checkObject);
			checkObject(scope[attrs.ngModel]);
		}
	};
});
*/

/*
appModule.config(['$translateProvider', function($translateProvider) {
	$translateProvider.preferredLanguage('es');
	$translateProvider.useStaticFilesLoader({
		prefix: CONTEXT_PATH + '/i18n/',
		suffix: '.json'
	});
}]);

billerModule.controller('LanguageCtrl', ['$scope', '$translate', function($scope, $translate) {
	$scope.changeLanguage = function(key) {
		$translate.use(key);
	};
	$scope.getLanguage = function() {
		return $translate.use();
	};
}]);
*/

/*
appModule.run(function($rootScope, $http, $cookies, $location) {
	try {
		$rootScope.user = JSON.parse($cookies.get('biller.user'));
	}catch(e) {
	};
});
*/

/**
 * Security interceptor
 */
/*
appModule.factory('authInterceptor', ['$rootScope', '$q', '$location', '$cookies', function ($rootScope, $q, $location, $cookies) {
	return {
		request: function (config) {
			config.headers = config.headers || {};
			config.headers.sessionid = $cookies.get("sessionid");
			if (config.method == 'POST' && config.data == null) {
				config.data = '{}';
			}
			return config;
		},
		requestError: function (rejection) {
			return $q.reject(rejection);
		},
		response: function (response) {
			if (response.status === 401 || response.status === 403) {
				$location.url("forbidden");
			}
			return response || $q.when(response);
		},
		responseError: function (rejection) {
			if(rejection.status === 403) {
				$location.url("forbidden");
				return;
			}
			return $q.reject(rejection);
		}
};}]);

appModule.config(['$httpProvider', function ($httpProvider) {
	$httpProvider.interceptors.push('authInterceptor');
}]);
*/

appModule.factory('messageService', function() {
	var message = null;
    return {
        setMessage: function(data) {
        	message = data;
        },
        getMessage: function() {
        	return message;
        },
        hasMessage: function() {
        	return message != null;
        }
    };
});

appModule.controller('CharacterListCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$filter', 'messageService', function($scope, $rootScope, $routeParams, $http, $filter, messageService) {
	$scope.currentPage = 1;
	$scope.itemsPerPage = 20;
	$scope.getSearchUrl = function() {
		var q = ""; //TODO
		return 'rest/entity/find/characters?p=' + $scope.currentPage + '&n=' + $scope.itemsPerPage + "&q=" + q;
	};
	$scope.search = function() {
		messageService.setMessage(null);
		$scope.setPage(1);
	};
	$scope.setPage = function(page) {
	    $scope.currentPage = page;
	    $scope.results = null;
	    $scope.searchMessage = "Loading...";
	    $http.get($scope.getSearchUrl()).success(function(data) {
	    	$scope.results = data;
	    });
	};
	$scope.search();
} ]);

appModule.controller('CharacterDetailCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$filter', 'messageService', function($scope, $rootScope, $routeParams, $http, $filter, messageService) {
} ]);

appModule.controller('CampaignListCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$filter', 'messageService', function($scope, $rootScope, $routeParams, $http, $filter, messageService) {
} ]);

appModule.controller('CampaignDetailCtrl', [ '$scope', '$rootScope', '$routeParams', '$http', '$filter', 'messageService', function($scope, $rootScope, $routeParams, $http, $filter, messageService) {
} ]);

