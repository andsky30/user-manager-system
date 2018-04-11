'use strict';

var app=angular
    .module('app', ['ngRoute', 'ngResource', 'usersModule', 'groupsModule'])
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider
            .when('/users', {
                templateUrl: '/partials/users.html',
                controller: 'ShowUsersController',
                controllerAs: 'showUsersCtrl'
            })
            .when('/users/confirm/:id', {
                templateUrl: '/partials/user_delete.html',
                controller: 'ShowUsersController',
                controllerAs: 'showUsersCtrl'
            })
            .when('/groups', {
                templateUrl: '/partials/groups.html',
                controller: 'GroupsController',
                controllerAs: 'groupsCtrl'
            })
            .when('/groups/confirm/:id', {
                templateUrl: '/partials/group_delete.html',
                controller: 'GroupsController',
                controllerAs: 'groupsCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
;



