/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity;


import java.util.List;
import java.util.Map;

import cz.cvut.fit.bpm.activity.converter.TaskToDtoConverter;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import cz.cvut.fit.bpm.api.service.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component("activitiTaskService")
public class TaskServiceAdapter extends AbstractServiceAdapter implements TaskService {

    @Autowired
    private TaskToDtoConverter converter;

    @Override
    public List<BpmTaskDto> getAllTasksForUser(String userId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee(userId).taskCandidateUser(userId);
        List<Task> tasks = taskQuery.list();
        return converter.convertList(tasks);
    }

    @Override
    public List<BpmTaskDto> getAssignedTasksForUser(String userId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).list();
        return converter.convertList(tasks);
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForUser(String userId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateUser(userId);
        List<Task> tasks = taskQuery.list();
        return converter.convertList(tasks);
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForGroup(String groupId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateGroup(groupId);
        List<Task> tasks = taskQuery.list();
        return converter.convertList(tasks);
    }

    @Override
    public void completeTask(String processId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        String taskId = getTaskIdByProcessInstance(processId);
        taskService.complete(taskId);
    }

    @Override
    public void completeTask(String processId, Map<String, Object> data) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        String taskId = getTaskIdByProcessInstance(processId);
        taskService.complete(taskId, data);
    }

    @Override
    public BpmTaskDto getTaskById(String taskId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        return converter.convert(task);
    }

    private String getTaskIdByProcessInstance(String processId) {
        org.activiti.engine.TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery()
            .processInstanceId(processId);

        Task task = taskQuery.singleResult();
        return task.getId();
    }
}
