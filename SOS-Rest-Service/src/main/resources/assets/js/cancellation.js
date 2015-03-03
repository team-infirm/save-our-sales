var cancellationApp = angular.module('cancellationApp', {});

cancellationApp.controller('CancellationController', function ($scope) {
    $scope.cancellations = [
        {vendorTxCode: 'njksncjnjn111', amount: '10.50', discount: '0'},
        {vendorTxCode: 'njksncjnjn222', amount: '20.50', discount: '0'},
        {vendorTxCode: 'njksncjnjn333', amount: '30.50', discount: '0'},
        {vendorTxCode: 'njksncjnjn444', amount: '40.50', discount: '0'}
    ]
})