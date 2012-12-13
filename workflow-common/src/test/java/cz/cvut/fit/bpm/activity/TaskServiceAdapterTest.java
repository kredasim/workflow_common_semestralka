/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.cvut.fit.bpm.AbstractActivitiTest;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class TaskServiceAdapterTest extends AbstractActivitiTest {

    public static final String TEST_USER = "kermit";
    private static final String TEST_GROUP = "admin";
    public static final String TEST_KEY = "test";
    private static final String TEST_VALUE = "testValue";

    private String taskId;

    @Autowired
    private TaskServiceAdapter taskServiceAdapter;

    @Before
    public void setThisUp() throws Exception {
        taskId = startTaskAssigneeUser();
    }


    @Test
    public void testGetAllTasksForUser() throws Exception {
        TaskService taskService = activitiLibrary.getTaskService();
        taskService.setAssignee(taskId, TEST_USER);
        taskService.addCandidateUser(taskId, TEST_USER);

        List<BpmTaskDto> allTasksForUser = taskServiceAdapter.getAllTasksForUser(TEST_USER);

        assertThat(allTasksForUser, is(notNullValue()));
        assertThat(allTasksForUser.size(), is(1));
    }

    @Test
    public void testGetAssignedTasksForUser() throws Exception {
        TaskService taskService = activitiLibrary.getTaskService();
        taskService.setAssignee(taskId, TEST_USER);

        List<BpmTaskDto> allTasksForUser = taskServiceAdapter.getAssignedTasksForUser(TEST_USER);

        assertThat(allTasksForUser, is(notNullValue()));
        assertThat(allTasksForUser.isEmpty(), is(false));
    }

    @Test
    public void testGetAvailableTasksForUser() throws Exception {
        TaskService taskService = activitiLibrary.getTaskService();
        taskService.addCandidateUser(taskId, TEST_USER);

        List<BpmTaskDto> allTasksForUser = taskServiceAdapter.getAvailableTasksForUser(TEST_USER);

        assertThat(allTasksForUser, is(notNullValue()));
        assertThat(allTasksForUser.isEmpty(), is(false));
    }

    @Test
    public void testGetAvailableTasksForGroup() throws Exception {
        List<BpmTaskDto> allTasksForUser = taskServiceAdapter.getAvailableTasksForGroup(TEST_GROUP);

        assertThat(allTasksForUser, is(notNullValue()));
        assertThat(allTasksForUser.isEmpty(), is(false));
    }

    @Test
    public void testCompleteTask() throws Exception {
        taskServiceAdapter.completeTask(taskId);
    }

    @Test
    public void testCompleteTaskWithData() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put(TEST_KEY, TEST_VALUE);
        }};

        taskServiceAdapter.completeTask(taskId, map);
    }

    @Test
    public void testGetTaskById() throws Exception {
        BpmTaskDto task = taskServiceAdapter.getTaskById(taskId);

        assertThat(task, is(notNullValue()));
    }

    @Test
    public void testGetTaskIdByProcessInstance() throws Exception {
        RuntimeService runtimeService = activitiLibrary.getRuntimeService();
        String processInstanceId = runtimeService.startProcessInstanceById(testProcessId).getId();
        TaskService taskService = activitiLibrary.getTaskService();
        Task help = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        taskService.setAssignee(help.getId(), TEST_USER);

        String task = taskServiceAdapter.getTaskIdByProcessInstance(processInstanceId, TEST_USER);

        assertThat(task, is(notNullValue()));
    }

    @Test
    public void testClaimTask() throws Exception {
        taskServiceAdapter.claimTask(taskId, TEST_USER);

        TaskService taskService = activitiLibrary.getTaskService();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        assertThat(task.getAssignee(),is(TEST_USER));
    }

    private String startTaskAssigneeUser() {
        RuntimeService runtimeService = activitiLibrary.getRuntimeService();
        String processInstanceId = runtimeService.startProcessInstanceById(testProcessId).getId();
        TaskService taskService = activitiLibrary.getTaskService();
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        return task.getId();
    }
}
