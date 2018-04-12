'use strict';

angular
.module('usersModule',[])
    .constant('USER_ENDPOINT', '/api/users/:id')
    .factory('User', function($resource, USER_ENDPOINT) {
            return $resource(USER_ENDPOINT);
    })
    .factory('UserPUT', function($resource, USER_ENDPOINT) {
        return $resource(USER_ENDPOINT, null,
            {
                'update': { method:'PUT' }
            })
    })
    .service('Users', function(User) {

        this.getAll = function () {
            return User.query();
        };

        this.get = function (index) {
            return User.get({id: index});
        };

        this.add = function (user) {
            user.$save()
        };

        this.delete = function (index) {
            return User.delete({id: index})
        };

    })
    .controller('AddUserController', function(Users, User) {
        var vm = this;
        vm.user = new User();
        vm.saveUser = function() {
            Users.add(vm.user);
            vm.user = new User();

            location.reload();
        };
    })
    .controller('ShowUsersController', function(Users, UserPUT, $routeParams, $location, $rootScope) {
        var vm = this;
        vm.users = Users.getAll();

        var userId = $routeParams.id;
        vm.user = Users.get(userId);

        vm.deleteUser = function (userId) {
            Users.delete(userId);

            $location.path('/users');
            location.reload();
        };

        $rootScope.showAddForm = false;
        $rootScope.showEditForm = false;

        vm.showAddingForm = function () {

            if ($rootScope.showAddForm === false){
                $rootScope.showAddForm = true;
            } else $rootScope.showAddForm = false;
        };

        vm.showEditForm = function () {

            if ($rootScope.showEditForm === false){
                $rootScope.showEditForm = true;
            }
        };

        vm.hideEditForm = function () {

            if ($rootScope.showEditForm === true){
                $rootScope.showEditForm = false;
            }
        };

        vm.setUser = function (userId) {
            vm.user = Users.get(userId);
        };
        
        vm.saveEditedUser = function () {
            var userId = vm.user.id;
            UserPUT.update({id:userId},vm.user);
            location.reload()
        };

        vm.historyBack = function () {
            window.history.back();
        }

    })
    

;
