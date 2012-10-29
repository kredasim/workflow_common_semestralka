package cz.cvut.fit.industry;

import org.activiti.engine.ProcessEngine;

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
	 * Sets up attached process engine and spring context.
	 * After calling this method it is safe to retrieve
	 * process engine by calling {@link #getProcessEngine()}. 
	 */
	void initialize();
}
