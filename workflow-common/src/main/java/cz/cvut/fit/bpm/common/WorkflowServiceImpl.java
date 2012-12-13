/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import cz.cvut.fit.bpm.api.dto.BpmType;
import cz.cvut.fit.bpm.api.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */


// TODO:remove try / catch blocks after stabilization of BPM systems
@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService {
    private static final Logger LOG = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    @Autowired
    private TaskServiceProvider taskServiceProvider;

    @Autowired
    private ProcessServiceProvider processServiceProvider;

    @Override
    public List<BpmTaskDto> getAllTasksForUser(String userId) {
        List<BpmTaskDto> result = null;
        try {
            result = new ArrayList<BpmTaskDto>();
            result.addAll(taskServiceProvider.getTaskService(BpmType.ACTIVITI).getAllTasksForUser(userId));
            result.addAll(taskServiceProvider.getTaskService(BpmType.LOMBARDY).getAllTasksForUser(userId));
        } catch (Throwable e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
        return result;
    }

    @Override
    public List<BpmProcessDto> getAllProcessesForUser(String userId) {
        List<BpmProcessDto> result = new ArrayList<BpmProcessDto>();
        try {
            result.addAll(processServiceProvider.getProcessService(BpmType.ACTIVITI).getAllProcessesForUser(userId));
            result.addAll(processServiceProvider.getProcessService(BpmType.LOMBARDY).getAllProcessesForUser(userId));
        } catch (Throwable e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
        return result;
    }

    @Override
    public String startProcess(String processId) {
        String result = null;
        try {
            LOG.info("Creating task");
            result = processServiceProvider.getProcessService(BpmType.ACTIVITI).startProcess(processId);
        } catch (Throwable e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
        return result;
    }

    @Override
    public void completeTaskById(String userId, String taskId, Map<String, Object> data) {
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Received data: \n " + data.toString());
            }
            TaskService activitiService = taskServiceProvider.getTaskService(BpmType.ACTIVITI);
            completeTask(taskId, data, activitiService);
            LOG.debug("Task was completed.");
        } catch (Throwable e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
    }

    @Override
    public void completeTaskByProcessId(String userId, String processInstanceId, Map<String, Object> data) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Received data: \n " + data);
        }
        try {
            TaskService activitiService = taskServiceProvider.getTaskService(BpmType.ACTIVITI);
            String taskId = activitiService.getTaskIdByProcessInstance(processInstanceId, userId);
            if (taskId != null) {
                activitiService.claimTask(taskId, userId);
                completeTask(taskId, data, activitiService);
            } else {
                LOG.warn("Could not find user task for process {} for user {}", processInstanceId, userId);
            }
        } catch (Throwable e) {
            LOG.warn("Error occurred. Error message is " + e.getMessage());
        }
    }

    private void completeTask(String taskId, Map<String, Object> data, TaskService activitiService) {
        if (data == null) {
            activitiService.completeTask(taskId);

        } else {
            activitiService.completeTask(taskId, data);
        }
    }
}
