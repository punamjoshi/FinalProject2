package com.niit.dao;

import java.util.List;


import com.niit.model.Jobs;

public interface JobDao {
	void saveJob(Jobs job);
	List<Jobs> getAllJobs();
	Jobs getJobById(int id);
	

}