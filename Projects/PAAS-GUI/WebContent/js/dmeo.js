var controller = function($scope) {

    $scope.login = {
        submit: function() {

            Console.info($scope.login.username + ' ' + $scope.login.password);
        }
    };

};