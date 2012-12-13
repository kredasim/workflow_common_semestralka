/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.common;

import java.util.List;
import java.util.Map;

import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public interface WorkflowService {
    /**
     * Returns all task for specified user.
     *
     * @param userId user identification.
     * @return list of user tasks.
     */
    List<BpmTaskDto> getAllTasksForUser(String userId);

    /**
     * Returns all processes which can the user start.
     *
     * @param userId user identification.
     * @return list of processes
     */
    List<BpmProcessDto> getAllProcessesForUser(String userId);

    /**
     * Starts process by provided id.
     *
     * @param processId process id
     * @return process instance ID
     */
    String startProcess(String processId);


    /**
     * Completes task by process id and user id.
     *
     * @param userId user identifier
     * @param processInstanceId process instance identifier
     * @param data data to be submitted.
     */
    @Deprecated
    void completeTaskByProcessId(String userId, String processInstanceId, Map<String, Object> data);

    /**
     * Completes task by task id.
     *
     * @param userId
     * @param taskId task identifier
     * @param data data to be submitted.
     */
    void completeTaskById(String userId, String taskId, Map<String, Object> data);
}
