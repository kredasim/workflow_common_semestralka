/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity;


import java.util.*;

import cz.cvut.fit.bpm.activity.converter.TaskToDtoConverter;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component("activitiTaskService")
public class TaskServiceAdapter extends AbstractServiceAdapter implements cz.cvut.fit.bpm.api.service.TaskService {

    @Autowired
    private TaskToDtoConverter converter;

    @Override
    public List<BpmTaskDto> getAllTasksForUser(String userId) {
        Set<BpmTaskDto> result = new HashSet<BpmTaskDto>();
        result.addAll(getAssignedTasksForUser(userId));
        result.addAll(getAvailableTasksForUser(userId));
        return new ArrayList<BpmTaskDto>(result);
    }

    @Override
    public List<BpmTaskDto> getAssignedTasksForUser(String userId) {
        TaskService taskService = activitiLibrary.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).list();
        return converter.convertList(tasks);
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForUser(String userId) {
        TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateUser(userId);
        List<Task> tasks = taskQuery.list();
        return converter.convertList(tasks);
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForGroup(String groupId) {
        TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateGroup(groupId);
        List<Task> tasks = taskQuery.list();
        return converter.convertList(tasks);
    }

    @Override
    public void claimTask(String taskId, String userId) {
        TaskService taskService = activitiLibrary.getTaskService();
        taskService.claim(taskId, userId);
    }

    @Override
    public void completeTask(String taskId) {
        TaskService taskService = activitiLibrary.getTaskService();
        taskService.complete(taskId);
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> data) {
        TaskService taskService = activitiLibrary.getTaskService();
        taskService.complete(taskId, data);
    }

    @Override
    public BpmTaskDto getTaskById(String taskId) {
        TaskService taskService = activitiLibrary.getTaskService();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        return converter.convert(task);
    }

    @Override
    public String getTaskIdByProcessInstance(String processId, String userId) {
        TaskService taskService = activitiLibrary.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery()
            .taskAssignee(userId)
            .processInstanceId(processId);

        Task task = taskQuery.singleResult();
        if (task != null) {
            return task.getId();
        } else{
            return null;
        }
    }
}
