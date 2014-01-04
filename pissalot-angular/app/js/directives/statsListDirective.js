'use strict';

/**
 * Directive for displaying a the correct table depending on the requested type (top-duration or latest).
 */
pissalotApp.directive('statsList', function () {

    return {
        restrict: 'E',
        scope: {
            items: '=listType',
            orderBy: '@'
        },
        templateUrl: 'partials/partial1.html'
    };

});
