	var app = angular.module("MyApp", []);

		app.controller("MyController", function($scope, $http) {
			$scope.registerID = "Click the button to genrerate Id";
	        $scope.items = [];

			$scope.generateID = function() {
				var response = $http
						.get('/RegistrationPage/webservice/regnumber/');
				response.success(function(data) {
					$scope.registerID = data;
				})

				response.error(function(data, status, headers, config) {
					alert("AJAX failed to get data, status=" + status);
				})
			};

			 $scope.add = function () {
		          $scope.items.push({ 
		            inlineChecked: false,
		            question: "",
		            questionPlaceholder: "foo",
		            text: ""
		          });
		        };
		        
		        $scope.remove = function(index){
		            $scope.items.splice(index, 1);
		        }
		});
