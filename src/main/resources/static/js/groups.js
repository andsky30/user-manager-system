'use strict';

angular
    .module('groupsModule', [])
    .constant('GROUP_ENDPOINT', '/api/groups/:id')
    .factory('Group', function ($resource, GROUP_ENDPOINT) {
        return $resource(GROUP_ENDPOINT);
    })
    .factory('GroupPUT', function ($resource, GROUP_ENDPOINT) {
        return $resource(GROUP_ENDPOINT, null,
            {
                'update': {method: 'PUT'}
            })
    })
    .constant('GROUP_USER_ENDPOINT', '/api/groups/:id/members')
    .factory('GroupUser', function ($resource, GROUP_USER_ENDPOINT) {
        return $resource(GROUP_USER_ENDPOINT, null,
            {
                'delete': {
                    method: 'DELETE',
                    hasBody: true,
                    headers: {"Content-Type": "application/json;charset=UTF-8"}
                },
                'addUserToGroup': {
                    method: 'POST'
                }
            });
    })
    .constant('GROUP_USERS_TO_ADD_ENDPOINT', '/api/users/candidates_to_group/:id')
    .factory('UsersToAdd', function ($resource, GROUP_USERS_TO_ADD_ENDPOINT) {
        return $resource(GROUP_USERS_TO_ADD_ENDPOINT);
    })
    .service('Groups', function (Group) {

        this.getAll = function () {
            return Group.query();
        };

        this.get = function (index) {
            return Group.get({id: index});
        };

        this.add = function (group) {
            group.$save()
        };

        this.delete = function (index) {
            return Group.delete({id: index})
        };
    })
    .service('GroupUtils', function () {

        this.isGroupInputValid = function (formName) {

            var valid = true;

            if (document.forms[formName].elements.item(0).value === "") {
                valid = false;
                alert("Inputs cannot be empty!");
            }
            return valid;
        }
    })
    .controller('AddGroupController', function (Groups, Group, GroupUtils) {
        var vm = this;
        vm.group = new Group();
        vm.saveGroup = function () {
            if (GroupUtils.isGroupInputValid('add_group_form')) {
                Groups.add(vm.group);
                vm.group = new Group();
                location.reload();
            }
        }
    })
    .controller('GroupsController', function (Groups, GroupPUT, UsersToAdd, GroupUser, GroupUtils, $routeParams, $location, $rootScope) {
        var vm = this;
        vm.groups = Groups.getAll();

        var groupId = $routeParams.id;
        vm.group = Groups.get(groupId);

        vm.deleteGroup = function (groupId) {
            Groups.delete(groupId);

            $location.path('/groups');
            location.reload();
        };

        $rootScope.showAddForm = false;
        $rootScope.showEditForm = false;

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

        vm.toggle_visibility = function (id) {
            var e = document.getElementById(id);
            if (e.style.display === 'block')
                e.style.display = 'none';
            else
                e.style.display = 'block';
        };

        $rootScope.showAddGroupForm = false;

        vm.showAddingForm = function () {

            if ($rootScope.showAddGroupForm === false) {
                $rootScope.showAddGroupForm = true
            } else $rootScope.showAddGroupForm = false;
        };

        vm.setGroup = function (groupId) {
            vm.group = Groups.get(groupId);
        };

        vm.saveEditedGroup = function () {
            if (GroupUtils.isGroupInputValid('edit_group_form')) {

                var groupId = vm.group.id;
                GroupPUT.update({id: groupId}, vm.group);
                location.reload()
            }
        };

        vm.deleteUserFromGroup = function (groupId, userId) {
            var r = confirm("Are you sure you want to delete this user from group? ");
            if (r === true) {
                var obj = {"userId": userId};
                GroupUser.delete({id: groupId}, obj);
                location.reload();
            }
        };

        vm.addUserToGroup = function (groupId) {
            var e = document.getElementById("user_to_add_select" + groupId);
            var userId = e.options[e.selectedIndex].value;
            var obj = {"userId": userId};
            GroupUser.addUserToGroup({id: groupId}, obj);
            location.reload();
        };

        vm.getUsersToAdd = function (groupId) {
            vm.usersToAdd = UsersToAdd.query({id: groupId});
        };

        vm.historyBack = function () {
            window.history.back();
        }
    })
;


