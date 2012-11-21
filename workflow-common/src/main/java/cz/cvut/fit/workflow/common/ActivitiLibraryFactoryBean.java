package cz.cvut.fit.workflow.common;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.FactoryBean;

import cz.cvut.fit.industry.ActivitiLibraryFactory;
import cz.cvut.fit.industry.api.service.ActivitiLibrary;

/**
 * Factory bean to initialize and provide instance of {@link ActivitiLibrary}.
 * @author Simeon Kredatus
 */
public class ActivitiLibraryFactoryBean implements FactoryBean<ActivitiLibrary> {
	
	private static ActivitiLibrary activitiLibrary;
	
	@PostConstruct
	public void init() {
		activitiLibrary = ActivitiLibraryFactory.createActivitiLibrary();
		activitiLibrary.initialize();
	}
	
	@PreDestroy
	public void destroy() {
		activitiLibrary.close();
	}
	
	public ActivitiLibrary getObject() throws Exception {
		return activitiLibrary;
	}

	public Class<?> getObjectType() {
		return ActivitiLibrary.class;
	}

	public boolean isSingleton() {
		return true;
	}
}
