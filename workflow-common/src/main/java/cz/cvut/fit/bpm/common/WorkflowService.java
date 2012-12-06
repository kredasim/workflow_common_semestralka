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

import java.util.List;
import java.util.Map;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public interface WorkflowService {

    List<BpmTaskDto> getAllTasksForUser(String userId);

    List<BpmProcessDto> getAllProcessesForUser(String userId);

    /**
     * Starts process by provided key.
     *
     * @param processKey process key
     * @return process ID
     */
    String startProcess(String processKey);


    //TODO: Should bye connected to taskId not processId. Need to be fixed.
    void completeTaskByProcessId(String processId, String userId, Map<String, Object> data);
}
