
/**
 * FriendService
 */

app.factory('FriendService',function($http){
	var friendService={};
	
	friendService.suggestedUsers=function(){
		return $http.get("http://localhost:8090/CollaborationBackend/suggesteduserslist")
	}
	
	friendService.sendFriendRequest=function(toUsername){
		return $http.get("http://localhost:8090/CollaborationBackend/friendrequest/"+toUsername);
	}
	
	friendService.pendingRequests=function(){
		return $http.get("http://localhost:8090/CollaborationBackend/pendingrequests");
	}
	
	friendService.updatePendingRequest=function(fromId,status){
		return $http.put("http://localhost:8090/CollaborationBackend/updatependingrequest/"+fromId+"/"+status);
	}
	
	friendService.listOfFriends=function(){
		return $http.get("http://localhost:8090/CollaborationBackend/listoffriends");
	}
	
	return friendService;
})
