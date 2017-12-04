var firewall = angular.module('firewall', []);
firewall.controller('MainCtrl', function($scope) {

	$scope.placement = {
		options : [ 'top', 'top-left', 'top-right', 'bottom', 'bottom-left',
				'bottom-right', 'left', 'left-top', 'left-bottom', 'right',
				'right-top', 'right-bottom' ],
		selected : 'top'
	};
});