'use strict';

angular
    .module('groupsModule',[])
    .constant('GROUP_ENDPOINT', '/api/groups/:id')
    .factory('Group', function($resource, GROUP_ENDPOINT) {
        return $resource(GROUP_ENDPOINT);
    })
    .factory('GroupPUT', function($resource, GROUP_ENDPOINT) {
        return $resource(GROUP_ENDPOINT, null,
            {
                'update': { method:'PUT' }
            })
    })
    .service('Groups', function(Group) {

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
    .controller('AddGroupController', function(Groups, Group) {
        var vm = this;
        vm.group = new Group();
        vm.saveGroup = function() {
            Groups.add(vm.group);
            vm.group = new Group();

            location.reload();
        }
    })
    .controller('GroupsController', function(Groups, GroupPUT, $routeParams, $location, $rootScope) {
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

            if ($rootScope.showEditForm === false){
                $rootScope.showEditForm = true;
            }
        };

        vm.hideEditForm = function () {

            if ($rootScope.showEditForm === true){
                $rootScope.showEditForm = false;
            }
        };

        $rootScope.showAddGroupForm = false;

        vm.showAddingForm = function () {

            if ($rootScope.showAddGroupForm === false){
                $rootScope.showAddGroupForm = true
            } else $rootScope.showAddGroupForm = false;
        };

        vm.setGroup = function (groupId) {
            vm.group = Groups.get(groupId);
        };

        vm.saveEditedGroup = function () {
            var groupId = vm.group.id;
            GroupPUT.update({id:groupId},vm.group);
            location.reload()
        }
    })
;
