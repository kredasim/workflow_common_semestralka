/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm;

import cz.cvut.fit.industry.api.service.ActivitiLibrary;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public abstract class AbstractActivitiTest extends AbstractTest {

    public static final String TEST_USER = "kermit";

    @Autowired
    protected ActivitiLibrary activitiLibrary;

    protected String testProcessId;
    protected String testProcessKey;

    @Before
    public void setUp() throws Exception {
        if (testProcessId == null) {
            RepositoryService repositoryService = activitiLibrary.getProcessEngine().getRepositoryService();
            Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("testprocess.bpmn20.xml")
                .deploy();
            String deployId = deploy.getId();
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
            testProcessId = processDefinition.getId();
            testProcessKey = processDefinition.getKey();
        }
    }
}
