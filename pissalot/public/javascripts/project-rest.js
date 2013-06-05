/**
 * Angular module for fetching User information via the REST api
 * User: mieldonkers
 */
angular.module('project-rest', ['ngResource']).
    factory('Project', function($resource) {
        var Project = $resource('/rest/users/:id',
            { id:'@id'}
        );

        return Project;
    });
