/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.common;


import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import cz.cvut.fit.bpm.api.dto.BpmType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService {
    private static final Logger LOG = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    @Autowired
    private TaskServiceProvider taskService;

    @Autowired
    private ProcessServiceProvider processService;

    @Override
    public List<BpmTaskDto> getAllTasksForUser(String userId) {
        List<BpmTaskDto> result = new ArrayList<BpmTaskDto>();
        result.addAll(taskService.getTaskService(BpmType.ACTIVITI).getAllTasksForUser(userId));
        result.addAll(taskService.getTaskService(BpmType.LOMBARDY).getAllTasksForUser(userId));
        return result;
    }

    @Override
    public List<BpmProcessDto> getAllProcessesForUser(String userId) {
        List<BpmProcessDto> result = new ArrayList<BpmProcessDto>();
        result.addAll(processService.getProcessService(BpmType.ACTIVITI).getAllProcessesForUser(userId));
        result.addAll(processService.getProcessService(BpmType.LOMBARDY).getAllProcessesForUser(userId));
        return result;
    }

    @Override
    public String startProcess(String processKey) {
        String result = null;
        try {
            LOG.info("Creating task");
            result = taskService.getTaskService(BpmType.ACTIVITI).startTask(processKey);
        } catch (Exception e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
        return result;
    }

    @Override
    public void completeTaskByProcessId(String processId, String userId, Map<String, Object> data) {
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Received data: \n " + data.toString());
            }
            taskService.getTaskService(BpmType.ACTIVITI).completeTask(processId, userId, data);
            LOG.debug("Task was completed.");
        } catch (Exception e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
    }
}
