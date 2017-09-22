/**
 * UserService for User module
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.registerUser=function(user){
		alert("service"+user.firstname);
		return $http.post("http://localhost:8090/CollaborationBackend/registration",user)
		
	}
	
	userService.login=function(user){
		return $http.post("http://localhost:8090/CollaborationBackend/login",user)
		
	}
	
	userService.logout=function(){
		return $http.get("http://localhost:8090/CollaborationBackend/logout")
	}
	
	userService.getUserByUsername=function(){
		return $http.get("http://localhost:8090/CollaborationBackend/getuserdetails")
	}
	
	userService.updateUserProfile=function(user){
		return $http.put("http://localhost:8090/CollaborationBackend/updateprofile",user)
	}
	
	
	
	return userService;
	
})