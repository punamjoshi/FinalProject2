
/**
 *blogpostservice
 */

app.factory('BlogPostService',function($http){
	var blogPostService={}
	
	blogPostService.saveBlog=function(blogPost){
		return $http.post("http://localhost:8090/CollaborationBackend/saveblogpost",blogPost)
	}
	
	blogPostService.blogsApproved=function()
	{
		
		return $http.get("http://localhost:8090/CollaborationBackend/listofblogs/"+1)
	}
	
	blogPostService.blogsWaitingForApproval=function(){
		return $http.get("http://localhost:8090/CollaborationBackend/listofblogs/"+0)
	}
	
	blogPostService.getBlogPost=function(id){
		return $http.get("http://localhost:8090/CollaborationBackend/getblogpost/"+id)
	}
	
	blogPostService.updateBlogPost=function(blogpost){
		return $http.put("http://localhost:8090/CollaborationBackend/updateblogpost",blogpost)
	}
	
	blogPostService.addComment=function(blogComment){
		return $http.post("http://localhost:8090/CollaborationBackend/addblogcomment",blogComment)
	}
	
	blogPostService.getBlogComments=function(blogId){
		return $http.get("http://localhost:8090/CollaborationBackend/getblogcomments/"+blogId)
	}
	return blogPostService;
})
