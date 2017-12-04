var mycloudprovider = angular.module('mycloudprovider', []);

mycloudprovider.controller('MainCtrl', function ($scope,$http) {
	
	$scope.field = {};
	
    $scope.showModal = false;
    $scope.toggleModal = function(){
        $scope.showModal = !$scope.showModal;
    };
    
    
/*============ ServiceAffinities REG=============*/
    
    $scope.regCloudProviders = function() {
    	console.log($scope.field);
    	var userData = JSON.stringify($scope.field);
    	var res = $http.post('/PAAS-GUI/rest/fetchData/storeCloudProviders', userData);
    	console.log(userData);

    	res.success(function(data, status, headers, config) {
    		$scope.message = data;
    		//document.location.href = '/PAAS-GUI/html/login.html';
    	});
    	res.error(function(data, status, headers, config) {
    		alert("failure message: " + JSON.stringify({
    			data : data
    		}));
    	});
    }; 
    
    
    /*==================POPULATE DATA TO TABLE===================*/
    
 	 $scope.selectCloudProviders = function() {
 		 //console.log("hiii");
    	var response = $http.get('/PAAS-GUI/rest/fetchData/selectCloudProviders');
    	response.success(function(data){
    		$scope.fields = data;
    		console.log("data given");
    	});
    	response.error(function(data, status, headers, config) {
                alert("Error in Fetching Data");
        });
    };           

    /*=================== delete*====================*/
   
    $scope.deleteCloudProviders = function(data) {
     	var response = $http.get('/PAAS-GUI/rest/fetchData/deleteCloudProviders/'+data);
     	response.success(function(data){
     		$scope.select();
     	});
     	response.error(function(data, status, headers, config) {
                 alert("Error in Fetching Data");
         });
     	
     };
    
    
    
  });  /*================end of controller======================*/











/*=============directive starts============*/

mycloudprovider.directive('modal', function () {
	return {
		template : '<div class="modal fade">'
				+ '<div class="modal-dialog">'
				+ '<div class="modal-content">'
				+ '<div class="modal-header">'
				+ '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'
				+ '<h4 class="modal-title">{{ title }}</h4>'
				+ '</div>'
				+ '<div class="modal-body" ng-transclude></div>'
				+ '</div>' + '</div>' + '</div>',
		restrict : 'E',
		transclude : true,
		replace : true,
		scope : true,
		link : function postLink(scope, element, attrs) {
			scope.title = attrs.title;

			scope.$watch(attrs.visible, function(value) {
				if (value == true)
					$(element).modal('show');
				else
					$(element).modal('hide');
			});

			$(element).on('shown.bs.modal', function() {
				scope.$apply(function() {
					scope.$parent[attrs.visible] = true;
				});
			});

			$(element).on('hidden.bs.modal', function() {
				scope.$apply(function() {
					scope.$parent[attrs.visible] = false;
				});
			});
			
			$('.continue').click(function() {
				$('.nav-tabs > .active').next('li').find('a').trigger('click');
			});
			$('.back').click(function() {
				$('.nav-tabs > .active').prev('li').find('a').trigger('click');
			});
			$('.cancel').click(function() {
				$('.nav-tabs > .active').cancel('li').find('a').trigger('click');
			});
		}
	};
});