'use strict';

/* Service to retrieve data from backend (CouchDB store) */
pissalotApp.factory('pissalotCouchService', function ($resource) {

    return $resource('http://192.168.1.4:8080/measurement/:listType',{
        listType: '@listType'
    }, {
        get: {
            method: 'GET',
            isArray: false
        }
    });
});
