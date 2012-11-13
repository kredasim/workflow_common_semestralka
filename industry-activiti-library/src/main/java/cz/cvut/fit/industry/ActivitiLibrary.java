package cz.cvut.fit.industry;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Main class for working with pre-configured
 * Activiti process engine.
 * @author szolatib
 */
public interface ActivitiLibrary {

	/**
	 * Closes attached Activiti process engine and Spring context.
	 * Call this method when closing your own application.
	 */
	void close();

	/**
	 * Retrieves Activiti process engine. Don't
	 * forget to initialize process engine
	 * by calling {@link #initialize()} once
	 * before calling this method. Process engine
	 * reference can be stored and used safely until
	 * {@link #close()} is called.
	 * @return Activiti process engine
	 */
	ProcessEngine getProcessEngine();
	
	
	/**
	 * Retrieves runtime service of attached process engine.
	 * 
	 * RuntimeService handles all process runtime actions
	 * such as starting new process or getting info about running
	 * processes.
	 * 
	 * Process engine should be properly initialized prior calling
	 * this method.
	 * 
	 * This method is shortcut for calling getProcessEngine().getRuntimeService().
	 * @return Runtime service of attached process engine.
	 */
	RuntimeService getRuntimeService();
	
	
	/**
	 * Retrieves TaskService of attached process engine.
	 * 
	 * TaskService manages all task-related actions
	 * such as getting info about existing tasks or completing
	 * existing task.
	 * 
	 * This method is shortcut for calling getProcessEngine().getTaskService().
	 * @return Runtime service of attached process engine.
	 * 
	 * @return Task service of attached process engine.
	 */
	TaskService getTaskService();

	/**
	 * Sets up attached process engine and spring context.
	 * After calling this method it is safe to retrieve
	 * process engine by calling {@link #getProcessEngine()}. 
	 */
	void initialize();
	
	ConfigurableApplicationContext getContext();
}
