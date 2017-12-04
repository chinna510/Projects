
angular.module('docsTemplateUrlDirective', [])
  .controller('Controller', ['$scope', '$compile', function($scope, $compile) {
    
    $scope.showdiv = function(){
      var compiledeHTML = $compile("<div my-Customer></div>")($scope);
      $("#d").append(compiledeHTML);
    };
  }])
  .directive('myCustomer', function() {
    return {
      templateUrl: 'environments.html'
    };
  });