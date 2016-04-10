var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $http.get("http://localhost:8080/neccps/Student/get/json")
    .success(function(data) {
        $scope.arr = data;
    });
});