package cz.cvut.fit.industry;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.*;

public class TaskCreatorImpl implements TaskCreator {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Task createTask() {
		Task task = getTestingTask();
		
		entityManager.persist(task);
		
		return task;
	}

	private Task getTestingTask() {
		Task task = new Task();
		
		AppUser appUser = entityManager.find(AppUser.class, 1);
		task.setAppUser(appUser);
		
		Project project = entityManager.find(Project.class, 1);
		task.setProject(project);
		
		
		task.setName("TestingTask1");
		task.setDescription("testing task");
		task.setHoursEstimated(20);
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		task.setValidFrom(timestamp);
		
		task.setRequiredOutput("Testing required output");
		task.setInsertTimestamp(timestamp);
		task.setUpdateTimestamp(timestamp);
		
		return task;
	}
	
}
