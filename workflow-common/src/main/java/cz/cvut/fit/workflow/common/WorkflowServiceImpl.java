/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.workflow.common;

import cz.cvut.fit.industry.api.service.ActivitiLibrary;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService {
    private static final Logger LOG = LoggerFactory.getLogger(WorkflowServiceImpl.class);
    @Autowired
    private ActivitiLibrary activitiLibrary;

    @Override
    public String createTask(String processKey) {
        String result = null;
        try {
            LOG.info("Creating task");
            RuntimeService runtimeService = activitiLibrary.getRuntimeService();
            result = runtimeService.startProcessInstanceByKey(processKey).getId();
        } catch (Exception e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
        return result;
    }

    @Override
    public void completeTaskByProcessId(String processId, Map<String, Object> data) {
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Received data: \n " + data.toString());
            }
            // Get the first task
            TaskService taskService = activitiLibrary.getTaskService();
            TaskQuery taskQuery = taskService.createTaskQuery()
                    .processInstanceId(processId);

            Task task = taskQuery.singleResult();
            taskService.complete(task.getId(), data);
            LOG.debug("Task was completed.");
        } catch (Exception e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
    }
}
