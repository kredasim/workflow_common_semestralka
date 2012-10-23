package cz.cvut.fit.industry;

import org.activiti.engine.ProcessEngine;

public interface ActivitiLibrary {

	void close();
	ProcessEngine getProcessEngine();
	void initialize();
}
