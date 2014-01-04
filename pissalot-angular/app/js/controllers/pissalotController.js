'use strict';

/*jshint -W098 *//*global controller for Pissalot application */
pissalotApp.controller('pissalotController', function ($scope, $timeout, pissalotCouchService) {

    function requestTimesFromService() {
        pissalotCouchService.get({listType: 'top-duration'}, function (response) {
            $scope.topDuration = response.rows;
        });

        pissalotCouchService.get({listType: 'latest'}, function (response) {
            $scope.latest = response.rows;
        });
    }

    function updateStatistics() {
        $timeout(function () {
            requestTimesFromService(); // update DOM
            updateStatistics(); // schedule another update
        }, 15000);
    }

    // Get initial data from service
    requestTimesFromService();
    // Schedule timeouts and update date
    updateStatistics();

});
