package com.niit.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Jobs;

@Repository
public class JobDaoImpl implements JobDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveJob(Jobs job) {
		Session session=sessionFactory.openSession();
		session.save(job);
		session.flush();
		session.close();
		
		
	}

	
	public List<Jobs> getAllJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Jobs> jobs=query.list();
		session.close();
		return jobs;
		
	}



	public Jobs getJobById(int id) {
		Session session=sessionFactory.openSession();
		Jobs job=(Jobs)session.get(Jobs.class, id);
		session.close();
		return job;
	}
	

}