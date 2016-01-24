

function Hello($scope, $http) {
    $http.get('http://localhost:9100/greeting').
        success(function(data) {
        	console.log('SUCCESS');
            $scope.greeting = data;
            console.log(data);
        }).error(function(){
            console.log('ERROR');
        });;
}