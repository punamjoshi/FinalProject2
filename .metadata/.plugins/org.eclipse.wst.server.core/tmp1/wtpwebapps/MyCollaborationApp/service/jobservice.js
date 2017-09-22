/**
 * job service
 */
app.factory('JobService',function($http){
	var jobService={}
	
	jobService.saveJob=function(job)
	{
		return $http.post("http://localhost:8090/CollaborationBackend/savejob",job)
	}
	
	jobService.getAllJobs=function()
	{
		return $http.get("http://localhost:8090/CollaborationBackend/getalljobs")
	}
	
	jobService.getJobById=function(id)
	{
		return $http.get("http://localhost:8090/CollaborationBackend/getjobbyid/"+id)
	}
	
	return jobService;
})