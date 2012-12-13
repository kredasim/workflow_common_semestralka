/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.lombardy;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import cz.cvut.fit.bpm.api.service.TaskService;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */

@Component("lombardyTaskService")
public class LombardyDummyTaskServiceImpl implements TaskService {
    @Override
    public List<BpmTaskDto> getAllTasksForUser(String userId) {
        return Collections.emptyList();
    }

    @Override
    public List<BpmTaskDto> getAssignedTasksForUser(String userId) {
        return Collections.emptyList();
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForUser(String userId) {
        return Collections.emptyList();
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForGroup(String groupId) {
        return Collections.emptyList();
    }

    @Override
    public void claimTask(String taskId, String userId) {
    }

    @Override
    public void completeTask(String taskId) {
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> data) {
    }

    @Override
    public BpmTaskDto getTaskById(String taskId) {
        return null;
    }

    @Override
    public String getTaskIdByProcessInstance(String processId, String userId) {
        return null;
    }
}
