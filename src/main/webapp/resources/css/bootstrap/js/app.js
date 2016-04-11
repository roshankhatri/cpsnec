var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
    $http.get("https://localhost:8443/neccps/Student/get/json")
    .success(function(data) {
        $scope.arr = data;
    });
});