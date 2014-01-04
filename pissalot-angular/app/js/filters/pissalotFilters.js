'use strict';

/**
 * Filters for the pissalot dashboard
 * User: mieldonkers
 */

pissalotApp.filter('secAppendix', function () {
    return function (input) {
        return input + ' sec';
    };
});

pissalotApp.filter('msToSec', function () {
    return function (input) {
        var parsedValue = parseInt(input, 10);
        return Math.round(parsedValue / 1000).toString();
    };
});
