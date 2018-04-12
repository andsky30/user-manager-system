'use strict';

angular
    .module('usersModule', [])
    .constant('USER_ENDPOINT', '/api/users/:id')
    .factory('User', function ($resource, USER_ENDPOINT) {
        return $resource(USER_ENDPOINT);
    })
    .factory('UserPUT', function ($resource, USER_ENDPOINT) {
        return $resource(USER_ENDPOINT, null,
            {
                'update': {method: 'PUT'}
            })
    })
    .service('Users', function (User) {

        this.getAll = function () {
            return User.query();
        };

        this.get = function (index) {
            return User.get({id: index});
        };

        this.add = function (user) {
            User.save(user)
        };

        this.delete = function (index) {
            return User.delete({id: index})
        };

    })
    .service('UserUtils', function () {

        this.isUserInputValid = function (formName) {

            var valid = true;
            var i;

            for (i = 0; i < 5; i++) {
                if (document.forms[formName].elements.item(i).value === "") {
                    valid = false;
                    alert("Inputs cannot be empty!");
                    break;
                }
                if (i === 4 && !document.forms[formName].elements.item(i).value.match(/(\d{4})-(\d{2})-(\d{2})/)) {
                    alert("Wrong date format! Should be: yyyy-MM-dd");
                    valid = false;
                    break;
                }
            }
            return valid;
        }
    })
    .controller('AddUserController', function (Users, User, UserUtils) {
        var vm = this;
        vm.user = new User();
        vm.saveUser = function () {

            if (UserUtils.isUserInputValid('add_user_form')) {
                Users.add(vm.user);
                vm.user = new User();
                location.reload();

            }
        };
    })
    .controller('ShowUsersController', function (Users, UserPUT, UserUtils, $routeParams, $location, $rootScope) {
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

            if ($rootScope.showAddForm === false) {
                $rootScope.showAddForm = true;
            } else $rootScope.showAddForm = false;
        };

        vm.showEditForm = function () {

            if ($rootScope.showEditForm === false) {
                $rootScope.showEditForm = true;
            }
        };

        vm.hideEditForm = function () {

            if ($rootScope.showEditForm === true) {
                $rootScope.showEditForm = false;
            }
        };

        vm.setUser = function (userId) {
            vm.user = Users.get(userId);
        };

        vm.saveEditedUser = function () {
            if (UserUtils.isUserInputValid('edit_user_form')) {
                var userId = vm.user.id;
                UserPUT.update({id: userId}, vm.user);
                location.reload()
            }
        };

        vm.historyBack = function () {
            window.history.back();
        }

    })


;
