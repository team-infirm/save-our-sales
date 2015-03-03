var cancellationApp = angular.module('cancellationApp', ['ngResource']);

cancellationApp.factory("GetCancellations", function($resource) {
  return $resource("/api/cancellations");
});

cancellationApp.factory("SaveCancellations", function($resource) {
  return $resource("/api/chasers");
});

cancellationApp.controller('CancellationController', function ($scope, GetCancellations, SaveCancellations) {
    GetCancellations.query(function(data) {
        $scope.cancellations = data;
      });

      $scope.saveCancellations = function () {
          var saveRequests = extractSaveRequests($scope.cancellations)
          if (saveRequests != undefined && saveRequests.length != 0) {
              alert(extractSaveRequests($scope.cancellations));
              var chaserRequest = {transactionIds: saveRequests}
              SaveCancellations.save(chaserRequest)
          }
      }
})

function extractSaveRequests(cancellations) {
    var saveRequests = []
    cancellations.forEach( function(cancellation) {
        if (cancellation.sendEmail) {saveRequests.push(cancellation.transactionId)}
    });
    return saveRequests;
}