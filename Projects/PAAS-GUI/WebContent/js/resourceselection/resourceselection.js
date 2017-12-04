var myresourceselection = angular.module('myresourceselection', []);

myresourceselection.controller('MainCtrl', function ($scope,$http) {
	
	$scope.field = {};
	
    $scope.showModal = false;
    $scope.toggleModal = function(){
        $scope.showModal = !$scope.showModal;
    };
    
    

    /*============ RESOURCE SELECTION REG=============*/

$scope.regResourceSelection = function() {
	console.log($scope.field);
	var userData = JSON.stringify($scope.field);
	var res = $http.post('/PAAS-GUI/rest/fetchData/storeResourceSelection', userData);
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

$scope.selectResourceSelection = function() {
	var response = $http.get('/PAAS-GUI/rest/fetchData/selectResourceSelection');
	response.success(function(data){
		$scope.fields = data;
		console.log("data given");
	});
	response.error(function(data, status, headers, config) {
            alert("Error in Fetching Data");
    });
};           

/*===================RESOURCE SELECTION DELETE*====================*/

$scope.deleteResourceSelection = function(data) {
 	var response = $http.get('/PAAS-GUI/rest/fetchData/deleteResourceSelection/'+data);
 	response.success(function(data){
 		$scope.selectResourceSelection();
 	});
 	response.error(function(data, status, headers, config) {
             alert("Error in Fetching Data");
     });
 	
 };
 




      /*==================CONTROLLER ENDS======================*/

    
  });


















myresourceselection.directive('modal', function () {
    return {
      template: '<div class="modal fade">' + 
          '<div class="modal-dialog">' + 
            '<div class="modal-content">' + 
              '<div class="modal-header">' + 
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' + 
                '<h4 class="modal-title">{{ title }}</h4>' + 
              '</div>' + 
              '<div class="modal-body" ng-transclude></div>' + 
            '</div>' + 
          '</div>' + 
        '</div>',
      restrict: 'E',
      transclude: true,
      replace:true,
      scope:true,
      link: function postLink(scope, element, attrs) {
        scope.title = attrs.title;

        scope.$watch(attrs.visible, function(value){
          if(value == true)
            $(element).modal('show');
          else
            $(element).modal('hide');
        });

        $(element).on('shown.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = true;
          });
        });

        $(element).on('hidden.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = false;
          });
        });
      }
    };
  });