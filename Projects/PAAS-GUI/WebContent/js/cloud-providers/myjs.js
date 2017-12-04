var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $window) {
  $scope.foo = function() {
    $window.close();
  };
});