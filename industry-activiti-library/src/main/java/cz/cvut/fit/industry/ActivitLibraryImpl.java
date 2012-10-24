package cz.cvut.fit.industry;

import org.activiti.engine.ProcessEngine;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class ActivitLibraryImpl implements ActivitiLibrary {

	private ConfigurableApplicationContext context;
	private boolean initialized = false;
	private ProcessEngine processEngine;

	public ActivitLibraryImpl() {
	}

	@Override
	public void close() {
		if(!initialized) throw new IllegalStateException("Not initialized. Call initialize before closing proces engine.");
		context.close();
		initialized = false;
	}

	@Override
	public ProcessEngine getProcessEngine() {
		if(!initialized) throw new IllegalStateException("Not initialized. Call initialize before getting proces engine.");
		return processEngine;
	}

	@Override
	public void initialize() {
		if(initialized) throw new IllegalStateException("Already initialized. Initialize should be called only once.");
		context = new ClassPathXmlApplicationContext("activiti-context.xml");
		processEngine = context.getBean(ProcessEngine.class);
		initialized = true;
	}

}
