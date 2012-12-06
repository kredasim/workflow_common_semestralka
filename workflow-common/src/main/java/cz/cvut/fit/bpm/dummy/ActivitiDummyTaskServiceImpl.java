/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.dummy;

import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import cz.cvut.fit.bpm.api.service.TaskService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component
public class ActivitiDummyTaskServiceImpl implements TaskService {
    @Override
    public List<BpmTaskDto> getAllTasksForUser(String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<BpmTaskDto> getAssignedTasksForUser(String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<BpmTaskDto> getAvailableTasksForUser(String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String startTask(String processId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void completeTask(String taskId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void completeTask(String processId, String userId, Map<String, Object> data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BpmTaskDto getTaskById(String taskId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
