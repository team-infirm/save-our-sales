var cancellationApp = angular.module('cancellationApp', ['ngResource']);

cancellationApp.factory("GetCancellations", function($resource) {
  return $resource("/api/cancellations");
});

cancellationApp.controller('CancellationController', function ($scope, GetCancellations) {
    GetCancellations.query(function(data) {
        $scope.cancellations = data;
      });
})